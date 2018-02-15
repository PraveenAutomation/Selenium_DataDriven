package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MvnRepoTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://mvnrepository.com/");
				
	}
	
	@Test
	public void mvnTitle()
	{
		String title=driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Maven Repository: Search/Browse/Explore1" , "Title is not Correct/Matched");
	}
	
	@Test
	public void elementDisplay()
	{
		boolean b=driver.findElement(By.xpath("//b[text()='Categories']")).isDisplayed();
		System.out.println(b);
		
		
		Assert.assertTrue(b, "if not Correct One Dude!!");
		//Assert.assertEquals(b, true);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
