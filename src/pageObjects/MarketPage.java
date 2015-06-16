package pageObjects;

import org.openqa.selenium.By;

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
		return By.xpath("//td[contains(text(),'Market Update')]");
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
		return By.xpath("//td[contains(text(),'Market News Today')]");
	}
	/*
	 * Function to check the presence of market update header.
	 */
	public boolean isMarketNewsTodayHeadPresent(){
		return isElementPresent(marketNewsToday(), MEDIUMWAIT);
	}


}
