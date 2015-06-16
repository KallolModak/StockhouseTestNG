package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sun.mail.handlers.message_rfc822;

import common.BrowserInstance;
import common.ReadInputData;
import common.WebdriverUtility;

public class Bullboard extends WebdriverUtility {
	@FindBy(id = "login-user-name")
	private WebElement we_loginEdit;
	
	private By pagination(String pageNumber){
		return By.xpath("//div[@class='pager']/a["+pageNumber+"]");
	}
	public void clickPage(String pageNumber){
		safeCheck(pagination(pageNumber), VERYLONGWAIT);
	}
	public String getCurrentURL(){
		return BrowserInstance.driver.getCurrentUrl();
	}
	
	private By ratingSelectCombo(){
		return By.xpath("//div[@class='bullboard-threads-filter row']/div[@class='col-md-3']/select");
	}
	private By rating(String rating){
		return By.xpath("//div[@class='bullboard-threads-filter row']/div[@class='col-md-3']/select/option[contains(text(),'"+rating+"')]");
	}
	public void selectViewByRating(String ratingSelectCombo){
		selectFromDropDown(ratingSelectCombo, BrowserInstance.driver.findElement(ratingSelectCombo()));
	}
	
	private By starImage(String rowNumber){
		return By.xpath("//div[@class='post-list']/div["+rowNumber+"]/div[@class='post-header']//img");
	}
	
	public String getNumberOfStarts(String rowNumber){
		return safeGetAttribute(starImage(rowNumber), "alt", MEDIUMWAIT);	
	}
	
	
	private By modeSelectCombo(){
		return By.xpath("//div[@class='bullboard-threads-filter row']/div[@class='col-md-9']/select");
	}

	public void selectViewMode(String modeSelectCombo){
		selectFromDropDown(modeSelectCombo, BrowserInstance.driver.findElement(modeSelectCombo()));
	}
	
	private By txtOfPostDate(String rowNumber){
		return By.xpath("//div[@class='post-list']/div["+rowNumber+"]/div[@class='post-info']/div[@class='post-info-user']/span");
	} 
	
	public String getTextofPostDate(String rowNumber){
		return safeGetText(txtOfPostDate(rowNumber), MEDIUMWAIT);
		
	}
	
	
	private By newPostButton(){
		return By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_lnkNew");
	}
	public void clickOnNewPostButton(){
		safeClick(newPostButton(), VERYLONGWAIT);
	}
	private By subjectTextBox(){
		return By.xpath("//div[@class='FormPadding']/table[@class='PostForm']//tr[2]//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_editElem_forumEdit_txtSubject']");
		                                                                                      		
	}
	public void typeSubject(String subject){
		safeClearAndType(subjectTextBox(), subject, MEDIUMWAIT);
	}
	
	public void typeMessage(String message){
		BrowserInstance.driver.switchTo().frame(BrowserInstance.driver.findElement(By.cssSelector("iframe[title='Rich text editor, p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_editElem_forumEdit_htmlTemplateBody, press ALT 0 for help.']")));
		BrowserInstance.driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys(message);
		switchToDefaultFrame();
	}
	
	public void clickOnPost(){
		BrowserInstance.driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_editElem_forumEdit_btnOk"));
	}
	
	private By addToFavouritesButton(){
		return By.xpath("//div[@class='company-header-buttons row']//a[contains(text(),'Add To Favorites')]");
	}
	public void clickOnAddToFavouritesButton(){
		safeClick(addToFavouritesButton(), MEDIUMWAIT);
		//WebdriverUtility.click(addToFavouritesButton(), "Add To Favorites button");
		//WebdriverUtility.waitForPageLoaded();
	}
	
	public String getMessageAfterFavouriteOperations(){
		return BrowserInstance.driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_lblFavMsg")).getText();
	}
	public String getMessageOfFavouriteButton(){
		return BrowserInstance.driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_liFavorite")).getText();
		
	}
	
	private By removeFromFavouritesButton(){
		return By.xpath("//div[@class='company-header-buttons row']//a[contains(text(),'Remove From Favorites')]");
	}
	public void clickOnRemoveFromFavouritesButton(){
		safeClick(removeFromFavouritesButton(), MEDIUMWAIT);
		//WebdriverUtility.click(removeFromFavouritesButton(), "Remove From Favorites button");
	//	WebdriverUtility.waitForPageLoaded();
	}
	
	/*
	 * Locator for get text for the unverified user. 
	 */
	private By txtForUnverifiedUser(){
		return By.xpath("//div[@class='bullboard-thread-edit ForumFlat']/table/tbody/tr[1]/td[1]//p");
	}
	
	/*
	 * Function is used to get message for unverified user on new post on bullboard.
	 */
	public String getTxtForUnverifiedUser(){
		return safeGetText(txtForUnverifiedUser(), MEDIUMWAIT);
	}
	/*
	  *Locator for order by head on bullboard page. 
	  */
	 private By orderByHead(){
	  return By.xpath("//label[text()='Order by:']");
	 }
	 /*
	  * Function to check the presence of order by header.
	  */
	 public boolean isOrderByHeadPresent(){
	  return isElementPresent(orderByHead(),MEDIUMWAIT);
	 }
	 /*
	  * Locator for 'displaying all bullboards' header.
	  */
	 private By displayBullBoards(){
	  return By.xpath("//h4[text()='Displaying all bullboards']");
	 }
	 /*
	  * Function to check the presence of 'displaying all bullboards' header.
	  */
	 public boolean isdisplayBullBoardsHeadPresent(){
	  return isElementPresent(displayBullBoards(), MEDIUMWAIT);
	 }
}
