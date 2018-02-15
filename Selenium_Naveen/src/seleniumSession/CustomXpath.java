package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com/");
		
		//driver.findElement(By.xpath("//*[@id='gh-ac']")).sendKeys("Java");
		//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Java Book");
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java Developer");
		//driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("Selenium Dev");
		//driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Automation Testing");
		//driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-')]")).sendKeys("Automation Expert");
		//driver.findElement(By.xpath("//input[@spellcheck='false']")).sendKeys("Architect Expert");
		driver.findElement(By.xpath("//input[starts-with(@class,'gh-tb ui-')]")).sendKeys("Arcitect Expert");
		
		//--Will continue next time
		

	}

}
