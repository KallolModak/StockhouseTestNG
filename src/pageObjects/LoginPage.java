package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.BrowserInstance;
import common.ReadInputData;
import common.WebdriverUtility;

//public class LoginPage {
//	//final  WebDriver driver;
//	@FindBy(id = "login-user-name")
//	private WebElement we_loginEdit;
//	@FindBy(id = "login-user-password")
//	private WebElement we_passwordEdit;
//	@FindBy(id = "btnLoginUser")
//	private WebElement we_loginButton;
//	
//	//@FindBy(xpath = "//div[@class='membership clearfix']/ul[@class='right']/li[@class='first']/a[@class='login-required']")
//	private WebElement we_registration;
//	@FindBy(xpath = "//div[@class='membership clearfix']/ul[@class='right']/li[@class='first']/a[@class='registration-required']")
//	
//	private WebElement we_signInLink;
//
//	private String str_UserId;
//	private String str_Password;
//		
//	public LoginPage() {
//	}
//		
//	public void setUserId(String prm_login) throws IOException {
//		 we_loginEdit.sendKeys(prm_login);
//		
//	}
//	public void setPassword(String prm_password) {
//		we_passwordEdit.sendKeys(prm_password);
//	}
//	
//	public void clickLoginButton() {
//		//loginButton.click();
////	 JavascriptExecutor executor = (JavascriptExecutor)BrowserInstance.driver;
////	   executor.executeScript("arguments[0].click();", we_loginButton);
////	   System.out.println("1****************");
////	   
//		we_loginButton.click();
//	}
//	
//	public void clickToSignIn(){
//		we_signInLink.click();
//	}
//	
//	public void login() throws IOException {
//		str_UserId = ReadInputData.HM_inputData.get("UserId");
//		str_Password = ReadInputData.HM_inputData.get("Password");
//		//str_organization = ReadInputData.HM_inputData.get("Organization");
//		clickToSignIn();
//		setUserId(str_UserId);
//		setPassword(str_Password);
//		clickLoginButton();
//		
//		//return PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//	}
////	
//	  ********class for new registration ************
	
public class LoginPage extends WebdriverUtility{
	
	/*
	 * Method for expanding Quick link and click the sub links
	 */
	
	public LoginPage()
	{
	}//End public LoginPage(WebDriver driver)

	/*
	 * Locator for join the community on the top of the page.
	 */
	private By joinTheCommunity(){
		return By.xpath("//input[@value='Join the Community']");
	}
	/*
	 * Function to click on the "Join The Community" on the top of the page.
	 */
	public RegisterPage clickOnJoinTheCommunity(){
		 safeClick(joinTheCommunity(), MEDIUMWAIT);
		 return(PageFactory.initElements(BrowserInstance.driver, RegisterPage.class));
	}
	
	/*
	 * Locator for user name input box.
	 */
	private By username(){
		return By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_SignIn_Login1_UserName']");
	}
	/*
	 * Function to type User name.
	 */
	public void EnterUserName(String username){
		 safeType(username(), username, MEDIUMWAIT);
	}

	/*
	 * Locator for password input box.
	 */
	private By password(){
		return By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_SignIn_Login1_Password']");
	}
	/*
	 * Function to type User name.
	 */
	public void EnterPassword(String username){
		 safeType(password(), username, MEDIUMWAIT);
	}
	
