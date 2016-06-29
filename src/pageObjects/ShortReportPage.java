package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class ShortReportPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public ShortReportPage()
	{
	}//End public StockScreener(WebDriver driver)
	
	
	/*
	 * Locator for the short report text.
	 */
	public By reportListTxt(int i){
		 return By.xpath("//div[@class='column span-3']/div[@class='hub-article-container']["+i+"]//a");
	}
	/*
	 * Function to get text of short report text.
	 */
	public String getTextOfReportList(int i){
		 return safeGetText(reportListTxt(i), MEDIUMWAIT);
	}


}
