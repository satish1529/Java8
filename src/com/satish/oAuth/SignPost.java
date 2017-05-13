package com.satish.oAuth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;
import oauth.signpost.signature.HmacSha1MessageSigner;

public class SignPost {

	int i =0;
	static int j =1;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		
			try {
				oAuth2Leg();
			} catch (OAuthMessageSignerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (OAuthExpectationFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (OAuthCommunicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void oAuth2Leg() throws IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException
	{
		OAuthConsumer oAuth = new DefaultOAuthConsumer("l7xx63237d5b8fca43178c864e62f6ddfa82", "d854beb98b5b4b279c3177bc9c90dd8d");
		oAuth.setMessageSigner(new HmacSha1MessageSigner());
		httpConnection(oAuth);
	}
	
	private static void httpConnection(OAuthConsumer oAuth ) throws IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException
	{
		int getStatus = 0;
		HttpURLConnection connection =null;
		//URL url = new URL("https://services.timewarnercable.com/api/account/v1?phone=2142728024&zip=75228");
		//URL url = new URL("https://services.timewarnercable.com/api/account/v1?acct=127715301&zip=14620"); //roch2 with acct
	//	URL url = new URL("https://services.timewarnercable.com/api/account/v1?acct=127715201&zip=14620"); //roch1 
		URL url = new URL("https://services.timewarnercable.com/api/account/v1?acct=205439001&zip=14620"); //roch7 
		//URL url = new URL("https://services.timewarnercable.com/api/account/v1?phone=5853193614&zip=14620"); //roch2 with phone
	//	URL url = new URL("https://services.timewarnercable.com/api/account/v1?phone=9193081081&zip=27704");
		//URL url = new URL("https://services.timewarnercable.com/api/account/v1?phone=5855555557&zip=14620");//test
		if(url.getProtocol().equalsIgnoreCase("http"))
			connection = (HttpURLConnection) url.openConnection();
		else if(url.getProtocol().equalsIgnoreCase("https")) 
		{
			//trustEveryone();
			connection = (HttpsURLConnection) url.openConnection();
		}
		
	    connection.setRequestMethod("GET");
	    connection.setConnectTimeout(10*1000);
        connection.setReadTimeout(10*1000);
	     connection.setDoInput(true);
         connection.setDoOutput(true);
         HttpsURLConnection.setFollowRedirects(true);
         connection.setInstanceFollowRedirects(true);
       /*  connection.setConnectTimeout(10*1000);
         connection.setReadTimeout(10*1000);*/
         oAuth.sign(connection);
         printRequestHeaders(oAuth);
         connection.connect();
		 System.out.println("status ::::::::"+connection.getResponseCode());
         System.out.println("output:::::::::"+getInputInReaderResponse(connection));
	}
	
	private static void printRequestHeaders(OAuthConsumer oAuth)
	{
		HttpParameters httpParams = oAuth.getRequestParameters();
		Set<String> sets = httpParams.keySet();
		 Iterator<String> iter = sets.iterator();
		 
		         for (int i = 0; iter.hasNext(); i++) {
		             String param = iter.next();
		            
		           System.out.println("key  : "+param+" , value : "+httpParams.get(param));
		           
		         }
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
