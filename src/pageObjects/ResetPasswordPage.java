package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class ResetPasswordPage extends WebdriverUtility{
	
	/*
	 * Method for expanding Quick link and click the sub links
	 */
	
	public ResetPasswordPage()
	{
	}//End public MailinatorInbox(WebDriver driver)
	/*
	 * Locator for new password.
	 */
	private By newPassword(){
		return By.xpath("//div[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_ResetPassword_resetPassitem_pnlReset']/table/tbody/tr[1]/td[2]/input");
	}
	/*
	 * Function to put text in new password text box.
	 */
	public void putTextInNewPasswordBox(String text){
		safeType(newPassword(), text, MEDIUMWAIT);
	}
	/*
	 * Locator for confirming new password.
	 */
	private By confirmNewPassword(){
		return By.xpath("//div[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_ResetPassword_resetPassitem_pnlReset']/table/tbody/tr[2]/td[2]/input");
	}
	/*
	 * Function to put text in confirm new password text box.
	 */
	public void putTextInConfirmNewPasswordBox(String text){
		safeType(confirmNewPassword(), text, MEDIUMWAIT);
	}//p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_ResetPassword_resetPassitem_btnReset
	/*
	 * Locator for reset new password button.
	 */
	private By resetButton(){
		return By.xpath("//div[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_ResetPassword_resetPassitem_pnlReset']/table/tbody/tr[3]/td[2]/input");
	}
	/*
	 * Function to click on reset new password button.
	 */
	public void clickOnResetButton(){
		safeClick(resetButton(), MEDIUMWAIT);
	}
	/*
	 * Locator for 'this page' link.
	 */
	private By thisPageLink(){
		return By.linkText("this page");
	}
	/*
	 * Function to click on 'this page' link.
	 */
	public void clickOnThisPageLink(){
		safeClick(thisPageLink(), MEDIUMWAIT);
	}

}
