package com.foodex.business;

import java.util.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.*; 
import com.twilio.sdk.resource.factory.*; 
import com.twilio.sdk.resource.instance.*; 
import com.twilio.sdk.resource.list.*; 
 
public class TwilioTest { 
 // Find your Account Sid and Token at twilio.com/user/account 
 public static final String ACCOUNT_SID = "ACd8bf7869ce179c00b7f02659e66fb10a"; 
 public static final String AUTH_TOKEN = "6d923954b6c3ab7a927039bf3e31a500"; 
 
 public static void main(String[]args) throws TwilioRestException { 
	TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
 
	 // Build the parameters 
	 List<NameValuePair> params = new ArrayList<NameValuePair>();      
	 params.add(new BasicNameValuePair("From","919677914374"));
	 params.add(new BasicNameValuePair("To","919047286162"));
	 params.add(new BasicNameValuePair("Body","Hi"));
	 params.add(new BasicNameValuePair("MediaUrl","https://wwww.google.com"));
	 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
	 Message message = messageFactory.create(params); 
	 System.out.println(message.getSid()); 
 } 
}