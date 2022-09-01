package pojo;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static WebDriver chromeBrowser () {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions ();
		option.addArguments("--disable-notifications");//to disable notifications from chrome browser
		
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver (option);
		
		driver.navigate().to("https://kite.zerodha.com/");
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));//implicit wait, 
		
		
		return driver;
	}

}
