package test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parameterization;
import utility.Report;
@Listeners(utility.Listeners.class)
public class LoginPageTest extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest 
	public void addReport () {
		reports = Report.generateReport();
	}
	
	
	@BeforeMethod
	
	public void launchBrowser () {
		driver = LaunchBrowser.chromeBrowser();
	}
	
	@Test
	public void zerodhaLoginTest () throws InterruptedException, EncryptedDocumentException, IOException {
		
		test = reports.createTest("zerodhaLoginTest");
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage (driver);
		
		String id = Parameterization.getData("credentials", 0, 1);
		String pass = Parameterization.getData("credentials", 1, 1);
		String pin = Parameterization.getData("credentials", 2, 1);
		
		zerodhaloginpage.enterUserId(id);
		zerodhaloginpage.enterPassword(pass);
		zerodhaloginpage.clickOnLogin();
	
		zerodhaloginpage.enterPin(pin, driver);
		Assert.assertTrue(false);

		zerodhaloginpage.clickOncontinue();
		
		
		
	}
	@AfterMethod
	public void postTest (ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
			
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
			
		}
		else {
			test.log(Status.SKIP,result.getName());
		}
	}
	@AfterTest 
	public void flushReport () {
		reports.flush();
	}
	

}
