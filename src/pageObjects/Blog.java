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
//	/*
//	 * Locator for most active members header.
//	 */
//	private By mostActiveMembersHead(){
//		return By.xpath("//h4[text()='Most Active Members']");
//	}
//	/*
//	 * Function to check the presence of most active members header.
//	 */
//	public boolean ismostActiveMembersHeadPresent(){
//		return isElementPresent(mostActiveMembersHead(), MEDIUMWAIT);
//	}
//	/*
//	 * Locator for most active members section.
//	 */
//	private By mostActiveMembersSection(int num){
//		return By.xpath("//ul[@class='top-contributors']/li["+num+"]");
//	}
//	/*
//	 * Function to check the presence of most active members section.
//	 */
//	public boolean ismostActiveMembersSectionPresent(int num){
//		return isElementPresent(mostActiveMembersSection(num), MEDIUMWAIT);
//	}
//	/*
//	 * Locator for Read, Shared, Discussed block head.
//	 */
//	private By readSharedDiscussHead(){
//		return By.id("tabs");
//	}
//	/*
//	 * Function to check the presence of Read, Shared, Discussed block head.
//	 */
//	public boolean isreadSharedDiscussHeadPresent(){
//		return isElementPresent(readSharedDiscussHead(), MEDIUMWAIT);
//	}
//	/*
//	 * Locator for Read, Shared, Discussed Section.
//	 */
//	private By readSharedDiscussSection(){
//		return By.xpath("//div[@class='readSharedDiscussed']");
//	}
//	/*
//	 * Function to check the presence of Read, Shared, Discussed Section.
//	 */
//	public boolean isreadSharedDiscussSectionPresent(){
//		return isElementPresent(readSharedDiscussSection(), MEDIUMWAIT);
//	}
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
		//selectFromDropDown(modeSelectCombo, BrowserInstance.driver.findElement(orderByCombo()));
		//safeSelectOptionInDropDown(orderByComboOptions(), value, MEDIUMWAIT);
		//safeClick(orderByComboOptions(value), MEDIUMWAIT);
		safeSelectOptionInDropDownByValue(orderByComboOptions(), value, MEDIUMWAIT);
	}
	

}
