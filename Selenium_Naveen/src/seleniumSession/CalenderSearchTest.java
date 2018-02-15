package seleniumSession;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com");
		
		driver.findElement(By.name("username")).sendKeys("Praveenk");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		
		WebElement  loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()", loginBtn);
		
		Thread.sleep(2000);
		
		driver.switchTo().frame("mainpanel");
		
		String date = "31-September-2017";
		String dateArr[] = date.split("-");
		
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		
		Select select1 = new Select(driver.findElement(By.name("slctYear")));
		select1.selectByVisibleText(year);
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		
		String befor_Xpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String after_Xpath = "]/td[";
		
		final int TotalWeekDay =7;
		
		boolean flag = false;
		String dayVal = null;
		for(int rowNum=2;rowNum<=7;rowNum++)
		{
			for(int colNum=1;colNum<=TotalWeekDay;colNum++)
			{
				try{
				dayVal = driver.findElement(By.xpath(befor_Xpath+rowNum+after_Xpath+colNum+"]")).getText();
				//int TotalDays = dayVal.length();
				//System.out.println("Total no od days::"+TotalDays);
				}catch (Exception e)
				{
					System.out.println("Please enter a correct date value");
					flag = false;
					break;
				}
				
				System.out.println(dayVal);
				
				if(dayVal.equals(day))
				{
					driver.findElement(By.xpath(befor_Xpath+rowNum+after_Xpath+colNum+"]")).click();
					flag=true;
					break;
				}
			}
			if(flag)
			{
				break;
			}
				
		}

	}

}
