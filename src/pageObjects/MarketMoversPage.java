package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class MarketMoversPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public MarketMoversPage()
	{
	}//End public MarketMoversPage(WebDriver driver)

	/*
	 *Locator for Exchange header. 
	 */
	private By exchangeHead(){
		return By.xpath("//td[text()='Exchange']");
	}
	/*
	 * Function to check the presence of Exchange header.
	 */
	public boolean isExchangeHeadPresent(){
		return isElementPresent(exchangeHead(),MEDIUMWAIT);
	}
	/*
	 *Locator for Market movers page header. 
	 */
	private By marketMoverHead(){
		return By.xpath("//h1[contains(text(),'Market Movers')]");
	}
	/*
	 * Function to check the presence of Market movers page header. 
	 */
	public boolean isMarketMoverHeadPresent(){
		return isElementPresent(marketMoverHead(),MEDIUMWAIT);
	}
}
