package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class BestOfBoardsAndBlogs extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public BestOfBoardsAndBlogs()
	{
	}//End public StockScreener(WebDriver driver)
	
	
	/*
	 * Locator for the portfolio text.
	 */
	public By reportListTxt(int i){
		 return By.xpath("//div[@class='column span-3']/div[@class='hub-article-container']["+i+"]//a");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public String getTextOfReportList(int i){
		 return safeGetText(reportListTxt(i), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the Best of Boards & Blogs text.
	 */
	public By bestOfBoardsAndBlogTxt(){
		 return By.xpath("//h1[text()='Best of Boards & Blogs']");
	}
	/*
	 * Function to check presence of the Best of Boards & Blogs text.
	 */
	public boolean isBestOfBoardsAndBlogTxtPresent(){
		 return isElementPresent(bestOfBoardsAndBlogTxt(), MEDIUMWAIT);
	}


}
