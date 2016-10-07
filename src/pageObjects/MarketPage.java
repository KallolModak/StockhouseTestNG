package pageObjects;

import org.openqa.selenium.By;

import common.BrowserInstance;
import common.WebdriverUtility;

public class MarketPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public MarketPage()
	{
	}//End public MarketPage(WebDriver driver)
	/*
	 * Locator for market update.
	 */
	private By marketUpdate(){
		return By.xpath("//h1[contains(text(),'Markets')]");
	}
	/*
	 * Function to check the presence of market update header.
	 */
	public boolean isMarketUpdateHeadPresent(){
		return isElementPresent(marketUpdate(), MEDIUMWAIT);
	}
	/*
	 * Locator for market news today.
	 */
	private By marketNewsToday(){
		return By.xpath("//div[contains(text(),'S&P TSX Composite')]");
	}
	/*
	 * Function to check the presence of market update header.
	 */
	public boolean isMarketNewsTodayHeadPresent(){
		return isElementPresent(marketNewsToday(), MEDIUMWAIT);
	}
	/*
	 * Locator for iframe for full page.
	 */
	public void switchToFrameInMarket(){
		   BrowserInstance.driver.switchTo().frame(BrowserInstance.driver.findElement(By.xpath("//div[@class='frame-container']/iframe")));
		BrowserInstance.driver.switchTo().frame(BrowserInstance.driver.findElement(By.xpath("//iframe[contains(@id,'QSAPI_IFRAME')]")));
	}

}
