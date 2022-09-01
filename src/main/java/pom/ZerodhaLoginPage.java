package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {
	
	@FindBy (xpath = "//input[@id='userid']")private WebElement userid;

	@FindBy (xpath = "//input[@id='password']")private WebElement password;
	@FindBy (xpath = "//button[@type='submit']")private WebElement login;
	@FindBy (xpath = "//a[text()='Forgot user ID or password?']")private WebElement forgot;
	@FindBy (xpath = "//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signup;
	@FindBy (xpath = "//input[@id='pin']")private WebElement pin;
	@FindBy (xpath = "//button[@type='submit']")private WebElement continu;
	
	@FindBy (xpath = "(//form//label)[2]")private WebElement remember;
	@FindBy (xpath = "(//form//label)[2]") private WebElement forgetradio ;
	@FindBy (xpath = "(//input[@type=\"text\"])[1]")private WebElement UserIdhidden;
	@FindBy (xpath = "(//input[@type=\"text\"])[2]")private WebElement pan;
	@FindBy (xpath = "(//form//label)[5]")private WebElement emailradio;
	@FindBy (xpath = "(//form//label)[6]")private WebElement sms;
	@FindBy (xpath = "(//input[@type='text'])[3]")private WebElement email ;
	@FindBy (xpath =  "(//input[@type='text'])[4]")private WebElement captch;
	@FindBy (xpath = "//button[@type='submit']")private WebElement reset;
	
	public ZerodhaLoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId (String  id) {
		
		userid.sendKeys(id);
	}
	
	public void enterPassword(String pass) {
		
		password.sendKeys(pass);
	}
	
	public void clickOnLogin () {
		
		login.click();
	}
	
	public void enterPin(String pins,WebDriver driver) {
		
		//  FluentWait <WebDriver> wait = new FluentWait<WebDriver>(driver);
		//	wait.withTimeout(Duration.ofMillis(2000));//this is maximum time of wait
		//	wait.pollingEvery(Duration.ofMillis(100));//this is pooling time
		//	wait.ignoring(Exception.class);//this will handle exception
		//	wait.until(ExpectedConditions.visibilityOf(pin));//condition
			
		
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(pin));
		
		    pin.sendKeys(pins);
	}
	public void clickOncontinue () {
		
		continu.click();
	}
	public void switchToSignUpPage (WebDriver driver) {
		
		Set<String>handles = driver.getWindowHandles();
		Iterator <String> i =handles.iterator();
		
		while(i.hasNext()) {
			String handle = i.next();
			
			driver.switchTo().window(handle);
			
			String title = driver.getTitle();
			
			if(title.equals("")) {
				break;
			}
		}
	}
	public void clickOnForgetId () {
		
		forgot.click();
	}
	

	public void clickOnfogetradiobutton () {
		
		forgetradio.click();
		
	}
	public void clickOnRememberRadio () {
		remember.click();
	}
	public void userIdonhiddenBrowser (String id) {

		UserIdhidden.sendKeys(id);
	}
	public void enterPan (String panNO) {
		pan.sendKeys(panNO);
	}
	public void clickOnemailradio () {
		emailradio.click();
	}
	public void clickOnsms () {
		sms.click();
	}
	public void enterEmail(String emails) {
		email.sendKeys(emails);
	}
	public void entercaptch (String captcha) {
		captch.sendKeys(captcha);
	}
	public void clickOnReset () {
		reset.click();
	}
	
}


