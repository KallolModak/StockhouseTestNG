package pageObjects;

import java.io.IOException;

import javax.print.attribute.standard.Media;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BrowserInstance;
import common.ReadInputData;
import common.WebdriverUtility;

public class LoginPage extends WebdriverUtility{
	
	public LoginPage() {
	}
		
	
	/*
	 * Locator for Email address text box.
	 */
	private By emailAddressTxtBox(){
		return By.id("user_email");
	}
	
	/*
	 * Function to type email address in the email address text box.
	 */
	public void setUserId(String userId){
		safeType(emailAddressTxtBox(), userId, VERYLONGWAIT);
	}
	
	/*
	 * Locator for Password text box.
	 */
	private By passwordTxtBox(){
		return By.id("user_password");
	}
	
	/*
	 * Function to type password in the password text box.
	 */
	public void setPassword(String pwd){
		safeType(passwordTxtBox(), pwd, MEDIUMWAIT);
	}
	
	/*
	 * Locator for Login button.
	 */
	private By loginButton(){
		return By.xpath("//header//div[@class='pull-right']/a[@class='btn btn-sm btn-header']");
	}
	
	/*
	 * Function to click on login button.
	 */
	public void clickLoginButton(){
		safeClick(loginButton(), MEDIUMWAIT);
	}

	
	public void login() throws IOException {
		String userId = ReadInputData.HM_inputData.get("UserId");
		String password = ReadInputData.HM_inputData.get("Password");
		setUserId(userId);
		setPassword(password);
		clickLoginButton();
	}
	
	
	}