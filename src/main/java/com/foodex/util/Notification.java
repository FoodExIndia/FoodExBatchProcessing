package com.foodex.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

@SuppressWarnings("deprecation")
public class Notification {
	private static final String APPLICATION_ID = "XXXXXXX";
	private static final String REST_API_KEY = "XXXXXXX";
	private static final String PUSH_URL = "https://api.parse.com/1/push";

	public static void main(String[] args) {
		String[] channels = new String[] { "testsddg" };
		String type = "android";
		Map<String, String> data = new HashMap<String, String>();
		data.put("alert", "push data test");

		try {
			new Notification().sendPost(channels, type, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendPost(String[] channels, String type, Map<String, String> data) throws Exception {
		JSONObject jo = new JSONObject();
		jo.put("channels", channels);
		if (type != null) {
			// ??type?????android?ios???
			jo.put("type", type);
		}
		jo.put("data", data);

		this.pushData(jo.toString());
	}

	@SuppressWarnings({ "resource" })
	private void pushData(String postData) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = null;
		HttpEntity entity = null;
		String responseString = null;
		HttpPost httpost = new HttpPost(PUSH_URL);
		httpost.addHeader("X-Parse-Application-Id", APPLICATION_ID);
		httpost.addHeader("X-Parse-REST-API-Key", REST_API_KEY);
		httpost.addHeader("Content-Type", "application/json");
		StringEntity reqEntity = new StringEntity(postData);
		httpost.setEntity(reqEntity);
		response = httpclient.execute(httpost);
		entity = response.getEntity();
		if (entity != null) {
			responseString = EntityUtils.toString(response.getEntity());
		}

		System.out.println(responseString);
	}
}