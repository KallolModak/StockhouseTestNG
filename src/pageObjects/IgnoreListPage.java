package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class IgnoreListPage extends WebdriverUtility{
	
	/*
	 * Constructor for IgnoreListPage.
	 */
	
	public IgnoreListPage()
	{
	}//End public IgnoreListPage(WebDriver driver)
	/*
	 * Locator for add users button.
	 */
	private By addUsers(){
		return By.xpath("//input[@class='LongButton orangeButton']");
	}
	/*
	 * Function to click on add users button.
	 */
	public void clickOnAddUsers(){
		safeClick(addUsers(), MEDIUMWAIT);
	}
	/*
	 * Locator for users to be selected for ignore list.(from new window pop up)
	 */
	private By ignoreUserInNewWindow(int num1,int num2,String name){
		if(name.equalsIgnoreCase("selection"))
			name="//table[@class='UniGridGrid _nodivs']/tbody/tr["+num1+"]/td["+num2+"]/input";
		else //text
			name="//table[@class='UniGridGrid _nodivs']/tbody/tr["+num1+"]/td["+num2+"]/div";
		return By.xpath(name);
	}
	/*
	 * Function for selection of users to be selected for ignore list.(from new window pop up).
	 */
	public void selectUsersToIgnoreInNewWindow(int num1,int num2,String name){
		try {
			safeSelectCheckboxes(MEDIUMWAIT, ignoreUserInNewWindow(num1,num2,name));
		} catch (Exception e) {}
	}
	/*
	 * Function to get text of name of users to be selected for ignore list.(from new window pop up).
	 */
	public String getTextOfIgnoreUserInNewWindow(int num1,int num2,String name){
		return safeGetText(ignoreUserInNewWindow(num1,num2,name), MEDIUMWAIT);
	}
	/*
	 * Locator for ok button on users to be ignored popup window.
	 */
	private By okButton(){
		return By.xpath("//input[@value='OK']");
	}
	/*
	 * Function to click on ok button on users to be ignored popup window.
	 */
	public void clickOnOkButton(){
		safeClick(okButton(), MEDIUMWAIT);
	}
	/*
	 * Locator for list of ignored users.
	 */
	private By ignoredUsers(int num){
		return By.xpath("//table[@class='UniGridGrid _nodivs']/tbody/tr["+num+"]/td["+num+"]/div");
	}
	/*
	 * Function to get text of ignored users from list.
	 */
	public String getTextOfIgnoredUsers(int num){
		return safeGetText(ignoredUsers(num), MEDIUMWAIT);
	}
	/*
	 * Locator to get size of list of ignored users.
	 */
	private By ignoredUserListSize(){
		return By.xpath("//table[@class='UniGridGrid _nodivs']/tbody/tr");
	}
	/*
	 * Function to get size of list of ignored users.
	 */
	public int getSizeOfIgnoredUserList(){
		return driver.findElements(ignoredUserListSize()).size();
	}

}
