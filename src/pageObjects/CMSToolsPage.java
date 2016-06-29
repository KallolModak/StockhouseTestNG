package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import common.BrowserInstance;
import common.WebdriverUtility;

public class CMSToolsPage extends WebdriverUtility{
	
	/*
	 * Method for expanding Quick link and click the sub links
	 */
	
	public CMSToolsPage()
	{}//End public CMSDeskPage(WebDriver driver)
	
	/*
	 * Function to switch to frame of tools menu.
	 */
	public void toolsMenuFrame(){
		BrowserInstance.driver.switchTo().frame(driver.findElement(By.xpath("//frame[@id='toolscontent']")));
	}
	/*
	 * Locator for custom tables.
	 */
	private By customTables(int divnum){
		return By.xpath("//div[@id='m_pnlContent']/table[@class='PanelMenuWrapper']/tbody/tr/td/div[@class='PanelMenu']/div[1]/div["+divnum+"]/div[@class='CategoryMenu']/a");
	}
	/*
	 * Function to click on custom tables.
	 */
	public void clickOnCustomTableOption(int tdnum){
		safeClick(customTables(tdnum), MEDIUMWAIT);
	}
	/*
	 * Locator for custom table menu.
	 */
	private By customTableMenuOption(int trnum){
		return By.xpath("//div[@class='UniGridContent']/table/tbody/tr/td/div/table[@class='UniGridGrid _nodivs']/tbody/tr["+trnum+"]/td[1]/input");
	}
	/*
	 * Function to click on news focus option in custom table menu.
	 */
	public void clickOnNewsFocus(int trnum){
		safeClick(customTableMenuOption(trnum), MEDIUMWAIT);
	}
	/*
	 * Locator for new item button in news focus.
	 */
	private By newItemButton(){
		return By.xpath("//span[text()='New item']");
	}
	/*
	 * Function to click on new item button in news focus.
	 */
	public void clickOnNewItemButton(){
		safeClick(newItemButton(), MEDIUMWAIT);
	}
	/*
	 * Locator for news focus form in adding new item in news focus.
	 */
	private By NewsFocusForm(String title,int trnum){
		if(title.equalsIgnoreCase("CompanySymbol")){
			title="//table[@class='EditingFormTable']/tbody/tr["+trnum+"]/td[2]//table/tbody/tr[2]/td[1]/input";
		}
		else{
			if(title.equalsIgnoreCase("AddCompanyButton")){
				title="//table[@class='EditingFormTable']/tbody/tr["+trnum+"]/td[2]//table/tbody/tr[2]/td[2]/div";
			}
			else{
				if(title.equalsIgnoreCase("newsTitle")){
					title="//table[@class='EditingFormTable']/tbody/tr["+trnum+"]/td[2]/div/input";
				}
				else{
					if(title.equalsIgnoreCase("previewText")){
						title="//table[@class='EditingFormTable']/tbody/tr["+trnum+"]/td[2]/div/textarea";
					}
					else{
						if(title.equalsIgnoreCase("destinationURL")){
							title="//table[@class='EditingFormTable']/tbody/tr["+trnum+"]/td[2]/div/input";
						}
						else{
							if(title.equalsIgnoreCase("targetDate")){
								title="//table[@class='EditingFormTable']/tbody/tr["+trnum+"]/td[2]/div/span/a";
							}
							else{
								if(title.equalsIgnoreCase("BBNewsSpotlight")){
									title="//table[@class='EditingFormTable']/tbody/tr["+trnum+"]/td[2]/div/span/input";
								}
								else{//news focus bar
									title="//table[@class='EditingFormTable']/tbody/tr["+trnum+"]/td[2]/div/span/input";
								}
							}
						}
					}
				}
				
			}
		}
		return By.xpath(title);
	}
	/*
	 * Function to set text in company symbol text box.
	 */
	public void setCompanySymbol(String title,int trnum,String textToType){
		safeType(NewsFocusForm(title, trnum), textToType, MEDIUMWAIT);
		try{
			Thread.sleep(4000);
		}catch(Exception e){}
		driver.findElement(NewsFocusForm(title, trnum)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(NewsFocusForm(title, trnum)).sendKeys(Keys.ENTER);
	}
	/*
	 * Function to click on add company button.
	 */
	public void clickOnAddCompanyButton(String title,int trnum){
		safeClick(NewsFocusForm(title, trnum), MEDIUMWAIT);
	}
	/*
	 * Function to set news title in title text box.
	 */
	public void setNewsTitle(String title,int trnum,String textToType){
		safeType(NewsFocusForm(title, trnum), textToType, MEDIUMWAIT);
	}
	/*
	 * Function to set text in preview textbox.
	 */
	public void setPreviewText(String title,int trnum,String textToType){
		safeType(NewsFocusForm(title, trnum), textToType, MEDIUMWAIT);
	}
	/*
	 * Function to set text in destination link textbox.
	 */
	public void setDestinationLink(String title,int trnum,String textToType){
		safeType(NewsFocusForm(title, trnum), textToType, MEDIUMWAIT);
	}
	/*
	 * Function to click on now link for target date.
	 */
	public void clickOnTargetDateNow(String title,int trnum){
		safeClick(NewsFocusForm(title, trnum), MEDIUMWAIT);
	}
	/*
	 * Function to select bullBoard news spotlight bar check box.
	 */
	public void selectBBNewsSpotlight(String title,int trnum) throws Exception{
		safeSelectCheckboxes(MEDIUMWAIT, NewsFocusForm(title, trnum));
		
	}
	/*
	 * Function to select news focus bar check box.
	 */
	public void selectNewsFocusBar(String title,int trnum) throws Exception{
		safeSelectCheckboxes(MEDIUMWAIT, NewsFocusForm(title, trnum));
	}
	/*
	 * Locator for save button.
	 */
	private By saveButton(){
		return By.xpath("//a[@class='MenuItemEdit']");
	}
	/*
	 * Function to click on save button.
	 */
	public void clickOnSaveButton(){
		safeClick(saveButton(), MEDIUMWAIT);
	}
}
