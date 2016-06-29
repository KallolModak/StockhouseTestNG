package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class InterviewPage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public InterviewPage()
	{
	}//End public StockScreener(WebDriver driver)
	
	
	/*
	 * Locator for the interview list text.
	 */
	public By interviewListTxt(int i){
		 return By.xpath("//div[@class='column span-3']/div[@class='hub-article-container']["+i+"]//a");
	}
	/*
	 * Function to get text of interview list text
	 */
	public String getTextOfInterviewList(int i){
		 return safeGetText(interviewListTxt(i), MEDIUMWAIT);
	}


}
