package com.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
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
		
		driver.get("https://www.google.com");
	}
	
	
	@Test(priority=2,groups ="Title")
	public void googleTitleTest()
	{
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority=1,groups ="Logo")
	public void googleLogoTest()
	{
		boolean b=driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		System.out.println(b);
	}
	
	@Test(priority=4,groups ="Link Test")
	public void googleLinkTest()
	{
		boolean b= driver.findElement(By.linkText("mail")).isDisplayed();
		System.out.println(b);
	}
	
	@Test(priority=3,groups ="Text")
	public void getText()
	{
		String text=driver.findElement(By.xpath("//div//span[text()='India']")).getText();
		System.out.println(text);
	}
	
	@Test(priority=5,groups ="Text")
	public void getText2()
	{
		String tagName=driver.findElement(By.xpath("//input[@type='submit' and @name='btnI']")).getTagName();
		System.out.println(tagName);
	}
	
	@Test(priority=6,groups ="Text")
	public void getTagName()
	{
		Dimension dim=driver.findElement(By.linkText("Privacy")).getSize();
		System.out.println(dim);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
