package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class CanadianPressRelease extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public CanadianPressRelease()
	{
	}//End public StockScreener(WebDriver driver)
	
	
	/*
	 * Locator for the portfolio text.
	 */
	public By reportListTxt(int i){
		 return By.xpath("//div[@class='press-releases-content']/table/tbody/tr[@class='pr-row']["+i+"]/td[1]/a");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public String getTextOfReportList(int i){
		 return safeGetText(reportListTxt(i), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the Canadian Press Releases text.
	 */
	public By canadianPressReleasesTxt(){
		 return By.xpath("//h1[contains(text(),'Canadian Press Releases')]");
	}
	/*
	 * Function to check presence of the Canadian Press Releases text.
	 */
	public boolean isCanadianPressReleasesTxtPresent(){
		 return isElementPresent(canadianPressReleasesTxt(), MEDIUMWAIT);
	}


}
