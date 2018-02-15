package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/register/");
		
		//1. isDisplayed() method: applicable for all element
		
		boolean b1=driver.findElement(By.id("submitButton")).isDisplayed();//for submit button
		System.out.println(b1);//true
		
		//2. isEnabled() method:
		
		boolean b2=driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b2);//false
		
		//select I agree checkbox:
		driver.findElement(By.name("agreeTerms")).click();
		boolean b3=driver.findElement(By.xpath("//button[@id='submitButton']")).isEnabled();
		System.out.println(b3);
		
		//3. isSelected() method: applicale only for Checkboxes,dropdown,radioButtons
		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b4);
		
		//de-select on i agree checkbox
		driver.findElement(By.name("agreeTerms")).click();
		boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b5);
		

	}

}
