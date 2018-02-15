package seleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDownHandles {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
		
		int Total_Label = list.size();
		System.out.println("Total no. of label:: "+Total_Label);
		
		//If we are going to click on all DropDowns/Options
		
/*		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			list.get(i).click();
		
		}
		*/
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			//If we have to click on only one option:			
			if(list.get(i).getText().contains("Oracle"))
			{
				list.get(i).click();
				break;
			}
		
		}
		


	}

}
