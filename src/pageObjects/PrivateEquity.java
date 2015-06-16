package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class PrivateEquity extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public PrivateEquity()
	{
	}//End public StockScreener(WebDriver driver)
	
	/*
	 * Locator for the portfolio text.
	 */
	public By articleTxt(){
		 return By.xpath("//h4[text()='Articles']");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public boolean isArticleTxtPresent(){
		 return isElementPresent(articleTxt(), MEDIUMWAIT);
	}

	/*
	 * Locator for the portfolio text.
	 */
	public By articleListTxt(int i){
		 return By.xpath("//div[@class='box-plain']/div[@class='hub-article-container']["+i+"]//a");
	}
	/*
	 * Function to check presence of the portfolio tracker text.
	 */
	public String getTextOfArticleList(int i){
		 return safeGetText(articleListTxt(i), MEDIUMWAIT);
	}


}
