package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class RegistrationPage extends WebdriverUtility{
	
	/*
	 * Method for expanding Quick link and click the sub links
	 */
	
	public RegistrationPage()
	{
	}//End public MailinatorInbox(WebDriver driver)

	/*
	 * Locator for add Your Password text box.
	 */
	private By addYourPassword(){
		return By.xpath("//input[@id='txtPassword']");
	}
	/*
	 * Function to type Add your Password.
	 */
	public void typeAddYourPassword(String pwd){
		  safeType(addYourPassword(), pwd, MEDIUMWAIT);
	}
	
	/*
	 * Locator for Confirm Your Password text box.
	 */
	private By confirmYourPassword(){
		return By.xpath("//input[@id='txtConfirmPassword']");
	}
	/*
	 * Function to type Confirm your Password.
	 */
	public void typeConfirmYourPassword(String pwd){
		  safeType(confirmYourPassword(), pwd, MEDIUMWAIT);
	}
	
	/*
	 * Locator for Next step button.
	 */
	private By nextStep(){
		return By.xpath("//input[@id='btnNext']");
	}
	/*
	 * Function to click on next step button.
	 */
	public void clickOnNextStep(){
		  safeClick(nextStep(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for text on second page.
	 */
	private By txtOnSecondStep(){
		return By.xpath("//div[@id='divAccreditedInvestor']");
	}
	/*
	 * Function to get text on second page.
	 */
	public String getTextOnSecondPage(){
		  return safeGetText(txtOnSecondStep(),MEDIUMWAIT);
	}
	
	/*
	 * Locator for display name in step 3.
	 */
	private By displayName(){
		return By.xpath("//input[@id='txtUsername']");
	}
	/*
	 * Function to type display name in step3.
	 */
	public void typeDisplayName(String displayName){
		  safeType(displayName(), displayName, MEDIUMWAIT);
	}
	
	/*
	 * Locator for Check Availability button on step 3.
	 */
	private By checkAvailabilityBtn(){
		return By.xpath("//button[@id='btnCheckAvailability']");
	}
	/*
	 * Function to Check Availability button on step 3.
	 */
	public void clickOnCheckAvailability(){
		  safeClick(checkAvailabilityBtn(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for result of check availability button on step 3.
	 */
	private By checkAvailabilityResult(){
		return By.xpath("//span[@id='lblMsg']");
	}
	/*
	 * Function to get text of result of check availability button on step 3.
	 */
	public String getTextForCheckAvailabilityResult(){
		  return safeGetText(checkAvailabilityResult(),MEDIUMWAIT);
	}
	
	/*
	 * Locator for text present on step 4.
	 */
	private By textOnStepFour(int i){
		return By.xpath("//div[@class='reg-wizard form-group']/div[@class='row clearfix']["+i+"]/div[3]");
	}
	/*
	 * Function to get text present on step 4.
	 */
	public String getTextOnStepFour(int i){
		  return safeGetText(textOnStepFour(i),MEDIUMWAIT);
	}
	
}
