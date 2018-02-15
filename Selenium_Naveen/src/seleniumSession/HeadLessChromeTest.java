package seleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChromeTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		
		//ChromeOptions options = new ChromeOptions(); 
		//options.addArguments("window-size=1400,800"); 
		//options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		
		String title=driver.getTitle();
		System.out.println(title);

	}

}
