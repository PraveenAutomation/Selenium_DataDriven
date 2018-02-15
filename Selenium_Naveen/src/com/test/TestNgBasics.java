package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	
	//Pre-conditions annotation -->Starting with @Before
	
	@BeforeSuite
	public void setUp()
	{
		System.out.println("setUp system property for chrome");
	}
	
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("launchBrowser");
	}
	
	@BeforeClass
	public void login()
	{
		System.out.println("login to app");
	}
	
	@BeforeMethod
	public void enterUrl()
	{
		System.out.println("enter URL");
	}
	
	//Test cases-->starting with @Test
	@Test
	public void googleTitleTest()
	{
		System.out.println("google Title Test");
	}
	
	//Post-condition-->starting with @After
	
	@AfterMethod
	public void logOut()
	{
		System.out.println("logOut from app");
	}
	
	@AfterTest
	public void deleteAllCookies()
	{
		System.out.println("delete all cookies");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("close the browser");
	}
	
	@AfterSuite
	public void generateReport()
	{
		System.out.println("generate all report");
	}
	

}
