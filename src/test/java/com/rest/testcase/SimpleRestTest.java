package com.rest.testcase;

import org.json.JSONObject;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;

import com.rest.commonUtils.CreateJsonTemplate;
import com.rest.commonUtils.GetStatus;
import com.rest.helpmethods.GetTopic;
import com.rest.helpmethods.SetUp;

public class SimpleRestTest extends SetUp{
	GetStatus getStatus = new GetStatus();
	CreateJsonTemplate jsonTemplate = new CreateJsonTemplate();
	GetTopic topicdetails = new GetTopic();
	
	int id = 2;
	String name= "Java";
	String description = "Quick start Java 2";
	
	/**
	 * Test Methods:
	 * postTopic
	 * updateTopic
	 * getTopic
	 * deleteTopic
	 */

	@SuppressWarnings("deprecation")
	@Test(groups = { "bvt","regression" }, description= "Add topics and validate using getTopic" )
	public void postTopic() {
		JSONObject topic=jsonTemplate.createTopicJson(id, name, description);

		System.out.println("--------Add Topic with id: " + id+ "-------");
		
		response = httpRequest.contentType("application/json").body(topic.toString()).post(url+"/topics");
		getStatus.getStatusCode(response, "postTopic");
		ATUReports.add("Verify Add Topic", "Add Topic By ID", "Add Topic", true);
	
		topicdetails.getTopicById(id);
	}

	@SuppressWarnings("deprecation")
	@Test(dependsOnMethods= { "postTopic"}, groups = { "regression" }, description= "Update topics and validate using getTopic")
	public void updateTopic() {
		JSONObject topic=jsonTemplate.createTopicJson(id, name, "Updated Description");
		
		System.out.println("--------Update Topic with id: " + id+ "------");

		response = httpRequest.contentType("application/json").body(topic.toString()).put(url+"/topics/"+id);
		getStatus.getStatusCode(response, "updateTopic");
		ATUReports.add("Verify Update Topic", "Update Topic", "Update Topic", true);
		
		topicdetails.getTopicById(id);
	}

	@SuppressWarnings("deprecation")
	@Test(dependsOnMethods= { "updateTopic"}, groups = { "regression" }, description= "Get All Topics, Validate Get Topic By Name" )
	public void getTopic() {
		System.out.println("--------Get All Topics-------");
		
		response = httpRequest.get(url+"/topics");
		
		getStatus.getStatusCode(response,"getTopic");
		getStatus.displayResponse(response);
		
		ATUReports.add("Verify Get Topic", "Get All Topics", "Get All Topics", true);
		
		topicdetails.getTopicByName("Java 8");
	}

	@SuppressWarnings("deprecation")
	@Test(dependsOnMethods= { "getTopic"}, groups = { "bvt","regression" }, description= "Delete topics and validate using getTopic" )
	public void deleteTopic() {
		System.out.println("--------Delete Topic with id: " + id+ "-------");
		response = httpRequest.contentType("application/json").delete(url+"/topics/"+id);
		getStatus.getStatusCode(response, "deleteTopic");
		ATUReports.add("Verify Delete Topic", "Delete Topic by ID", "Delete Topic By ID", true);
		//Check if delete is success
		topicdetails.getTopicById(id);
	}

}
