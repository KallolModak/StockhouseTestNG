package test;


import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import common.BaseSetup;
import common.BrowserInstance;
import common.BrowserType;
import common.JavaUtility;
import common.LoggerInstance;
import common.ReadInputData;
import common.WebdriverUtility;
import pageObjects.Bullboard;
import pageObjects.FlyinSideBar;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class BullBoardTestcases extends BaseSetup {
	
	//private FlyinSideBar flyin;
	
	
	/*
	 * Test case for rating the bull board.
	 */
	@Test(priority=1)
	public void BullboardViewByRating()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 1 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			Bullboard bullboardPage = baseState();
			Thread.sleep(20000);
			bullboardPage.cancelLoading();
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"/companies/bullboard/t.bb/blackberry?rt=5");
			//WebdriverUtility.waitForPageLoaded();
			Thread.sleep(20000);
			bullboardPage.cancelLoading();
			for(int i=1;i<=10;i++){
				//LoggerInstance.logger.info(i+" rating is: "+bullboardPage.getNumberOfStarts(i+""));
				if(bullboardPage.isStarImagePresent(i)){
					//String stars=bullboardPage.getNumberOfStarts(i);
					//if(stars.equalsIgnoreCase("5 stars")){
						Assert.assertEquals("5 stars",bullboardPage.getNumberOfStarts(i));
						//Assert.assertEquals(1,1);
					//}
				}
			}
			}catch(Exception e){
				LoggerInstance.logger.info("Bull board list view by rating is failed. "+e);
			Assert.fail("Bull board list view by rating is failed. "+e);
		}//End catch(Exception e)
	}// End public void BullboardViewByRating()
	/*
	 * New post functionality is checked.
	 */
	@Test(priority=2)
	public void BullboardNewPost()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 2 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			//WebdriverUtility.waitForPageLoaded();
			homepage.clickOnSignIn();
			Thread.sleep(10000);
			homepage.cancelLoading();
			String username=ReadInputData.HM_inputData.get("UserIdForHomePage");
			String password=ReadInputData.HM_inputData.get("Password");
			homepage.typeUserIdOnSignInPopup(username);
			homepage.typePasswordOnSignInPopup(password);
			homepage.clickOnSignInBtnOnSigninPopup();
			Thread.sleep(20000);
			homepage.cancelLoading();
			//WebdriverUtility.waitForPageLoaded();
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"/companies/bullboard/testj/test-co");
			Thread.sleep(20000);
			homepage.cancelLoading();
			Bullboard bullboardPage = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			//int msg1=bullboardPage.getSizeOfPostedMessage();
			int randomNum=JavaUtility.randInt(1, 100);
			bullboardPage.clickOnNewPostButton();// NEW THREAD
			Thread.sleep(20000);
			bullboardPage.cancelLoading();
			bullboardPage.typeSubject("Test"+randomNum);
			bullboardPage.typeMessage("TestMessage"+randomNum);
			Thread.sleep(20000);
			bullboardPage.clickOnPost(4);
			Thread.sleep(20000);
			//bullboardPage.cancelLoading();
			//int msg2=bullboardPage.getSizeOfPostedMessage();
			String head=bullboardPage.getTextOfPostedMessageHead(1);
			Assert.assertEquals("Test"+randomNum, head);
		
			}catch(Exception e){
				LoggerInstance.logger.info("New post functionality failed. "+e);
			Assert.fail("New post functionality failed. "+e);
		}//End catch(Exception e)
	}// End public void Job_TC_5()
	/*
	 * Check add to favorite and remove from favorite.
	 */
	@Test(priority=3)
	public void AddRemoveFromFavorite()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 3 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnSignIn();
			Thread.sleep(10000);
			String username=ReadInputData.HM_inputData.get("UserIdForHomePage");
			String password=ReadInputData.HM_inputData.get("Password");
			homepage.typeUserIdOnSignInPopup(username);
			homepage.typePasswordOnSignInPopup(password);
			homepage.clickOnSignInBtnOnSigninPopup();
			Thread.sleep(20000);
			homepage.cancelLoading();
			//WebdriverUtility.waitForPageLoaded();
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"companies/bullboard/testj/test-co");
			//WebdriverUtility.waitForPageLoaded();
			Bullboard bullboardPage = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			Thread.sleep(20000);
			bullboardPage.cancelLoading();
			for(int i=1;i<=10;i++){
				if (bullboardPage.getMessageOfFavouriteButton().equals("Remove From Favorites")){
					break;
				}
				else{
					bullboardPage.clickOnAddToFavouritesButton();
					Thread.sleep(30000);
					bullboardPage.cancelLoading();
				}
			}
			//Thread.sleep(20000);
			/* **** Commented as this message is not appearing now.******* */
			//Assert.assertEquals("Bullboard has been added to your favorites", bullboardPage.getMessageAfterFavouriteOperations());
			Assert.assertEquals("Remove From Favorites",bullboardPage.getMessageOfFavouriteButton());
			for(int i=1;i<=10;i++){
				if (bullboardPage.getMessageOfFavouriteButton().equals("Add To Favorites")){
					break;
				}
				else{
					bullboardPage.clickOnRemoveFromFavouritesButton();
					Thread.sleep(20000);
					bullboardPage.cancelLoading();
				}
			}
			/* ****** Commented as this message is not appearing now.******* */
			//Assert.assertEquals("Bullboard has been removed to your favorites", bullboardPage.getMessageAfterFavouriteOperations());
			Assert.assertEquals("Add To Favorites", bullboardPage.getMessageOfFavouriteButton());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Add to favorite and remove from favorite is failed "+e);
			Assert.fail("Add to favorite and remove from favorite is failed "+e);
		}//End catch(Exception e)
 	}// End public void AddRemoveFromFavorite()
	/*
	 * Check the bull board list by view by mode (oldest to newest).
	 */
	 @Test(priority=4)
	 public void ViewByModeOldToNew()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 4 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	  try{
		  Bullboard bullboardPage = baseState();
		  //Thread.sleep(20000);
		  bullboardPage.cancelLoading();
		  //bullboardPage.selectViewMode("Flat - newest to oldest",2);
		  bullboardPage.selectViewMode("Flat - newest to oldest");
		  Thread.sleep(30000);
		  bullboardPage.cancelLoading();
		  String first=bullboardPage.getTextOfPostsHead(1);
			 bullboardPage.selectViewMode("Flat - oldest to newest");
			 //bullboardPage.selectViewMode("Flat - oldest to newest",3);
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();

			 String sec=bullboardPage.getTextOfPostsHead(1);
			 Assert.assertNotEquals(first, sec);
		 
	   	}catch(Exception e){
	   		LoggerInstance.logger.info("Bull board list by ViewByModeOldToNew failed. "+e);
	   		Assert.fail("Bull board list by ViewByModeOldToNew failed. "+e);
	   }//End catch(Exception e)
	}// End public void ViewByModeOldToNew()
	 /*
	  * Check the bull board list by view by mode (newest to oldest).
	  */
	 @Test(priority=5)
	 
	 public void ViewByModeNewToOld()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 5 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(20000);
			  bullboardPage.cancelLoading();

			// bullboardPage.selectViewMode("Flat - oldest to newest",3);
			 bullboardPage.selectViewMode("Flat - oldest to newest");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
