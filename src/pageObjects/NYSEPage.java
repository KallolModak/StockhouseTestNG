package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class NYSEPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public NYSEPage()
	{
	}//End public NYSEPage(WebDriver driver)
	/*
	 * Locator for NYSE volume activities table header.
	 */
	private By NYSEVolActivities(){
		return By.xpath("//td[text()='NYSE Volume Actives']");
	}
	/*
	 * Function to check the presence of NYSE volume activities table header.
	 */
	public boolean isNYSEVolActivitiesHeadPresent(){
		return isElementPresent(NYSEVolActivities(),MEDIUMWAIT);
	}

}
