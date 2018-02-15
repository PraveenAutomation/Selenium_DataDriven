package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		
//Get data from Excel::				
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Dell\\From11Nov2017WebDriver\\Selenium_Naveen\\src\\com\\testdata\\HalfEbayTestData1.xlsx");
		
		String firstName=reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstName);
		
		String lastName=reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastName);
		
		String address1=reader.getCellData("RegTestData", "address1", 2);
		System.out.println(address1);
		
		String address2=reader.getCellData("RegTestData", "address2", 2);
		System.out.println(address2);
		
		String city=reader.getCellData("RegTestData", "city", 2);
		System.out.println(city);
		
		String state=reader.getCellData("RegTestData", "state", 2);
		System.out.println(state);
		
		String pinCode=reader.getCellData("RegTestData", "pincode", 2);
		System.out.println(pinCode);
		
		String emailAddress=reader.getCellData("RegTestData", "emailaddress", 2);
		System.out.println(emailAddress);
		
//WebDriver Code::
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//Launch Chrome
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);
		driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);
		driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);
		
		Select select = new Select(driver.findElement(By.xpath("//*[@id='state']")));
		select.selectByVisibleText(state);
		
		//driver.findElement(By.xpath("//*[@id='state']")).sendKeys(state);
		
		driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(pinCode);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//*[@id='retype_email']")).sendKeys(emailAddress);
		
		

	}

}
