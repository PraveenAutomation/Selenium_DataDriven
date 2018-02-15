package seleniumSession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		
		FileInputStream  ip=  new FileInputStream("C:\\Users\\Dell\\From11Nov2017WebDriver\\Selenium_Naveen\\src\\seleniumSession\\config.properties");
		
		prop.load(ip);
		
		//System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("Name"));
		System.out.println(prop.getProperty("age"));
		
		String url=prop.getProperty("URL");
		System.out.println(url);
		
		String browserName=prop.getProperty("Browser");
		System.out.println(browserName);
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\geckodriver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.internetexplorer.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\internetexplorer\\internetexplorerdriver.exe");
			driver= new InternetExplorerDriver();
		}
		
		driver.get(url);
		
		driver.findElement(By.xpath(prop.getProperty("firstName_xpath"))).sendKeys(prop.getProperty("firstName"));
		
		driver.findElement(By.xpath(prop.getProperty("lastName_xpath"))).sendKeys(prop.getProperty("lastName"));
		
		driver.findElement(By.xpath(prop.getProperty("city_xpath"))).sendKeys(prop.getProperty("city"));
		

	}

}
