package com.rest.commonUtils;

import org.testng.Assert;

import io.restassured.response.Response;
import atu.testng.reports.ATUReports;

import com.rest.helpmethods.SetUp;

public class GetStatus extends SetUp{

	@SuppressWarnings("deprecation")
	public void getStatusCode(Response response, String method){
		
		System.out.println(response.getStatusLine());
		if(response.statusLine().contains("200") || response.statusLine().contains("201") || response.statusLine().contains("204")) {
			System.out.println(method + " Success");
		}
		else{
			ATUReports.add(method+ " : Fail", "", true);
			Assert.assertTrue(false, method+ " Fail");
		}
	}

	public void displayResponse(Response response) {
		System.out.println("Response Body is =>  " + response.getBody().asString());
	}
}
