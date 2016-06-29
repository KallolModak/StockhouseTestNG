/*
 * This is Home Page factory, contains all operations performed from home page.
 */

package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.server.SeleniumServer;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.BrowserInstance;
import common.LoggerInstance;
import common.WebdriverUtility;


public class HomePage extends WebdriverUtility{
	
	/*
	 * Method for expanding Quick link and click the sub links
	 */
	
	public HomePage()
	{
	}//End public HomePage(WebDriver driver)
	private By quickLinks()
	{
	 	return By.xpath("//a[contains(text(),'Quick Links')]");
	}
	
	public void expandQuickLinks(){
	  safeClick(quickLinks(), MEDIUMWAIT);
	  
	}
	
	private By quickLinkItems(String item)
	{
			return By.xpath("//a[contains(text(),'"+item+"')]");
	}
	
	public void clickQuickLinkItems(String item){
		  safeClick(quickLinkItems(item), MEDIUMWAIT);
		  LoggerInstance.logger.info("Click on Quick Link > "+item);
			
	}
 	 
	/*
	 * *******************   Method for Footer  Link********************
	 * This Method is used for  Stockhouse  in footer section. 
	 */
	
 	private By StockhouseLink(){
	 	return By.xpath("//a[contains(text(),'Quick Links')]");
	}
	//It returns the xpath
	private By stockHouseItems(String item){
			return By.xpath("//footer[@id='footer']//a[contains(text(),'"+item+"')]"); //Returns xpath of footer links
	}
	
	//It clicks on the link in footer 
	public void clickStockHouseItems(String item){
		  safeClick(stockHouseItems(item), MEDIUMWAIT); 
		  LoggerInstance.logger.info("Click on Stock House items in footer section > "+item); 
	}
   /*
    * Locator for 'commodities' and 'currency' button.
    */
	private By commoditiesCurrencyTab(String name1)
	{
		if(name1.equalsIgnoreCase("commodity"))
			return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][1]/nav/ul/li[contains(@class,'first')]/a");
		else //currency
			return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][1]/nav/ul/li[@class='last']/a");
	}
	/*
	 * Function to click on 'commodity' or 'currency' tab.
	 */
	public void clickCommoditiesCurrencyTab(String name1){
		safeJavaScriptClick(commoditiesCurrencyTab(name1), MEDIUMWAIT);
		//LoggerInstance.logger.info("Click on Commodities link ");  
	}
   /*
    * Locator for options under commodities and currencies table.
    */
	private By commodityCurrencyOption(String name2){
		if(name2.equalsIgnoreCase("commodity"))
			
			return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][1]/div[@class='tab-content']/div[contains(@id,'panelTab1')]/table/tbody/*[1]/*[1]/a");
		else //currency
			return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][1]/div[@class='tab-content']/div[contains(@id,'panelTab2')]/table/tbody/*[1]/*[1]/a");
	}
	/*
	 * Function to click on commodity or currency option.
	 */
	public void clickOnCommodityCurrencyOption(String name2){
		safeClick(commodityCurrencyOption(name2),MEDIUMWAIT);
	}
	/*
	 * Function to get attribute of commodity or currency option.
	 */
	public String getHrefOfCommodityCurrencyOption(String name2){
		return driver.findElement(commodityCurrencyOption(name2)).getAttribute("href");
	}
	/*
	 * Locator for header after click on commodity option.
	 */
	private By headerAfterComOptClick(String name){
		if(name.endsWith("firstHead")){
			return By.xpath("//div[@class='company-header container-fluid']/h1");
		}
		else{// second head
			return By.xpath("//div[@class='company-header container-fluid']/h2/span");
		}
	}
	/*
	 * Function to check the nullness of header after click on commodity option.
	 */
	public String getTextOfHeaderAfterComOptClick(String name){
		return safeGetText(headerAfterComOptClick(name), MEDIUMWAIT);
	}
	/*
	 * Locator for tables on page appearing after click on commodity or currency or initial market option.
	 */
	private By tableAfterComCurrIntMarkOptClick(int value1, int value2){
		return By.xpath("//div[@id='companySnapshotQuote']//table/tbody/tr["+value1+"]/td["+value2+"]/strong");
	}
	/*
	 * Function to check the nullness of text of 'price' and '52 weeks high/low'.
	 */
	public String getTextOfTableAfterComCurrIntMarkOptClick(int value1, int value2){
		return safeGetText(tableAfterComCurrIntMarkOptClick(value1,value2), MEDIUMWAIT);
	}
	/*
	 * Locator for header after click on currency option.
	 */
	private By headerAfterCurrOptClick(String name){
		if(name.endsWith("firstHead")){
			return By.xpath("//div[@class='company-header container-fluid']/h1");
		}
		else{// second head
			return By.xpath("//div[@class='company-header container-fluid']/h2/span");
		}
	}
	/*
	 * Function to check the nullness of header after click on commodity option.
	 */
	public String getTextOfHeaderAfterCurrOptClick(String name){
		return safeGetText(headerAfterCurrOptClick(name), MEDIUMWAIT);
	}
