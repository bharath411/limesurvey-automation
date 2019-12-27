package com.slokam.limesurvey.rest.commons;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestHttpClient {

	
	public static String parse(String jsonLine) {
		 JsonElement jelement = new JsonParser().parse(jsonLine);
		 JsonObject  jobject = jelement.getAsJsonObject();
		 String result = jobject.get("result").getAsString();
		 return result;
		}
	
	 public static void main(String[] args) throws UnsupportedEncodingException {
	      DefaultHttpClient client = new DefaultHttpClient();          
	         
	      HttpPost post = new HttpPost("http://localhost/limesurvey/index.php/admin/remotecontrol");
	      post.setHeader("Content-type", "application/json");
	      post.setEntity( new StringEntity("{\"method\": \"get_session_key\", \"params\": [\"user\", \"user123\" ], \"id\": 1}"));
	      try {
	        HttpResponse response = client.execute(post);
	        if(response.getStatusLine().getStatusCode() == 200){
	            HttpEntity entity = response.getEntity();
	            String sessionKey = parse(EntityUtils.toString(entity));
	            System.out.println(sessionKey);
	            post.setEntity( new StringEntity("{\"method\": \"list_users\", \"params\": [ \""+sessionKey+"\"]}"));
	            response = client.execute(post);
	            if(response.getStatusLine().getStatusCode() == 200){
	                entity = response.getEntity();
	                System.out.println(EntityUtils.toString(entity));
	                }
	           }
	       
	       
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
}
