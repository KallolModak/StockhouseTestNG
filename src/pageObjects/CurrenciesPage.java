package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class CurrenciesPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public CurrenciesPage()
	{
	}//End public CurrenciesPage(WebDriver driver)
	/*
	 *Locator for Currency table.
	 */
	private By currencyTable(){
		return By.xpath("//div[@class='custom-watch']/table");
	}
	/*
	 * Function to check the presence of Currency table.
	 */
	public boolean isCurrencyTablePresent(){
		return isElementPresent(currencyTable(),MEDIUMWAIT);
	}

}
