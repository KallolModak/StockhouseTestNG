package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class NaturalResources extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public NaturalResources()
	{
	}//End public StockScreener(WebDriver driver)
	
	
	/*
	 * Locator for the portfolio text.
	 */
	public By naturalResourcesTxt(){
		 return By.xpath("//h1[contains(text(),'Natural Resources')]");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isNaturalResourcesTxtPresent(){
		 return isElementPresent(naturalResourcesTxt(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the Refine Your Search text.
	 */
	public By refineYourSearchTxt(){
		 return By.xpath("//h4[contains(text(),'Refine Your Search')]");
	}
	/*
	 * Function to check presence of the Refine Your Search text.
	 */
	public boolean isRefineYourSearchTxtPresent(){
		 return isElementPresent(refineYourSearchTxt(), MEDIUMWAIT);
	}


}
