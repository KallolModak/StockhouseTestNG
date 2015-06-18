package pageObjects;

import org.openqa.selenium.By;

import common.BrowserInstance;
import common.WebdriverUtility;

public class GroupsPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public GroupsPage()
	{
	}//End public GroupsPage(WebDriver driver)
	/*
	 * Locator for sort by header.
	 */
	private By sortBy(){
		return By.xpath("//label[text()='Sort By:']");
	}
	/*
	 * Function to check the presence of sort by head.
	 */
	public boolean isSortByHeadPresent(){
		return isElementPresent(sortBy(), MEDIUMWAIT);
	}
	/*
	 * Locator for various groups.
	 */
	private By variousGroups(int num){
		return By.xpath("//div[@class='groups-page']//div[@class='groups']["+num+"]/div[@class='group-info']//a");
	}
	/*
	 * Function to get text of head of various groups.
	 */
	public String getTextOfVariousGroupsHead(int num){
		return safeGetText(variousGroups(num), MEDIUMWAIT);
	}
	/*
	 * Locator for sort by combo box.
	 */
	private By sortByCombo(){
		return By.xpath("//div[@class='bullboard-posts-header clearfix']//select");
	}
	/*
	 * Function to select an option from sort by combo box.
	 */
	public void selectSortByViewMode(String modeSelectCombo){
		selectFromDropDown(modeSelectCombo, BrowserInstance.driver.findElement(sortByCombo()));
	}
	/*
	 * Locator for sorting arrow.
	 */
	private By sortingArrow(){
		return By.xpath("//div[@class='bullboard-posts-header clearfix']/div[@class='pull-left']/input[1]");
	}
	/*
	 * Function to click on sorting arrow.
	 */
	public void clickOnSortingArrow(){
		safeClick(sortingArrow(), MEDIUMWAIT);
	}
	/*
	 * Locator for filter groups by sectors.
	 */
	private By filterBySectors(){
		return By.xpath("//div[@class='groups-sector-filter']/a");
	}
	/*
	 * Function to click on filter groups by sectors.
	 */
	public void clickOnFilterBySectors(){
		safeClick(filterBySectors(), MEDIUMWAIT);
	}
	/*
	 * Locator for options for filter groups by sectors pop up.
	 */
	private By optionInFilterBySectors(int tr, int td, String txt){
		if(txt.equalsIgnoreCase("button"))
			txt="//div[@class='groups-sector-filter']/div[@class='gc-filter-panel']/table/tbody/tr["+tr+"]/td["+td+"]/input";
		else //label
			txt="//div[@class='groups-sector-filter']/div[@class='gc-filter-panel']/table/tbody/tr["+tr+"]/td["+td+"]/label";
		return By.xpath(txt);
	}
	/*
	 * Function to select the options for filter groups by sectors pop up.
	 */
	public void selectOptionInFilterBySectors(int tr, int td, String txt){
		safeSelectRadioButton(optionInFilterBySectors(tr,td, txt), MEDIUMWAIT);
	}
	/*
	 * Function to get text of option displayed on group page after selecting from filter groups by sectors.
	 */
	public String getTextOptionInFilterBySectors(int tr, int td, String txt){
		return safeGetText(optionInFilterBySectors(tr,td, txt), MEDIUMWAIT);
	}
	/*
	 * Locator for submit button in filter groups by sectors pop up.
	 */
	private By submitFilterBySectors(){
		return By.xpath("//div[@class='groups-sector-filter']/div[@class='gc-filter-panel']/div/input");
	}
	/*
	 * Function to click on submit button in filter groups by sectors pop up.
	 */
	public void clickOnSubmitFilterBySectors(){
		safeClick(submitFilterBySectors(), MEDIUMWAIT);
	}
	/*
	 * Locator for option displayed on group page after selecting from filter groups by sectors.
	 */
	private By filterSectorOptionOnPage(String txt){
		return By.xpath("//div[@class='groups-page']/div[text()='"+txt+"']");
	}
	/*
	 * Function to get text of option displayed on group page after selecting from filter groups by sectors.
	 */
	public boolean isFilterSectorOptionOnPagePresent(String txt){
		return isElementPresent(filterSectorOptionOnPage(txt), MEDIUMWAIT);
	}

}
