package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWaitConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		driver.get("https://www.facebook.com");
		
		//clickOn(driver, locator,timeout);
		clickOn(driver, driver.findElement(By.xpath("//*[@id='u_0_2']")), 20);//for login button
		clickOn(driver, driver.findElement(By.xpath("//*[@id='reg_pages_msg']/a")), 10);//for create a apge link
		


	}
	
	public static void clickOn(WebDriver driver,WebElement locator, int timeout)
	{
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeout)
				.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

}
