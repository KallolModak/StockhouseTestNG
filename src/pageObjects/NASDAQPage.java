package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class NASDAQPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public NASDAQPage()
	{
	}//End public NASDAQPage(WebDriver driver)
	/*
	 * Locator for NASDAQ volume activities table header.
	 */
	private By NASDAQVolActivities(){
		return By.xpath("//h1[contains(text(),'NASDAQ')]");
	}
	/*
	 * Function to check the presence of NASDAQ volume activities table header.
	 */
	public boolean isNASDAQVolActivitiesHeadPresent(){
		return isElementPresent(NASDAQVolActivities(),MEDIUMWAIT);
	}

	/*
	 * Locator for NASDAQ volume activities table header.
	 */
	private By NASDAQTable(){
		return By.xpath("//div[text()='TSX Composite Intraday']");
	}
	/*
	 * Function to check the presence of NASDAQ volume activities table header.
	 */
	public boolean isNASDAQTableHeadPresent(){
		return isElementPresent(NASDAQTable(),MEDIUMWAIT);
	}

}
