package com.rest.testcase;

import org.json.JSONObject;
import org.testng.annotations.Test;

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
	
	@Test
	public void postTopic() {
		JSONObject topic=jsonTemplate.createTopicJson(id, name, description);

		System.out.println("--------Add Topic with id: " + id+ "-------");
		
		response = httpRequest.contentType("application/json").body(topic.toString()).post(url+"/topics");
		getStatus.getStatusCode(response, "postTopic");
	
		topicdetails.getTopicById(id);
	}

	@Test(dependsOnMethods= { "postTopic"} )
	public void updateTopic() {
		JSONObject topic=jsonTemplate.createTopicJson(id, name, "Updated Description");
		
		System.out.println("--------Update Topic with id: " + id+ "------");

		response = httpRequest.contentType("application/json").body(topic.toString()).put(url+"/topics/"+id);
		getStatus.getStatusCode(response, "updateTopic");
		
		topicdetails.getTopicById(id);
	}

	@Test(dependsOnMethods= { "updateTopic"} )
	public void getTopic() {
		System.out.println("--------Get All Topics-------");
		
		response = httpRequest.get(url+"/topics");
		
		getStatus.getStatusCode(response,"getTopic");
		getStatus.displayResponse(response);
		
		topicdetails.getTopicByName("Java 8");
	}

	@Test(dependsOnMethods= { "getTopic"} )
	public void deleteTopic() {
		System.out.println("--------Delete Topic with id: " + id+ "-------");
		response = httpRequest.contentType("application/json").delete(url+"/topics/"+id);
		getStatus.getStatusCode(response, "deleteTopic");
		
		//Check if delete is success
		topicdetails.getTopicById(id);
	}

}
