package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterTest {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public void setUp(String url,String browser)
	{
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		driver = new ChromeDriver();
		}else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	@Parameters({"browser","url","emailid"})
	public void yahooLoginTest(String url,String emailid,String browser)
	{
		
		driver.findElement(By.xpath("//*[@id='login-username']")).clear();
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(emailid);
		driver.findElement(By.xpath("//*[@id='login-signin']")).click();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
