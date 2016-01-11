package com.satish.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;


public class HttpConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		try {
			httpConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void httpConnection() throws IOException
	{
		HttpURLConnection connection =null;
		URL url = new URL("https://test.com");
		if(url.getProtocol().equalsIgnoreCase("http"))
			connection = (HttpURLConnection) url.openConnection();
		else if(url.getProtocol().equalsIgnoreCase("https")) 
		{
			System.out.println("test");
			trustEveryone();
			connection = (HttpsURLConnection) url.openConnection();
		}
		
	 /*    for (String headerStr : requestHeaders.keySet())
	            connection.addRequestProperty(headerStr, requestHeaders.get(headerStr));
	 */    
		//connection.addRequestProperty("Content-Type","application/json");
	     connection.setRequestMethod("GET");
	     connection.setDoInput(true);
         connection.setDoOutput(true);
         HttpsURLConnection.setFollowRedirects(true);
         connection.setInstanceFollowRedirects(true);
         connection.setConnectTimeout(60*1000);
         connection.setReadTimeout(60*1000);
                  
		 int getStatus = connection.getResponseCode();
		 System.out.println("status ::::::::"+getStatus);
		  System.out.println("output:::::::::"+getInputInReaderResponse(connection));
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

}
