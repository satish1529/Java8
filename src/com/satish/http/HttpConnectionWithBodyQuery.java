package com.satish.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;


public class HttpConnectionWithBodyQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		try {
			httpConnection(args[0],args[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void httpConnection(String urlStr,String action) throws IOException
	{
		//String sb = "<?xml version=\"1.0\" ?><nnu_twc_device_mgmt_request version=\"1.0\"><method>"+action+"</method><twcid>twcid_comm_2</twcid><password>password1</password><mac>EB-3A-61-66-28-95</mac></nnu_twc_device_mgmt_request>";
		String sb ="{\"isPaperless\": false,\"statementCode\": \"1\"}";
		//String sb ="{\"isPaperless\": true}";
		HttpURLConnection connection =null;
		URL url = new URL(urlStr);
		if(url.getProtocol().equalsIgnoreCase("http"))
			connection = (HttpURLConnection) url.openConnection();
		else if(url.getProtocol().equalsIgnoreCase("https")) 
		{
			trustEveryone();
			connection = (HttpsURLConnection) url.openConnection();
		}
		
		connection.addRequestProperty("Cookie","Wayfarer=mcxABId2RVabay7IVyybhMRTSUYGb8LqRtRF9FOkDRZCGY5ZEHlHxiu1ActA%2BEQv8VGOOV3eeRnwTsp5OkSZM5ihZxFOgpDePQ8c6YsIcl3YN2tiucqpgQF%2Fta4YeeMZwNMPQpmhOKtcwaorjHU59DtXLefkT8z7VcbeaJbkHuzqG9g8M3Fa%2B6yvTZ7jKtL9waGD53Os%2F98TuRufQXr8dGDC1BWsArCv7oIKEncc%2B%2FS0hjyDUpVm%2BQ%3D%3D");
		connection.addRequestProperty("content-type","application/json");
	     connection.setRequestMethod("POST");
	     
	     connection.setDoInput(true);
         connection.setDoOutput(true);
         connection.setRequestProperty("Content-Length", String.valueOf(sb.length()));
         connection.getOutputStream().write(sb.toString().getBytes());
         HttpsURLConnection.setFollowRedirects(true);
         connection.setInstanceFollowRedirects(true);
         connection.setConnectTimeout(10*1000);
         connection.setReadTimeout(10*1000);
                  
		 int getStatus = connection.getResponseCode();
		 printHeaders(connection);
		  System.out.println("status ::::::::"+getStatus);
		  System.out.println("request::::::::"+sb);
		  System.out.println("response:::::::::"+getInputInReaderResponse(connection));
		  
	}
	
	  public static void trustEveryone()
	   {
	      try
	      {
	         HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier()
	         {
	            public boolean verify( String s, SSLSession sslsession )
	            {
	               return true;
	            }
	         });
	         SSLContext context = SSLContext.getInstance("TLS");
	         context.init(null, new X509TrustManager[] { new X509TrustManager()
	         {
	            public void checkClientTrusted( X509Certificate[] ax509certificate, String s ) throws CertificateException
	            {
	            }

	            public void checkServerTrusted( X509Certificate[] ax509certificate, String s ) throws CertificateException
	            {
	            }

	            public X509Certificate[] getAcceptedIssuers()
	            {
	               return new X509Certificate[0];
	            }
	         } }, new SecureRandom());
	         HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
	      }
	      catch (Exception e)
	      { // should never happen
	         e.printStackTrace();
	      }
	   }

	   /**
	    * This method is responsible to read the input stream and covert to String
	    * 
	    * @return the InputSteam as String
	    * @throws IOException
	    */
	   public static String getInputInReaderResponse(HttpURLConnection connection ) throws IOException
	   {
	      String THIS_METHOD = "getInputInReaderResponse";
	      String response = null;
	      if (connection.getInputStream() != null)
	      {
	         StringBuilder builder = new StringBuilder();
	         String line;
	         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	         while (( line = reader.readLine() ) != null)
	         {
	            builder.append(line);
	         }
	         response = builder.toString();
	      }
	      return response;
	   }
	   
	   public static void printHeaders(HttpURLConnection connection ) throws IOException
	   {
		   Map<String, List<String>> mapHeader = connection.getHeaderFields();
		   List<String> headerList = null;
		   for (String header : mapHeader.keySet())
	         {
	            headerList = mapHeader.get(header);
	            for (String headerValue : headerList)
	            	System.out.println( header + " : ====== : " +headerValue);
	            
	         }
	   }

}
