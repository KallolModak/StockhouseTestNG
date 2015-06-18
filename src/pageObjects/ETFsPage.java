package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import common.WebdriverUtility;

public class ETFsPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public ETFsPage()
	{
	}//End public ETFsPage(WebDriver driver)
	
	/*
	 * Locator for the MoreETFArticles text.
	 */
	public By MoreETFArticles(){
		 return By.xpath("//h4[text()='More ETF Articles']");
	}
	/*
	 * Function to check presence of the MoreETFArticles text.
	 */
	public boolean isMoreETFArticlesPresent(){
		 return isElementPresent(MoreETFArticles(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the ETFPerformanceOverview text.
	 */
	public By topStory(){
		 return By.xpath("//span[text()='Top Story']");
	}
	/*
	 * Function to check presence of the ETFPerformanceOverview text.
	 */
	public boolean isTopStoryPresent(){
		 return isElementPresent(topStory(), MEDIUMWAIT);
	}
	
}
