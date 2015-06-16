package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class AMEXPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public AMEXPage()
	{
	}//End public AMEXPage(WebDriver driver)
	/*
	 * Locator for AMEX volume activities table header.
	 */
	private By AMEXVolActivities(){
		return By.xpath("//td[text()='NYSE MKT AMX Volume Actives']");
	}
	/*
	 * Function to check the presence of AMEX volume activities table header.
	 */
	public boolean isAMEXVolActivitiesHeadPresent(){
		return isElementPresent(AMEXVolActivities(),MEDIUMWAIT);
	}

}
