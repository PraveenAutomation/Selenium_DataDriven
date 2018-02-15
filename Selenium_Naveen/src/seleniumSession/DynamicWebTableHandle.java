package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com");
		
		driver.findElement(By.name("username")).sendKeys("Praveenk");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()", loginBtn);
		
		//WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		 //JavascriptExecutor js = (JavascriptExecutor)driver;
		 //js.executeScript("arguments[0].click()", loginBtn);
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		//*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[6]/td[2]/a
		//*[@id='vContactsForm']/table/tbody/tr[7]/td[2]/a
		
		//Method:-1
		String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
		String after_xpath = "]/td[2]/a";
		
		for(int i=4;i<=7;i++)
		{
			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			System.out.println(name);
			
			
			if(name.contains("Natwar Lal"))
			{		
				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
				
				//driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[" +i+ "]/td[2]/a")).click();
			}
		}
		
		//Method:-2
		driver.findElement(By.xpath("//a[contains(text(), 'Natwar Lal')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Bahu Bali')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}

}
