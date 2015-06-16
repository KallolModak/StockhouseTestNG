package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class NewsPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public NewsPage()
	{
	}//End public VideoPage(WebDriver driver)
	
	/*
	 * Locator for the news text.
	 */
	public By newsTxt(){
		 return By.xpath("//h1[contains(text(),'News')]");
	}
	/*
	 * Function to check presence of the news text.
	 */
	public boolean isNewsTxtPresent(){
		 return isElementPresent(newsTxt(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the FeaturedNews text.
	 */
	public By featuredNews(){
		 return By.xpath("//h4[contains(text(),'Featured News')]");
	}
	/*
	 * Function to check presence of the FeaturedNews text.
	 */
	public boolean isFeaturedNewsTxtPresent(){
		 return isElementPresent(featuredNews(), MEDIUMWAIT);
	}
	

}
