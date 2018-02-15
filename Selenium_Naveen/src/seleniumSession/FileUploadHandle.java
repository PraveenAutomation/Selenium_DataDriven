package seleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("C:\\Users\\Dell\\Desktop\\java9.xml");
		
		
		// https://html.com/input-type-file/

	}

}
