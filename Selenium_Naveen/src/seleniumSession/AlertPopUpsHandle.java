package seleniumSession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpsHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();//Click on Go btn
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		String text = alert.getText();
		
		if(text.equals("Please enter a valid user name"))
		{
			System.out.println("Correct alert masg");
		}
		else
		{
			System.out.println("In-correct alert msg");
		}
		
		
		alert.accept();//for Click on OK btn
		//alert.dismiss();//for click on Cancel btn
		
		driver.close();
		
		

	}

}
