package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import common.BrowserInstance;
import common.LoggerInstance;
import common.WebdriverUtility;

public class CMSDeskPage extends WebdriverUtility{
	
	/*
	 * Method for expanding Quick link and click the sub links
	 */
	
	public CMSDeskPage()
	{}//End public CMSDeskPage(WebDriver driver)
	
	/*
	 * Locator for iframe for full page.
	 */
	public void switchToFrame1(){
		BrowserInstance.driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='m_c_cmsdesktop']")));
	}
	/*
	 * Locator for iframe of form page.
	 */
	public void switchToFrame2(){
		BrowserInstance.driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='m_c_contentview']")));
		
	}
	
	/*
	 * Function to switch to tags pop-up iframe.
	 */
	public WebDriver tagPopupiframe(){
		switchToDefaultFrame();
		return driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='UIPopupDialog ui-dialog-content ui-widget-content']")));
	}
	/*
	 * Function to switch to frame inside iframe.
	 */
	public void switchToFrameInsideiframe1(){
		BrowserInstance.driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='contenteditview']")));
	}
	/*
	 * Locator for options in left content management tree.
	 */
	private By leftTree(String option){
		return By.xpath("//div[@id='m_c_contenttree_CMSDeskTree_pnlTreeArea']//span[text()='"+option+"']/../../../../../../../../td[2]/a/img");
	}
	/*
	 * Function to select any option from left content management tree.
	 */
	public void expandOptionInLeftTree(String option){
		safeClick(leftTree(option), MEDIUMWAIT);
	}
	/*
	 * Locator for sub-options under the main left content management tree.
	 */
	private By subOptionOfLeftTree(String option){
		return By.xpath("//span[text()='"+option+"']");
	}
	/*
	 * Function to click on sub-options under the main left content management tree.
	 */
	public void clickOnSubOptionOfLeftTree(String option){
		safeClick(subOptionOfLeftTree(option), MEDIUMWAIT);
	}
	/*
	 * Locator for new button on top.
	 */
	private By newButton(){
		return By.xpath("//span[text()='New']/..");
	}
	/*
	 * Function to click on new button on top.
	 */
	public void clickOnNewButton(){
		//safeClick(newButton(), SHORTWAIT);
		  BrowserInstance.driver.findElement(newButton()).click();
	}
	/*
	 * Locator for "!Content Item" appearing after new button click.
	 */
	private By contentItem(){
		return By.xpath("//a[contains(text(),'Content Item')]");
	}
	/*
	 * Function to click on "!Content Item" appearing after new button click.
	 */
	public void clickOnContentItem(){
		try{
        safeJavaScriptClick(contentItem(), MEDIUMWAIT);
		//BrowserInstance.driver.findElement(contentItem()).click();
		}catch(Exception e){}
	}
	/*
	 * Locator for 
	 */
	private By mainTree(){
		return By.xpath("//div[@class='TreePadding']/table/tbody/tr/td/a");
	}
	/*
	 * 
	 */
	public void clickOnMainTree(){
		safeClick(mainTree(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for form table.
	 */
	private By formTable(int num,String title){
		if(title.equalsIgnoreCase("title")){
			title="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[@class='EditingFormValueCell']/div[@class='EditingFormControlNestedControl']/input";
		}
			else{
				if(title.equalsIgnoreCase("author")){
					title="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[2]/div/select";
				}
				else{
					if(title.equalsIgnoreCase("deck")){
						title="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[2]/div/textarea";
					}
					else{
						if(title.equalsIgnoreCase("content")){
							//title="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[2]/div";
							title="/html/body[@class='cke_show_borders']";
						}
						else{
							if(title.equalsIgnoreCase("feedPublished")){// feed published check-box
								title="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[2]/div/span/input";
							}
							else{ // publish date's now option.
								title="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[2]/div/span/a";
							}
						}
					}
				}
			}

		return By.xpath(title);

	}
	/*
	 * Function to set the value text for title.
	 */
	public void setFormTableTitle(int num, String title, String textToType){
		BrowserInstance.driver.findElement(formTable(num, title)).isSelected();
		safeJavaScriptClick(formTable(num, title), SHORTWAIT);
		safeType(formTable(num, title), textToType, MEDIUMWAIT);
	}
	/*
	 * Function to set the value text for deck.
	 */
	public void setFormTableDeck(int num, String title, String textToType){
		safeClick(formTable(num, title), SHORTWAIT);
		safeType(formTable(num, title), textToType, MEDIUMWAIT);
	}
	/*
	 * Function to set the value text for content.
	 */
	public void setFormTableContent(int num, String title, String textToType){
		
		BrowserInstance.driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich text editor, m_c_f_f_Content_editor, press ALT 0 for help.']")));
		scrollIntoViewThroughJavaScriptExecuter(formTable(num, title));
		//safeClick(formTable(num, title), SHORTWAIT);
		safeType(formTable(num, title), textToType, MEDIUMWAIT);
		}
	/*
	 * Function to select author in form table.
	 */
	public void selectAuthor(int num, String title, String optionToSelect){
		safeSelectOptionInDropDown(formTable(num, title), optionToSelect, MEDIUMWAIT);
		
	}
	/*
	 * Function to select checkbox of feed published.
	 */
	public void selectFeedPublished(int num, String title) throws Exception{
		safeSelectCheckboxes(MEDIUMWAIT, formTable(num, title));
	}
	/*
	 * Locator for symbols text-box and button.
	 */
	private By symbolTextAndButton(String option, int num){
		if(option.equalsIgnoreCase("symbolText")){
			option="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[2]//table/tbody/tr[2]/td[1]/input";
		}
		else{ 
			if(option.equalsIgnoreCase("symbolButton")){
				option="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[2]//table/tbody/tr[2]/td[2]/div/input";
			}
//			else{ // symbol from list.
//				option="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[2]//table/tbody/tr[2]/td[1]/ul/li";
//			}
		}
		return By.xpath(option);	
	}
	/*
	 * Function to set symbol text.
	 */
	public void setSymbolText(String option, String textToType, int num){
		safeType(symbolTextAndButton(option, num), textToType, MEDIUMWAIT);
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		driver.findElement(symbolTextAndButton(option, num)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(symbolTextAndButton(option, num)).sendKeys(Keys.ENTER);
	}
	/*
	 * Function to click on add symbol button.
	 */
	public void clickOnAddSymbol(String option, int num){
		safeJavaScriptClick(symbolTextAndButton(option, num), MEDIUMWAIT);
	}
	/*
	 * Locator for tags text-box and button.
	 */
	private By tagsTextAndButton(String option,int num){
		if(option.equalsIgnoreCase("tagText")){
			option="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[2]//table/tbody/tr/td[1]/input";
			
		}
		else{ // tags select button
			option="//table[@class='EditingFormTable']/tbody/tr["+num+"]/td[2]//table/tbody/tr/td[2]/input";
		}
		return By.xpath(option);
			
	}
	/*
	 * Function to type text in tags text-box.
	 */
	public void setTagsText(String option,String textToType,int num){
		safeType(tagsTextAndButton(option, num), textToType, MEDIUMWAIT);
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		
		driver.findElement(tagsTextAndButton(option, num)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(tagsTextAndButton(option, num)).sendKeys(Keys.ENTER);
	}
	
	public void switchToDefaultFrame(){
		
		driver.switchTo().defaultContent();
	}
	/*{
	 * Function to click on tags selecting button.
	 */
	public void clickOnTagsSelect(String option, int num){
		safeJavaScriptClick(tagsTextAndButton(option, num), MEDIUMWAIT);
	}
	
	/*
	 * Locator for tags pop-up.
	 */
	private By tagsPopUp(int num){
		return By.xpath("//a[contains(text(),'Kallol')]");
		
	}
	
	private By tagNameTextBox(){
		return By.xpath("//input[@id='m_c_gridElem_TagNameTextValue']");
	}
	
	private By showButton(){
		return By.xpath("//input[@id='m_c_gridElem_btnShow']");
	}
	/*
	 * Function to click on tags pop-up options.
	 */
	public void clickOnTagsPopupOption(int num){
		tagPopupiframe();
		safeClearAndType(tagNameTextBox(), "kallol", MEDIUMWAIT);
		safeClick(showButton(), SHORTWAIT);
		try{
			Thread.sleep(5000);
		}catch(Exception e){}
		safeClick(tagsPopUp(num), MEDIUMWAIT);
	}
	/*
	 * Locator for ok button on tags pop-up.
	 */
	private By tagsPopupOk(){
		return By.xpath("//div[@class='FloatRight']/input[@value='OK']");
	}
	/*
	 * Function to click on ok button on tags pop-up.
	 */
	public void clickOnTagsPopupOk(){
		safeClick(tagsPopupOk(), MEDIUMWAIT);
		
	}
	/*
	 * Function to click on now infront of publish date.
	 */
	public void clickOnPublishDateNow(String title, int num){
		scrollIntoViewThroughJavaScriptExecuter(formTable(num, title));
		safeClick(formTable(num, title), MEDIUMWAIT);
	}
	/*
	 * Locator for save button.
	 */
	private By saveButton(){
		//return By.xpath("//div[@class='CMSEditMenu']//div[@class='LeftAlign Actions']/table/tbody/tr/td[1]/a");
		return By.xpath("//span[text()='Save']");
	}
	/*
	 * Function to click on save button.
	 */
	public void clickOnSaveButton(){
//		switchToDefaultFrame();
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ui-layout-pane ui-layout-pane-center']")));
		//BrowserInstance.driver.switchTo().frame( BrowserInstance.driver.findElement(By.id("m_c_contentview")));
		safeJavaScriptClick(saveButton(), MEDIUMWAIT);
	}
	/*
	 * Locator for tools in menu bar.
	 */
	private By tools(){
		return By.xpath("//span[text()='Tools']");
	}
	/*
	 * Function to click on tools option in menu bar.
	 */
	public CMSToolsPage clickOnToolsMenu(){
		safeClick(tools(), MEDIUMWAIT);
		LoggerInstance.logger.info("Click on tools in menu bar on CMS Desk Page "); 
		return(PageFactory.initElements(BrowserInstance.driver, CMSToolsPage.class));
	}
	
}
