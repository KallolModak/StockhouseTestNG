package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class StockStreamPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public StockStreamPage()
	{
	}//End public StockStreamPage(WebDriver driver)
	
	/*
	 * Locator for the portfolio text.
	 */
	public By moduleContent(int i){
		 return By.xpath("//div[@class='module-content']/div["+i+"]/h3");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public String getTxtOfModuleContent(int i){
		 return safeGetText(moduleContent(i), MEDIUMWAIT);
	}

}
