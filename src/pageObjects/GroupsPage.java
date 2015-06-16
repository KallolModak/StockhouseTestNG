package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class GroupsPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public GroupsPage()
	{
	}//End public GroupsPage(WebDriver driver)
	/*
	 * Locator for sort by header.
	 */
	private By sortBy(){
		return By.xpath("//label[text()='Sort By:']");
	}
	/*
	 * Function to check the presence of sort by head.
	 */
	public boolean isSortByHeadPresent(){
		return isElementPresent(sortBy(), MEDIUMWAIT);
	}
	/*
	 * Locator for various groups.
	 */
	private By variousGroups(int num){
		return By.xpath("//div[@class='groups-page']//div[@class='groups']["+num+"]/div[@class='group-info']//a");
	}
	/*
	 * Function to get text of head of various groups.
	 */
	public String getTextOfVariousGroupsHead(int num){
		return safeGetText(variousGroups(num), MEDIUMWAIT);
	}
	

}
