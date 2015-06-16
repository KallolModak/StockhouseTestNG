package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class FeaturedNews extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public FeaturedNews()
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
	 * Locator for the MoreETFArticles text.
	 */
	public By featuredNewsTxt(){
		 return By.xpath("//h1[contains(text(),'Featured News')]");
	}
	/*
	 * Function to check presence of the MoreETFArticles text.
	 */
	public boolean isFeaturedNewsTxtPresent(){
		 return isElementPresent(featuredNewsTxt(), MEDIUMWAIT);
	}


}
