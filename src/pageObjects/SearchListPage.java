package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class SearchListPage extends WebdriverUtility{

 public SearchListPage() {
 }

 /*
  * Locator for Email address text box.
  */
 private By property(String propertyNumber){
  return By.xpath("//section[@id='content']/div[@id='main_page']/div[@id='listings_list_view']//div[@class='media listing']["+propertyNumber+"]/a[@class='media-body listing-data listing-data']/h2");
 }
 
 /*
  * Function to type email address in the email address text box.
  */
 public void selectProperty(int propertyNumber){
     safeClick(property(propertyNumber+""),VERYLONGWAIT);
     
 }
 
 /*
  * Locator for Email address text box.
  */
 private By propertyTxt(String propertyNumber){
  return By.xpath("//section[@id='content']/div[@id='main_page']/div[@id='listings_list_view']//div[@class='media listing']["+propertyNumber+"]/a[@class='media-body listing-data listing-data']/address");
 }
 
 /*
  * Function to type email address in the email address text box.
  */
 public String getPropertyText(int propertyNumber){
     return safeGetText(propertyTxt(propertyNumber+""), MEDIUMWAIT);
	 
 }
 
 
 /*
  * Locator for Email address text box.
  */
 private By requestShowing(){
  return By.xpath("//div[@id='main_page']//article[@class='listing-details']/div[@class='listing-details-buttons pseudo-table']/a[contains(text(),'Request Showing')]");
 }
 
 /*
  * Function to type email address in the email address text box.
  */
 public void clickRequestShowing(){
     safeClick(requestShowing(),VERYLONGWAIT);
     
 }
 private By next(){
	  return By.xpath("//section[@id='content']/div[@id='main_page']/header[@class='header list-fixed']//div[@class='btn btn-sm btn-header']");
	 }
	 
 /*
  * Function to type email address in the email address text box.
  */
 public void clickOnNext(){
     safeClick(next(),VERYLONGWAIT);
     
 }
 
 private By messageBox(){
	  return By.xpath("//div[@class='showing-new-message showing-new-message-request']/form/textarea[@id='showing_requested_time_message']");
	 }
	 
/*
 * Function to type email address in the email address text box.
 */
public void typeIntoMessageBox(String msg){
    safeType(messageBox(), msg, VERYLONGWAIT);
}
private By send(){
	  return By.xpath("//div[@class='pseudo-table']//div[@class='pseudo-table-cell text-right']/a");
	 }
	 
/*
* Function to type email address in the email address text box.
*/
public void clickOnsend(){
   safeClick(send(),VERYLONGWAIT);
   
}
private By okOnShowingRequestSent(){
	  return By.xpath("//div[@class='modal-dialog']/div[@class='modal-content']//button[@class='btn btn-default']");
	 }
	 
/*
* Function to type email address in the email address text box.
*/
public void clickOkOnShowingRequestSent(){
 safeClick(okOnShowingRequestSent(),VERYLONGWAIT);
 
}
 
}