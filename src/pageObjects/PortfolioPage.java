package pageObjects;

import org.openqa.selenium.By;

import common.BrowserInstance;
import common.WebdriverUtility;

public class PortfolioPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public PortfolioPage()
	{
	}//End public VideoPage(WebDriver driver)
	
	/*
	 * Locator for the portfolio text.
	 */
	public By portfolio(){
		 BrowserInstance.driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='frame-container iframe-loading']/iframe")));
		 return By.xpath("//div[@id='portfoliomanager_index']/div[@class='main-control standalone clearfix']/div[@class='toolbar']/div[@class='pull-left title']/h3[text()='Portfolio Manager']");
		 //return By.xpath("//div[@id='MasterMiddle']/div[@id='MasterMainContent']/form/div[@id='MainDiv']/div[@id='portfoliomanagercontent']//div[@class='toolbar']/div[@class='pull-left title']/h3[text()='Portfolio Manager']");
	}
	/*
	 * Function to check presence of the portfolio Manager text.
	 */
	public boolean isPortfolioTxtPresent(){
		 return isElementPresent(portfolio(),SHORTWAIT);
	}
	
	/*
	 * Locator for the portfolio text.
	 */
	public By portfolioTracker(){
		 return By.xpath("//h4[contains(text(),'Portfolio Tracker')]");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isPortfolioTrackerTxtPresent(){
		 return isElementPresent(portfolioTracker(), MEDIUMWAIT);
	}
	

}
