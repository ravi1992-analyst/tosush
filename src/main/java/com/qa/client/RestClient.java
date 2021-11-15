package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// create the get method and the URL
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); // http get request
		CloseableHttpResponse closableHttpsResponse = httpClient.execute(httpget); // it will hit get url

		// Status Code
		int statusCode = closableHttpsResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code -->" + statusCode);

		// Json String
		String responseString = EntityUtils.toString(closableHttpsResponse.getEntity(), "UTF-8");
		JSONObject jsonResponse = new JSONObject(responseString);
		System.out.println("Response Json from API" + jsonResponse);

		// All Headers
		Header[] hearderArray = closableHttpsResponse.getAllHeaders();
		HashMap<String, String> allhearders = new HashMap<String, String>();
		for (Header header : hearderArray) {
			allhearders.put(header.getName(), header.getValue());
		}

		System.out.println("Headers Array -->" + allhearders);

	}

}