/*
 * Locator for Commodities Section's table items.
 */
//	private By commoditiesItems(int rownum,int colnum)
//	{
//		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='frame-container']/iframe")));
//		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='iframe-container-widget']/iframe")));
//		return By.xpath("//div[@class='rtq-grid-scroll']/div[@class='rtq-grid-bd']/div[@class='rtq-grid-row'][1]");
//		//return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][1]/div[@class='tab-content']/div[contains(@id,'panelTab1')]/table/tbody/tr["+rownum+"]/td["+colnum+"]");
//	}
	private By commoditiesItems(int num)
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='custom-markets'][1]/div[@class='tab-content'][1]//div[@class='frame-container']/iframe")));
		//driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='frame-container']/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='iframe-container-widget']/iframe")));
		return By.xpath("//div[@class='rtq-grid-scroll']/div[@class='rtq-grid-bd']/div[@class='rtq-grid-row']["+num+"]");
		//return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][1]/div[@class='tab-content']/div[contains(@id,'panelTab1')]/table/tbody/tr["+rownum+"]/td["+colnum+"]");
	}
//	/*
//	 * Function to check the null value of Commodities Section's table items.
//	 */
//	public String getTextOfCommoditiesItems(int rownum,int colnum)
//	{
//		LoggerInstance.logger.info("Click on Quick Link > "+rownum);
//		String s = driver.findElement(commoditiesItems(rownum,colnum)).getText();
//		return s;
//	}	
	/*
	 * Function to check the null value of Commodities Section's table items.
	 */
	public String getTextOfCommoditiesItems(int num)
	{
		LoggerInstance.logger.info("Click on Quick Link > ");
		String s=driver.findElement(commoditiesItems(num)).getText();
		return s;
		
	}	
	/*
	 * Locator for Currencies Section's table items.
	 */
	private By currenciesItems(int rownum,int colnum)
	{
		return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][1]/div[@class='tab-content']/div[contains(@id,'panelTab2')]/table/tbody/tr["+rownum+"]/td["+colnum+"]");
	}
	/*
	 * Function to check the null value of Currencies Section's table items.
	 */
	public String getTextOfCurrenciesItems(int rownum,int colnum)
	{
		LoggerInstance.logger.info("Click on Quick Link > "+rownum);
		String s = driver.findElement(currenciesItems(rownum,colnum)).getText();
		return s;
	}
	/*
	 * Locator for Market and initial market tab.
	 */
	private By marketsIntialMarketTab(String name)
	{
		if(name.equalsIgnoreCase("market"))
			return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][2]/nav/ul/li[contains(@class,'first')]/a");
		else //initial market
			return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][2]/nav/ul/li[@class='last']/a");
	}
	/*
	 * Function to click on Market or initial market tab.
	 */
	public void clickMarketsIntialMarketTab(String name){
		safeClick(marketsIntialMarketTab(name), VERYLONGWAIT);
	} 
	/*
	 * Locator for options under market and inital market table.
	 */
	private By marketInitialMarketOption(String name){
		if(name.equalsIgnoreCase("market"))
			return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][2]//div[contains(@id,'panelTab1')]/table/tbody/*[1]/*[1]/a");
		else //initial market
			return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][2]//div[contains(@id,'panelTab2')]/table/tbody/*[1]/*[1]/a");
	}
	/*
	 * Function to click on market or inital market option.
	 */
	public void clickOnMarketInitialMarketOption(String name){
		safeClick(marketInitialMarketOption(name),MEDIUMWAIT);
	}
	/*
	 * Function to get attribute of option under initial market.
	 */
	public String getHrefOfInitialMarketOption(String name){
		return driver.findElement(marketInitialMarketOption(name)).getAttribute("href");
	}
	/*
	 * Function to get text of option under market.
	 */
	public String getTextOfMarketOption(String name){
		return safeGetText(marketInitialMarketOption(name), MEDIUMWAIT);
	}
	/*
	 * Locator for header after click on option under market.
	 */
	private By headerAfterMarketOptClick(){
		return By.xpath("//div[@class='column span-6 last']/h1");
	}
	/*
	 * Function to get text of header after click on option under market.
	 */
	public String getTextOfHeaderAfterMarketOptClick(){
		return safeGetText(headerAfterMarketOptClick(), MEDIUMWAIT);
	}
	/*  
	 * Locator for table appearing after choosing any option from market table.
	 */
	private By tableAfterMarketOptClick(int rownum,int colnum)
	{
		return By.xpath("//table[@id='qmmt_scalingMarketStatsTable']/tbody/tr["+rownum+"]/td["+colnum+"]");
	}
	/*
	 * Function to check null values of table appearing after choosing any option from market table.
	 */
	public String getTextOfTableAfterMarketOptClick(int rownum,int colnum)
	{
		
		LoggerInstance.logger.info("Click on Quick Link > "+rownum);
		String s = driver.findElement(tableAfterMarketOptClick(rownum,colnum)).getText();
		return s;
	}	
	/*
	 * Locator for header after click on option under initial market.
	 */
	private By headerAfterInitialMarketOptClick(){
		return By.xpath("//div[@class='company-header container-fluid']/h1");
	}
	/*
	 * Function to check the nullness of header after click on option under initial market.
	 */
	public String nullOfHeaderAfterInitialMarketOptClick(){
		return safeGetText(headerAfterInitialMarketOptClick(),MEDIUMWAIT);
	}
	/*  
	 * Locator for Market section's table items.
	 */
	private By marketItems(int num)
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='custom-markets'][2]/div[@class='tab-content'][1]//div[@class='frame-container']/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='iframe-container-widget']/iframe")));
		return By.xpath("//div[@class='rtq-grid-scroll']/div[@class='rtq-grid-bd']/div[@class='rtq-grid-row']["+num+"]");
		//return By.xpath("//div[@class='custom-markets'][2]/div[@class='tab-content'][1]//div[@class='frame-container']/iframe");
		//return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][2]/div[@class='tab-content']/div[contains(@id,'panelTab1')]/table/tbody/tr["+rownum+"]/td["+colnum+"]");
	}
	/*
	 * Function to check Market sectio's values are null.
	 */
	public String getTextOfMarketsItems(int num)
	{
		
		LoggerInstance.logger.info("Click on Quick Link > ");
		String s = driver.findElement(marketItems(num)).getText();
		return s;
	}	
	/*  
	 * Locator for Initial Market section's table items.
	 */
	private By initialMarketItems(int rownum,int colnum)
	{
		return By.xpath("//div[@class='column span-2 last']/div[@class='custom-markets'][2]/div[@class='tab-content']/div[contains(@id,'panelTab2')]/table/tbody/tr["+rownum+"]/td["+colnum+"]");
	}
	/*
	 * Function to check Initial Market sectio's values are null.
	 */
	public String getTextOfInitialMarketItems(int rownum,int colnum)
	{
		
		LoggerInstance.logger.info("Click on Quick Link > "+rownum);
		String s = driver.findElement(initialMarketItems(rownum,colnum)).getText();
		return s;
	}	
