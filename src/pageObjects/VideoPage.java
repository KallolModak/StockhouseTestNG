package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class VideoPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public VideoPage()
	{
	}//End public VideoPage(WebDriver driver)
	
	/*
	 * Locator for the video cover.
	 */
	public By videoCover(){
		 return By.xpath("//div[@class='player']");
	}
	/*
	 * Function to check presence of the video cover.
	 */
	public boolean isVideoCoverPresent(){
		 return isElementPresent(videoCover(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for the ETFPerformanceOverview text.
	 */
	public By thumbnail(){
		 return By.xpath("//ol[@class='thumbnails']/li");
	}
	/*
	 * Function to check presence of the ETFPerformanceOverview text.
	 */
	public int numberOfThumbnailPresent(){
		 return driver.findElements(thumbnail()).size();
	}
	

}
