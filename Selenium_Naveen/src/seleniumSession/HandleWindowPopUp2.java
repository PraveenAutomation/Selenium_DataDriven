package seleniumSession;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("//a[@class='blu']")).click();
		
		Set<String> handler=driver.getWindowHandles();
		
		Iterator<String> it=handler.iterator();
		
		String parentWinId=it.next();
		System.out.println("Parent Window ID: "+parentWinId);
		
		String childWinId=it.next();
		System.out.println("Child Window ID: "+childWinId);
		
		driver.switchTo().window(childWinId);
		Thread.sleep(1000);
		
		System.out.println("Child Page title: "+driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWinId);
		Thread.sleep(1000);
		
		System.out.println("Parent Page title: "+driver.getTitle());
		
		
	}
	
	
	

}
