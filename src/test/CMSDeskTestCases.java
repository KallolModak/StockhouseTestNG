package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BreakingNews;
import pageObjects.Bullboard;
import pageObjects.CMSDeskPage;
import pageObjects.CMSToolsPage;
import pageObjects.FeaturedNews;
import pageObjects.HomePage;
import pageObjects.IndependentReports;
import pageObjects.InterviewPage;
import pageObjects.MicroCapReport;
import pageObjects.MoversAndShakers;
import pageObjects.NaturalResources;
import pageObjects.PrivateEquity;
import pageObjects.ShortReportPage;
import common.BaseSetup;
import common.BrowserInstance;
import common.JavaUtility;
import common.LoggerInstance;
import common.ReadInputData;

public class CMSDeskTestCases extends BaseSetup {
	
	private CMSToolsPage cmsToolsPage;

	/*
	 * TestCase for news posting for natural resource.
	 */
	@Test(priority=1)
	public void NaturalResourceNewsPosting()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 1 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(20000);
			  homepage.cancelLoading();
			  homepage.clickOnSignIn();
			//  String username=ReadInputData.HM_inputData.get("UserIdForQA");
			  String username=ReadInputData.HM_inputData.get("UserIdForQA");
			  String password=ReadInputData.HM_inputData.get("Password");
			  homepage.typeUserIdOnSignInPopup(username);
			  homepage.typePasswordOnSignInPopup(password);
			  homepage.clickOnSignInBtnOnSigninPopup();
			  Thread.sleep(30000);
			  homepage.cancelLoading();
			  String url=ReadInputData.HM_inputData.get("URL");
			  BrowserInstance.driver.get(url+"cmsdesk/");
			  Thread.sleep(10000);
			  CMSDeskPage cmsDeskPage= PageFactory.initElements(BrowserInstance.driver, CMSDeskPage.class);
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.expandOptionInLeftTree("News");
			  cmsDeskPage.clickOnSubOptionOfLeftTree("Natural Resources");
			  cmsDeskPage.clickOnNewButton();
			  Thread.sleep(10000);
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnContentItem();
			  Thread.sleep(10000);
			  String titlePassed="Test QA Natural Resource News"+JavaUtility.randInt(100, 9999);
			  cmsDeskPage.setFormTableTitle(1,"title",titlePassed );
			  cmsDeskPage.setFormTableDeck(3,"deck", "Test Deck content");
			  cmsDeskPage.selectAuthor(2, "author", "Peter Kennedy");
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 6);//T : AT&T Inc
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 6);
			  cmsDeskPage.selectFeedPublished(8, "feedPublished");
			  Thread.sleep(20000);
			 // cmsDeskPage.setTagsText("tagText", "gold", 13);
			  cmsDeskPage.clickOnPublishDateNow("publishDateNow", 14);
			  cmsDeskPage.setFormTableContent(4,"content", "Test content's content");
			  cmsDeskPage.switchToDefaultFrame();
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnSaveButton();
			  cmsDeskPage.switchToDefaultFrame();
			  Thread.sleep(50000);
			  BrowserInstance.driver.get(url);
				Thread.sleep(20000);
				homepage.cancelLoading();
				homepage.clickOnNavigationSubLink(4,"News",2,"Natural Resources");//4,2
				Thread.sleep(10000);
				NaturalResources naturalResources=  PageFactory.initElements(BrowserInstance.driver, NaturalResources.class);
				String text = naturalResources.getTextOfItem(1);
				Assert.assertEquals(titlePassed,text);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case NaturalResourceNewsPosting is failed. "+e); 
			Assert.fail("Test case NaturalResourceNewsPosting is failed. "+e);
		}
	}// End of NaturalResourceNewsPosting()
	/*
	 * TestCase for news posting for Featured News.
	 */
	@Test(priority=2)
	public void FeaturedNewsPosting()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 2 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(20000);
			  homepage.cancelLoading();
			  homepage.clickOnSignIn();
			 // String username=ReadInputData.HM_inputData.get("UserIdForQA");//usrQA1
			  String username=ReadInputData.HM_inputData.get("UserIdForQA");
			  String password=ReadInputData.HM_inputData.get("Password");
			  homepage.typeUserIdOnSignInPopup(username);
			  homepage.typePasswordOnSignInPopup(password);
			  homepage.clickOnSignInBtnOnSigninPopup();
			  Thread.sleep(30000);
			  homepage.cancelLoading();
			  String url=ReadInputData.HM_inputData.get("URL");
			  BrowserInstance.driver.get(url+"cmsdesk/");
			  Thread.sleep(10000);
			  CMSDeskPage cmsDeskPage= PageFactory.initElements(BrowserInstance.driver, CMSDeskPage.class);
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.expandOptionInLeftTree("News");
			  cmsDeskPage.clickOnSubOptionOfLeftTree("Featured News");
			  cmsDeskPage.clickOnNewButton();
			  Thread.sleep(10000);
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnContentItem();
			  Thread.sleep(10000);
			  String titlePassed="Test QA Featured News"+JavaUtility.randInt(100, 9999);
			  cmsDeskPage.setFormTableTitle(1,"title", titlePassed);
			  cmsDeskPage.setFormTableDeck(3,"deck", "Test Deck content");
			  cmsDeskPage.selectAuthor(2, "author", "Peter Kennedy");
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 6);//T : AT&T Inc
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 6);
			  cmsDeskPage.selectFeedPublished(8, "feedPublished");
			  Thread.sleep(20000);
			  //cmsDeskPage.setTagsText("tagText", "gold", 13);
			  cmsDeskPage.clickOnPublishDateNow("publishDateNow", 14);
			  cmsDeskPage.setFormTableContent(4,"content", "Test content's content");
			  cmsDeskPage.switchToDefaultFrame();
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnSaveButton();
			  cmsDeskPage.switchToDefaultFrame();
			  Thread.sleep(50000);
			  BrowserInstance.driver.get(url);
				Thread.sleep(20000);
				homepage.cancelLoading();
				homepage.clickOnNavigationSubLink(4,"News",1,"Featured News");//4,1
				Thread.sleep(10000);
				FeaturedNews featuredNews=  PageFactory.initElements(BrowserInstance.driver, FeaturedNews.class);
				String text = featuredNews.getTextOfItem(1);
				Assert.assertEquals(titlePassed,text);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case Featured News is failed. "+e); 
			Assert.fail("Test case Featured News is failed. "+e);
		}
	}// End of FeaturedNewsPosting()
	
	
	/*
	 * TestCase for news posting for Micro Cap Report.
	 */
	@Test(priority=3)
	public void MicroCapNewsPosting()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 3 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(20000);
			  homepage.cancelLoading();
			  homepage.clickOnSignIn();
			  String username=ReadInputData.HM_inputData.get("UserIdForQA");
			  String password=ReadInputData.HM_inputData.get("Password");
			  homepage.typeUserIdOnSignInPopup(username);
			  homepage.typePasswordOnSignInPopup(password);
			  homepage.clickOnSignInBtnOnSigninPopup();
			  Thread.sleep(30000);
			  homepage.cancelLoading();
			  String url=ReadInputData.HM_inputData.get("URL");
			  BrowserInstance.driver.get(url+"cmsdesk/");
			  Thread.sleep(10000);
			  CMSDeskPage cmsDeskPage= PageFactory.initElements(BrowserInstance.driver, CMSDeskPage.class);
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.expandOptionInLeftTree("News");
			  cmsDeskPage.clickOnSubOptionOfLeftTree("Micro Cap Report");
			  cmsDeskPage.clickOnNewButton();
			  Thread.sleep(10000);
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnContentItem();
			  Thread.sleep(15000);
			  String titlePassed="this is TestQA Micro Cap Report"+JavaUtility.randInt(100, 9999);
			  cmsDeskPage.setFormTableTitle(1,"title", titlePassed);
			  cmsDeskPage.selectAuthor(2, "author", "Peter Kennedy");
			  
			  // Set losers text.
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 4);
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 4);
			 // Set gainers text. 
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 5);
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 5);
			  
		  cmsDeskPage.setSymbolText("symbolText", "T.G", 6);//T.G //t.c
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 6);
			  Thread.sleep(20000);
			  cmsDeskPage.clickOnPublishDateNow("publishDateNow", 11);
			  cmsDeskPage.setFormTableContent(3,"content", "Test content's content");
			  
			  cmsDeskPage.switchToDefaultFrame();
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnSaveButton();
			  cmsDeskPage.switchToDefaultFrame();
			  Thread.sleep(20000);//50000
			  System.out.println("********ON URL STOCKHOUSE*********** ");
			  BrowserInstance.driver.get(url);
				Thread.sleep(20000);
				homepage.cancelLoading();
				homepage.clickOnNavigationSubLink(4,"News",3,"Micro Cap Report");
				Thread.sleep(10000);
				MicroCapReport microCap=  PageFactory.initElements(BrowserInstance.driver, MicroCapReport.class);
				String text = microCap.getTextOfReportList(1);
				Assert.assertEquals(titlePassed,text);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case Micro Cap Report is failed. "+e); 
			Assert.fail("Test case Micro Cap Report is failed. "+e);
		}
	}// End of MicroCapNewsPosting()
	
	/*
	 * TestCase for posting of private equity in opinion category.
	 */
	@Test(priority=4)
	public void OpinionPrivateEquity()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 4 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(20000);
			  homepage.cancelLoading();
			  homepage.clickOnSignIn();
			  String username=ReadInputData.HM_inputData.get("UserIdForQA");
			  String password=ReadInputData.HM_inputData.get("Password");
			  homepage.typeUserIdOnSignInPopup(username);
			  homepage.typePasswordOnSignInPopup(password);
			  homepage.clickOnSignInBtnOnSigninPopup();
			  Thread.sleep(30000);
			  homepage.cancelLoading();
			  String url=ReadInputData.HM_inputData.get("URL");
			  BrowserInstance.driver.get(url+"cmsdesk/");
			  Thread.sleep(10000);
			  CMSDeskPage cmsDeskPage= PageFactory.initElements(BrowserInstance.driver, CMSDeskPage.class);
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.expandOptionInLeftTree("Opinion");
			  cmsDeskPage.clickOnSubOptionOfLeftTree("Private Equity");
			  cmsDeskPage.clickOnNewButton();
			  Thread.sleep(10000);
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnContentItem();
			  Thread.sleep(15000);
			  String titlePassed="Test QA Private Equity"+JavaUtility.randInt(100, 9999);
			  cmsDeskPage.setFormTableTitle(1,"title", titlePassed);
			  cmsDeskPage.setFormTableDeck(3,"deck", "Test Deck content Private Equity");
			  cmsDeskPage.selectAuthor(2, "author", "Peter Kennedy");
			 // Set losers text.
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 6);
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 6);
			 // Set gainers text. 
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 7);
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 7);
			  // Set symbols text.
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 8);
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 8);
			  
			  cmsDeskPage.selectFeedPublished(10, "feedPublished");
			  Thread.sleep(20000);
			 // cmsDeskPage.setTagsText("tagText", "gold", 16);
			  cmsDeskPage.clickOnPublishDateNow("publishDateNow", 17);
			  cmsDeskPage.setFormTableContent(4,"content", "Test content's content Private Equity");
			  cmsDeskPage.switchToDefaultFrame();
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnSaveButton();
			  cmsDeskPage.switchToDefaultFrame();
			  Thread.sleep(50000);
			  System.out.println("********ON URL STOCKHOUSE*********** ");
			  BrowserInstance.driver.get(url);
				Thread.sleep(20000);
				homepage.cancelLoading();
				homepage.clickOnNavigationSubLink(5,"Opinion",1,"Private Equity");//5,1
				Thread.sleep(10000);
				PrivateEquity privateEquity=  PageFactory.initElements(BrowserInstance.driver, PrivateEquity.class);
				String text = privateEquity.getTextOfArticleList(1);
				Assert.assertEquals(titlePassed,text);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case OpinionPrivateEquity is failed. "+e); 
			Assert.fail("Test case OpinionPrivateEquity is failed. "+e);
		}
	}// End of OpinionPrivateEquity()
	/*
	 * TestCase for posting of private equity in opinion category.
	 */
	@Test(priority=5)
	public void OpinionShortReport()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 5 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(20000);
			  homepage.cancelLoading();
			  homepage.clickOnSignIn();
			  String username=ReadInputData.HM_inputData.get("UserIdForQA");
			  String password=ReadInputData.HM_inputData.get("Password");
			  homepage.typeUserIdOnSignInPopup(username);
			  homepage.typePasswordOnSignInPopup(password);
			  homepage.clickOnSignInBtnOnSigninPopup();
			  Thread.sleep(30000);
			  homepage.cancelLoading();
			  String url=ReadInputData.HM_inputData.get("URL");
			  BrowserInstance.driver.get(url+"cmsdesk/");
			  Thread.sleep(10000);
			  CMSDeskPage cmsDeskPage= PageFactory.initElements(BrowserInstance.driver, CMSDeskPage.class);
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.expandOptionInLeftTree("Opinion");
			  cmsDeskPage.clickOnSubOptionOfLeftTree("Short Report");
			  cmsDeskPage.clickOnNewButton();
			  Thread.sleep(10000);
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnContentItem();
			  Thread.sleep(15000);
			  String titlePassed="Title Test QA Short Report"+JavaUtility.randInt(100, 9999);
			  cmsDeskPage.setFormTableTitle(1,"title", titlePassed);
			  cmsDeskPage.setFormTableDeck(3,"deck", "Test Deck content Short Report");
			  cmsDeskPage.selectAuthor(2, "author", "Peter Kennedy");
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 6);
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 6);
			  cmsDeskPage.selectFeedPublished(8, "feedPublished");
			  Thread.sleep(20000);
		//	  cmsDeskPage.setTagsText("tagText", "gold", 13);
			  cmsDeskPage.clickOnPublishDateNow("publishDateNow", 14);
			  cmsDeskPage.setFormTableContent(4,"content", "This is Short Report content.");
			  cmsDeskPage.switchToDefaultFrame();
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnSaveButton();
			  cmsDeskPage.switchToDefaultFrame();
			  Thread.sleep(50000);
			  System.out.println("********ON URL STOCKHOUSE*********** ");
			  BrowserInstance.driver.get(url);
				Thread.sleep(20000);
				homepage.cancelLoading();
				homepage.clickOnNavigationSubLink(5,"Opinion",2,"Short Report");
				Thread.sleep(10000);
				ShortReportPage shortReport=  PageFactory.initElements(BrowserInstance.driver, ShortReportPage.class);
				String text = shortReport.getTextOfReportList(1);
				Assert.assertEquals(titlePassed,text);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case OpinionShortReport is failed. "+e); 
			Assert.fail("Test case OpinionShortReport is failed. "+e);
		}
	}// End of OpinionShortReport()
	/*
	 * TestCase for posting of Interviews in opinion category.
	 */
	@Test(priority=6)
	public void OpinionInterviews()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 6 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(20000);
			  homepage.cancelLoading();
			  homepage.clickOnSignIn();
			  String username=ReadInputData.HM_inputData.get("UserIdForQA");
			  String password=ReadInputData.HM_inputData.get("Password");
			  homepage.typeUserIdOnSignInPopup(username);
			  homepage.typePasswordOnSignInPopup(password);
			  homepage.clickOnSignInBtnOnSigninPopup();
			  Thread.sleep(30000);
			  homepage.cancelLoading();
			  String url=ReadInputData.HM_inputData.get("URL");
			  BrowserInstance.driver.get(url+"cmsdesk/");
			  Thread.sleep(10000);
			  CMSDeskPage cmsDeskPage= PageFactory.initElements(BrowserInstance.driver, CMSDeskPage.class);
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.expandOptionInLeftTree("Opinion");
			  cmsDeskPage.clickOnSubOptionOfLeftTree("Interviews");
			  cmsDeskPage.clickOnNewButton();
			  Thread.sleep(10000);
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnContentItem();
			  Thread.sleep(15000);
			  String titlePassed="Test QA Interviews"+JavaUtility.randInt(100, 9999);
			  cmsDeskPage.setFormTableTitle(1,"title", titlePassed);
			  cmsDeskPage.setFormTableDeck(3,"deck", "Test Deck content Interviews");
			  cmsDeskPage.selectAuthor(2, "author", "Peter Kennedy");
			  
			// Set losers text.
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 6);
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 6);
			 // Set gainers text. 
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 7);
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 7);
			  // Set symbols text.
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 8);
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 8);
			  cmsDeskPage.selectFeedPublished(10, "feedPublished");
			  Thread.sleep(20000);
			//  cmsDeskPage.setTagsText("tagText", "gold", 15);
			  cmsDeskPage.clickOnPublishDateNow("publishDateNow", 16);
			  cmsDeskPage.setFormTableContent(4,"content", "Test content's content Private Equity");
			  cmsDeskPage.switchToDefaultFrame();
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnSaveButton();
			  cmsDeskPage.switchToDefaultFrame();
			  Thread.sleep(50000);
			  System.out.println("********ON URL STOCKHOUSE*********** ");
			  BrowserInstance.driver.get(url);
				Thread.sleep(20000);
				homepage.cancelLoading();
				homepage.clickOnNavigationSubLink(5,"Opinion",4,"Interviews");
				Thread.sleep(10000);
				InterviewPage interviewsPage=  PageFactory.initElements(BrowserInstance.driver, InterviewPage.class);
			String text = interviewsPage.getTextOfInterviewList(1);
			Assert.assertEquals(titlePassed,text);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case OpinionInterviews is failed. "+e); 
			Assert.fail("Test case OpinionInterviews is failed. "+e);
		}
	}// End of OpinionInterviews()
	/*
	 * TestCase for posting of Independent Reports in opinion category.
	 */
	@Test(priority=7)
	public void OpinionIndependentReports()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 7 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			  HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			  Thread.sleep(20000);
			  homepage.cancelLoading();
			  homepage.clickOnSignIn();
			  String username=ReadInputData.HM_inputData.get("UserIdForQA");
			  String password=ReadInputData.HM_inputData.get("Password");
			  homepage.typeUserIdOnSignInPopup(username);
			  homepage.typePasswordOnSignInPopup(password);
			  homepage.clickOnSignInBtnOnSigninPopup();
			  Thread.sleep(30000);
			  homepage.cancelLoading();
			  String url=ReadInputData.HM_inputData.get("URL");
			  BrowserInstance.driver.get(url+"cmsdesk/");
			  Thread.sleep(10000);
			  CMSDeskPage cmsDeskPage= PageFactory.initElements(BrowserInstance.driver, CMSDeskPage.class);
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.expandOptionInLeftTree("Opinion");
			  cmsDeskPage.clickOnSubOptionOfLeftTree("Independent Reports");
			  cmsDeskPage.clickOnNewButton();
			  Thread.sleep(10000);
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnContentItem();
			  Thread.sleep(15000);
			  String titlePassed="Test QA Independent Reports"+JavaUtility.randInt(100, 9999);
			  cmsDeskPage.setFormTableTitle(1,"title", titlePassed);
			  cmsDeskPage.setFormTableDeck(3,"deck", "Test Deck content Independent Reports");
			  cmsDeskPage.selectAuthor(2, "author", "Peter Kennedy");
			  cmsDeskPage.setSymbolText("symbolText", "T.G", 6);
			  cmsDeskPage.clickOnAddSymbol("symbolButton", 6);
			  cmsDeskPage.selectFeedPublished(8, "feedPublished");
			  Thread.sleep(20000);
			//  cmsDeskPage.setTagsText("tagText", "gold", 12);
			  cmsDeskPage.clickOnPublishDateNow("publishDateNow", 13);
			  cmsDeskPage.setFormTableContent(4,"content", "Test content's content Independent Reports");
			  cmsDeskPage.switchToDefaultFrame();
			  cmsDeskPage.switchToFrame1();
			  cmsDeskPage.switchToFrame2();
			  cmsDeskPage.clickOnSaveButton();
			  cmsDeskPage.switchToDefaultFrame();
			  Thread.sleep(50000);
			  BrowserInstance.driver.get(url);
				Thread.sleep(20000);
				homepage.cancelLoading();
				homepage.clickOnNavigationSubLink(5,"Opinion",5,"Independent Reports");
				Thread.sleep(10000);
				IndependentReports independentReports=  PageFactory.initElements(BrowserInstance.driver, IndependentReports.class);
				String text = independentReports.getTextOfReportList(1);
			Assert.assertEquals(titlePassed,text);
		}catch(Exception e){
			LoggerInstance.logger.info("Test case Independent Reports is failed. "+e); 
			Assert.fail("Test case Independent Reports is failed. "+e);
		}
	}// End of IndependentReports()
}
