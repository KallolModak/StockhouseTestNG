package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class FlyinSideBar  extends WebdriverUtility{
	
	/*
	 * Method for expanding Quick link and click the sub links
	 */
	
	public FlyinSideBar()
	{
	}//End public FlyingSideBar(WebDriver driver)

	/*
	 * Locator for checkboxes.
	 */
	private By checkBoxes(int i){
		return By.xpath("//div[@class='rightTrueSidebar']//div[@id='flyin-subscribe-to-list-feature-container']/div[@class='mailing-list']/div[@class='clearfix row']["+i+"]//input[@class='subscription-checkbox']");
	}
	
	/*
	 * Function to click on the checkboxes.
	 */
	public void selectCheckboxes(int i){
		 safeClick(checkBoxes(i), MEDIUMWAIT);
	}

	/*
	 * Locator for get text for the check-boxes available.
	 */
	private By checkBoxesText(int i){
		return By.xpath("//div[@id='flyin-subscribe-to-list-feature-container']/div[@class='mailing-list']/div[@class='clearfix row']["+i+"]//span");
	}
	
	/*
	 * Function to get text for checkboxes.
	 */
	public String getTxtOfCheckboxes(int i){
		 return safeGetText(checkBoxesText(i), MEDIUMWAIT);
	}
	
	/*
	 * Locator for email text box.
	 */
	private By emailAddressBox(){
		return By.xpath("//div[@id='flyinsidebarsubscriptions']//div[@class='form-group feat-pass-email']//input[@class='form-control input-sm']");
	}
	
	/*
	 * Function to type in email text box.
	 */
	public void typeEmailAddress(String emailId){
		 safeType(emailAddressBox(), emailId, MEDIUMWAIT);
	}
	
	/*
	 * Locator for email text box.
	 */
	private By passwordBox(){
		return By.xpath("//input[@type='password']");
	}
	
	/*
	 * Function to type in email text box.
	 */
	public void typePassword(String pwd){
		 safeType(passwordBox(), pwd, MEDIUMWAIT);
	}
	
	
	/*
	 * Locator for submit button.
	 */
	private By submitButton(){
		return By.xpath("//button[@id='flyinsidebarsubscriptions-subscribe']");
	}
	
	/*
	 * Function to click on submit button.
	 */
	public void clickSubmitButton(){
		 safeClick(submitButton(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for confirm email text box.
	 */
	private By confirmEmailAddressBox(){
		return By.xpath("//div[@id='flyinsidebarsubscriptions']//div[@class='form-group feat-pass-email-confirm collapse']//input[@class='form-control input-sm']");
	}
	
	/*
	 * Function to type in confirm email text box.
	 */
	public void typeConfirmEmailAddress(String emailId){
		 safeType(confirmEmailAddressBox(), emailId, MEDIUMWAIT);
	}
	
	/*
	 * Function to check presence of confirm email text box.
	 */
	public boolean isConfirmEmailAddressPresent(){
		return isElementPresent(confirmEmailAddressBox(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for cross button.
	 */
	private By cross(){
		return By.xpath("//span[@class='close-fly-in']");
	}
	
	/*
	 * Function to click on cross button.
	 */
	public void clickOnCross(){
		 safeClick(cross(), MEDIUMWAIT);
	}
	
	/*
	 * Function to check presence of cross button.
	 */
	public boolean isCrossPresent(){
		return isElementPresent(cross(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for fly in side bar.
	 */
	private By flyinSideBar(){
		return By.xpath("//div[@class='rightTrueSidebar']");
	}
	
	/*
	 * Function to check presence of flyin side bar.
	 */
	public String getstyleOfFlyinSideBar(){
		return driver.findElement(flyinSideBar()).getAttribute("style");
	}
	
	/*
	 * Locator for Thank you message.
	 */
	private By thankYouMsg(){
		return By.xpath("//h4[text()='Thank You']");
	}
	
	/*
	 * Function to check presence of Thank You message.
	 */
	public boolean isThankYouMessagePresent(){
		return isElementPresent(thankYouMsg(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for get text for your selection option.
	 */
	private By txtOfYourSelection(int i){
		return By.xpath("//div[@class='post-login-subscribed-features']/ul/li["+i+"]");
	}
	
	/*
	 * Function to get text for your selection option.
	 */
	public String getTxtOfYourSelection(int i){
		 return safeGetText(txtOfYourSelection(i), MEDIUMWAIT);
	}
	
	
	
	/*
	 * Locator for get text for current email address.
	 */
	private By currentEmailAddressSection(){
		return By.xpath("//em[contains(text(),'Your current email')]");
	}
	
	/*
	 * Function to get text for current email address.
	 */
	public String getTxtOfCurrentEmailAddressSection(){
		 return safeGetText(currentEmailAddressSection(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for confirm email text box.
	 */
	private By thankyouSubscribing(){
		return By.xpath("//h4[contains(text(),'Thank you for subscribing!')]");
	}
	
	/*
	 * Function to check presence of confirm email text box.
	 */
	public boolean isThankYouForSubscribingPresent(){
		return isElementPresent(thankyouSubscribing(), MEDIUMWAIT);
	}
}
