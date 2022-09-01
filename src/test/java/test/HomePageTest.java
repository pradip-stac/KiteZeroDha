package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.HomePage;
import pom.ZerodhaLoginPage;
import utility.Parameterization;

public class HomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void lauchBrowser () throws EncryptedDocumentException, IOException {
		driver = LaunchBrowser.chromeBrowser();
        
		ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage (driver);
		
		String id = Parameterization.getData("credentials", 0, 1);
		String pass = Parameterization.getData("credentials", 1, 1);
		String pin = Parameterization.getData("credentials", 2, 1);
		
		zerodhaloginpage.enterUserId(id);
		zerodhaloginpage.enterPassword(pass);
		zerodhaloginpage.clickOnLogin();
	
		zerodhaloginpage.enterPin(pin, driver);

		zerodhaloginpage.clickOncontinue();
		
		
	}
	@Test
	public void searchStocks () {
		HomePage homepage = new HomePage (driver);
		homepage.searchStock("Tata", driver);
		
	}
	@Test
	public void checkSearchReslt () {
		HomePage homepage = new HomePage (driver);
		homepage.searchStock("Tata", driver);
		int x=homepage.checkSearchResultNumber();
		System.out.println(x);
	     Assert.assertTrue(x>0);

	}
	@Test
	public void searchAndMoveonSearchStock() throws InterruptedException {
		HomePage homepage = new HomePage (driver);
		homepage.searchStock("Tata", driver);
	    Thread.sleep(3000);
		homepage.searchAndMoveOnStock(driver, "TATASTLLP");
		
	}
	@Test
	public void searchAndClickOnBuys () throws InterruptedException {
		HomePage homepage = new HomePage (driver);
		homepage.searchStock("Tata", driver);
	    Thread.sleep(3000);
		homepage.searchAndMoveOnStock(driver, "TATASTLLP");
		homepage.searchAndClickOnBuy(driver);
		
	}
	@Test
	public void clickonBuyandCheckthetriggerbuttonisdisabled () throws InterruptedException {
		HomePage homepage = new HomePage (driver);
		homepage.searchStock("Tata", driver);
	    Thread.sleep(3000);
		homepage.searchAndMoveOnStock(driver, "TATASTLLP");
		homepage.searchAndClickOnBuy(driver);
		homepage.checktheTriggerButtonisDisable(driver);
		
		
	}
	@Test
	public void clickOnmis () {
		HomePage homepage = new HomePage (driver);
		homepage.searchStock("Tata", driver);
	  
		homepage.searchAndMoveOnStock(driver, "TATASTLLP");
		homepage.searchAndClickOnBuy(driver);
		
		homepage.clickOnMISRadioButton(driver);
		
	}
	
	
	@Test 
	public void checkwhenweclickonMistriggerpriceAndPrice () {
		HomePage homepage = new HomePage (driver);
		homepage.searchStock("Tata", driver);
	  
		homepage.searchAndMoveOnStock(driver, "TATASTLLP");
		homepage.searchAndClickOnBuy(driver);
		
		homepage.clickOnMISRadioButton(driver);
	    boolean a =homepage.clicOnMarketAndcheckpriceAndTriggerpriceDisable(driver);
	    Assert.assertFalse(a);
	}
	@Test
	public void searchAndClickOnSell() {
		
		HomePage homepage = new HomePage (driver);
		homepage.searchStock("tata", driver);
		homepage.searchAndMoveOnStock(driver, "TATASTLLP");
		homepage.searchAndClickOnSell(driver);

	}
	@Test
	public void searchAndClickOnDepth () {
		HomePage homepage = new HomePage (driver);
		homepage.searchStock("tata", driver);
		homepage.searchAndMoveOnStock(driver, "TATASTLLP");
		homepage.searchAndClickOnDepth(driver);
	}
	@Test
	public void searchAndClicOnMarketDepth () {
		HomePage homepage = new HomePage (driver);
		homepage.searchStock("tata", driver);
		homepage.searchAndMoveOnStock(driver, "TATASTLLP");
		homepage.searchAndClickOnMarketDepth(driver);
	}
	
	
	
	
	
	
	
	
	

}
