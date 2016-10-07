package pageObjects;

import org.openqa.selenium.By;

import common.BrowserInstance;
import common.WebdriverUtility;

public class BondsPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public BondsPage()
	{
	}//End public CurrenciesPage(WebDriver driver)
	/*
	 *Locator for Bonds table.
	 */
	private By bondsTable(){
		return By.xpath("//div[@id='bmcontainer']");
	}
	/*
	 * Function to check the presence of Bonds table.
	 */
	public boolean isBondsTablePresent(){
		return isElementPresent(bondsTable(),MEDIUMWAIT);
	}
	/*
	 * Locator for iframe for full page.
	 */
	public void switchToFrameInBond(){
		BrowserInstance.driver.switchTo().frame(BrowserInstance.driver.findElement(By.xpath("//div[@class='frame-container']/iframe")));
		BrowserInstance.driver.switchTo().frame(BrowserInstance.driver.findElement(By.xpath("//iframe[contains(@id,'QSAPI_IFRAME')]")));
	}
}
