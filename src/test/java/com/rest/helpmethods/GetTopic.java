package com.rest.helpmethods;

import com.rest.commonUtils.GetStatus;
import com.rest.testcase.SetUp;

public class GetTopic extends SetUp{
	GetStatus getStatus = new GetStatus();
	
	/**
	 *  Methods:
	 *  getTopicById
	 *  getTopicByName
	 */
	
	public void getTopicById(int id) {
		System.out.println("--------Get Topic By Id: " + id+ "-------");
		response = httpRequest.get(url+"/topics/"+id);
	
		getStatus.getStatusCode(response, "getTopicById");
		getStatus.displayResponse(response);
	}

	public void getTopicByName(String name) {
		System.out.println("--------Get Topic By Name: "+ name+ "-------");
		response = httpRequest.get(url+"/topics?name="+name);
	
		getStatus.getStatusCode(response, "getTopicByName");
		getStatus.displayResponse(response);
	}
}
