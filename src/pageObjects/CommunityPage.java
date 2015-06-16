package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class CommunityPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public CommunityPage()
	{
	}//End public CommunityPage(WebDriver driver)

	/*
	 * Locator for bullboard on community page.
	 */
	private By bullBoardHead(){
		return By.xpath("//span[text()='Bullboards']");
	}
	/*
	 * Function to check the presence of bullboard on community page.
	 */
	public boolean isBullBoardHeadPresent(){
		return isElementPresent(bullBoardHead(), MEDIUMWAIT);
	}
	/*
	 * Locator for groups on community page.
	 */
	private By groupsHead(){
		return By.xpath("//div[@class='column span-4']/div[contains(@class,'webpart-container')][3]/table/tbody/tr[1]/td[1]/h4[text()='Groups']");
	}
	/*
	 * Function to get text of groups head on community page.
	 */
	public String getTextOfGroupHead(){
		return safeGetText(groupsHead(), MEDIUMWAIT);
	}
	/*
	 * Locator for blog on community page.
	 */
	private By blogHead(){
		return By.xpath("//div[@class='column span-4']/div[contains(@class,'webpart-container')][3]/table/tbody/tr[1]/td[2]/h4");
	}
	/*
	 * Function to check the presence of groups on community page.
	 */
	public String getTextOfBlogHead(){
		return safeGetText(blogHead(), MEDIUMWAIT);
	}
	

}