/*
 * Locator for Market Update block.			
 */
private By marketUpdate(){
	return By.xpath("//div[@class='column span-6 last']/following-sibling::*[2]/div[contains(@class,'webpart-container')][1]/div/h3");
}
/*
 * Function to get total size of links present in market update block.
 */
public int getSizeOfMarketUpdate(){
	return driver.findElement(marketUpdate()).findElements(By.tagName("a")).size();
}
/*
 * Locator for attribute of link in market update block.
 */
private By marketUpdateLink(){
	return By.xpath("//div[@class='column span-6 last']/following-sibling::*[2]/div[contains(@class,'webpart-container')][1]/div/h3/a");
}
/*
 * Function to get href of links in market update block.
 */
public String getHrefOfMarketUpdate(){
	return driver.findElement(marketUpdateLink()).getAttribute("href");
}
/*
 * Function to click On link in market update block.
 */
public void clickOnMarketupdate(){
	safeClick(marketUpdateLink(), MEDIUMWAIT);
}
/*
 * Locator for Columnists block.
 */
private By columnistsBlock(){
	return By.xpath("//div[@class='column span-6 last']/following-sibling::*[2]/div[contains(@class,'webpart-container')][2]/ul");
}
/*
 * Function to get number of links present in columnists block.
 */
public int getSizeOfColumnists(){
	return driver.findElement(columnistsBlock()).findElements(By.tagName("li")).size();
	//return driver.findElements(columnistsBlock()).size();
}
/*
 * Locator for attribute of link in columnists block.
 */
private By columnistsLink(int num){
	return By.xpath("//div[@class='column span-6 last']/following-sibling::*[2]/div[contains(@class,'webpart-container')][2]/ul/li["+num+"]/h3[2]/a");
}
/*
 * Function to get attribute of link of columnists block.
 */
public String getHrefOfColumnistsLink(int num){
	return driver.findElement(columnistsLink(num)).getAttribute("href");
}
/*
 * Function to click on link in columnists block.
 */
