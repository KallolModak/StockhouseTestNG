package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class OpenionPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public OpenionPage()
	{
	}//End public VideoPage(WebDriver driver)
	
	/*
	 * Locator for the portfolio text.
	 */
	public By stockhouseReports(){
		 return By.xpath("//h4[contains(text(),'Stockhouse Reports')]");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isStockhouseReportsTxtPresent(){
		 return isElementPresent(stockhouseReports(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the portfolio text.
	 */
	public By independentReports(){
		 return By.xpath("//h4[contains(text(),'Independent Reports')]");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isIndependentReportsTxtPresent(){
		 return isElementPresent(independentReports(), MEDIUMWAIT);
	}
	

}
