package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandles {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("Praveenk");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()", loginBtn);
		 
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
		
		Thread.sleep(2000);
		driver.switchTo().frame("mainpanel");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(), 'Contacts')]")).click();
		
		//mainpanel
		
		
		
		//driver.close();
	}

}