public void clickOnColumnistsLink(int num){
	safeClick(columnistsLink(num), MEDIUMWAIT);
}
/*
 * Locator for Breaking News Block.
 */
private By breakingNewsBlock(){
//	return By.xpath("//div[@class='column span-6 last']/following-sibling::*[2]/div[@class='box-hr-thick'][3]");
	return By.xpath("//h4[text()='Breaking News']/..");
}
/*
 * Function to find number of links in breaking news block.
 */
public int getSizeOfBreakingNewsBlock(){
	return driver.findElement(breakingNewsBlock()).findElements(By.tagName("div")).size();
}
/*
 * Locator for links in Breaking news block.
 */
private By breakingNewsLinks(int num){
//	return By.xpath("//div[@class='column span-6 last']/following-sibling::*[2]/div[@class='box-hr-thick'][3]/div["+num+"]/h3/a");
	return By.xpath("//h4[text()='Breaking News']/../div["+num+"]/h3/a");
}
/*
 * Function to get attribute of links in breaking news block.
 */
public String getHrefOfBreakingNewsLinks(int num){
	return driver.findElement(breakingNewsLinks(num)).getAttribute("href");
}
/*
 * Function to click on links in breaking news block.
 */
public void clickOnBreakingNewsLinks(int num){
	scrollIntoElementView(breakingNewsLinks(num));
	safeClick(breakingNewsLinks(num), MEDIUMWAIT);
}
/*
 * Locator for Interviews block.
 */
private By interviewsBlock(){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[2]/div[@class='box-hr-thick'][2]");
	return By.xpath("//h4[text()='Interviews']/..");
}
/*
 * Function to find number of links in interview block.
 */
public int getSizeOfInterviewsBlock(){
	return driver.findElement(interviewsBlock()).findElements(By.tagName("div")).size();
}
/*
 * Locator for Links in interview block.
 */
private By interviewLinks(){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[2]/div[@class='box-hr-thick'][2]/div/h3/a");
	return By.xpath("//h4[text()='Interviews']/../div/h3/a");
}
/*
 * Function to get attribute of links in interview block.
 */
public String getHrefOfInterviewLinks(){
	return driver.findElement(interviewLinks()).getAttribute("href");
}
/*
 * Function to click on links in interview block.
 */
public void clickOnInterviewLinks(){
	safeClick(interviewLinks(),MEDIUMWAIT);
}
/*
 * Locator for Featured News block.
 */
private By featuredNews(){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[1]/div[@class='box-hr-thick'][1]");
	return By.xpath("//h4[text()='Featured News']/..");
}
/*
 * Function to find size of Featured News block.
 */
public int getSizeOfFeaturedNews(){
	return driver.findElement(featuredNews()).findElements(By.tagName("a")).size();
}
/*
 * Locator for links in Featured News block.
 */
private By featuredNewsLinks(int num){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[1]/div[@class='box-hr-thick'][1]/a["+num+"]");
	//return By.xpath("//h4[text()='Featured News']/../ul/a["+num+"]");
	return By.xpath("//h4[text()='Featured News']/following-sibling::*[1]/div/h3/a");
}
/*
 * Function to click on links in Featured News block. 
 */
public void clickOnFeaturedNewsLinks(int num){
	safeClick(featuredNewsLinks(num), MEDIUMWAIT);
}
/*
 * Function to get href of links in Featured News block.
 */
public String getHrefOfFeaturedNewsLinks(int num){
	return BrowserInstance.driver.findElement(featuredNewsLinks(num)).getAttribute("href");
}

/*
 * Locator for Opinion And Analysis block.
 */
private By opinionAndAnalysisBlock(){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[1]/div[@class='box-hr-thick'][2]");
	return By.xpath("//h4[text()='Opinion and Analysis']/..");
}
/*
 * Function to find size of Opinion And Analysis block.
 */
public int getSizeOfOpinionAndAnalysis(){
	return driver.findElement(opinionAndAnalysisBlock()).findElements(By.tagName("div")).size();
}
/*
 * Locator for links in Opinion And Analysis block.
 */
private By opinionAndAnalysisLinks(int num){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[1]/div[@class='box-hr-thick'][2]/div["+num+"]/h3/a");
	return By.xpath("//h4[text()='Opinion and Analysis']/../div["+num+"]/h3/a");
}
/*
 * Function to get attribute of links in Opinion And Analysis block.
 */
public String getHrefOfOpinionAndAnalysisLinks(int num){
	return driver.findElement(opinionAndAnalysisLinks(num)).getAttribute("href");
}
/*
 * Function to click on links in Opinion And Analysis block.
 */