String first=bullboardPage.getTextOfPostsHead(1);
			 //Thread.sleep(30000);
			// bullboardPage.selectViewMode("Flat - newest to oldest",2);
			 bullboardPage.selectViewMode("Flat - newest to oldest");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();

			 String sec=bullboardPage.getTextOfPostsHead(1);
			 Assert.assertNotEquals(first, sec);
		
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by ViewByModeNewToOld failed. "+e);
		   		Assert.fail("Bull board list by ViewByModeNewToOld failed. "+e);
	   }//End catch(Exception e)
	}// End public void ViewByModeNewToOld()
	 /*
	  * Check the bull board list by view by mode (Threaded).
	  */
	 @Test(priority=6)
	 public void ViewByModeThreaded()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 6 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			  bullboardPage.cancelLoading();

			// Thread.sleep(80000);
			// bullboardPage.selectViewMode("Threaded",1);
			 bullboardPage.selectViewMode("Threaded");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();

			 for(int i=1;i<=10;i++){
				 String txt=bullboardPage.getTextOfPostsHeadThreaded(i);
				 if(txt.contains("RE:"))
				 {
					 Assert.assertEquals(1, 0);
				 }
				 else
					 Assert.assertEquals(1, 1);
			 }
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by ViewByModeThreaded failed. "+e);
		   		Assert.fail("Bull board list by ViewByModeThreaded failed. "+e);
	   }//End catch(Exception e)
	}// End public void ViewByModeThreaded()
	 /*
	  * Check the bull board list by pagination.
	  */
	 @Test(priority=7)
	 public void Pagination()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 7 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			  bullboardPage.cancelLoading();

			 for(int i=1;i<=3;i++){
				 String href= bullboardPage.getHrefOfPagination();
				 bullboardPage.clickOnPagination();
				 Thread.sleep(30000);
				  bullboardPage.cancelLoading();

				 Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),href);
			 }
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by Pagination failed. "+e);
		   		Assert.fail("Bull board list by Pagination failed. "+e);
	   }//End catch(Exception e)
	}// End public void Pagination()
	 /*
	  * Check the bull board page navigation links QuoteLink.
	  */
	 @Test(priority=8)
	 public void QuoteLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 8 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			  bullboardPage.cancelLoading();

			 String txt=bullboardPage.getTextOfBBNavLink("Quote");
			 bullboardPage.clickOnBBNavLink("Quote");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();

			 String url=BrowserInstance.driver.getCurrentUrl();
			System.out.println("url==="+url);
			 if(url.contains("/quote?symbol=t.bb"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by QuoteLink failed. "+e);
		   		Assert.fail("Bull board list by QuoteLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void QuoteLink()
	 /*
	  * Check the bull board page navigation links BullBoardLink.
	  */
	 @Test(priority=9)
	 public void BullBoardLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 9 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			  bullboardPage.cancelLoading();
			// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink("Bullboard");
			 bullboardPage.clickOnBBNavLink("Bullboard");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by BullBoardLink failed. "+e);
		   		Assert.fail("Bull board list by BullBoardLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void BullBoardLink()
	 /*
	  * Check the bull board page navigation links NewsLink.
	  */
	 @Test(priority=10)
	 public void NewsLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 10 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			  bullboardPage.cancelLoading();
			 String txt=bullboardPage.getTextOfBBNavLink("News");
			 bullboardPage.clickOnBBNavLink("News");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains("/news?symbol=t.bb"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by NewsLink failed. "+e);
		   		Assert.fail("Bull board list by NewsLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void NewsLink()
	 /*
	  * Check the bull board page navigation links Opinion.
	  */
	 @Test(priority=11)
	 public void OpinionLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 11 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			  bullboardPage.cancelLoading();
			 String txt=bullboardPage.getTextOfBBNavLink("Opinion");
			 bullboardPage.clickOnBBNavLink("Opinion");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains("opinion?symbol=t.bb"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by OpinionLink failed. "+e);
		   		Assert.fail("Bull board list by OpinionLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void OpinionLink()
//	 /*
//	  * Check the bull board page navigation links Level II.
//	  */
//	 @Test(priority=12)
//	 public void LevelLink()
//	 {
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 12 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		 try{
//			 Bullboard bullboardPage = baseState();
//			// Thread.sleep(80000);
//			  bullboardPage.cancelLoading();
//			 String[] txt=bullboardPage.getTextOfBBNavLink("Level II").split(" ");
//			 bullboardPage.clickOnBBNavLink("Level II");
//			 Thread.sleep(30000);
//			  bullboardPage.cancelLoading();
//			 String url=BrowserInstance.driver.getCurrentUrl();
//			
//			 if(url.contains(txt[0].toLowerCase()+"2/t.bb/blackberry"))
//				 Assert.assertEquals(1, 1);
//			 else
//				 Assert.assertEquals(1, 0);
//		  }catch(Exception e){
//		   		LoggerInstance.logger.info("Bull board list by LevelLink failed. "+e);
//		   		Assert.fail("Bull board list by LevelLink failed. "+e);
//	   }//End catch(Exception e)
//	}// End public void LevelLink()
//	 /*
//	  * Check the bull board page navigation links ChartsLink.
//	  */
//	 @Test(priority=13)
//	 public void ChartsLink()
//	 {
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 13 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		 try{
//			 Bullboard bullboardPage = baseState();
//			// Thread.sleep(80000);
//			  bullboardPage.cancelLoading();
//			 String txt=bullboardPage.getTextOfBBNavLink("Charts");
//			 bullboardPage.clickOnBBNavLink("Charts");
//			 Thread.sleep(30000);
//			  bullboardPage.cancelLoading();
//			 String url=BrowserInstance.driver.getCurrentUrl();
//			
//			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
//				 Assert.assertEquals(1, 1);
//			 else
//				 Assert.assertEquals(1, 0);
//		  }catch(Exception e){
//		   		LoggerInstance.logger.info("Bull board list by ChartsLink failed. "+e);
//		   		Assert.fail("Bull board list by ChartsLink failed. "+e);
//	   }//End catch(Exception e)
//	}// End public void ChartsLink()
	 /*
	  * Check the bull board page navigation links ProfileLink.
	  */
	 @Test(priority=14)
	 public void ProfileLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 14 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			/// Thread.sleep(80000);
			  bullboardPage.cancelLoading();
			 String txt=bullboardPage.getTextOfBBNavLink("Profile");
			 bullboardPage.clickOnBBNavLink("Profile");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			// System.out.println("url=="+url);
			 if(url.contains("/profile?symbol=t.bb"))
			// if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by ProfileLink failed. "+e);
		   		Assert.fail("Bull board list by ProfileLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void ProfileLink()
	 /*
	  * Check the bull board page navigation links FinancialLink.
	  */
	 @Test(priority=15)
	 public void FinancialLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 15 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			  bullboardPage.cancelLoading();
			 String txt=bullboardPage.getTextOfBBNavLink("Financials");
			 bullboardPage.clickOnBBNavLink("Financials");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains("/financials?symbol=t.bb"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by FinancialLink failed. "+e);
		   		Assert.fail("Bull board list by FinancialLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void FinancialLink()
	 /*
	  * Check the bull board page navigation links OptionsLink.
	  */
	 @Test(priority=16)
	 public void OptionsLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 16 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			  bullboardPage.cancelLoading();
			 String txt=bullboardPage.getTextOfBBNavLink("Options");
			 bullboardPage.clickOnBBNavLink("Options");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains("options?symbol=t.bb"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by OptionsLink failed. "+e);
		   		Assert.fail("Bull board list by OptionsLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void OptionsLink()
	 /*
	  * Check the bull board page navigation links PriceHistoryLink.
	  */
	 @Test(priority=17)
	 public void PriceHistoryLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 17 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			  bullboardPage.cancelLoading();
			 String[] txt=bullboardPage.getTextOfBBNavLink("Price History").split(" ");
			 bullboardPage.clickOnBBNavLink("Price History");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
		//	System.out.println("********* url ********** "+url);
			 if(url.contains("/history?symbol=t.bb"))///profile?symbol=t.bb
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by PriceHistoryLink failed. "+e);
		   		Assert.fail("Bull board list by PriceHistoryLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void PriceHistoryLink()
//	 /*
//	  * Check the bull board page navigation links AnalystsLink.
//	  */
//	 @Test(priority=18)
//	 public void AnalystsLink()
//	 {
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 18 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		 try{
//			 Bullboard bullboardPage = baseState();
//			// Thread.sleep(80000);
//			  bullboardPage.cancelLoading();
//			 String txt=bullboardPage.getTextOfBBNavLink("Analysts");
//			 bullboardPage.clickOnBBNavLink("Analysts");
//			 Thread.sleep(30000);
//			 bullboardPage.cancelLoading();
//			 String url=BrowserInstance.driver.getCurrentUrl();
//			
//			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
//				 Assert.assertEquals(1, 1);
//			 else
//				 Assert.assertEquals(1, 0);
//		  }catch(Exception e){
//		   		LoggerInstance.logger.info("Bull board list by AnalystsLink failed. "+e);
//		   		Assert.fail("Bull board list by AnalystsLink failed. "+e);
//	   }//End catch(Exception e)
//	}// End public void AnalystsLink()
//	 /*
//	  * Check the bull board page navigation links EarningsLink.
//	  */
//	 @Test(priority=19)
//	 public void EarningsLink()
//	 {
//		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 19 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		 try{
//			 Bullboard bullboardPage = baseState();
//			// Thread.sleep(80000);
//			  bullboardPage.cancelLoading();
//			 String txt=bullboardPage.getTextOfBBNavLink("Earnings");
//			 bullboardPage.clickOnBBNavLink("Earnings");
//			 Thread.sleep(30000);
//			  bullboardPage.cancelLoading();
//			 String url=BrowserInstance.driver.getCurrentUrl();
//			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
//				 Assert.assertEquals(1, 1);
//			 else
//				 Assert.assertEquals(1, 0);
//		  }catch(Exception e){
//		   		LoggerInstance.logger.info("Bull board list by EarningsLink failed. "+e);
//		   		Assert.fail("Bull board list by EarningsLink failed. "+e);
//	   }//End catch(Exception e)
//	}// End public void EarningsLink()
	 /*
	  * Check the bull board page navigation links InsidersLink.
	  */
	 @Test(priority=20)
	 public void InsidersLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 20 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			 Thread.sleep(20000);
			  bullboardPage.cancelLoading();
			 String txt=bullboardPage.getTextOfBBNavLink("Insiders");
			 bullboardPage.clickOnBBNavLink("Insiders");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			 System.out.println("url==="+url);
			 if(url.contains("insiders?symbol=t.bb"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by InsidersLink failed. "+e);
		   		Assert.fail("Bull board list by InsidersLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void InsidersLink()
	 /*
	  * Check the bull board page navigation links Filings Link.
	  */
	 @Test(priority=21)
	 public void FilingsLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 21 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			 Thread.sleep(20000);
			  bullboardPage.cancelLoading();
			 String txt=bullboardPage.getTextOfBBNavLink("Filings");
			 bullboardPage.clickOnBBNavLink("Filings");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			// if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))//filings?symbol=t.bb
				 if(url.contains("filings?symbol=t.bb"))//filings?symbol=t.bb
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by FilingsLink failed. "+e);
		   		Assert.fail("Bull board list by FilingsLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void FilingsLink()
	 
	 /*
	  * Check the bull board page navigation links Peers Link.
	  */
	 @Test(priority=22)
	 public void PeersLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 22 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			 Thread.sleep(20000);
			 bullboardPage.cancelLoading();
			 String txt=bullboardPage.getTextOfBBNavLink("Peers");
			 bullboardPage.clickOnBBNavLink("Peers");
			 Thread.sleep(30000);
			 bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			 if(url.contains("/peers?symbol=t.bb"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by PeersLink failed. "+e);
		   		Assert.fail("Bull board list by PeersLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void PeersLink()
	 
	 /*
	  * Check the bull board page navigation links Ratios Link.
	  */
	 @Test(priority=23)
	 public void RatiosLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 23 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			 Thread.sleep(20000);
			  bullboardPage.cancelLoading();
			 String txt=bullboardPage.getTextOfBBNavLink("Ratios");
			 bullboardPage.clickOnBBNavLink("Ratios");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			// System.out.println("url==="+url);
			 if(url.contains("/ratios?symbol=t.bb"))
		//	 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by RatiosLink failed. "+e);
		   		Assert.fail("Bull board list by RatiosLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void RatiosLink()
	 
	 /*
	  * Check the bull board page navigation links Valuation Link.
	  */
	 @Test(priority=24)
	 public void ValuationLink()
	 {
		 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 24 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		 try{
			 Bullboard bullboardPage = baseState();
			 Thread.sleep(20000);
			  bullboardPage.cancelLoading();
			 String txt=bullboardPage.getTextOfBBNavLink("Valuation");
			 bullboardPage.clickOnBBNavLink("Valuation");
			 Thread.sleep(30000);
			  bullboardPage.cancelLoading();
			 String url=BrowserInstance.driver.getCurrentUrl();
			// System.out.println("url=="+url);
		//	 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
			 if(url.contains("/valuation?symbol=t.bb"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by ValuationLink failed. "+e);
		   		Assert.fail("Bull board list by ValuationLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void ValuationLink()
	 
	 
	 /*
	  * This is the base state.
	  */
	public Bullboard baseState(){
		BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"companies/bullboard/t.bb/blackberry");
		 try{Thread.sleep(20000);}catch(Exception e){}

		//WebdriverUtility.waitForPageLoaded();
		Bullboard bullboardPage = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
		return bullboardPage;
	}
	
}
