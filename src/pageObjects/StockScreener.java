package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class StockScreener extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public StockScreener()
	{
	}//End public StockScreener(WebDriver driver)
	
	/*
	 * Locator for the portfolio text.
	 */
	public By featuredCompany(){
		 return By.xpath("//h4[text()='Featured Company']");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isFeaturedCompanyTxtPresent(){
		 return isElementPresent(featuredCompany(), MEDIUMWAIT);
	}

	/*
	 * Locator for the portfolio text.
	 */
	public By searchOptions(){
		 return By.xpath("//span[text()='Search Options']");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isSearchOptionsTxtPresent(){
		 return isElementPresent(searchOptions(), MEDIUMWAIT);
	}


}
