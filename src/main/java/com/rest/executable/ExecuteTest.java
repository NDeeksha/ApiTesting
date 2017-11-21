package com.rest.executable;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Listeners;
import org.testng.collections.Lists;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

import com.rest.commonUtils.FileLoader;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,	MethodListener.class })
public class ExecuteTest {
	{	
		System.setProperty("atu.reporter.config", "D:\\E\\luna\\rest\\src\\test\\resources\\atu.properties");
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG tng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add(FileLoader.getFilePath("suites/",args[0].toString()+".xml" ));//path to xml..
		tng.setTestSuites(suites);
		tng.addListener(tla);
		tng.run();
		}
}
