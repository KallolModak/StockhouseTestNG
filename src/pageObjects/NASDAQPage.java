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
		return By.xpath("//td[text()='NASDAQ Volume Actives']");
	}
	/*
	 * Function to check the presence of NASDAQ volume activities table header.
	 */
	public boolean isNASDAQVolActivitiesHeadPresent(){
		return isElementPresent(NASDAQVolActivities(),MEDIUMWAIT);
	}


}
