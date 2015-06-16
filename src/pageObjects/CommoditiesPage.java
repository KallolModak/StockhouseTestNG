package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class CommoditiesPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public CommoditiesPage()
	{
	}//End public CommoditiesPage(WebDriver driver)
	/*
	 * Locator for metals.
	 */
	private By metals(){
		return By.xpath("//h4[contains(text(),'Metals')]");
	}
	/*
	 * Function to check the presence of metals header.
	 */
	public boolean isMetalsHeadPresent(){
		return isElementPresent(metals(), MEDIUMWAIT);
	}
	/*
	 * Locator for energies.
	 */
	private By energies(){
		return By.xpath("//h4[contains(text(),'Energies')]");
	}
	/*
	 * Function to check the presence of market update header.
	 */
	public boolean isEnergiesHeadPresent(){
		return isElementPresent(energies(), MEDIUMWAIT);
	}

}
