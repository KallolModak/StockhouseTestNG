package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class BondsPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public BondsPage()
	{
	}//End public CurrenciesPage(WebDriver driver)
	/*
	 *Locator for Bonds table.
	 */
	private By bondsTable(){
		return By.xpath("//div[@class='custom-watch']/table");
	}
	/*
	 * Function to check the presence of Bonds table.
	 */
	public boolean isBondsTablePresent(){
		return isElementPresent(bondsTable(),MEDIUMWAIT);
	}

}
