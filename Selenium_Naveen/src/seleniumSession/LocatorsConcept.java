package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//Launch Chrome
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		// https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=
		
		//1. xpath:
		
		/*driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Tom");
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Peter");
		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("123,New Street");*/
		
		//2. ID:
		
		//driver.findElement(By.id("firstname")).sendKeys("tamu");
		//driver.findElement(By.id("lastname")).sendKeys("Mamur");
		
		// 3.Name:
		
		//driver.findElement(By.name("firstname")).sendKeys("tamu");
		driver.findElement(By.name("lastname")).sendKeys("Mamur");
		
		//4. Linktext:
		
		//driver.findElement(By.linkText("Sign in")).click();
		
		//5.partialLinkText
		
		driver.findElement(By.partialLinkText("How to pick")).click();
		
		///6. cssSelectors
		
		driver.findElement(By.cssSelector("#firstname")).sendKeys("Tom");
		
		//7. className
		
		driver.findElement(By.className("ancAsb")).click();
		
		
		//driver.close();

	}

}
