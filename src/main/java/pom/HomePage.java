package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	@FindBy (xpath = "//input[@type='text']")private WebElement search;
	@FindBy (xpath = "//span[@class='tradingsymbol']")private List<WebElement> searchResult;
	@FindBy (xpath = "(//button[@class='button-blue'])[1]")private WebElement searchBuy;
	@FindBy (xpath = "//button[@class='button-orange sell']")private WebElement searchSell;
	@FindBy (xpath = "(//button[@type='button'])[4]")private WebElement searchDepth;
	@FindBy (xpath = "(//button[@class='button-outline'])[1]")private WebElement searchMarketDepth;
	@FindBy (xpath = "(//div[@data-balloon-length='large'])[1]") private WebElement mis;
	@FindBy (xpath = "(//input[@name='orderType'])[1]")private WebElement market;
	@FindBy (xpath = "(//input[@type=\"number\"])[2]")private WebElement price;
	@FindBy (xpath = "(//input[@type=\"number\"])[3]")private WebElement triggerprice;
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchStock (String StockName,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(StockName);
	}
	
	public int checkSearchResultNumber () {
     int a = searchResult.size();
    
     return a;
	}
	
	public void searchAndMoveOnStock (WebDriver driver,String stockText) {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(searchBuy));
		for(int i = 0;i<searchResult.size();i++) {
			
			WebElement liststock =searchResult.get(i);
			
			String stockname = liststock.getText();
			
			if(stockname.equals(stockText)) {
				Actions action = new Actions (driver);
				action.moveToElement(liststock);
				action.build().perform();
				
				break;
			}
		}
	}
	public void searchAndClickOnBuy (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(searchBuy));
		
		searchBuy.click();
		}
	
	public void checktheTriggerButtonisDisable (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(searchBuy));
		
		boolean result = triggerprice.isEnabled();
		System.out.println(result);
		Assert.assertFalse(result);
	}
	public void clickOnMISRadioButton (WebDriver driver) {
	
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(mis));
		mis.click();
		
	}
	public void clickOnMarketOrder () {
		market.click();
	}
	public boolean clicOnMarketAndcheckpriceAndTriggerpriceDisable (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(mis));
		mis.click();
		market.click();
		boolean disable =price.isEnabled();
		
		return disable;

	}
	public void searchAndClickOnSell (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(searchBuy));
		
		searchBuy.click();
	}
	public void searchAndClickOnDepth (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(searchDepth));
		searchDepth.click();
	}
	public void searchAndClickOnMarketDepth (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(searchMarketDepth));
		searchMarketDepth.click();
	}
}
