package test;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FlyinSideBar;
import pageObjects.HomePage;
import common.BaseSetup;
import common.BrowserInstance;
import common.LoggerInstance;

public class HomePageTC  extends BaseSetup {

	/*
	 * Test case to check commodity section's items should not be null.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority =1)
	public void CheckCommoditySection()
	{
		
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(40000);
			homepage.clickCommoditiesCurrencyTab("commodity");
			for (int i=1;i<=3;i++)
			{
				
				Assert.assertNotNull(homepage.getTextOfCommoditiesItems(i,1)); 
				Assert.assertNotNull(homepage.getTextOfCommoditiesItems(i,2)); 
				Assert.assertNotNull(homepage.getTextOfCommoditiesItems(i,4)); 
			}	 
			}catch(Exception e){
				LoggerInstance.logger.info("Test case CheckCommoditySection is failed. "+e); 
				Assert.fail("Test case CheckCommoditySection is failed. "+e);
		}//End catch(Exception e)
	}// End public void CheckCommoditySection()
	
	/*
	 * Test case to check Currencies section's items should not be null.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority =2)
	public void CheckCurrenciesSection()
	{
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(40000);

			FlyinSideBar flyingSideBar = PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
			flyingSideBar.clickOnCross();
			homepage.clickCommoditiesCurrencyTab("currency");
			for (int i=1;i<=3;i++)
			{
				
				Assert.assertNotNull(homepage.getTextOfCurrenciesItems(i,1)); 
				Assert.assertNotNull(homepage.getTextOfCurrenciesItems(i,2)); 
				Assert.assertNotNull(homepage.getTextOfCurrenciesItems(i,4)); 
			}	 
			}catch(Exception e){
				LoggerInstance.logger.info("Test case CheckCurrenciesSection is failed. "+e); 
				Assert.fail("Test case CheckCurrenciesSection is failed. "+e);
		}//End catch(Exception e)
	}// End public void CheckCurrenciesSection()
	/*
	 * Test case to check Markets section's items should not be null.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=3)
	public void CheckMarketSection()
	{
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(40000);
			homepage.clickMarketsIntialMarketTab("market");
			for (int i=1;i<=3;i++)
			{
				
				Assert.assertNotNull(homepage.getTextOfMarketsItems(i,1));
				Assert.assertNotNull(homepage.getTextOfMarketsItems(i,2)); 
				Assert.assertNotNull(homepage.getTextOfMarketsItems(i,4)); 
			}	 
			}catch(Exception e){
				LoggerInstance.logger.info("Test case CheckMarketSection is failed. "+e); 
				Assert.fail("Test case CheckMarketSection is failed. "+e);
		}//End catch(Exception e)
	}// End public void CheckMarketSection()
	/*
	 * Test case to check Intial Market section's items not be null.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=4)
	public void CheckInitialMarketSection()
	{
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(50000);
			homepage.clickMarketsIntialMarketTab("Initialmarket");
			for (int i=1;i<=3;i++)
			{
				Assert.assertNotNull(homepage.getTextOfInitialMarketItems(i,1));
				Assert.assertNotNull(homepage.getTextOfInitialMarketItems(i,2)); 
				Assert.assertNotNull(homepage.getTextOfInitialMarketItems(i,4)); 
			}	  
			}catch(Exception e){
				LoggerInstance.logger.info("Test case CheckInitialMarketSection is failed. "+e); 
				Assert.fail("Test case CheckInitialMarketSection is failed. "+e);
			}
	}// End public void CheckInitialMarketSection()
	/*
	 * Test case for functionality of option under commodity.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=5)
	public void Commodity()
	{
		try{
			 HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			 Thread.sleep(40000);
			// homepage.clickCommoditiesCurrencyTab("commodity");
			 String href= homepage.getHrefOfCommodityCurrencyOption("commodity");
			 homepage.clickOnCommodityCurrencyOption("commodity");
			 Thread.sleep(20000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			 Assert.assertEquals(url, href);
			 
			 Assert.assertNotNull(homepage.getTextOfHeaderAfterComOptClick("firstHead"));
			 Assert.assertNotNull(homepage.getTextOfHeaderAfterComOptClick("secondHead"));
			 
			 Assert.assertNotNull(homepage.getTextOfTableAfterComCurrIntMarkOptClick(1, 1));
			 Assert.assertNotNull(homepage.getTextOfTableAfterComCurrIntMarkOptClick(3, 2));
		}catch(Exception e){
			LoggerInstance.logger.info("Test case Commodity is failed. "+e); 
			Assert.fail("Test case Commodity is failed. "+e);
		}
	}// End of Commodity()
	/*
	 * Test case for functionality of option under currency.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=6)
	public void Currencies()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);

				FlyinSideBar flyingSideBar = PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
				flyingSideBar.clickOnCross();
			  homepage.clickCommoditiesCurrencyTab("currency");
			  String href= homepage.getHrefOfCommodityCurrencyOption("currency");
			  homepage.clickOnCommodityCurrencyOption("currency");
			  Thread.sleep(20000);
			  String url=BrowserInstance.driver.getCurrentUrl();
			  Assert.assertEquals(url, href);
			  
			  Assert.assertNotNull(homepage.getTextOfHeaderAfterCurrOptClick("firstHead"));
			  Assert.assertNotNull(homepage.getTextOfHeaderAfterCurrOptClick("secondHead"));
			  
			  Assert.assertNotNull(homepage.getTextOfTableAfterComCurrIntMarkOptClick(1, 1));
			  Assert.assertNotNull(homepage.getTextOfTableAfterComCurrIntMarkOptClick(3, 2));
		}catch(Exception e){
			LoggerInstance.logger.info("Test case Currencies is failed. "+e); 
			Assert.fail("Test case Currencies is failed. "+e);
		}
	}// End of Currency()	
	/*
	 * Test case for functionality of option under Market.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=7)
	public void Market()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			  homepage.clickMarketsIntialMarketTab("market");
			  String txt1=homepage.getTextOfMarketOption("market");
			  homepage.clickOnMarketInitialMarketOption("market");
			  String txt2=homepage.getTextOfHeaderAfterMarketOptClick();
			  Assert.assertEquals(txt2, txt1);
			  //table rows check
			  for(int i=1;i<=3;i++){

				  Assert.assertNotNull(homepage.getTextOfTableAfterMarketOptClick(i, 1));
				  Assert.assertNotNull(homepage.getTextOfTableAfterMarketOptClick(i, 2));
				  Assert.assertNotNull(homepage.getTextOfTableAfterMarketOptClick(i, 3));
				  Assert.assertNotNull(homepage.getTextOfTableAfterMarketOptClick(i, 5));
				  Assert.assertNotNull(homepage.getTextOfTableAfterMarketOptClick(i, 6));
				  Assert.assertNotNull(homepage.getTextOfTableAfterMarketOptClick(i, 7));
				  Assert.assertNotNull(homepage.getTextOfTableAfterMarketOptClick(i, 8));
			  }
		}catch(Exception e){
			LoggerInstance.logger.info("Test case Market is failed. "+e); 
			Assert.fail("Test case Market is failed. "+e);
		}
	}// End of Market()
	/*
	 * Test case for functionality of option under InitialMarket.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=8)
	public void InitialMarket()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			  homepage.clickMarketsIntialMarketTab("initialMarket");
			  String txt1=homepage.getHrefOfInitialMarketOption("initialMarket");
			  homepage.clickOnMarketInitialMarketOption("initialmarket");
			  Thread.sleep(20000);
			  Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(), txt1);
			  Assert.assertNotNull(homepage.nullOfHeaderAfterInitialMarketOptClick());
			  String txt=homepage.nullOfHeaderAfterInitialMarketOptClick();
			  Assert.assertNotNull(homepage.getTextOfTableAfterComCurrIntMarkOptClick(1, 1));
			  Assert.assertNotNull(homepage.getTextOfTableAfterComCurrIntMarkOptClick(3, 2));
		}catch(Exception e){
			LoggerInstance.logger.info("Test case InitialMarket is failed. "+e); 
			Assert.fail("Test case InitialMarket is failed. "+e);
		}
	}// End of InitialMarket()
	/*
	 * Test case for Market Update block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=9)
	public void MarketUpdate()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			  int num=homepage.getSizeOfMarketUpdate();
			  Assert.assertNotEquals(num,0);
			  String href=homepage.getHrefOfMarketUpdate();
			  homepage.clickOnMarketupdate();
			  Thread.sleep(40000);
			  Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),href);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case MarketUpdate is failed. "+e); 
			Assert.fail("Test case MarketUpdate is failed. "+e);
		}
	}// End of MarketUpdate()
	/*
	 * Test case for Columnists block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=10)
	public void Columnists()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			  int num=homepage.getSizeOfColumnists();
			  Assert.assertNotEquals(num,0);
			  String href=homepage.getHrefOfColumnistsLink(1);
			  homepage.clickOnColumnistsLink(1);
			  Thread.sleep(20000);
			  Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),href);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case Columnists is failed. "+e); 
			Assert.fail("Test case Columnists is failed. "+e);
		}
	}// End of Columnists()
	/*
	 * Test case for breaking news block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=11)
	public void BreakingNews()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			  	int num=homepage.getSizeOfBreakingNewsBlock();
			  	Assert.assertNotEquals(num, 0);
			  	homepage.clickOnBreakingNewsLinks(1);
			  	Thread.sleep(20000);
			 if(BrowserInstance.driver.getCurrentUrl().contains("news"))
			 	Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case BreakingNews is failed. "+e); 
			Assert.fail("Test case BreakingNews is failed. "+e);
		}
	}// End of BreakingNews()
	/*
	 * Test case for Interviews block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=12)
	public void Interviews()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(80000);
			 int num=homepage.getSizeOfInterviewsBlock();
			 Assert.assertNotEquals(num, 0);
			 String href=homepage.getHrefOfInterviewLinks();
			 homepage.clickOnInterviewLinks();
			 Thread.sleep(20000);
			 Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(), href);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case Interviews is failed. "+e); 
			Assert.fail("Test case Interviews is failed. "+e);
		}
	}// End of Interviews()
/////******* Commented as this block is not present. ********///////
////	/*
////	 * Test case for Featured News block.
////	 */
////	@Test(groups={"BrowserCertificationTestCase"}, priority=13)
////	public void FeaturedNews()
////	{
////		try{
////			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
////			  System.out.println("111111111111111111111 ");
////			  Thread.sleep(80000);
////			 int num=homepage.getSizeOfFeaturedNews();
////			 System.out.println("22222222222222222222222 "+num);
////			 Assert.assertNotEquals(num, 0);
////			 //String linkTxt=homepage.
////			 homepage.clickOnFeaturedNewsLinks(1);
////			 ArrayList<String> tabs2 = new ArrayList<String> (BrowserInstance.driver.getWindowHandles());
////			 BrowserInstance.driver.switchTo().window(tabs2.get(1));
////			 //Assert.assertEquals(linkTxt, homepage.getTextHeaderForNode());
////			 BrowserInstance.driver.close();
////			 BrowserInstance.driver.switchTo().window(tabs2.get(0));
////		}catch(Exception e){
////			LoggerInstance.logger.info("Test case CheckMarketSection is failed. "+e); 
////			Assert.fail("Test case CheckMarketSection is failed. "+e);
////		}
////	}// End of FeaturedNews()
	/*
	 * Test case for Opinion and Analysis block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=14)
	public void OpinionAndAnalysis()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			 int num=homepage.getSizeOfOpinionAndAnalysis();
			 Assert.assertNotEquals(num, 0);
			 homepage.clickOnOpinionAndAnalysisLinks(1);
			 Thread.sleep(20000);
			 if(BrowserInstance.driver.getCurrentUrl().contains("opinion"))
			 	Assert.assertEquals(1,1);
			 else
				 Assert.assertEquals(1, 0);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case OpinionAndAnalysis is failed. "+e); 
			Assert.fail("Test case OpinionAndAnalysis is failed. "+e);
		}
	}// End of OpinionAndAnalysis()
	/*
	 * Test case for Canadian Press Releases block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=15)
	public void CanadianPressReleases()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			 int num=homepage.getSizeOfCanadianPR();
			 Assert.assertNotEquals(num, 0);
			 String href=homepage.getHrefOfCanadianPRLinksLinks(1);
			 homepage.clickOnCanadianPRLinksLinks(1);
			 Thread.sleep(20000);
			 Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(), href);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case CanadianPressReleases is failed. "+e); 
			Assert.fail("Test case CanadianPressReleases is failed. "+e);
		}
	}// End of CanadianPressReleases()
	/*
	 * Test case for US Press Releases block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=16)
	public void USPressReleases()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			 int num=homepage.getSizeOfUSPressRelease();
			 Assert.assertNotEquals(num, 0);
			 String href=homepage.getHrefOfUSPressReleaseLinks(1);
			 homepage.clickOnUSPressReleaseLinks(1);
			 Thread.sleep(20000);
			 Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(), href);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case USPressReleases is failed. "+e); 
			Assert.fail("Test case USPressReleases is failed. "+e);
		}
	}// End of USPressReleases()
	/*
	 * Test case for Showcase News Releases block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=17)
	public void ShowcaseNewsRelease()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			 int num=homepage.getSizeOfShowcaseNR();
			 Assert.assertNotEquals(num, 0);
			 String href=homepage.getHrefOfShowcaseNRLinks();
			 homepage.clickOnShowcaseNRLinks();
			 Thread.sleep(20000);
			 Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(), href);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case ShowcaseNewsRelease is failed. "+e); 
			Assert.fail("Test case ShowcaseNewsRelease is failed. "+e);
		}
	}// End of ShowcaseNewsRelease()
	/*
	 * Test case for Featured Company block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=18)
	public void FeaturedCompany()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			 int num=homepage.getSizeOfFeaturedCompany();
			 Assert.assertNotEquals(num, 0);
			 String href=homepage.getHrefOfFeaturedCompanyLinks();
			 homepage.clickOnFeaturedCompanyLinks();
			 Thread.sleep(20000);
			 Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(), href);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case CheckMarketSection is failed. "+e); 
			Assert.fail("Test case CheckMarketSection is failed. "+e);
		}
	}// End of FeaturedCompany()
	/*
	 * Test case for Video Showcase block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=19)
	public void VideoShowcase()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			 int num=homepage.getSizeOfVideoShowcase();
			 Assert.assertNotEquals(num, 0);
			 homepage.clickOnVideoInVideoShowcase(1);
			 //Thread.sleep(40000);
			 Assert.assertTrue(homepage.isVideoPlayingPresentInVideoShowcase(1));
		}catch(Exception e){
			LoggerInstance.logger.info("Test case VideoShowcase is failed. "+e); 
			Assert.fail("Test case VideoShowcase is failed. "+e);
		}
	}// End of VideoShowcase()
	/*
	 * Test case for Private Equity block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=20)
	public void PrivateEquity()
	{
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(40000);
			 int num=homepage.getSizeOfPrivateEquity();
			 Assert.assertNotEquals(num, 0);
			 String txt1=homepage.getTextOfLinkInPrivateEquity(1);
			 homepage.clickOnLinkInPrivateEquity(1);
			 Thread.sleep(20000);
			 String txt2=homepage.getHeaderOfLinkInPrivateEquity();
			 Assert.assertEquals(txt1,txt2);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case PrivateEquity is failed. "+e); 
			Assert.fail("Test case PrivateEquity is failed. "+e);
		}
	}// End of PrivateEquity()
}

