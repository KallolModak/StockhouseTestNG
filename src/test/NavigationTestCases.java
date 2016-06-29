package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AMEXPage;
import pageObjects.BestOfBoardsAndBlogs;
import pageObjects.Blog;
import pageObjects.BreakingNews;
import pageObjects.Bullboard;
import pageObjects.BondsPage;
import pageObjects.CSEPage;
import pageObjects.CommoditiesPage;
import pageObjects.CommunityPage;
import pageObjects.CurrenciesPage;
import pageObjects.DJIAPage;
import pageObjects.CanadianPressRelease;
import pageObjects.MarketMoversPage;
import pageObjects.MarketPage;
import pageObjects.NASDAQPage;
import pageObjects.NYSEPage;
import pageObjects.ETFsPage;
import pageObjects.FeaturedNews;
import pageObjects.FundsPage;
import pageObjects.GroupsPage;
import pageObjects.HomePage;
import pageObjects.IndependentReports;
import pageObjects.InterviewPage;
import pageObjects.MicroCapReport;
import pageObjects.MoversAndShakers;
import pageObjects.NaturalResources;
import pageObjects.NewsPage;
import pageObjects.OpenionPage;
import pageObjects.PrivateEquity;
import pageObjects.ShortReportPage;
import pageObjects.ShowcaseCompanies;
import pageObjects.StockScreener;
import pageObjects.StockStreamPage;
import pageObjects.SymbolLookup;
import pageObjects.TickerTraxPage;
import pageObjects.USPressRelease;
import pageObjects.VideoPage;
import pageObjects.PortfolioPage;
import pageObjects.StockScreenerPage;
import pageObjects.TSXPage;
import pageObjects.TSXVPage;
import common.BaseSetup;
import common.BrowserInstance;
import common.LoggerInstance;
import common.ReadInputData;

public class NavigationTestCases extends BaseSetup {

