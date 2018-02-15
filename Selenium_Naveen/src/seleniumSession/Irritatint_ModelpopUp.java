package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Irritatint_ModelpopUp {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:/BULUT DRIVE/New Software/Naveen_Mat/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Praveenk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		
		
		driver.switchTo().frame("intercom-borderless-frame");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
		
		
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		System.out.println(driver.getTitle());
		
		driver.close();
		

	}

}
