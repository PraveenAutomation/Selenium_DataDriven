package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCalenderByJS {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.spicejet.com/");
		
		
		WebElement date = driver.findElement(By.id("ctl00_mainContent_txt_Todate"));
		String dateVal = "28-01-2018";
		
		selectDateByJS(driver, date, dateVal);

	}
	
	public static void selectDateByJS(WebDriver driver,WebElement element, String dateVal )
	{
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
	}

}
