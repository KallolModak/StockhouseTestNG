package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class CSEPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public CSEPage()
	{
	}//End public CSEPage(WebDriver driver)
	/*
	 * Locator for CSE volume activities table header.
	 */
	private By CSEVolActivities(){
		return By.xpath("//td[text()='CSE Volume Actives']");
	}
	/*
	 * Function to check the presence of CSE volume activities table header.
	 */
	public boolean isCSEVolActivitiesHeadPresent(){
		return isElementPresent(CSEVolActivities(),MEDIUMWAIT);
	}

}
