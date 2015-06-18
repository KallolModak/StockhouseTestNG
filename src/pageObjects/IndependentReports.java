package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class IndependentReports extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public IndependentReports()
	{
	}//End public StockScreener(WebDriver driver)
	
	
	/*
	 * Locator for the portfolio text.
	 */
	public By reportListTxt(int i){
		 return By.xpath("//div[@class='column span-3']//div[@class='hub-article-container']["+i+"]//a");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public String getTextOfReportList(int i){
		 return safeGetText(reportListTxt(i), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the MoreETFArticles text.
	 */
	public By independentReportsTxt(){
		 return By.xpath("//h1[text()='Independent Reports']");
	}
	/*
	 * Function to check presence of the MoreETFArticles text.
	 */
	public boolean isIndependentReportsTxtPresent(){
		 return isElementPresent(independentReportsTxt(), MEDIUMWAIT);
	}


}
