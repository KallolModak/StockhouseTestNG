package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class DJIAPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public DJIAPage()
	{
	}//End public DJIAPage(WebDriver driver)
	/*
	 * Locator for DJIA volume activities table header.
	 */
	private By DJIAVolActivities(){
		return By.xpath("//h1[contains(text(),'Dow Jones Industrial Average')]");
	}
	/*
	 * Function to check the presence of DJIA volume activities table header.
	 */
	public boolean isDJIAVolActivitiesHeadPresent(){
		return isElementPresent(DJIAVolActivities(),MEDIUMWAIT);
	}

}
