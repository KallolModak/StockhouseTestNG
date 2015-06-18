package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import common.BrowserInstance;
import common.WebdriverUtility;

public class RegisterPage extends WebdriverUtility{
	
	/*
	 * Method for expanding Quick link and click the sub links
	 */
	
	public RegisterPage()
	{
	}//End public RegisterPage(WebDriver driver)

	/*
	 * Locator for join the community on the top of the page.
	 */
	private By joinTheCommunity(){
		return By.xpath("//input[@value='Join the Community']");
	}
	/*
	 * Function to click on the "Join The Community" on the top of the page.
	 */
	public void clickOnJoinTheCommunity(){
		 safeClick(joinTheCommunity(), MEDIUMWAIT);
	}
	
	
	/*
	 * Locator for email input box.
	 */
	private By email(){
		return By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Register_txtEmail']");
	}
	/*
	 * Function to type email address.
	 */
	public void typeEmail(String mailId){
		 safeType(email(), mailId, MEDIUMWAIT);
	}
	
	/*
	 * Locator for password input box.
	 */
	private By password(){
		return By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Register_txtPassword']");
	}
	/*
	 * Function to type password.
	 */
	public void typePassword(String pwd){
		 safeType(password(), pwd, MEDIUMWAIT);
	}
	
	/*
	 * Locator for text present on the Choose Display Name Page.
	 */
	private By txtOnChooseDisplayName(int i){
		return By.xpath("//table[@class='mailing-lists']/tbody/tr["+i+"]/td[2]/label");
	}
	/*
	 * Function to get text present on the Choose Display Name Page.
	 */
	public String getTxtOnChooseDisplayName(int i){
		 return safeGetText(txtOnChooseDisplayName(i), MEDIUMWAIT);
	}
	
	/*
	 * Locator for user name on the Choose Display Name Page.
	 */
	private By userNameOnChooseDisplayName(){
		return By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Register_txtUsername']");
	}
	/*
	 * Function to type user name on the Choose Display Name Page.
	 */
	public void typeUserNameOnChooseDisplayName(String userName){
		 safeType(userNameOnChooseDisplayName(), userName, MEDIUMWAIT);
	}

	/*
	 * Locator for join the community on the top of the page.
	 */
	private By checkAvaibilityOnChooseDisplayName(){
		return By.xpath("//input[@value='Check Availability']");
	}
	/*
	 * Function to click on the "Join The Community" on the top of the page.
	 */
	public void clickOnCheckAvaibilityOnChooseDisplayName(){
		 safeClick(checkAvaibilityOnChooseDisplayName(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for text present on the Choose Display Name Page.
	 */
	private By txtResultforCheckAvaibilityOnChooseDisplayName(){
		return By.xpath("//span[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Register_lblUserAvailble']");
	}
	/*
	 * Function to get text present on the Choose Display Name Page.
	 */
	public String getTxtResultforCheckAvaibilityOnChooseDisplayName(){
		 return safeGetText(txtResultforCheckAvaibilityOnChooseDisplayName(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for join the community on the top of the page.
	 */
	private By submitOnChooseDisplayName(){
		return By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Register_btnSubmit']");
	}
	/*
	 * Function to click on the "Join The Community" on the top of the page.
	 */
	public HomePage clickOnSubmitOnChooseDisplayName(){
		 safeClick(submitOnChooseDisplayName(), MEDIUMWAIT);
		 return(PageFactory.initElements(BrowserInstance.driver, HomePage.class));
	}
	
}
