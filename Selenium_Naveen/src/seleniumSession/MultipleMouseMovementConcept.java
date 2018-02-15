package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleMouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//driver.get("htttps://www.spicejet.com");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.spicejet.com/");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.linkText("MENU"))).build().perform();
		action.moveToElement(driver.findElement(By.linkText("Travel Info"))).build().perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Carriage of Live Animals")).click();
		
		//System.out.println(driver.getTitle());
		String title=driver.getTitle();
		
		if(title.equals("SpiceJet Policy for Carriage of Live Animals in Flight"))
		{
			System.out.println("Correct message is: " +title);
		}
		else
		{
			System.out.println("In-Correct message");
		}
		

	}

}
