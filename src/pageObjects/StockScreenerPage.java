package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class StockScreenerPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public StockScreenerPage()
	{
	}//End public StockScreenerPage(WebDriver driver)
	/*
	 * Locator for featured company header.
	 */
	private By FeaturedCompany(){
		return By.xpath("//h4[text()='Featured Company']");
	}
	/*
	 * Function to check the presence of featured company header.
	 */
	public boolean isFeaturedCompanyHeadPresent(){
		return isElementPresent(FeaturedCompany(), MEDIUMWAIT);
	}
	/*
	 * Locator for search option table header.
	 */
	private By SearchOption(){
		return By.xpath("//span[text()='Search Options']");
	}
	/*
	 * Function to check the presence of search option table header.
	 */
	public boolean isSearchOptionHeadPresent(){
		return isElementPresent(SearchOption(), MEDIUMWAIT);
	}

}
