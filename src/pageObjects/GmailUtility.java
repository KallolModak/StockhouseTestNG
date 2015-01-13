package pageObjects;

import org.openqa.selenium.By;

import common.BrowserInstance;
import common.WebdriverUtility;

public class GmailUtility extends WebdriverUtility {
	

	 /*
	  * Constructor to initialize required objects. 
	  */
	 public GmailUtility() {
		 BrowserInstance.driver.get("https://www.gmail.com/");
		
	 }//End public HomePage(WebDriver driver)

	 private By email(){
		  return By.id("Email");
		 }
		 
	 /*
	  * Function to type email address in the email address text box.
	  */
	 public void typeEmail(String emailId){
	     safeType(email(),emailId,VERYLONGWAIT);
	     
	 }
	 
	 private By password(){
		  return By.id("Passwd");
		 }
		 
	 /*
	  * Function to type email address in the email address text box.
	  */
	 public void typePassword(String pwd){
		 safeType(password(),pwd,VERYLONGWAIT);
	     
	 }
	 private By signin(){
		  return By.id("signIn");
		 }
		 
	 /*
	  * Function to type email address in the email address text box.
	  */
	 public void clickSignin(){
	     safeClick(signin(),VERYLONGWAIT);
	     
	 }
	 
	 private By selectemail(String number){
		 return By.xpath("//div[@class='UI']/div/div[1]//table/tbody/tr["+number+"]/td[6]/div");
	 }
	 
	 public String getTextOfEmailSubject(int number){
		return safeGetText(selectemail(number+""), MEDIUMWAIT);
	 }
	 
	 public void openEmail(int number){
		 safeClick(selectemail(number+""), VERYSHORTWAIT);
	 }
	 
	 
}
