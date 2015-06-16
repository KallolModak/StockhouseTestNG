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
		return By.xpath("//b[text()='Exchange:']");
	}
	/*
	 * Function to check the presence of Exchange header.
	 */
	public boolean isExchangeHeadPresent(){
		return isElementPresent(exchangeHead(),MEDIUMWAIT);
	}
	/*
	 *Locator for TSX Volume Activities header. 
	 */
	private By volActivitiesHead(int num){
		return By.xpath("//table[@id='market_mover']/tbody/tr["+num+"]/");
	}
	/*
	 * Function to check the presence of TSX Volume Activities header.
	 */
	public boolean isVolActivitiesHeadPresent(int num){
		return isElementPresent(volActivitiesHead(num),MEDIUMWAIT);
	}
}
