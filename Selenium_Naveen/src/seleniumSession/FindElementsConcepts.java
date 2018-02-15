package seleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcepts {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com/");
		
		//1. Find total no. of count of links
		//2. Print text of link
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		
		System.out.println(linkList.size());
		
		//For print the text of link
		for(int i=0;i<linkList.size();i++)
		{
			String linkText=linkList.get(i).getText();
			System.out.println(linkText);
		}
				

	}

}
