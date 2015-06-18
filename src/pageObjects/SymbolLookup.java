package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class SymbolLookup extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public SymbolLookup()
	{
	}//End public StockScreener(WebDriver driver)
	
	/*
	 * Locator for the symbolLookupTxt text.
	 */
	public By symbolLookupTxt(){
		 return By.xpath("//h1[text()='Symbol Lookup']");
	}
	/*
	 * Function to check presence of the symbolLookupTxt text.
	 */
	public boolean isSymbolLookupTxtPresent(){
		 return isElementPresent(symbolLookupTxt(), MEDIUMWAIT);
	}



}
