package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class Portfolio extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public Portfolio()
	{
	}//End public VideoPage(WebDriver driver)
	
	/*
	 * Locator for the portfolio text.
	 */
	public By portfolio(){
		 return By.xpath("//h1[contains(text(),'Portfolio')]");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isPortfolioTxtPresent(){
		 return isElementPresent(portfolio(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the portfolio text.
	 */
	public By portfolioTracker(){
		 return By.xpath("//h4[contains(text(),'Portfolio Tracker')]");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isPortfolioTrackerTxtPresent(){
		 return isElementPresent(portfolioTracker(), MEDIUMWAIT);
	}
	

}
