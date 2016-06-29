package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class InboxPage extends WebdriverUtility{
	
	/*
	 * Constructor for InboxPage.
	 */
	
	public InboxPage()
	{
	}//End public InboxPage(WebDriver driver)
	/*
	 * Locator for receiver text box in inbox.
	 */
	private By receiverTextBox(){
		return By.xpath("//div[@class='NewPanel']/div[@class='SendMessage']/table/tbody/tr[2]/td[2]/input[@type='text']");
	}
	/*
	 * Function to type text in receiver text box in inbox.
	 */
	public void putTextInReceiverTextBox(String text){
		safeType(receiverTextBox(), text, MEDIUMWAIT);
	}
	/*
	 * Locator for subject text box in inbox.
	 */
	private By subjectTextBox(){
		return By.xpath("//div[@class='SubjectRow']/input[@type='text']");
	}
	/*
	 * Function to type text in subject text box in inbox.
	 */
	public void putTextInSubjectTextBox(String text){
		safeType(subjectTextBox(), text, MEDIUMWAIT);
	}
	/*
	 * Locator for message text box in inbox.
	 */
	private By msgTextBox(){
		return By.xpath("//div[@id='p_lt_zoneContent_SubContent_p_lt_zoneCenter_MyMessages_ucMyMessages_i_ucSendMessage_ucBBEditor']/textarea");
	}
	/*
	 * Function to type text in message text box in inbox.
	 */
	public void putTextInMsgTextBox(String text){
		safeType(msgTextBox(), text, MEDIUMWAIT);
	}
	/*
	 * Locator for send button to send the message in inbox.
	 */
	private By sendButton(){
		return By.xpath("//div[@id='p_lt_zoneContent_SubContent_p_lt_zoneCenter_MyMessages_ucMyMessages_i_ucSendMessage_pnlSubPanel']/input");
	}
	/*
	 * Function to click on send button to send the message in inbox.
	 */
	public void clickOnSendBtn(){
		safeClick(sendButton(), MEDIUMWAIT);
	}
	/*
	 * Locator for view message window text in inbox.
	 */
	private By viewMsgWindowText(){
		return By.xpath("//div[@class='ViewMessage']/table/tbody/tr[2]/td/div/span");
	}
	/*
	 * Function to check the presence of text in view message window in inbox.
	 */
	public boolean isViewMsgWindowTextPresent(){
		return isElementPresent(viewMsgWindowText(), MEDIUMWAIT);
	}
	/*
	 * Locator for view message window header in inbox.
	 */
	private By viewMsgWindow(){
		return By.xpath("//div[@class='ViewPanel']/div[@class='ViewMessageHeader']/span[text()='View message']");
	}
	/*
	 * Function to check the presence of header of view message window in inbox.
	 */
	public boolean isViewMsgWindowHeadPresent(){
		return isElementPresent(viewMsgWindow(), MEDIUMWAIT);
	}
	

}
