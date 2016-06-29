package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class BreakingNews extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public BreakingNews()
	{
	}//End public StockScreener(WebDriver driver)
	
	
	/*
	 * Locator for the portfolio text.
	 */
	public By reportListTxt(int i){
		 return By.xpath("//div[@class='column span-4']//div[@class='hub-article-container']["+i+"]//a");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public String getTextOfReportList(int i){
		 return safeGetText(reportListTxt(i), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the BreakingNews text.
	 */
	public By breakingNewsTxt(){
		 return By.xpath("//h1[contains(text(),'Breaking News')]");
	}
	/*
	 * Function to check presence of the BreakingNews text.
	 */
	public boolean isBreakingNewsTxtPresent(){
		 return isElementPresent(breakingNewsTxt(), MEDIUMWAIT);
	}

	private By textOfItem(int num){
		return By.xpath("//div[@class='hub-article-container']["+num+"]/h3/a");
	}
	
	public String getTextOfItem(int num){
		return safeGetText(textOfItem(num), MEDIUMWAIT);
	}


}
