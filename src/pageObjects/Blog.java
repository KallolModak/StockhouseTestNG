package pageObjects;

import org.openqa.selenium.By;

import common.BrowserInstance;
import common.WebdriverUtility;

public class Blog extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public Blog()
	{
	}//End public Blog(WebDriver driver)
	
	/*
	 *Locator for order by header on blog page. 
	 */
	private By orderByHead(){
		return By.xpath("//label[text()='Order by:']");
	}
	/*
	 * Function to check the presence of order by header.
	 */
	public boolean isOrderByHeadPresent(){
		return isElementPresent(orderByHead(),MEDIUMWAIT);
	}
	/*
	 * Locator for blog summary on blog page.
	 */
	private By blogs(int num){
		return By.xpath("//div[@class='blog-summary']/ul/li["+num+"]/h3/a");
	}
	/*
	 * Function to check the text of header of blog summary.
	 */
	public String getTextOfBlogSummaryHead(int num){
		return safeGetText(blogs(num), MEDIUMWAIT);
	}
	/*
	 * Locator for options in order by combo box.
	 */
	private By orderByComboOptions(){
		return By.xpath("//div[@class='blog-orderby clearfix']/select");
	}
	/*
	 * Function to select an option from order by combo box.
	 */
	public void selectOrderByComboOptions(String value){
		safeSelectOptionInDropDownByValue(orderByComboOptions(), value, MEDIUMWAIT);
	}
	

}
