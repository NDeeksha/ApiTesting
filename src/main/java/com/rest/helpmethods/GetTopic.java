package com.rest.helpmethods;

import atu.testng.reports.ATUReports;

import com.rest.commonUtils.GetStatus;

public class GetTopic extends SetUp{
	GetStatus getStatus = new GetStatus();
	
	/**
	 *  Methods:
	 *  getTopicById
	 *  getTopicByName
	 */
	
	@SuppressWarnings("deprecation")
	public void getTopicById(int id) {
		System.out.println("--------Get Topic By Id: " + id+ "-------");
		response = httpRequest.get(url+"/topics/"+id);
	
		getStatus.getStatusCode(response, "getTopicById");
		getStatus.displayResponse(response);
		ATUReports.add("Get Topic By ID", "Get Topic By ID", "Get Topic", true);
	}

	@SuppressWarnings("deprecation")
	public void getTopicByName(String name) {
		System.out.println("--------Get Topic By Name: "+ name+ "-------");
		response = httpRequest.get(url+"/topics?name="+name);
	
		getStatus.getStatusCode(response, "getTopicByName");
		getStatus.displayResponse(response);
		ATUReports.add("Get Topic By Name", "Get Topic By Name", "Get Topic", true);
	}
}
