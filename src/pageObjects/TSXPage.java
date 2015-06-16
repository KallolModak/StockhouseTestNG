package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class TSXPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public TSXPage()
	{
	}//End public TSXPage(WebDriver driver)
	/*
	 * Locator for TSX volume activities table header.
	 */
	private By TSXVolActivities(){
		return By.xpath("//td[text()='TSX Volume Actives']");
	}
	/*
	 * Function to check the presence of TSX volume activities table header.
	 */
	public boolean isTSXVolActivitiesHeadPresent(){
		return isElementPresent(TSXVolActivities(),MEDIUMWAIT);
	}

}
