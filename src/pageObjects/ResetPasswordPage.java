package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

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
	return By.xpath("//div[@class='column span-4']/div[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_ResetPassword_resetPassitem_pnlReset']/table/tbody/tr[1]/td[2]/input");
	//return By.xpath("//div[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_SignIn_Login1_pnlLogin']/div[@class='form-section'][1]/input");
	}
	/*
	 * Function to put text in new password text box.
	 */
	public void putTextInNewPasswordBox(String text){
		//safeClick(newPassword(), MEDIUMWAIT);
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
		//safeClick(confirmNewPassword(), MEDIUMWAIT);
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