public void clickOnOpinionAndAnalysisLinks(int num){
	safeClick(opinionAndAnalysisLinks(num), MEDIUMWAIT);
}
/*
 * Locator for Canadian Press Releases block.
 */
private By canadianPR(){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[1]/div[@class='box-hr-thick'][3]");
	return By.xpath("//h4[text()='Canadian Press Releases']/..");
}
/*
 * Function to find size of Canadian Press Releases block.
 */
public int getSizeOfCanadianPR(){
	return driver.findElement(canadianPR()).findElements(By.tagName("div")).size();
}
/*
 * Locator for links in Canadian Press Releases block.
 */
private By canadianPRLinks(int num){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[1]/div[@class='box-hr-thick'][3]/div["+num+"]/h3/a");
	return By.xpath("//h4[text()='Canadian Press Releases']/../div["+num+"]/h3/a");
}
/*
 * Function to get attribute of links in Canadian Press Releases block.
 */
public String getHrefOfCanadianPRLinksLinks(int num){
	return driver.findElement(canadianPRLinks(num)).getAttribute("href");
}
/*
 * Function to click on links in Canadian Press Releases block.
 */
public void clickOnCanadianPRLinksLinks(int num){
	safeClick(canadianPRLinks(num), MEDIUMWAIT);
}
/*
 * Locator for US Press Releases block.
 */
private By USPressRelease(){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[1]/div[@class='box-hr-thick'][3]");
	return By.xpath("//h4[text()='US Press Releases']/..");
}
/*
 * Function to scroll the US press release block into view.
 */
public void scrollUSPressRelease(){
	scrollIntoElementView(USPressRelease());
}
/*
 * Function to find size of US Press Releases block.
 */
public int getSizeOfUSPressRelease(){
	return driver.findElement(USPressRelease()).findElements(By.tagName("div")).size();
}
/*
 * Locator for links in US Press Releases block.
 */
private By USPressReleaseLinks(int num){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[1]/div[@class='box-hr-thick'][3]/div["+num+"]/h3/a");
	return By.xpath("//h4[text()='US Press Releases']/../div["+num+"]/h3/a");

}
/*
 * Function to get attribute of links in US Press Releases block.
 */
public String getHrefOfUSPressReleaseLinks(int num){
	return driver.findElement(USPressReleaseLinks(num)).getAttribute("href");
}
/*
 * Function to click on links in US Press Releases block.
 */
public void clickOnUSPressReleaseLinks(int num){
	safeClick(USPressReleaseLinks(num), MEDIUMWAIT);
}
/*
 * Locator for Showcase News Releases block.
 */
private By showcaseNR(){
	//return By.xpath("//div[@class='column span-2 last']/div[@class='box-plain']/div");
	return By.xpath("//h4[text()='Showcase News Releases']/../div");
}
/*
 * Function to find size of Showcase News Releases block.
 */
public int getSizeOfShowcaseNR(){
	return driver.findElement(showcaseNR()).findElements(By.tagName("a")).size();
}
/*
 * Locator for links in Showcase News Releases block.
 */
private By showcaseNRLinks(){
	//return By.xpath("//div[@class='column span-2 last']/div[@class='box-plain']/div/a");
	return By.xpath("//h4[text()='Showcase News Releases']/../div/a");
}
/*
 * Function to get attribute of links in Showcase News Releases block.
 */
public String getHrefOfShowcaseNRLinks(){
	return driver.findElement(showcaseNRLinks()).getAttribute("href");
}
/*
 * Function to click on links in Showcase News Releases block.
 */
public void clickOnShowcaseNRLinks(){
	safeClick(showcaseNRLinks(), MEDIUMWAIT);
}
/*
 * Locator for Featured Company block.
 */
private By featuredCompany(){
	//return By.xpath("//div[@class='column span-2 last']/div[@class='box-hr-thick']");
	return By.xpath("//h4[text()='Featured Company']/..");
}
/*
 * Function to find size of Featured Company block.
 */
public int getSizeOfFeaturedCompany(){
	return driver.findElement(featuredCompany()).findElements(By.tagName("figure")).size();
}
/*
 * Locator for links in Featured Company block.
 */
private By featuredCompanyLinks(int figNum){
	//return By.xpath("//div[@class='column span-2 last']/div[@class='box-hr-thick']/figure//h3/a");
	return By.xpath("//h4[text()='Featured Company']/../figure["+figNum+"]/div/a");
}
/*
 * Function to get attribute of links in Featured Company block.
 */
public String getHrefOfFeaturedCompanyLinks(int figNum){
	return driver.findElement(featuredCompanyLinks(figNum)).getAttribute("href");
}
/*
 * Function to click on links in SFeatured Company block.
 */
