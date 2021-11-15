package com.qa.tests;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.client.RestClient;
import com.qa.restapi.TestBase;

public class GETAPITEST extends TestBase {
	TestBase testBase;
	String mainurl;
	String apiURL;
	String url;
	RestClient restClient;

	@BeforeMethod
	public void setUp() {

		testBase = new TestBase();
		mainurl = prop.getProperty("URL");
		apiURL = prop.getProperty("serviceURL");
		url = mainurl + apiURL;

	}

	@Test
	public void GetAPITest() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		restClient.get(url);

	}

}
