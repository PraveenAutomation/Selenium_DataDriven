package seleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\BULUT DRIVE\\New Software\\Naveen_Mat\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//Launch Chrome
		driver.get("https://www.google.com");
		
	String title=driver.getTitle();
	System.out.println(title);
	
	//Validation Point:
	if(title.equals("Google"))
	{
		System.out.println("Correct tile");
	}
	else
	{
		System.out.println("In-correct tiltle");
	}
		
		
		String Curr_URL =driver.getCurrentUrl();
		
		System.out.println("Current URL:: "+Curr_URL);
		
		String Page_Source=driver.getPageSource();
		//System.out.println("Complete Page Source::"+Page_Source);
		
		driver.close();
		
	}

}
