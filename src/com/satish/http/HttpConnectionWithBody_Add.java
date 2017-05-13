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




public class HttpConnectionWithBody_Add {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		try {
			httpConnection(args[0],args[1]);
			/*String authorization = "TWCVA" + ":" + "twcva*$123";
		//	String authorization = "briansoffice" + ":" + "bcktwc22";
			String bytes = Base64.encode(authorization.getBytes(),0);
			System.out.println(bytes);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void httpConnection(String urlStr,String action) throws IOException
	{
		//String sb = "{\"real_time\": true,\"gw_mac\": \"ACB313866BC4\", \"2ghz_wifi\": {\"radio_enabled\": true, \"subscriber\": {\"ssid\": \"DG1670AC2\", \"ssid_enabled\": true,\"broadcast\": true, \"passphrase\": \"testpass2\", \"security_mode\": \"WPA2-Personal\" }}, \"5ghz_wifi\": {\"radio_enabled\": true,\"subscriber\": {\"ssid\": \"DG1670AC2-5G\",\"ssid_enabled\": true,\"broadcast\": true,\"passphrase\": \"DG1670A866BC2\", \"security_mode\": \"WPA2-Personal\" }  }}";
		String sb = "{\"real_time\": true,\"gw_mac\": \"ACB313866BC4\", \"2ghz_wifi\": {\"radio_enabled\": true, \"subscriber\": {\"ssid\": \"test\", \"ssid_enabled\": true,\"broadcast\": true, \"passphrase\": \"1234567897896\", \"security_mode\": \"WPA2-Personal\" }}, \"5ghz_wifi\": {\"radio_enabled\": true,\"subscriber\": {\"ssid\": \"DG1670AC25Gdsf\",\"ssid_enabled\": true,\"broadcast\": true,\"passphrase\": \"ss\", \"security_mode\": \"WPA2-Personal\" }  }}";
		//sb = "";
		HttpURLConnection connection =null;
		System.out.println(urlStr);
		URL url = new URL(urlStr);
		if(url.getProtocol().equalsIgnoreCase("http"))
			connection = (HttpURLConnection) url.openConnection();
		else if(url.getProtocol().equalsIgnoreCase("https")) 
		{
			trustEveryone();
			connection = (HttpsURLConnection) url.openConnection();
		}
		
	 	
	     connection.setRequestMethod("POST");
	     
	     connection.setDoInput(true);
         connection.setDoOutput(true);
         connection.addRequestProperty("content-type","application/json");
 		connection.addRequestProperty("Cookie", "Wayfarer=38f5L6hq0F8VxyFtdu5cpAo5UxIbOOVjfxmoQa8Dll6xZbr1k6lDSKH27MEx0zdYW%2F8800FHV9TwTsp5OkSZM3HOjv5izvw1p4kVg3mb3baKdHWm0uEIc05FPdTNx1WyeyXQ0a82JmPS4OTiCZzmL6AMkBYeqfoa9w8g%2FRARUZ8rpDAguHLjHL9jlqOgpglOmlOIGz8ON7YoMss8xsHGIJbKgjeWV%2BtU5MBtZwBz2rL39qUNkw0dzA%3D%3D");
         connection.setRequestProperty("Content-Length", String.valueOf(sb.length()));
         connection.getOutputStream().write(sb.toString().getBytes());
         HttpsURLConnection.setFollowRedirects(true);
         connection.setInstanceFollowRedirects(true);
         connection.setConnectTimeout(10*1000);
         connection.setReadTimeout(10*1000);
                  
		 int getStatus = connection.getResponseCode();
		  System.out.println("status ::::::::"+getStatus);
		  System.out.println("request::::::::"+sb);
		  System.out.println("response:::::::::"+getInputInReaderResponse(connection));
		  printHeaders(connection);
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
