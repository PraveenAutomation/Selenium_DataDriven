package seleniumSession;

import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Praveenk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		
		WebElement  lognbtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
		
		//call flash() method
		flash(lognbtn, driver);
		
		//call drawBorder() method
		drawBorder(lognbtn, driver);
		//ScreenShot Utility
		Date d = new Date();
		String fileName = d.toString().replace(" ", "_").replace(":", "_")+".jpg";
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scr, new File("E:\\BULUT DRIVE\\SELENIUM\\AuroScreeshot\\screenshot"+fileName));
	
		//Call generateAlert() method
		genrateAlert(driver, "There is an issue with login button");
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		//Calling click() method--->click on any button using JS
		clickElementByJS(lognbtn, driver);
		
		//Refresh page
		//1. By Using Selenim
		driver.navigate().refresh();
		//2. By using JavascriptExecutor-->call refreshBrowser() method
		refreshBrowserByJS(driver);
		
		//Get the title of Page by JS
		System.out.println(getTitleByJS(driver));
		
		//Get the page innerText by JS
		System.out.println(getPageInnertext(driver));
		
		//scrollPageDown() method call
		scrollpageDown(driver);
		
		


	}
	
	public static void flash(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("bachgroundColor");
		for(int i=0;i<100;i++)
		{
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}
	
	public static void changeColor(String color,WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor ='"+color+"'", element);
		
		try{
			Thread.sleep(20);
			
		}catch(InterruptedException e)
		{
			
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	//generateAlert method()
	public static void genrateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowserByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0);");
	}
	
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
		
	}
	
	public static String getPageInnertext(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollpageDown(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

}
