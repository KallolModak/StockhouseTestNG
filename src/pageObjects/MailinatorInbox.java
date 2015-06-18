package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import common.WebdriverUtility;

public class MailinatorInbox extends WebdriverUtility{
	
	/*
	 * Method for expanding Quick link and click the sub links
	 */
	
	public MailinatorInbox()
	{
	}//End public MailinatorInbox(WebDriver driver)

	/*
	 * Locator for registration request link.
	 */
	private By registrationRequest(){
		return By.xpath("//div[contains(text(),'Stockhouse Registration - Action required')]");
	}
	/*
	 * Function to click on the registration request link.
	 */
	public void clickOnRegistractionRequest(){
		  safeClick(registrationRequest(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the link for registration present in the mail.
	 */
	private By linkForRegistration(){
		return By.xpath("//a[contains(@href,'http://test.stockhouse.com/registration/email-confirmation')]");
	}
	/*
	 * Function to click on the link for registration present in the mail.
	 */
	public RegistrationPage clickOnLinkForRegistration(){
			driver.switchTo().frame("rendermail");
		  safeClick(linkForRegistration(), MEDIUMWAIT);
		  switchToDefaultFrame();
		  switchToNewWindow();
		  return(PageFactory.initElements(driver, RegistrationPage.class));
	}
	/*
	 * Locator for forgot password reset link.
	 */
	private By forgotPasswordRequest(){
		return By.xpath("//div[contains(text(),'Stockhouse password reset request')]");
	}
	/*
	 * Function to click on the forgot password reset link.
	 */
	public void clickOnForgotPasswordRequest(){
		  safeClick(forgotPasswordRequest(), MEDIUMWAIT);
	}
	/*
	 * Locator for the link for generating new password.
	 */
	private By linkForGenerateNewPassword(){
		return By.xpath("//a[text()='click here']");
	}
	/*
	 * Function to click on the link for generating new password.
	 */
	public ResetPasswordPage clickOnLinkForGenerateNewPassword(){
			driver.switchTo().frame("rendermail");
		  safeClick(linkForGenerateNewPassword(), MEDIUMWAIT);
		 
		  switchToDefaultFrame();
		  try{
			  Thread.sleep(2000);
		  }catch(Exception e){}
		  switchToNewWindow();
		  return(PageFactory.initElements(driver, ResetPasswordPage.class));
	}
	
	
	
}