	/*
	 * Locator for join the community on the top of the page.
	 */
	private By signInBtn(){
		return By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_SignIn_Login1_LoginButton']");
	}
	/*
	 * Function to click on the "Join The Community" on the top of the page.
	 */
	public void clickOnSignInBtn(){
		 safeClick(signInBtn(), MEDIUMWAIT);
	}
	/*
	 * Function to check the presence of signin button.
	 */
	public boolean isSigninBtnPresent(){
		return isElementPresent(signInBtn(), MEDIUMWAIT);
	}
	/*
	 * Locator for join the community on the top of the page.
	 */
	private By logoutBtn(){
		return By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_SignIn_btnLogout']");
	}
	/*
	 * Function to check the presence of logout button on login page.
	 */
	public boolean isLogoutButtonPresent(){
		 return isElementPresent(logoutBtn(), MEDIUMWAIT);
	}
	/*
	 * Function to click on logout button on login page.
	 */
	public void clickOnLogoutButton(){
		 safeClick(logoutBtn(), MEDIUMWAIT);
	}
	/*
	 * Locator for forgot password.
	 */
	private By forgotPassword(){
		return By.xpath("//div[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_SignIn_Login1_pnlLogin']/div[3]/a[text()='Forgot password?']");
	}
	/*
	 * Function to click on forgot password.
	 */
	public void clickOnForgotPassword(){
		 safeClick(forgotPassword(), MEDIUMWAIT);
	}
	/*
	 * Locator for user name box for resetting password.
	 */
	private By resetPwdUserName(){
		return By.xpath("//div[@class='form-section']/input");
	}
	/*
	 * Function to type in user name box for resetting password.
	 */
	public void putResetPwdUserName(String text){
		safeType(resetPwdUserName(), text, MEDIUMWAIT);
	}
	/*
	 * Locator for 'send password' on reset password page.
	 */
	private By sendPassword(){
		return By.xpath("//div[@class='login-retrieval']//input[@type='submit']");
	}
	/*
	 * Function to click on 'send password' on reset password page.
	 */
	public void clickOnSendPassword(){
		safeClick(sendPassword(), MEDIUMWAIT);
	}
	/*
	 * Locator for message generated after 'send password' click.
	 */
	private By ResetPasswordMsg(){
		return By.xpath("//div[@class='login-retrieval']//span[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_SignIn_lblResult']");
	}
	/*
	 * Function to get text of message generated after 'send password' click.
	 */
	public String getTextOfResetPasswordMsg(){
		return safeGetText(ResetPasswordMsg(), MEDIUMWAIT);
	}
	
//	//final  WebDriver driver;
//	@FindBy(id = "membership-register-userEmail")
//	private WebElement we_loginEdit;
//	//@FindBy(id = "login-user-password")
//	//private WebElement we_passwordEdit;
//	@FindBy(id = "btnRegisterEmail")
//	private WebElement we_loginButton;
//	
//	//@FindBy(xpath = "//div[@class='membership clearfix']/ul[@class='right']/li[@class='first']/a[@class='login-required']")
//	//private WebElement we_registration;
//	@FindBy(xpath = "//div[@class='membership clearfix']/ul[@class='right']/li[@class='first']/a[@class='registration-required']")
//	
//	private WebElement we_signInLink;
//
//	private String str_UserId;
//	//private String str_Password;
//		
//	public LoginPage() {
//	}
//		
//	public void setUserId(String prm_login) throws IOException {
//		 we_loginEdit.sendKeys(prm_login);
//		
//	}
//	public void setPassword(String prm_password) {
//		//we_passwordEdit.sendKeys(prm_password);
//	}
//	
//	public void clickLoginButton() {
//		//loginButton.click();
////	 JavascriptExecutor executor = (JavascriptExecutor)BrowserInstance.driver;
////	   executor.executeScript("arguments[0].click();", we_loginButton);
////	   System.out.println("1****************");
////	   
//		we_loginButton.click() ;
//	}
//	
//	public void clickToSignIn(){
//		we_signInLink.click();
//	}
//	
//	public void login() throws IOException {
//		str_UserId = ReadInputData.HM_inputData.get("registrationID");
//		//str_Password = ReadInputData.HM_inputData.get("Password");
//		//str_organization = ReadInputData.HM_inputData.get("Organization");
//		clickToSignIn();
//		setUserId(str_UserId);
//		//setPassword(str_Password);
//		clickLoginButton();
//		
//		//return PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//	}
	
	}