package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;

public class ResetPageTest {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser () {
		driver = LaunchBrowser.chromeBrowser();
	}
	
	
		
	
	
	@Test
	public void resetUserId () throws InterruptedException {
		
		
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage (driver);
		zerodhaloginpage.clickOnForgetId();
		Thread.sleep(4000);
		zerodhaloginpage.clickOnfogetradiobutton();
		//zerodhaloginpage.clickOnRememberRadio();
		zerodhaloginpage.enterPan("12345");
		zerodhaloginpage.clickOnemailradio();
		//zerodhaloginpage.clickOnsms();
		zerodhaloginpage.enterEmail("email");
		zerodhaloginpage.entercaptch("1234");
		zerodhaloginpage.clickOnReset();
		
	}

}