public void clickOnFeaturedCompanyLinks(int figNum){
	safeClick(featuredCompanyLinks(figNum), MEDIUMWAIT);
}
/*
 * Locator for Video Showcase block.
 */
private By videoShowcase(){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[2]/div[contains(@class,'webpart-container')][3]/ul");
	return By.xpath("//h4[text()='Video Showcase']/../ul");
}
/*
 * Function to find size of Video Showcase block.
 */
public int getSizeOfVideoShowcase(){
	return driver.findElement(videoShowcase()).findElements(By.tagName("li")).size();
}
/*
 * Locator for video in Video Showcase block.
 */
private By videoInVideoShowcase(int num){
	return By.xpath("//div[@id='player']//button[@class='play rounded-box state-paused']");
}
/*
 * Function to click on any video in Video Showcase block.
 */
public void clickOnVideoInVideoShowcase(int num){
	driver.switchTo().frame(driver.findElement(videoPlayInVideoShowcase(num)));
	safeClick(videoInVideoShowcase(num), MEDIUMWAIT);
}
/*
 * Locator for playing video in Video Showcase block..
 */
private By videoPlayInVideoShowcase(int num){
	//return By.xpath("//div[@class='column span-6 last']/following-sibling::*[2]/div[contains(@class,'webpart-container')][3]/ul/li["+num+"]/iframe");
	return By.xpath("//h4[text()='Video Showcase']/../ul/li["+num+"]/iframe");
}
/*
 * Locator for playing video in Video Showcase block.
 */
private By videoPlaying(){
	return By.xpath("//div[@class='controls-wrapper']//button[contains(@class,'play rounded-box state-playing')]");
}
/*
 * Function to check the presence of playing video in Video Showcase block..
 */
public boolean isVideoPlayingPresentInVideoShowcase(int num){
	//driver.switchTo().frame(driver.findElement(videoPlayInVideoShowcase(num)));
	return isElementPresent(videoPlaying(), MEDIUMWAIT);
}
/*
 * Locator for Private Equity block.
 */
private By privateEquity(){
//	return By.xpath("//div[@class='column span-2'][1]/div[@class='clearfix blog-activity-listitem']");
	return By.xpath("//h2[contains(text(),'Private Equity')]/../following-sibling::div[@class='clearfix blog-activity-listitem']");
}
/*
 * Function to find size of Private Equity block.
 */
public int getSizeOfPrivateEquity(){
	//scrollIntoElementView(privateEquity(num));
	return driver.findElements(privateEquity()).size();
}
/*
 * Locator for video in Private Equity block.
 */
private By linkInPrivateEquity(int num){
//	return By.xpath("//div[@class='column span-2'][1]/div[@class='clearfix blog-activity-listitem']["+num+"]/strong//a");
	return By.xpath("//h2[contains(text(),'Private Equity')]/../following-sibling::div[@class='clearfix blog-activity-listitem']["+num+"]/strong//a");
}
/*
 * Function to click on any video in Private Equity block.
 */
public void clickOnLinkInPrivateEquity(int num){
	safeClick(linkInPrivateEquity(num), MEDIUMWAIT);
}
/*
 * Function to get text of any link in Private Equity block.// new
 */
public String getTextOfLinkInPrivateEquity(int num){
	return safeGetText(linkInPrivateEquity(num), MEDIUMWAIT);
}
/*
 * Locator to get header text after click on private equity link click.//new
 */
private By headerOfPrivateEquityLinkNextPage(){
	return By.xpath("//div[@class='column span-6 last']/h1");
}
/*
 * Function to get text of header after click on private equity link click.//new
 */
public String getHeaderOfLinkInPrivateEquity(){
	return safeGetText(headerOfPrivateEquityLinkNextPage(), MEDIUMWAIT);
}
///*
// * Locator for playing video in Private Equity block.
// */
//private By videoPlayingInPrivateEquity(){
//	return By.id("video1");
//}
///*
// * Function to check the presence of playing video in Private Equity block.
// */
//public boolean isVideoPlayingPresentInPrivateEquity(){
//	return isElementPresent(videoPlayingInPrivateEquity(), MEDIUMWAIT);
//}

/*
 * Locator for join the community on the top of the page.
 */
private By joinTheCommunity(){
	return By.xpath("//a[contains(text(),'Join the Community')]");
}
/*
 * Function to click on the "Join The Community" on the top of the page.
 */
public void clickOnJoinTheCommunity(){
	 safeClick(joinTheCommunity(), MEDIUMWAIT);
}

/*
 * Locator for SignIn on the top of the page.
 */
private By signIn(){
	return By.xpath("//a[contains(text(),'Sign In')]");
}
/*
 * Function to click on the "SignIn" on the top of the page.
 */
