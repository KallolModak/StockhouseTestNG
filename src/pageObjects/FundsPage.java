package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class FundsPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public FundsPage()
	{
	}//End public FundsPage(WebDriver driver)
	/*
	 * Locator for funds performance overview table header.
	 */
	private By FundsPerformOver(){
		driver.switchTo().frame(driver.findElement(By.id("p_lt_zoneContent_SubContent_p_lt_zoneLeft_Stockhouse_MutualFunds_dynamicIFrame")));
		return By.xpath("//span[contains(text(),'Funds Performance Overview')]");
	}
	/*
	 * Function to check the presence of funds performance overview table header.
	 */
	public boolean isFundsPerformOverHeadPresent(){
		boolean result= isElementPresent(FundsPerformOver(), MEDIUMWAIT);
		switchToDefaultFrame();
		return result;
	}
	/*
	 * Locator for Funds page header.
	 */
	private By FundsHead(){
		return By.xpath("//h1[contains(text(),'Funds Performance Overview')]");
	}
	/*
	 * Function to check the presence of Funds page header.
	 */
	public boolean isFundsHeadPresent(){
		return isElementPresent(FundsHead(), MEDIUMWAIT);
	}


}