	/*
	 * Test case to check ETFs link on navigation bar.
	 * Check URL after clicking the EFTs.
	 * Check presence of "More ETF Articles" text on the page.
	 * Check presence of "ETF Performance Overview" on the page.
	 */
	@Test( priority =1)
	public void ETFsLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 1 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(10000);
			homepage.cancelLoading();
			homepage.clickOnNavigationLink(8,"ETFs");//8
			Thread.sleep(20000);
			ETFsPage etfsPage =  PageFactory.initElements(BrowserInstance.driver, ETFsPage.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/etfs");
			Assert.assertTrue(etfsPage.isMoreETFArticlesPresent());
			Assert.assertTrue(etfsPage.isTopStoryPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
				Assert.fail("Test case ETFsLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void ETFsLink()

	/*
	 * Test case to check video link on navigation bar.
	 * Check URL after clicking the Video.
	 * Check presence of "Video cover" section.
	 * Check presence of thumbnails.
	 */
	@Test( priority =2)
	public void VideoLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 2 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(10000);
			homepage.cancelLoading();
			homepage.clickOnNavigationLink(7,"Video");//7
			VideoPage videoPage =  PageFactory.initElements(BrowserInstance.driver, VideoPage.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL"));
			Assert.assertTrue(videoPage.isVideoCoverPresent());
			Assert.assertEquals(videoPage.numberOfThumbnailPresent(), 6);
			}catch(Exception e){
				LoggerInstance.logger.info("Test case VideoLink is failed. "+e); 
				Assert.fail("Test case VideoLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void VideoLink()
	
	/*
	 * Test case to check Portfolio link on navigation bar.
	 * Check URL after clicking the Portfolio.
	 * Check presence of "Portfolio" text.
	 * Check presence of "Portfolio Tracker" text.
	 */
	@Test( priority =3)
	public void PortfolioLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 3 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationLink(6,"Portfolio");//6
 			Thread.sleep(20000);
			homepage.cancelLoading();
			PortfolioPage portfolio =  PageFactory.initElements(BrowserInstance.driver, PortfolioPage.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"portfolio");
			//Assert.assertTrue(portfolio.isPortfolioTxtPresent());
			Assert.assertTrue(portfolio.isPortfolioTrackerTxtPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case PortfolioLink is failed. "+e); 
				Assert.fail("Test case PortfolioLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void PortfolioLink()
	
	/*
	 * Test case to check Portfolio > StockStream link on navigation bar.
	 * Check URL after clicking the Portfolio.
	 * Check presence of "Portfolio" text.
	 * Check presence of "Portfolio Tracker" text.
	 */
	@Test( priority =4)
	public void PortfolioStockStreamLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 4 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(6,"Portfolio",1,"Stockstream");//6,"Portfolio",1,"Stockstream"
			homepage.cancelLoading();
			homepage.switchToNewWindow();
			StockStreamPage stockStream=  PageFactory.initElements(BrowserInstance.driver, StockStreamPage.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"portfolio/stockstream-promo");
			Assert.assertNotNull(stockStream.getTxtOfModuleContent(1));
			Assert.assertNotNull(stockStream.getTxtOfModuleContent(2));
			}catch(Exception e){
				LoggerInstance.logger.info("Test case PortfolioStockStreamLink is failed. "+e); 
				Assert.fail("Test case PortfolioStockStreamLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void PortfolioStockStreamLink()
	
	/*
	 * Test case to check Portfolio > StockScreener link on navigation bar.
	 * Check URL after clicking the Portfolio.
	 * Check presence of "Featured Company" text.
	 * Check presence of "Search Options" text.
	 */
	@Test( priority =5)
	public void PortfolioStockScreenerLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 5 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(6,"Portfolio",2,"Stock Screener");//6,"Portfolio",2,"Stock Screener"
			Thread.sleep(10000);
			StockScreener stockScreener=  PageFactory.initElements(BrowserInstance.driver, StockScreener.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"portfolio/stock-screener");
			Assert.assertTrue(stockScreener.isFeaturedCompanyTxtPresent());
			Assert.assertTrue(stockScreener.isSearchOptionsTxtPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case PortfolioStockScreenerLink is failed. "+e); 
				Assert.fail("Test case PortfolioStockScreenerLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void PortfolioStockScreenerLink()
	
	/*
	 * Test case to check Portfolio > SymbolLookup link on navigation bar.
	 * Check URL after clicking the SymbolLookup.
	 * Check presence of "Symbol Lookup" text.
	 */
	@Test( priority =6)
	public void PortfolioSymbolLookupLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 6 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(6,"Portfolio",3,"Symbol Lookup");//6,3
			Thread.sleep(10000);
			SymbolLookup symbolLookup=  PageFactory.initElements(BrowserInstance.driver, SymbolLookup.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"portfolio/symbol-lookup");
			Assert.assertTrue(symbolLookup.isSymbolLookupTxtPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case PortfolioSymbolLookupLink is failed. "+e); 
				Assert.fail("Test case PortfolioSymbolLookupLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void PortfolioSymbolLookupLink()
	
	/*
	 * Test case to check Portfolio > ShowcaseCompanies companies link on navigation bar.
	 * Check URL after clicking the ShowcaseCompanies.
	 * Check presence of "ShowcaseCompanies" text.
	 * Check presence of "FeaturedCompany" text.
	 */
	@Test( priority =7)
	public void PortfolioShowcaseCompaniesLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 7 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(6,"Portfolio",4,"Showcase Companies");//6,4
			Thread.sleep(10000);
			ShowcaseCompanies showcaseCompanies=  PageFactory.initElements(BrowserInstance.driver, ShowcaseCompanies.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"companies/showcase");
			Assert.assertTrue(showcaseCompanies.isShowcaseCompaniesTxtPresent());
			Assert.assertTrue(showcaseCompanies.isFeaturedCompanyTxtPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case PortfolioShowcaseCompaniesLink is failed. "+e); 
				Assert.fail("Test case PortfolioShowcaseCompaniesLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void PortfolioShowcaseCompaniesLink()
	
	/*
	 * Test case to check Opinion link on navigation bar.
	 * Check URL after clicking the Opinion.
	 * Check presence of "Stockhouse Reports" text.
	 * Check presence of "Independent Reports" text.
	 */
	@Test( priority =8)
	public void OpinionLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 8 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationLink(5,"Opinion");//5
			Thread.sleep(10000);
			OpenionPage openionPage =  PageFactory.initElements(BrowserInstance.driver, OpenionPage.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion");
			Assert.assertTrue(openionPage.isStockhouseReportsTxtPresent());
			Assert.assertTrue(openionPage.isIndependentReportsTxtPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case OpinionLink is failed. "+e); 
				Assert.fail("Test case OpinionLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void OpinionLink()
	
	/*
	 * Test case to check Opinion > PrivateEquity companies link on navigation bar.
	 * Check URL after clicking the Private equity.
	 * Check presence of "Articles" text.
	 * Check links are not blank.
	 */
	@Test( priority =9)
	public void OpinionPrivateEquityLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 9 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(5,"Opinion",1,"Private Equity");//5,1
			Thread.sleep(10000);
			PrivateEquity privateEquity=  PageFactory.initElements(BrowserInstance.driver, PrivateEquity.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/private-equity");
			Assert.assertTrue(privateEquity.isArticleTxtPresent());
			Assert.assertNotNull(privateEquity.getTextOfArticleList(1));
			}catch(Exception e){
				LoggerInstance.logger.info("Test case OpinionPrivateEquityLink is failed. "+e); 
				Assert.fail("Test case OpinionPrivateEquityLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void OpinionPrivateEquityLink()
	
	/*
	 * Test case to check Opinion > Short Report companies link on navigation bar.
	 * Check URL after clicking the Short Report.
	 * Check links are not blank.
	 */
	@Test( priority =10)
	public void OpinionShortReportLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 10 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(5,"Opinion",2,"Short Report");//5,2
			Thread.sleep(10000);
			ShortReportPage shortReportPage=  PageFactory.initElements(BrowserInstance.driver, ShortReportPage.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/short-report");
			Assert.assertNotNull(shortReportPage.getTextOfReportList(1));
			Assert.assertNotNull(shortReportPage.getTextOfReportList(2));
			}catch(Exception e){
				LoggerInstance.logger.info("Test case OpinionShortReportLink is failed. "+e); 
				Assert.fail("Test case OpinionShortReportLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void OpinionShortReportLink()
	
	/*
	 * Test case to check Opinion > TickerTrax companies link on navigation bar.
	 * Check URL after clicking the TickerTrax.
	 * Check links are not blank.
	 */
	@Test( priority =11)
	public void OpinionTickerTraxLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 11 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(5,"Opinion",3,"Tickertrax");//5,3
			Thread.sleep(10000);
			TickerTraxPage tickerTraxPage=  PageFactory.initElements(BrowserInstance.driver, TickerTraxPage.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/tickertrax");
			Assert.assertNotNull(tickerTraxPage.getTextOfReportList(1));
			Assert.assertNotNull(tickerTraxPage.getTextOfReportList(2));
			}catch(Exception e){
				LoggerInstance.logger.info("Test case OpinionTickerTraxLink is failed. "+e); 
				Assert.fail("Test case OpinionTickerTraxLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void OpinionTickerTraxLink()
	/*
	 * Test case to check Opinion > Interviews companies link on navigation bar.
	 * Check URL after clicking the Interviews.
	 * Check links are not blank.
	 */
	@Test( priority =12)
	public void OpinionInterviewsLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 12 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(5,"Opinion",4,"Interviews");//5,4
			Thread.sleep(10000);
			InterviewPage interviewPage=  PageFactory.initElements(BrowserInstance.driver, InterviewPage.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/interviews");
			Assert.assertNotNull(interviewPage.getTextOfInterviewList(1));
			Assert.assertNotNull(interviewPage.getTextOfInterviewList(2));
			}catch(Exception e){
				LoggerInstance.logger.info("Test case OpinionInterviewsLink is failed. "+e); 
				Assert.fail("Test case OpinionInterviewsLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void OpinionInterviewsLink()
	
	/*
	 * Test case to check Opinion > Independent Reports companies link on navigation bar.
	 * Check URL after clicking the Independent Reports.
	 * Check Independent Reports Text present.
	 * Check links are not blank.
	 */
	@Test( priority =13)
	public void OpinionIndependentReportsLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 13 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(5,"Opinion",5,"Independent Reports");//5,5
			Thread.sleep(10000);
			IndependentReports indepedentReports=  PageFactory.initElements(BrowserInstance.driver, IndependentReports.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/independent-reports");
			Assert.assertTrue(indepedentReports.isIndependentReportsTxtPresent());
			Assert.assertNotNull(indepedentReports.getTextOfReportList(1));
			Assert.assertNotNull(indepedentReports.getTextOfReportList(2));
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case OpinionIndependentReportsLink is failed. "+e); 
				Assert.fail("Test case OpinionIndependentReportsLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void OpinionIndependentReportsLink()
	
	/*
	 * Test case to check Opinion > MoversAndShakers link on navigation bar.
	 * Check URL after clicking the MoversAndShakers.
	 * Check links are not blank.
	 */
	@Test( priority =14)
	public void OpinionMoversAndShakersLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 14 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(5,"Opinion",6,"Movers & Shakers");//5,6
			Thread.sleep(10000);
			MoversAndShakers moversAndShakers=  PageFactory.initElements(BrowserInstance.driver, MoversAndShakers.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/movers-shakers");
			Assert.assertNotNull(moversAndShakers.getTextOfReportList(1));
			Assert.assertNotNull(moversAndShakers.getTextOfReportList(2));
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case OpinionMoversAndShakersLink is failed. "+e); 
				Assert.fail("Test case OpinionMoversAndShakersLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void OpinionMoversAndShakersLink()
	
	/*
	 * Test case to check Opinion > BestOfBoardsAndBlogs link on navigation bar.
	 * Check URL after clicking the BestOfBoardsAndBlogs.
	 * Check presence of text BestOfBoardsAndBlogs.
	 * Check links are not blank.
	 */
	@Test( priority =15)
	public void OpinionBestOfBoardsAndBlogsLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 15 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(5,"Opinion",7,"Best of Boards & Blogs");//5,7
			Thread.sleep(10000);
			BestOfBoardsAndBlogs bestOfBoardsAndBlogs=  PageFactory.initElements(BrowserInstance.driver, BestOfBoardsAndBlogs.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/best-of-boards-blogs");
			Assert.assertTrue(bestOfBoardsAndBlogs.isBestOfBoardsAndBlogTxtPresent());
			Assert.assertNotNull(bestOfBoardsAndBlogs.getTextOfReportList(1));
			Assert.assertNotNull(bestOfBoardsAndBlogs.getTextOfReportList(2));
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case OpinionBestOfBoardsAndBlogsLink is failed. "+e); 
				Assert.fail("Test case OpinionBestOfBoardsAndBlogsLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void OpinionBestOfBoardsAndBlogsLink()
	
	/*
	 * Test case to check News link on navigation bar.
	 * Check URL after clicking the News.
	 * Check presence of "News" text.
	 * Check presence of "Featured News" text.
	 */
	@Test( priority =16)
	public void NewsLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 16 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationLink(4,"News");//4
			Thread.sleep(10000);
			NewsPage newsPage =  PageFactory.initElements(BrowserInstance.driver, NewsPage.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news");
			Assert.assertTrue(newsPage.isNewsTxtPresent());
			Assert.assertTrue(newsPage.isFeaturedNewsTxtPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case NewsLink is failed. "+e); 
				Assert.fail("Test case NewsLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void NewsLink()
	
	/*
	 * Test case to check News > Featured News companies link on navigation bar.
	 * Check URL after clicking the Featured News.
	 * Check presence of "Featured News" text.
	 * Check links are not blank.
	 */
	@Test( priority =17)
	public void newsFeaturedNewsLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 17 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(4,"News",1,"Featured News");//4,1
			Thread.sleep(10000);
			FeaturedNews featuredNews=  PageFactory.initElements(BrowserInstance.driver, FeaturedNews.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/newswire");
			Assert.assertTrue(featuredNews.isFeaturedNewsTxtPresent());
			Assert.assertNotNull(featuredNews.getTextOfReportList(1));
			}catch(Exception e){
				LoggerInstance.logger.info("Test case newsFeaturedNewsLink is failed. "+e); 
				Assert.fail("Test case newsFeaturedNewsLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void newsFeaturedNewsLink()
	
	/*
	 * Test case to check News > NaturalResources link on navigation bar.
	 * Check URL after clicking the NaturalResources.
	 * Check NaturalResources text presence.
	 * Check RefineYourSearch text presence.
	 */
	@Test( priority =18)
	public void NewsNaturalResourcesLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 18 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(4,"News",2,"Natural Resources");//4,2
			Thread.sleep(10000);
			NaturalResources naturalResources=  PageFactory.initElements(BrowserInstance.driver, NaturalResources.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/natural-resources");
			Assert.assertTrue(naturalResources.isNaturalResourcesTxtPresent());
			Assert.assertTrue(naturalResources.isRefineYourSearchTxtPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case NewsNaturalResourcesLink is failed. "+e); 
				Assert.fail("Test case NewsNaturalResourcesLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void NewsNaturalResourcesLink()
	
	/*
	 * Test case to check News > BreakingNews companies link on navigation bar.
	 * Check URL after clicking the BreakingNews.
	 * Check links are not blank.
	 * Check presence of Breaking news text.
	 */
	@Test( priority =19)
	public void NewsBreakingNews()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 19 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(4,"News",3,"Breaking News");//4,3
			Thread.sleep(10000);
			BreakingNews breakingNews=  PageFactory.initElements(BrowserInstance.driver, BreakingNews.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/bulletins");
			Assert.assertTrue(breakingNews.isBreakingNewsTxtPresent());
			Assert.assertNotNull(breakingNews.getTextOfReportList(1));
			}catch(Exception e){
				LoggerInstance.logger.info("Test case NewsBreakingNews is failed. "+e); 
				Assert.fail("Test case NewsBreakingNews is failed. "+e);
		}//End catch(Exception e)
	}// End public void NewsBreakingNews()
	/*
	 * Test case to check News > Micro Cap Report link on navigation bar.
	 * Check URL after clicking the Micro Cap Report.
	 * Check links are not blank.
	 */
	@Test( priority =20)
	public void NewsMicroCapReport()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 20 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(4,"News",3,"Micro Cap Report");//4,4
			Thread.sleep(10000);
			MicroCapReport microCapReport=  PageFactory.initElements(BrowserInstance.driver, MicroCapReport.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/micro-cap-report");
			Assert.assertNotNull(microCapReport.getTextOfReportList(1));
			Assert.assertNotNull(microCapReport.getTextOfReportList(2));
			}catch(Exception e){
				LoggerInstance.logger.info("Test case NewsMicroCapReport is failed. "+e); 
				Assert.fail("Test case NewsMicroCapReport is failed. "+e);
		}//End catch(Exception e)
	}// End public void NewsMicroCapReport()
	
	/*
	 * Test case to check News > Canadian Press Releases link on navigation bar.
	 * Check URL after clicking the Independent Reports.
	 * Check Canadian Press Release Text present.
	 * Check links are not blank.
	 */
	@Test( priority =21)
	public void NewsCanadianPressReleaseLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 21 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(4,"News",5,"Canadian Press Releases");//4,6
			Thread.sleep(10000);
			CanadianPressRelease canadianPressRelease=  PageFactory.initElements(BrowserInstance.driver, CanadianPressRelease.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/canadian-press-releases");
			Assert.assertTrue(canadianPressRelease.isCanadianPressReleasesTxtPresent());
			Assert.assertNotNull(canadianPressRelease.getTextOfReportList(1));
			Assert.assertNotNull(canadianPressRelease.getTextOfReportList(2));
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case NewsCanadianPressReleaseLink is failed. "+e); 
				Assert.fail("Test case NewsCanadianPressReleaseLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void NewsCanadianPressReleaseLink()
	
	/*
	 * Test case to check News > US Press Releases link on navigation bar.
	 * Check URL after clicking the US Press Releases.
	 * Check presence of US Press Releases text.
	 * Check links are not blank.
	 */
	@Test( priority =22)
	public void NewsUSPressReleaseLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 22 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(4,"News",4,"US Press Releases");//4,5
			Thread.sleep(10000);
			USPressRelease uSPressRelease=  PageFactory.initElements(BrowserInstance.driver, USPressRelease.class);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/us-press-releases");
			Assert.assertTrue(uSPressRelease.isUSPressReleasesTxtPresent());
			Assert.assertNotNull(uSPressRelease.getTextOfReportList(1));
			Assert.assertNotNull(uSPressRelease.getTextOfReportList(2));
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case NewsUSPressReleaseLink is failed. "+e); 
				Assert.fail("Test case NewsUSPressReleaseLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void NewsUSPressReleaseLink()
	
	
	/*
	 * Test case to check Community link on navigation bar.
	 * Check URL after clicking the Community.
	 * Check presence of "Bullboard" text on the page.
	 * Check presence of "Groups" text on the page.
	 * Check presence of "Blog" text on hte page.
	 */
	@Test( priority =23)
	public void CommunityLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 23 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			CommunityPage communityPage=PageFactory.initElements(BrowserInstance.driver, CommunityPage.class);
			homepage.clickOnNavigationLink(2,"Community");//2
			Thread.sleep(20000);
			homepage.cancelLoading();
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"community");
			Assert.assertTrue(communityPage.isBullBoardHeadPresent());
			String txtgrp= communityPage.getTextOfGroupHead();
			Assert.assertEquals(txtgrp, "Groups");
			String txtblog= communityPage.getTextOfBlogHead();
			Assert.assertEquals(txtblog, "Blogs");
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case CommunityLink is failed. "+e); 
				Assert.fail("Test case CommunityLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void CommunityLink()
	
	/*
	 * Test case to check Community sub link on navigation bar.
	 * Check url after clicking on 'bullboard' link.
	 * Check presence of "order by" text on the page.
	 * Check presence of "Displaying all bullboards" text on the page.
	 */
	@Test( priority =24)
	public void BullBoardLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 24 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Bullboard bullBoard= PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(2,"Community",1,"Bullboards");//2,1
			Thread.sleep(20000);
			homepage.cancelLoading();
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"community/bullboards");
			Assert.assertTrue(bullBoard.isOrderByHeadPresent());
			Assert.assertTrue(bullBoard.isdisplayBullBoardsHeadPresent());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case BullBoardLink is failed. "+e); 
				Assert.fail("Test case BullBoardLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void BullBoardLink()
	
	/*
	 * Test case to check Community sub link on navigation bar.
	 * Check url after clicking on 'blog' link.
	 * Check presence of "order by" text on the page.
	 * Check presence of blog summary header text on the page.
	 */
	@Test( priority =25)
	public void BlogLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 25 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Blog blog= PageFactory.initElements(BrowserInstance.driver, Blog.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(2,"Community",2,"Blogs");//2,2
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"blogs");
			Assert.assertTrue(blog.isOrderByHeadPresent());
			Assert.assertNotNull(blog.getTextOfBlogSummaryHead(1));
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case BlogLink is failed. "+e); 
				Assert.fail("Test case BlogLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void BlogLink()
	
	/*
	 * Test case to check Community sub link on navigation bar.
	 * Check url after clicking on 'group' link.
	 * Check presence of "sort by" text on the page.
	 * Check presence of groups header text on the page.
	 */
	@Test( priority =26)
	public void GroupLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 26 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			GroupsPage group= PageFactory.initElements(BrowserInstance.driver, GroupsPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(2,"Community",3,"Groups");//2,3
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"groups");
			Assert.assertTrue(group.isSortByHeadPresent());
			Assert.assertNotNull(group.getTextOfVariousGroupsHead(1));
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case GroupLink is failed. "+e); 
				Assert.fail("Test case GroupLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void GroupLink()
	
	/*
	 * Test case to check Markets link on navigation bar.
	 * Check url after clicking on 'Markets' link.
	 * Check presence of "Market update" text on the page.
	 * Check presence of "Market news today" text on the page.
	 */
	@Test( priority =27)
	public void MarketsLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 27 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			MarketPage market= PageFactory.initElements(BrowserInstance.driver, MarketPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationLink(3,"Markets");//3
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets");
			Assert.assertTrue(market.isMarketUpdateHeadPresent());
			Assert.assertTrue(market.isMarketNewsTodayHeadPresent());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case MarketsLink is failed. "+e); 
				Assert.fail("Test case MarketsLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void MarketsLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'Commodities' link.
	 * Check presence of "metals" text on the page.
	 * Check presence of "energies" text on the page.
	 */
	@Test( priority =28)
	public void CommoditiesLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 28 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			CommoditiesPage commodities= PageFactory.initElements(BrowserInstance.driver, CommoditiesPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(3,"Markets", 2,"Commodities");//3,2
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/commodities");
			Assert.assertTrue(commodities.isMetalsHeadPresent());
			Assert.assertTrue(commodities.isEnergiesHeadPresent());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case CommoditiesLink is failed. "+e); 
				Assert.fail("Test case CommoditiesLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void CommoditiesLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'Market Movers' link.
	 * Check presence of "Exchange" text on the page.
	 * Check presence of "TSX Volume Activities" text on the page.
	 */
	@Test( priority =29)
	public void MarketMoversLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 29 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			MarketMoversPage marketMovers= PageFactory.initElements(BrowserInstance.driver, MarketMoversPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(3,"Markets", 3,"Market Movers");//3,3
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/market-movers");
			Assert.assertTrue(marketMovers.isExchangeHeadPresent());
			Assert.assertTrue(marketMovers.isMarketMoverHeadPresent());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case MarketMoversLink is failed. "+e); 
				Assert.fail("Test case MarketMoversLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void MarketMoversLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'Currencies' link.
	 * Check presence of currency table on the page.
	 */
	@Test( priority =30)
	public void CurrenciesLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 30 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			CurrenciesPage currencies= PageFactory.initElements(BrowserInstance.driver, CurrenciesPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(3,"Markets",4, "Currencies");//3,4
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/currencies");
			Assert.assertTrue(currencies.isCurrencyTablePresent());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case CurrenciesLink is failed. "+e); 
				Assert.fail("Test case CurrenciesLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void CurrenciesLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'Bonds' link.
	 * Check presence of bonds table on the page.
	 */
	@Test( priority =31)
	public void BondsLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 31 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			BondsPage bonds= PageFactory.initElements(BrowserInstance.driver, BondsPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(3,"Markets",5,"Bonds");//3,5
			
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/bonds");
			Assert.assertTrue(bonds.isBondsTablePresent());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case BondsLink is failed. "+e); 
				Assert.fail("Test case BondsLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void BondsLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'TSX' link.
	 * Check presence of "TSX Volume Activities" on the page.
	 */
	@Test( priority =32)
	public void TSXLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 32 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			TSXPage tsx= PageFactory.initElements(BrowserInstance.driver, TSXPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnStocksSubLink(3,"Markets",1,"TSX");//3,1
			
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/stocks/tsx");
			Assert.assertTrue(tsx.isTSXVolActivitiesHeadPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case TSXLink is failed. "+e); 
				Assert.fail("Test case TSXLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void TSXLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'TSXV' link.
	 * Check presence of "TSX Volume Activities" on the page.
	 */
	@Test( priority =33)
	public void TSXVLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 33 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			TSXVPage tsxv= PageFactory.initElements(BrowserInstance.driver, TSXVPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnStocksSubLink(3,"Markets",2,"TSXV");//3,2
			
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/stocks/tsxv");
			Assert.assertTrue(tsxv.isTSXVentureVolActivitiesHeadPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case TSXVLink is failed. "+e); 
				Assert.fail("Test case TSXVLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void TSXVLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'CSE' link.
	 * Check presence of "CSE Volume Activities" on the page.
	 */
	@Test( priority =34)
	public void CSELink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 34 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			CSEPage cse= PageFactory.initElements(BrowserInstance.driver, CSEPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnStocksSubLink(3,"Markets",3,"CSE-CNSX");//3,3
			
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/stocks/cse-cnsx");
			Assert.assertTrue(cse.isCSEVolActivitiesHeadPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case CSELink is failed. "+e); 
				Assert.fail("Test case CSELink is failed. "+e);
		}//End catch(Exception e)
	}// End public void CSELink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'NYSE' link.
	 * Check presence of "NYSE Volume Activities" on the page.
	 */
	@Test( priority =35)
	public void NYSELink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 35 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			NYSEPage nyse= PageFactory.initElements(BrowserInstance.driver, NYSEPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnStocksSubLink(3,"Markets",4,"NYSE");//3,4
			
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/stocks/nyse");
			Assert.assertTrue(nyse.isNYSEVolActivitiesHeadPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case NYSELink is failed. "+e); 
				Assert.fail("Test case NYSELink is failed. "+e);
		}//End catch(Exception e)
	}// End public void NYSELink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'NASDAQ' link.
	 * Check presence of "NASDAQ Volume Activities" on the page.
	 */
	@Test( priority =36)
	public void NASDAQLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 36 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			NASDAQPage nasdaq= PageFactory.initElements(BrowserInstance.driver, NASDAQPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnStocksSubLink(3,"Markets",5,"NASDAQ");//3,5
			
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/stocks/nasdaq");
			Assert.assertTrue(nasdaq.isNASDAQVolActivitiesHeadPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case NASDAQLink is failed. "+e); 
				Assert.fail("Test case NASDAQLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void NASDAQLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'AMEX' link.
	 * Check presence of "AMEX Volume Activities" on the page.
	 */
	@Test( priority =37)
	public void AMEXLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 37 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			AMEXPage amex= PageFactory.initElements(BrowserInstance.driver, AMEXPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnStocksSubLink(3,"Markets",6,"AMEX");//3,6
			
			Thread.sleep(25000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/stocks/amex");
			Assert.assertTrue(amex.isAMEXVolActivitiesHeadPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case AMEXLink is failed. "+e); 
				Assert.fail("Test case AMEXLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void AMEXLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'DJIA' link.
	 * Check presence of "DJIA Volume Activities" on the page.
	 */
	@Test( priority =38)
	public void DJIALink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 38 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			DJIAPage djia= PageFactory.initElements(BrowserInstance.driver, DJIAPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnStocksSubLink(3,"Markets",7,"DJIA");//3,7
			
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/stocks/djia");
			Assert.assertTrue(djia.isDJIAVolActivitiesHeadPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case DJIALink is failed. "+e); 
				Assert.fail("Test case DJIALink is failed. "+e);
		}//End catch(Exception e)
	}// End public void DJIALink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check URL after clicking the ETFs.
	 * Check presence of "More ETF Articles" text on the page.
	 * Check presence of "ETF Performance Overview" on the page.
	 */
	@Test( priority =39)
	public void ETFSubLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 39 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			ETFsPage etf= PageFactory.initElements(BrowserInstance.driver, ETFsPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(3,"Markets",6,"ETFs");//3,6
			
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/etfs");
			Assert.assertTrue(etf.isMoreETFArticlesPresent());
			Assert.assertTrue(etf.isTopStoryPresent());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case ETFSubLink is failed. "+e); 
				Assert.fail("Test case ETFSubLink is failed. "+e);
		}//End catch(Exception e)
	}// End public void ETFSubLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'Funds' link.
	 * Check presence of "Funds performance overview" header and table on the page.
	 */
	@Test( priority =40)
	public void FundsLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 40 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			FundsPage funds= PageFactory.initElements(BrowserInstance.driver, FundsPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(3,"Markets",6,"Funds");//3,7
			
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/funds");
			Assert.assertTrue(funds.isFundsHeadPresent());
			Assert.assertTrue(funds.isFundsPerformOverHeadPresent());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case FundsLink is failed. "+e); 
				Assert.fail("Test case FundsLink is failed. "+e);
		}//End catch(Exception e)

    }// End public void FundsLink()
	/*
	 * Test case to check Markets Sub link on navigation bar.
	 * Check url after clicking on 'Stock-Screener' link.
	 * Check presence of "Featured Company" header on the page.
	 * Check presence of "Search Options" header on the page.
	 */
	@Test( priority =41)
	public void StockScreenerLink()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 41 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			StockScreenerPage stockScreen= PageFactory.initElements(BrowserInstance.driver, StockScreenerPage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnNavigationSubLink(3,"Markets",8,"Stock Screener");//3,8
			
			Thread.sleep(20000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"portfolio/stock-screener");
			Assert.assertTrue(stockScreen.isFeaturedCompanyHeadPresent());
			Assert.assertTrue(stockScreen.isSearchOptionHeadPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case StockScreenerLink is failed. "+e); 
				Assert.fail("Test case StockScreenerLink is failed. "+e);
		}//End catch(Exception e)

    }// End public void StockScreenerLink()
	
}
