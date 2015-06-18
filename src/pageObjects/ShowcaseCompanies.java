package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class ShowcaseCompanies extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public ShowcaseCompanies()
	{
	}//End public StockScreener(WebDriver driver)
	
	/*
	 * Locator for the portfolio text.
	 */
	public By featuredCompany(){
		 return By.xpath("//h4[text()='Featured Company']");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isFeaturedCompanyTxtPresent(){
		 return isElementPresent(featuredCompany(), MEDIUMWAIT);
	}

	/*
	 * Locator for the portfolio text.
	 */
	public By showcaseComapnyTxt(){
		 return By.xpath("//h1[contains(text(),'Showcase Companies')]");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isShowcaseCompaniesTxtPresent(){
		 return isElementPresent(showcaseComapnyTxt(), MEDIUMWAIT);
	}


}
