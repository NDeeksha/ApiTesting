package com.rest.helpmethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeTest;

import com.rest.helpmethods.SetUp;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class SetUp {

	protected Response response;
	protected String url="http://10.51.236.53:9001";
	protected RequestSpecification httpRequest = RestAssured.given();

	{	
		System.setProperty("atu.reporter.config", "D:\\E\\luna\\rest\\src\\test\\resources\\atu.properties");
	}

// 	@BeforeTest
// 	public void setProxy() 
// 	{
// 		System.setProperty("http.proxyHost", "goaproxy.persistent.co.in");
// 		System.setProperty("http.proxyPort", "8080");
// 		SetUp.atuSetup();
// 	}

	public Response getResponse() {
		return response;
	}

	public String getUrl() {
		return url;
	}

	public RequestSpecification getHttpRequest() {
		return httpRequest;
	}

	// Setup for ATU reporters
	public static void atuSetup(){
		ATUReports.indexPageDescription ="Automation Report";
		ATUReports.currentRunDescription="Automation Test Run";
		ATUReports.setAuthorInfo("Nagadeeksha", Utils.getCurrentTime(), "1.0");
	}

}
