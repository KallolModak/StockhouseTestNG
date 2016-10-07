package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class TSXVPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public TSXVPage()
	{
	}//End public TSXVPage(WebDriver driver)
	/*
	 * Locator for TSXV volume activities table header.
	 */
	private By TSXVentureVolActivities(){
		return By.xpath("//h1[contains(text(),'TSX Venture')]");
	}
	/*
	 * Function to check the presence of TSXV volume activities table header.
	 */
	public boolean isTSXVentureVolActivitiesHeadPresent(){
		return isElementPresent(TSXVentureVolActivities(),MEDIUMWAIT);
	}


}
