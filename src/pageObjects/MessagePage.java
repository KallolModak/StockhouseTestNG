package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class MessagePage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public MessagePage()
	{
	}//End public MessagePage(WebDriver driver)
	
	/*
	 * Locator for header on message page.
	 */
	private By headOnMessagePage(){
		return By.xpath("//h1[contains(text(),'My messages')]");
	}
	/*
	 * Function to check the presence of header on message page.
	 */
	public boolean isHeadOnMessagePagePresent(){
		return isElementPresent(headOnMessagePage(),MEDIUMWAIT);
	}
	/*
	 * Locator for 'new message' text on message page.
	 */
	private By newMessageLink(){
		return By.xpath("//a[text()='New message']");
	}
	/*
	 * Function to check the presence of 'new message' text on message page.
	 */
	public boolean isNewMessageLinkPresent(){
		return isElementPresent(newMessageLink(),MEDIUMWAIT);
	}
	/*
	 * Function to click on 'new message' link.
	 */
	public void clickOnNewMessageLink(){
		safeClick(newMessageLink(), MEDIUMWAIT);
	}
	/*
	 * Locator for msg generated after performing sending and deletion operation.
	 */
	private By successMsg(){
		return By.xpath("//div[@class='MessagingBox']/span");
	}
	/*
	 * Function to check the presence of msg generated after performing sending and deletion operation.
	 */
	public String getTextOfSuccessMsg(){
		return safeGetText(successMsg(),MEDIUMWAIT);
	}
	/*
	 * Locator for delete icon in msg list.
	 */
	private By deleteViewInMsgList(int num,String mode){
		if(mode.equalsIgnoreCase("delete"))
			mode="//table[@class='UniGridGrid _nodivs']/tbody/tr["+num+"]/td["+num+"]/input[@title='Delete']";
		else
			mode="//table[@class='UniGridGrid _nodivs']/tbody/tr["+num+"]/td["+num+"]/input[@title='View']";
		return By.xpath(mode);
	}
	/*
	 * Function to click on delete icon in msg list.
	 */
	public void clickOnDeleteViewInMsgList(int num,String mode){
		safeClick(deleteViewInMsgList(num,mode), MEDIUMWAIT);
	}
	/*
	 * Locator for control tabs under my messages head.
	 */
	private By msgControlTabs(int num){
		return By.xpath("//table[@class='TabControlTable']/tbody/tr/td["+num+"]/a");
	}
	/*
	 * Function to click on control tabs under my messages head.
	 */
	public void clickOnMsgControlTabs(int num){
		safeClick(msgControlTabs(num),MEDIUMWAIT);
	}
	/*
	 * Locator for message text under subject head in msg list.
	 */
	private By msgTextInMsgList(int num1,int num2){
		return By.xpath("//table[@class='UniGridGrid _nodivs']/tbody/tr["+num1+"]/td["+num2+"]/a");
	}
	/*
	 * Function to get text of message under subject head in msg list..
	 */
	public String getMsgTextInMsgList(int num1,int num2){
		return safeGetText(msgTextInMsgList(num1,num2),MEDIUMWAIT);
	}

}
