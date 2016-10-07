package pageObjects;

import org.openqa.selenium.By;

import common.BrowserInstance;
import common.WebdriverUtility;

public class CurrenciesPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public CurrenciesPage()
	{
	}//End public CurrenciesPage(WebDriver driver)
	/*
	 *Locator for Currency table.
	 */
	private By currencyTable(){
		return By.xpath("//div[@class='bd']/div[@class='qs-main']");
	}
	/*
	 * Function to check the presence of Currency table.
	 */
	public boolean isCurrencyTablePresent(){
		return isElementPresent(currencyTable(),MEDIUMWAIT);
	}
	/*
	 * Locator for iframe for full page.
	 */
	public void switchToFrameInCurrency(){
		   BrowserInstance.driver.switchTo().frame(BrowserInstance.driver.findElement(By.xpath("//div[@class='frame-container']/iframe")));
		BrowserInstance.driver.switchTo().frame(BrowserInstance.driver.findElement(By.xpath("//iframe[contains(@id,'QSAPI_IFRAME')]")));
	}
}
