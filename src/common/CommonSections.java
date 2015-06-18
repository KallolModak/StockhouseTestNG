package common;

import org.openqa.selenium.By;

public class CommonSections extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public CommonSections()
	{
	}//End public GroupsPage(WebDriver driver)
	
	/*
	 * Locator for most active members header.
	 */
	private By mostActiveMembersHead(){
		return By.xpath("//h4[text()='Most Active Members']");
	}
	/*
	 * Function to check the presence of most active members header.
	 */
	public boolean ismostActiveMembersHeadPresent(){
		return isElementPresent(mostActiveMembersHead(), MEDIUMWAIT);
	}
	/*
	 * Locator for most active members section.
	 */
	private By mostActiveMembersSection(int num){
		return By.xpath("//ul[@class='top-contributors']/li["+num+"]");
	}
	/*
	 * Function to check the presence of most active members section.
	 */
	public boolean ismostActiveMembersSectionPresent(int num){
		return isElementPresent(mostActiveMembersSection(num), MEDIUMWAIT);
	}
	/*
	 * Locator for Read, Shared, Discussed block head.
	 */
	private By readSharedDiscussedHead(int num){
		return By.xpath("//ul[@id='tabs']/li["+num+"]");
	}
	/*
	 * Function to check the presence of Read, Shared, Discussed block head.
	 */
	public boolean isreadSharedDiscussedHeadPresent(int num){
		return isElementPresent(readSharedDiscussedHead(num), MEDIUMWAIT);
	}
	/*
	 * Function to click on Read, Shared, Discussed block head.
	 */
	public void clickOnReadSharedDiscussedHead(int num){
		safeClick(readSharedDiscussedHead(num), MEDIUMWAIT);
	}
	/*
	 * Locator for Read, Shared, Discussed Section.
	 */
	private By readSharedDiscussedSection(int num){
		return By.xpath("//div[@class='readSharedDiscussed']/div["+num+"]");
	}
	/*
	 * Function to check the presence of Read, Shared, Discussed Section.
	 */
	public boolean isreadSharedDiscussedSectionPresent(int num){
		return isElementPresent(readSharedDiscussedSection(num), MEDIUMWAIT);
	}

}