public void clickOnSignIn(){
	 safeClick(signIn(), MEDIUMWAIT);
}
/*
 * Function to check the presence of 'sign in' option after logging out.
 */
public String getTextOfSignIn(){
	return safeGetText(signIn(), MEDIUMWAIT);
}

/*
 * Locator for email input box on join the community popup.
 */
private By emailAddressOnJoinCommunityPopup(){
	return By.xpath("//div[@id='user-membership-register']//input[@id='membership-register-userEmail']");
}
/*
 * Function to type email address o join community popup.
 */
public void enterEmailAddressOnJoinCommunityPopup(String mailId){
	 safeType(emailAddressOnJoinCommunityPopup(), mailId, MEDIUMWAIT);
}

/*
 * Locator for submit button on join the community popup.
 */
private By submitBtnOnJoinCommunityPopup(){
	return By.xpath("//button[@id='btnRegisterEmail']");
}
/*
 * Function to click on submit button on join community popup.
 */
public void clickOnSubmitBtnOnJoinCommunityPopup(){
	 safeClick(submitBtnOnJoinCommunityPopup(), MEDIUMWAIT);
}

/*
 * Locator for Welcome to Stockhouse popup present.
 */
private By welcomeToStockhousePopup(){
	return By.xpath("//div[@id='unverified-user-msg']");
}
/*
 * Function to check presence of Welcome to stock house popup.
 */
public boolean isWelcomeToStockhousePopupExist(){
	 return isElementPresent(welcomeToStockhousePopup(), MEDIUMWAIT);
}

/*
 * Locator for email section of Welcome to Stockhouse popup.
 */
private By mailIdInWelcomeStockhousePopup(){
	return By.xpath("//span[@id='unverified-user-email']");
}
/*
 * Function to get text of message section of Welcome to Stockhouse popup.
 */
public String getMailIdInWelcomeStockhousePopup(){
	 return safeGetText(mailIdInWelcomeStockhousePopup(), MEDIUMWAIT);
}

/*
 * Locator for resend confirmation email on Welcome to Stockhouse popup.
 */
private By resendConfirmationEmailOnWelcomeToStockhouse(){
	return By.xpath("//span[@id='unverified-user-email']");
}
/*
 * Function to check presence of resend confirmation email on Welcome to Stockhouse popup.
 */
public boolean isResendConfirmationEmailOnWelcomeToStockhousePresent(){
	 return isElementPresent(resendConfirmationEmailOnWelcomeToStockhouse(), MEDIUMWAIT);
}

/*
 * Locator for  get text of logged in user on the top of the page.
 */
private By txtOfLoggedinUser(){
	return By.xpath("//span[@class='member-user-name']");
}
/*
 * Function to get text of logged in user on the top of the page.
 */
public String getTxtOfLoggedinUser(){
	 return safeGetText(txtOfLoggedinUser(), MEDIUMWAIT);
}
/*
 * Locator for logged in user on the top of the page.(after logging in)
 */
private By LoggedinUser(int num){
	return By.xpath("//div[@class='membership clearfix']/ul[@class='right']/li["+num+"]/a");
}
/*
 * Function to click on logged in user on the top of the page.
 */
public void clickOnLoggedinUser(int num){
	safeClick(LoggedinUser(num), MEDIUMWAIT);
}
/*
 * Function to click on logged in user on the top of the page.
 */
public void clickOnLogo(){
	 safeClick(txtOfLoggedinUser(), MEDIUMWAIT);
}

/*
 * Locator for user id input box on signin popup.
 */
private By userIdOnSignInPopup(){
	return By.xpath("//div[@id='user-membership-login']//input[@id='login-user-name']");
}
/*
 * Function to type user id on sign in popup.
 */
public void typeUserIdOnSignInPopup(String id){
	 safeType(userIdOnSignInPopup(), id, MEDIUMWAIT);
}

/*
 * Locator for password input box on signin popup.
 */
private By passwordOnSignInPopup(){
	return By.xpath("//div[@id='user-membership-login']//input[@id='login-user-password']");
}
/*
 * Function to type password on sign in popup.
 */
public void typePasswordOnSignInPopup(String pwd){
	 safeType(passwordOnSignInPopup(), pwd, MEDIUMWAIT);
}

/*
 * Locator for sign in button on sign in popup.
 */
public By signInBtnOnSigninPopup(){
	 return By.xpath("//button[@id='btnLoginUser']");
}
/*
 * Function to click on sign in button on sign in popup.
 */
public void clickOnSignInBtnOnSigninPopup(){
	 safeClick(signInBtnOnSigninPopup(), MEDIUMWAIT);
}

/*
 * Locator for the Navigation Link.
 */
