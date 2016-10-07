package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
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
	
	private By starImage(int rowNumber){
		return By.xpath("//div[@class='post-list']/div["+rowNumber+"]/div[@class='post-header']//img");
	}
	
	public String getNumberOfStarts(int rowNumber){
		return safeGetAttribute(starImage(rowNumber), "alt", MEDIUMWAIT);	
	}
	public boolean isStarImagePresent(int rowNumber){
		return isElementPresent(starImage(rowNumber), MEDIUMWAIT);
	}
	
	private By modeSelectCombo(){
		return By.xpath("//div[@class='bullboard-threads-filter row']/div[@class='col-md-9']/select");
		//return By.xpath("//div[@class='bullboard-threads-filter row']/div[@class='col-md-9']/select/option["+opt+"]");
	}

	public void selectViewMode(String modeSelectCombo){
		selectFromDropDown(modeSelectCombo, BrowserInstance.driver.findElement(modeSelectCombo()));
		//safeClick(modeSelectCombo(opt), MEDIUMWAIT);
	}
	
	private By txtOfPostDate(String rowNumber){
		return By.xpath("//div[@class='post-list']/div["+rowNumber+"]/div[@class='post-info']/div[@class='post-info-user']/span");
	} 
	
	public String getTextofPostDate(String rowNumber){
		return safeGetText(txtOfPostDate(rowNumber), MEDIUMWAIT);
		
	}
	/*
	 * Locator for messages already posted.
	 */
	private By postedMessageHead(int num){
		return By.xpath("//div[@class='post-list']/div["+num+"]/div[@class='post-header']/h3/a");
	}
	/*
	 * Function to get text of head of messages posted.
	 */
	public String getTextOfPostedMessageHead(int num){
		return safeGetText(postedMessageHead(num), MEDIUMWAIT);
	}
	
	private By newPostButton(){
		return By.xpath("//a[contains(text(),'New Post')]");
		//return By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_CompanyBullboard_viewerForum_threadsElem_lnkNew");
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
	
	public void clickOnPost(int num){
		BrowserInstance.driver.findElement(By.xpath("//div[@class='FormPadding']/table/tbody/tr["+num+"]//div[@class='right']/input")).click();
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
	  return By.xpath("//h4[contains(text(),'Displaying all bullboards')]");
	 }
	 /*
	  * Function to check the presence of 'displaying all bullboards' header.
	  */
	 public boolean isdisplayBullBoardsHeadPresent(){
	  return isElementPresent(displayBullBoards(), MEDIUMWAIT);
	 }
	 /*
	  * Locator for date of posts.
	  */
	 private By dateOfPost(int num){
		 return By.xpath("//div[@class='post-list']/div["+num+"]/div[@class='post-info']//span");
	 }
	 /*
	  * Function to get text of date.
	  */
	 public String getTextOfDate(int num){
		 return safeGetText(dateOfPost(num), MEDIUMWAIT);
	 }
	 /*
	  * Locator for heading of posts.(under option threaded)
	  */
	 private By postsHeadThreaded(int num){
		 return By.xpath("//div[@class='bullboard-content']/div[@class='post-list']/div[@class='post-header']["+num+"]/h3/a");
	 }
	 /*
	  * Function to get text of heading of posts.(under option threaded).
	  */
	 public String getTextOfPostsHeadThreaded(int num){
		 return safeGetText(postsHeadThreaded(num), MEDIUMWAIT);
	 }
	 /*
	  * Locator for heading of posts.(other than option threaded)
	  */
	 private By postsHead(int num){
		 return By.xpath("//div[@class='bullboard-content']/div[@class='post-list']/div["+num+"]//h3/a");
	 }
	 /*
	  * Function to get text of heading of posts.(other than option threaded).
	  */
	 public String getTextOfPostsHead(int num){
		 return safeGetText(postsHead(num), MEDIUMWAIT);
	 }
	 /*
	  * Locator for upper pagination.
	  */
	 private By pagination(){
		 return By.xpath("//div[@class='pager'][1]/span/following-sibling::*[1]");
	 }
	 /*
	  * Function to click on upper pagination.
	  */
	 public void clickOnPagination(){
		 safeClick(pagination(), MEDIUMWAIT);
	 }
	 /*
	  * Function to get href of pages in upper pagination.
	  */
	 public String getHrefOfPagination(){
		 return driver.findElement(pagination()).getAttribute("href");
	 }
	 /*
	  * Locator for bull board page navigation links.
	  */
	 private By BBNavLink(String text){
		 //return By.xpath("//div[@class='comp-nav-container']/a["+num+"]");
		 return By.xpath("//div[@class='comp-nav-container']/a[text()='"+text+"']");
	 }
	 /*
	  * Function to click on bull board page navigation links.
	  */
	 public void clickOnBBNavLink(String text){
		 mouseHover(BBNavLink(text), MEDIUMWAIT);
		 safeClick(BBNavLink(text), MEDIUMWAIT);
	 }
	 /*
	  * Function to get text of bull board page navigation links.
	  */
	 public String getTextOfBBNavLink(String text){
		 return safeGetText(BBNavLink(text), MEDIUMWAIT);
	 }
	 /*
	  * Locator for news focus posted news box (posted from CMS Desk page).
	  */
	 private By newsFocusBox(){
		 return By.xpath("//div[@class='post-content news-focus']");
	 }
	 /*
	  * Function to check the presence of news focus posted news box(posted from CMS Desk page).
	  */
	 public boolean isNewsFocusBoxPresent(){
		 return isElementPresent(newsFocusBox(), MEDIUMWAIT);
	 }
	 /*
	  * Function to get the border color of news focus posted news box (posted from CMS Desk page).
	  */
	 public String getColorOfNewsFocusBox(){
		 return BrowserInstance.driver.findElement(newsFocusBox()).getCssValue("border-top-color");
	 }
}
