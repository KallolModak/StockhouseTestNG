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
import pageObjects.Portfolio;
import pageObjects.StockScreenerPage;
import pageObjects.TSXPage;
import pageObjects.TSXVPage;
import common.BaseSetup;
import common.BrowserInstance;
import common.LoggerInstance;
import common.ReadInputData;

public class NavigationTestCases extends BaseSetup {

//	/*
//	 * Test case to check ETFs link on navigation bar.
//	 * Check URL after clicking the EFTs.
//	 * Check presence of "More ETF Articles" text on the page.
//	 * Check presence of "ETF Performance Overview" on the page.
//	 */
//	@Test( priority =1)
//	public void ETFsLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationLink(8);
//			ETFsPage etfsPage =  PageFactory.initElements(BrowserInstance.driver, ETFsPage.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/etfs");
//			Assert.assertTrue(etfsPage.isMoreETFArticlesPresent());
//			System.out.println("##################################3");
//			Assert.assertTrue(etfsPage.isTopStoryPresent());
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void ETFsLink()
//
//	/*
//	 * Test case to check video link on navigation bar.
//	 * Check URL after clicking the Video.
//	 * Check presence of "Video cover" section.
//	 * Check presence of thumbnails.
//	 */
//	@Test( priority =2)
//	public void VideoLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationLink(7);
//			Thread.sleep(10000);
//			VideoPage videoPage =  PageFactory.initElements(BrowserInstance.driver, VideoPage.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),"http://www.stockhouse.tv/");
//			Assert.assertTrue(videoPage.isVideoCoverPresent());
//			System.out.println("##################################3");
//			Assert.assertEquals(videoPage.numberOfThumbnailPresent(), 6);
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void ETFsLink()
//	
//	/*
//	 * Test case to check Portfolio link on navigation bar.
//	 * Check URL after clicking the Portfolio.
//	 * Check presence of "Portfolio" text.
//	 * Check presence of "Portfolio Tracker" text.
//	 */
//	@Test( priority =3)
//	public void PortfolioLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationLink(6);
//			Thread.sleep(10000);
//			Portfolio portfolio =  PageFactory.initElements(BrowserInstance.driver, Portfolio.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"portfolio");
//			Assert.assertTrue(portfolio.isPortfolioTxtPresent());
//			System.out.println("##################################3");
//			Assert.assertTrue(portfolio.isPortfolioTrackerTxtPresent());
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void ETFsLink()
//	
//	/*
//	 * Test case to check Portfolio > StockStream link on navigation bar.
//	 * Check URL after clicking the Portfolio.
//	 * Check presence of "Portfolio" text.
//	 * Check presence of "Portfolio Tracker" text.
//	 */
//	@Test( priority =4)
//	public void PortfolioStockStreamLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(6,1);
//			Thread.sleep(10000);
//			homepage.switchToNewWindow();
//			StockStreamPage stockStream=  PageFactory.initElements(BrowserInstance.driver, StockStreamPage.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"portfolio/stockstream-promo");
//			Assert.assertNotNull(stockStream.getTxtOfModuleContent(1));
//			System.out.println("##################################3");
//			Assert.assertNotNull(stockStream.getTxtOfModuleContent(2));
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check Portfolio > StockScreener link on navigation bar.
//	 * Check URL after clicking the Portfolio.
//	 * Check presence of "Featured Company" text.
//	 * Check presence of "Search Options" text.
//	 */
//	@Test( priority =5)
//	public void PortfolioStockScreenerLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(6,2);
//			Thread.sleep(10000);
//			StockScreener stockScreener=  PageFactory.initElements(BrowserInstance.driver, StockScreener.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"portfolio/stock-screener");
//			Assert.assertTrue(stockScreener.isFeaturedCompanyTxtPresent());
//			System.out.println("##################################3");
//			Assert.assertTrue(stockScreener.isSearchOptionsTxtPresent());
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check Portfolio > SymbolLookup link on navigation bar.
//	 * Check URL after clicking the SymbolLookup.
//	 * Check presence of "Symbol Lookup" text.
//	 */
//	@Test( priority =6)
//	public void PortfolioSymbolLookupLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(6,3);
//			Thread.sleep(10000);
//			SymbolLookup symbolLookup=  PageFactory.initElements(BrowserInstance.driver, SymbolLookup.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"portfolio/symbol-lookup");
//			Assert.assertTrue(symbolLookup.isSymbolLookupTxtPresent());
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check Portfolio > ShowcaseCompanies companies link on navigation bar.
//	 * Check URL after clicking the ShowcaseCompanies.
//	 * Check presence of "ShowcaseCompanies" text.
//	 * Check presence of "FeaturedCompany" text.
//	 */
//	@Test( priority =7)
//	public void PortfolioShowcaseCompaniesLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(6,4);
//			Thread.sleep(10000);
//			ShowcaseCompanies showcaseCompanies=  PageFactory.initElements(BrowserInstance.driver, ShowcaseCompanies.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"companies/showcase");
//			Assert.assertTrue(showcaseCompanies.isShowcaseCompaniesTxtPresent());
//			System.out.println("########################3");
//			Assert.assertTrue(showcaseCompanies.isFeaturedCompanyTxtPresent());
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check Opinion link on navigation bar.
//	 * Check URL after clicking the Opinion.
//	 * Check presence of "Stockhouse Reports" text.
//	 * Check presence of "Independent Reports" text.
//	 */
//	@Test( priority =8)
//	public void OpinionLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationLink(5);
//			Thread.sleep(10000);
//			OpenionPage openionPage =  PageFactory.initElements(BrowserInstance.driver, OpenionPage.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion");
//			Assert.assertTrue(openionPage.isStockhouseReportsTxtPresent());
//			System.out.println("##################################3");
//			Assert.assertTrue(openionPage.isIndependentReportsTxtPresent());
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void ETFsLink()
//	
//	/*
//	 * Test case to check Opinion > PrivateEquity companies link on navigation bar.
//	 * Check URL after clicking the Private equity.
//	 * Check presence of "Articles" text.
//	 * Check links are not blank.
//	 */
//	@Test( priority =9)
//	public void OpinionPrivateEquityLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(5,1);
//			Thread.sleep(10000);
//			PrivateEquity privateEquity=  PageFactory.initElements(BrowserInstance.driver, PrivateEquity.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/private-equity");
//			Assert.assertTrue(privateEquity.isArticleTxtPresent());
//			System.out.println("########################3");
//			Assert.assertNotNull(privateEquity.getTextOfArticleList(1));
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check Opinion > Short Report companies link on navigation bar.
//	 * Check URL after clicking the Short Report.
//	 * Check links are not blank.
//	 */
//	@Test( priority =10)
//	public void OpinionShortReportLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(5,2);
//			Thread.sleep(10000);
//			ShortReportPage shortReportPage=  PageFactory.initElements(BrowserInstance.driver, ShortReportPage.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/short-report");
//			Assert.assertNotNull(shortReportPage.getTextOfReportList(1));
//			System.out.println("########################3");
//			Assert.assertNotNull(shortReportPage.getTextOfReportList(2));
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check Opinion > TickerTrax companies link on navigation bar.
//	 * Check URL after clicking the TickerTrax.
//	 * Check links are not blank.
//	 */
//	@Test( priority =11)
//	public void OpinionTickerTraxLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(5,3);
//			Thread.sleep(10000);
//			TickerTraxPage tickerTraxPage=  PageFactory.initElements(BrowserInstance.driver, TickerTraxPage.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/ticker-trax");
//			Assert.assertNotNull(tickerTraxPage.getTextOfReportList(1));
//			System.out.println("########################3");
//			Assert.assertNotNull(tickerTraxPage.getTextOfReportList(2));
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	/*
//	 * Test case to check Opinion > Interviews companies link on navigation bar.
//	 * Check URL after clicking the Interviews.
//	 * Check links are not blank.
//	 */
//	@Test( priority =12)
//	public void OpinionInterviewsLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(5,4);
//			Thread.sleep(10000);
//			InterviewPage interviewPage=  PageFactory.initElements(BrowserInstance.driver, InterviewPage.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/interviews");
//			Assert.assertNotNull(interviewPage.getTextOfReportList(1));
//			System.out.println("########################3");
//			Assert.assertNotNull(interviewPage.getTextOfReportList(2));
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check Opinion > Independent Reports companies link on navigation bar.
//	 * Check URL after clicking the Independent Reports.
//	 * Check Independent Reports Text present.
//	 * Check links are not blank.
//	 */
//	@Test( priority =13)
//	public void OpinionIndependentReportsLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(5,5);
//			Thread.sleep(10000);
//			IndependentReports indepedentReports=  PageFactory.initElements(BrowserInstance.driver, IndependentReports.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/independent-reports");
//			Assert.assertTrue(indepedentReports.isIndependentReportsTxtPresent());
//			Assert.assertNotNull(indepedentReports.getTextOfReportList(1));
//			System.out.println("########################3");
//			Assert.assertNotNull(indepedentReports.getTextOfReportList(2));
//			
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check Opinion > MoversAndShakers link on navigation bar.
//	 * Check URL after clicking the MoversAndShakers.
//	 * Check links are not blank.
//	 */
//	@Test( priority =14)
//	public void OpinionMoversAndShakersLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(5,6);
//			Thread.sleep(10000);
//			MoversAndShakers moversAndShakers=  PageFactory.initElements(BrowserInstance.driver, MoversAndShakers.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/movers-shakers");
//			Assert.assertNotNull(moversAndShakers.getTextOfReportList(1));
//			System.out.println("########################3");
//			Assert.assertNotNull(moversAndShakers.getTextOfReportList(2));
//			
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check Opinion > BestOfBoardsAndBlogs link on navigation bar.
//	 * Check URL after clicking the BestOfBoardsAndBlogs.
//	 * Check presence of text BestOfBoardsAndBlogs.
//	 * Check links are not blank.
//	 */
//	@Test( priority =15)
//	public void OpinionBestOfBoardsAndBlogsLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(5,7);
//			Thread.sleep(10000);
//			BestOfBoardsAndBlogs bestOfBoardsAndBlogs=  PageFactory.initElements(BrowserInstance.driver, BestOfBoardsAndBlogs.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"opinion/best-of-boards-blogs");
//			Assert.assertTrue(bestOfBoardsAndBlogs.isBestOfBoardsAndBlogTxtPresent());
//			Assert.assertNotNull(bestOfBoardsAndBlogs.getTextOfReportList(1));
//			System.out.println("########################3");
//			Assert.assertNotNull(bestOfBoardsAndBlogs.getTextOfReportList(2));
//			
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check News link on navigation bar.
//	 * Check URL after clicking the News.
//	 * Check presence of "News" text.
//	 * Check presence of "Featured News" text.
//	 */
//	@Test( priority =16)
//	public void NewsLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationLink(4);
//			Thread.sleep(10000);
//			NewsPage newsPage =  PageFactory.initElements(BrowserInstance.driver, NewsPage.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news");
//			Assert.assertTrue(newsPage.isNewsTxtPresent());
//			System.out.println("##################################3");
//			Assert.assertTrue(newsPage.isFeaturedNewsTxtPresent());
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void NewsLink()
//	
//	/*
//	 * Test case to check News > Featured News companies link on navigation bar.
//	 * Check URL after clicking the Featured News.
//	 * Check presence of "Featured News" text.
//	 * Check links are not blank.
//	 */
//	@Test( priority =17)
//	public void newsFeaturedNewsLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(4,1);
//			Thread.sleep(10000);
//			FeaturedNews featuredNews=  PageFactory.initElements(BrowserInstance.driver, FeaturedNews.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/newswire");
//			Assert.assertTrue(featuredNews.isFeaturedNewsTxtPresent());
//			System.out.println("########################3");
//			Assert.assertNotNull(featuredNews.getTextOfReportList(1));
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check News > NaturalResources link on navigation bar.
//	 * Check URL after clicking the NaturalResources.
//	 * Check NaturalResources text presence.
//	 * Check RefineYourSearch text presence.
//	 */
//	@Test( priority =18)
//	public void NewsNaturalResourcesLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(4,2);
//			Thread.sleep(10000);
//			NaturalResources naturalResources=  PageFactory.initElements(BrowserInstance.driver, NaturalResources.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/natural-resources");
//			Assert.assertTrue(naturalResources.isNaturalResourcesTxtPresent());
//			System.out.println("########################3");
//			Assert.assertTrue(naturalResources.isRefineYourSearchTxtPresent());
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check News > BreakingNews companies link on navigation bar.
//	 * Check URL after clicking the BreakingNews.
//	 * Check links are not blank.
//	 * Check presence of Breaking news text.
//	 */
//	@Test( priority =19)
//	public void NewsBreakingNews()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(4,3);
//			Thread.sleep(10000);
//			BreakingNews breakingNews=  PageFactory.initElements(BrowserInstance.driver, BreakingNews.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/bulletins");
//			Assert.assertTrue(breakingNews.isBreakingNewsTxtPresent());
//			System.out.println("########################3");
//			Assert.assertNotNull(breakingNews.getTextOfReportList(1));
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	/*
//	 * Test case to check News > Micro Cap Report link on navigation bar.
//	 * Check URL after clicking the Micro Cap Report.
//	 * Check links are not blank.
//	 */
//	@Test( priority =20)
//	public void NewsMicroCapReport()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(4,4);
//			Thread.sleep(10000);
//			MicroCapReport microCapReport=  PageFactory.initElements(BrowserInstance.driver, MicroCapReport.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/micro-cap-report");
//			Assert.assertNotNull(microCapReport.getTextOfReportList(1));
//			System.out.println("########################3");
//			Assert.assertNotNull(microCapReport.getTextOfReportList(2));
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check News > Canadian Press Releases link on navigation bar.
//	 * Check URL after clicking the Independent Reports.
//	 * Check Canadian Press Release Text present.
//	 * Check links are not blank.
//	 */
//	@Test( priority =21)
//	public void NewsCanadianPressReleaseLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(4,5);
//			Thread.sleep(10000);
//			CanadianPressRelease canadianPressRelease=  PageFactory.initElements(BrowserInstance.driver, CanadianPressRelease.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/canadian-press-releases");
//			Assert.assertTrue(canadianPressRelease.isCanadianPressReleasesTxtPresent());
//			System.out.println("########################3");
//			Assert.assertNotNull(canadianPressRelease.getTextOfReportList(1));
//			System.out.println("########################3");
//			Assert.assertNotNull(canadianPressRelease.getTextOfReportList(2));
//			
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
//	
//	/*
//	 * Test case to check News > US Press Releases link on navigation bar.
//	 * Check URL after clicking the US Press Releases.
//	 * Check presence of US Press Releases text.
//	 * Check links are not blank.
//	 */
//	@Test( priority =22)
//	public void NewsUSPressReleaseLink()
//	{
//		try{
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			Thread.sleep(30000);
//			homepage.clickOnNavigationSubLink(4,6);
//			Thread.sleep(10000);
//			USPressRelease uSPressRelease=  PageFactory.initElements(BrowserInstance.driver, USPressRelease.class);
//			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"news/us-press-releases");
//			Assert.assertTrue(uSPressRelease.isUSPressReleasesTxtPresent());
//			Assert.assertNotNull(uSPressRelease.getTextOfReportList(1));
//			System.out.println("########################3");
//			Assert.assertNotNull(uSPressRelease.getTextOfReportList(2));
//			
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case ETFsLink is failed. "+e); 
//				Assert.fail("Test case ETFsLink is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void PortfolioStockStreamLink()
	
	
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(30000);
			CommunityPage communityPage=PageFactory.initElements(BrowserInstance.driver, CommunityPage.class);
			homepage.clickOnNavigationLink(2);
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Bullboard bullBoard= PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(2,1);
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Blog blog= PageFactory.initElements(BrowserInstance.driver, Blog.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(2,2);
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			GroupsPage group= PageFactory.initElements(BrowserInstance.driver, GroupsPage.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(2,3);
			Thread.sleep(30000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"groups");
			Assert.assertTrue(group.isSortByHeadPresent());
			System.out.println("111111111111111111111111 ");
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			MarketPage market= PageFactory.initElements(BrowserInstance.driver, MarketPage.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationLink(3);
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			CommoditiesPage commodities= PageFactory.initElements(BrowserInstance.driver, CommoditiesPage.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(3, 2);
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			MarketMoversPage marketMovers= PageFactory.initElements(BrowserInstance.driver, MarketMoversPage.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(3, 3);
			Thread.sleep(30000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/market-movers");
			Assert.assertTrue(marketMovers.isExchangeHeadPresent());
			Assert.assertTrue(marketMovers.isVolActivitiesHeadPresent(1));
			
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			CurrenciesPage currencies= PageFactory.initElements(BrowserInstance.driver, CurrenciesPage.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(3, 4);
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			BondsPage bonds= PageFactory.initElements(BrowserInstance.driver, BondsPage.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(3,5);
			
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			TSXPage tsx= PageFactory.initElements(BrowserInstance.driver, TSXPage.class);
			Thread.sleep(30000);
			homepage.clickOnStocksSubLink(3,1);
			
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			TSXVPage tsxv= PageFactory.initElements(BrowserInstance.driver, TSXVPage.class);
			Thread.sleep(30000);
			homepage.clickOnStocksSubLink(3,2);
			
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			CSEPage cse= PageFactory.initElements(BrowserInstance.driver, CSEPage.class);
			Thread.sleep(30000);
			homepage.clickOnStocksSubLink(3,3);
			
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			NYSEPage nyse= PageFactory.initElements(BrowserInstance.driver, NYSEPage.class);
			Thread.sleep(30000);
			homepage.clickOnStocksSubLink(3,4);
			
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			NASDAQPage nasdaq= PageFactory.initElements(BrowserInstance.driver, NASDAQPage.class);
			Thread.sleep(30000);
			homepage.clickOnStocksSubLink(3,5);
			
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			AMEXPage amex= PageFactory.initElements(BrowserInstance.driver, AMEXPage.class);
			Thread.sleep(30000);
			homepage.clickOnStocksSubLink(3,6);
			
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			DJIAPage djia= PageFactory.initElements(BrowserInstance.driver, DJIAPage.class);
			Thread.sleep(30000);
			homepage.clickOnStocksSubLink(3,7);
			
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			ETFsPage etf= PageFactory.initElements(BrowserInstance.driver, ETFsPage.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(3,6);
			
			Thread.sleep(30000);
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			FundsPage funds= PageFactory.initElements(BrowserInstance.driver, FundsPage.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(3,7);
			
			Thread.sleep(30000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"markets/funds");
			Assert.assertTrue(funds.isFundsPerformOverHeadPresent());
			Assert.assertTrue(funds.isFundsHeadPresent());
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
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			StockScreenerPage stockScreen= PageFactory.initElements(BrowserInstance.driver, StockScreenerPage.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(3,8);
			
			Thread.sleep(30000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"portfolio/stock-screener");
			Assert.assertTrue(stockScreen.isFeaturedCompanyHeadPresent());
			Assert.assertTrue(stockScreen.isSearchOptionHeadPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case StockScreenerLink is failed. "+e); 
				Assert.fail("Test case StockScreenerLink is failed. "+e);
		}//End catch(Exception e)

    }// End public void StockScreenerLink()
	
}