private By NavigationLink(int num,String linktext){
 return By.xpath("//ul[@id='menuElem']/li["+num+"]/a[text()='"+linktext+"']");
}
/*
 * Function to make click on the navigation links.
 */
public void clickOnNavigationLink(int num,String linktext){
 safeClick(NavigationLink(num,linktext), MEDIUMWAIT);
  //return(PageFactory.initElements(driver, CommunityPage.class));
}

/*
 * Locator for the Navigation Link.
 */
private By NavigationSubLink(int num,int sub,String sublinktext){
 return By.xpath("//ul[@id='menuElem']/li["+num+"]/ul/li["+sub+"]/a[text()='"+sublinktext+"']");
}


/*
 * Function to make click on the navigation links.
 */
public void clickOnNavigationSubLink(int num,String linktext,int sub,String sublinktext){
	mouseHover(NavigationLink(num,linktext), MEDIUMWAIT);
	try{
		Thread.sleep(10000);
	}catch(Exception e){}
	safeJavaScriptClick(NavigationSubLink(num,sub,sublinktext), MEDIUMWAIT);
}

	/*
	 * Locator for sub links of market under 'stocks' header.
	 */
	private By StocksSubLink(int num, int sub,String sublinktext){
		return By.xpath("//ul[@id='menuElem']/li["+num+"]/ul/li[1]/ul/li["+sub+"]/a[text()='"+sublinktext+"']");
		 
	}
	public void clickOnStocksSubLink(int num,String linktext,int sub,String sublinktext){
		mouseHover(NavigationLink(num,linktext), MEDIUMWAIT);
		 try{
		  Thread.sleep(4000);
		 }catch(Exception e){}
		 safeClick(StocksSubLink(num,sub,sublinktext), MEDIUMWAIT); 
	}
	/*
	 * Locator for logout.
	 */
	private By logout(){
		return By.xpath("//a[text()='Logout']");
	}
	/*
	 * Function to click on logout.
	 */
	public void clickOnLogout(){
		safeClick(logout(), MEDIUMWAIT);
	}
	
	/*
	 * Locator for My Profile.
	 */
	private By myProfile(){
		return By.xpath("//a[text()='My Profile']");
	}
	/*
	 * Function to click on My Profile.
	 */
	public ProfilePage clickOnMyProfile(){
		safeClick(myProfile(), MEDIUMWAIT);
		return PageFactory.initElements(BrowserInstance.driver, ProfilePage.class);
	}
	/*
	 * Locator for 'i don't know password' on sign in popup.
	 */
	private By forgotPassword(){
		return By.linkText("I don't know my password");
	}
	/*
	 * Function to click on 'i don't know password' on sign in popup.
	 */
	public void clickOnForgotPassword(){
		safeClick(forgotPassword(), MEDIUMWAIT);
	}
	/*
	 * Locator for submit button for recovering password.
	 */
	private By submitForgotPassword(){
		return By.id("btnResetPassword");
	}
	/*
	 * Function to click on submit button for recovering password.
	 */
	public void clickOnSubmitForgotPassword(){
		safeClick(submitForgotPassword(), MEDIUMWAIT);
	}
	/*
	 * Locator for message appearing for reset password.
	 */
	private By ResetPasswordMsg(){
		return By.xpath("//div[@id='reset-password-msg']/div[1]/span");
	}
	/*
	 * Function to get text of message appearing for reset password.
	 */
	public String getTextOfResetPasswordMsg(){
		return safeGetText(ResetPasswordMsg(), MEDIUMWAIT);
	}
	/*
	 * Locator for close on reset password message popup.
	 */
	private By ResetPasswordClose(){
		return By.xpath("//div[@id='reset-password-msg']/div[2]/button");
	}
	/*
	 * Function to click on close on reset password message popup.
	 */
	public void clickOnResetPasswordClose(){
		safeClick(ResetPasswordClose(), MEDIUMWAIT);
	}
	/*
	 * Locator for options at top menu.
	 */
	private By topMenuOptions(int num){
		return By.xpath("//div[@class='membership clearfix']/ul[@class='right']/li["+num+"]/a");
	}
	/*
	 * Function to click on options at top menu.
	 */
	public void clickOnTopMenuOptions(int num){
		safeClick(topMenuOptions(num), MEDIUMWAIT);
	}
	/*
	 * Locator for news focus bar under navigation link.
	 */
	private By newsFocusBar(){
		return By.xpath("//div[@class='column span-6 last']//div[@id='ticker-items']/div[@class='owl-wrapper-outer']/div/div[1]");
	}
	/*
	 * Function to get text of titles in news focus bar under navigation link.
	 */
	public String getTextOfTitlesInNewsFocusBar(){
		return safeGetText(newsFocusBar(), MEDIUMWAIT);
	}
	
}