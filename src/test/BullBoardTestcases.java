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
import common.LoggerInstance;
import common.ReadInputData;
import common.WebdriverUtility;
import pageObjects.Bullboard;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class BullBoardTestcases extends BaseSetup {
	private LoginPage loginPage;
	private String jobName,reportName,frquency,jobType,selectTask;
	

	@Test(groups={"BrowserCertificationTestCase"}, priority=1)
	public void BullboardViewByRating()
	{
		try{
			Bullboard bullboardPage = baseState();
			Thread.sleep(20000);
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"/companies/bullboard/t.bb/blackberry?rt=5");
			WebdriverUtility.waitForPageLoaded();
			Thread.sleep(20000);
			for(int i=1;i<=10;i++){
				LoggerInstance.logger.info(i+" rating is: "+bullboardPage.getNumberOfStarts(i+""));
				Assert.assertEquals("5 stars",bullboardPage.getNumberOfStarts(i+""));
			}
			}catch(Exception e){
				LoggerInstance.logger.info("Bull board list view by rating is failed. "+e);
			Assert.fail("Bull board list view by rating is failed. "+e);
		}//End catch(Exception e)
	}// End public void BullboardViewByRating()
//	

	/*
	 * New post functionality is checked.
//	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=2)
	public void BullboardNewPost()
	{
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(30000);
			homepage.clickOnSignIn();
			Thread.sleep(10000);
			homepage.typeUserIdOnSignInPopup("testForLogin@mailinator.com");
			homepage.typePasswordOnSignInPopup("M()dak12");
			homepage.clickOnSignInBtnOnSigninPopup();
			Thread.sleep(20000);
			
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"companies/bullboard/testj/test-co");
			Thread.sleep(30000);
			Bullboard bullboardPage = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			int msg1=bullboardPage.getSizeOfPostedMessage();
			bullboardPage.clickOnNewPostButton();
			Thread.sleep(20000);
			bullboardPage.typeSubject("Test");
			bullboardPage.typeMessage("TestMessage");
			Thread.sleep(20000);
			bullboardPage.clickOnPost(4);
			Thread.sleep(20000);
			int msg2=bullboardPage.getSizeOfPostedMessage();
			Assert.assertEquals(msg1+1, msg2);
			///verify
			}catch(Exception e){
				LoggerInstance.logger.info("New post functionality failed. "+e);
			Assert.fail("New post functionality failed. "+e);
		}//End catch(Exception e)
	}// End public void Job_TC_5()
	
//	


	/*
	 * Check add to favorite and remove from favorite.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=3)
	public void AddRemoveFromFavorite()
	{
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(30000);
			homepage.clickOnSignIn();
			Thread.sleep(10000);
			homepage.typeUserIdOnSignInPopup("testForLogin@mailinator.com");
			homepage.typePasswordOnSignInPopup("M()dak12");
			homepage.clickOnSignInBtnOnSigninPopup();
			Thread.sleep(20000);
			
			//WebdriverUtility.waitForPageLoaded();
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"/companies/bullboard/testj/test-co");
			//WebdriverUtility.waitForPageLoaded();
			Bullboard bullboardPage = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			Thread.sleep(20000);
			for(int i=1;i<=10;i++){
				if (bullboardPage.getMessageOfFavouriteButton().equals("Remove From Favorites")){
					break;
				}
				else{
					bullboardPage.clickOnAddToFavouritesButton();
					Thread.sleep(30000);
				}
			}
			Assert.assertEquals("Bullboard has been added to your favorites", bullboardPage.getMessageAfterFavouriteOperations());
			Assert.assertEquals("Remove From Favorites",bullboardPage.getMessageOfFavouriteButton());
			
			for(int i=1;i<=10;i++){
				if (bullboardPage.getMessageOfFavouriteButton().equals("Add To Favorites")){
					break;
				}
				else{
					bullboardPage.clickOnRemoveFromFavouritesButton();
					Thread.sleep(30000);
				}
			}
			Assert.assertEquals("Bullboard has been removed to your favorites", bullboardPage.getMessageAfterFavouriteOperations());
			Assert.assertEquals("Add To Favorites", bullboardPage.getMessageOfFavouriteButton());
			
			
			}catch(Exception e){
				LoggerInstance.logger.info("Add to favorite and remove from favorite is failed "+e);
			Assert.fail("Add to favorite and remove from favorite is failed "+e);
		}//End catch(Exception e)
 	}// End public void Job_TC_5()
	/*
	 * Check the bull board list by view by mode (oldest to newest).
	 */
	 @Test(groups={"BrowserCertificationTestCase"}, priority=4)
	 public void ViewByModeOldToNew()
	 {
	  try{
		  Bullboard bullboardPage = baseState();
		  bullboardPage.selectViewMode("Flat - oldest to newest");
		  HashMap<String,String> hm = new HashMap<String,String>();
		  hm.put("January", "1");
		  hm.put("Februray", "2");
		  hm.put("March", "3");
		  hm.put("April", "4");
		  hm.put("May", "5");
		  hm.put("June", "6");
		  hm.put("July", "7");
		  hm.put("August", "8");
		  hm.put("September", "9");
		  hm.put("October", "10");
		  hm.put("November", "11");
		  hm.put("December", "12");
		  
		  Thread.sleep(80000);
		  String[] first= bullboardPage.getTextOfDate(1).split(" ");
		  String monthName = hm.get(first[1]);
		  int yr = Integer.parseInt(first[3]);
		  int month = Integer.parseInt(monthName);
		  int day = Integer.parseInt(first[2].replace(",", ""));
		  for(int i=2;i<=10;i++){
			  String[] sec=bullboardPage.getTextOfDate(i).split(" ");
			  String monthName1 = hm.get(sec[1]);
			  int yr1 = Integer.parseInt(sec[3]);
			  int month1 = Integer.parseInt(monthName1);
			  int day1 = Integer.parseInt(sec[2].replace(",", ""));
			  if(yr<=yr1){//year
				 if(yr<yr1)
					  Assert.assertEquals(1, 1);
				  else{
					  if(month<=month1){
						  if(month<month1)
							  Assert.assertEquals(1, 1);
						  else{
							  if(day<=day1)
								  Assert.assertEquals(1, 1);
							  else
								  Assert.assertEquals(1, 0);
						  }
					  }else{
						  Assert.assertEquals(1, 0);
					  }
				  }
			  }else{
				  Assert.assertEquals(1, 0);
			  }
		  }
	   	}catch(Exception e){
	   		LoggerInstance.logger.info("Bull board list by ViewByModeOldToNew failed. "+e);
	   		Assert.fail("Bull board list by ViewByModeOldToNew failed. "+e);
	   }//End catch(Exception e)
	}// End public void ViewByModeOldToNew()
	 /*
	  * Check the bull board list by view by mode (newest to oldest).
	  */
	 @Test(groups={"BrowserCertificationTestCase"}, priority=5)
	 public void ViewByModeNewToOld()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			 HashMap<String,String> hm = new HashMap<String,String>();
			 hm.put("January", "1");
			 hm.put("Februray", "2");
			 hm.put("March", "3");
			 hm.put("April", "4");
			 hm.put("May", "5");
			 hm.put("June", "6");
			 hm.put("July", "7");
			 hm.put("August", "8");
			 hm.put("September", "9");
			 hm.put("October", "10");
			 hm.put("November", "11");
			 hm.put("December", "12");
			 	
			 Thread.sleep(60000);
			 String[] first= bullboardPage.getTextOfDate(1).split(" ");
			 String monthName = hm.get(first[1]);
			 int yr = Integer.parseInt(first[3]);
			 int month = Integer.parseInt(monthName);
			 int day = Integer.parseInt(first[2].replace(",", ""));
			 for(int i=2;i<=10;i++){
				String[] sec=bullboardPage.getTextOfDate(i).split(" ");
				String monthName1 = hm.get(sec[1]);
				int yr1 = Integer.parseInt(sec[3]);
				int month1 = Integer.parseInt(monthName1);
				int day1 = Integer.parseInt(sec[2].replace(",", ""));
				if(yr>=yr1){//year
					if(yr>yr1)
						Assert.assertEquals(1, 1);
					else{
						if(month>=month1){
							if(month>month1)
								Assert.assertEquals(1, 1);
							else{
								if(day>=day1)
									Assert.assertEquals(1, 1);
								else
									Assert.assertEquals(1, 0);
							}
						 }else{
							  Assert.assertEquals(1, 0);
						 }
					}
				  	}else{
				  		Assert.assertEquals(1, 0);
				}
			}
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by ViewByModeNewToOld failed. "+e);
		   		Assert.fail("Bull board list by ViewByModeNewToOld failed. "+e);
	   }//End catch(Exception e)
	}// End public void ViewByModeNewToOld()
	 /*
	  * Check the bull board list by view by mode (Threaded).
	  */
	 @Test(groups={"BrowserCertificationTestCase"}, priority=6)
	 public void ViewByModeThreaded()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 bullboardPage.selectViewMode("Threaded");
			 Thread.sleep(80000);
			 for(int i=1;i<=10;i++){
				 System.out.println("################### "+i);
				 String txt=bullboardPage.getTextOfPostsHead(i);
				 System.out.println("&&&&&&&&&&&&&&&&&&& "+txt);
				 if(txt.contains("RE"))
				 {
					 Assert.assertEquals(1, 0);
				 }
				 else
					 System.out.println("%%%%%%%%%%%%%%%"+i);
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
	 @Test(groups={"BrowserCertificationTestCase"}, priority=7)
	 public void Pagination()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			/// Thread.sleep(90000);
			 System.out.println("@@@@@@@@@@@@@@@@@@@ ");
			 for(int i=1;i<=3;i++){
				 String href= bullboardPage.getHrefOfPagination();
				 System.out.println("111111111111111 "+href+" "+i);
				 bullboardPage.clickOnPagination();
				 Thread.sleep(30000);
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
	 @Test(groups={"BrowserCertificationTestCase"}, priority=8)
	 public void QuoteLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink(1);
			 bullboardPage.clickOnBBNavLink(1);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
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
	 @Test(groups={"BrowserCertificationTestCase"}, priority=9)
	 public void BullBoardLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink(2);
			 bullboardPage.clickOnBBNavLink(2);
			 Thread.sleep(30000);
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
	 @Test(groups={"BrowserCertificationTestCase"}, priority=10)
	 public void NewsLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink(3);
			 bullboardPage.clickOnBBNavLink(3);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
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
	 @Test(groups={"BrowserCertificationTestCase"}, priority=11)
	 public void OpinionLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink(4);
			 bullboardPage.clickOnBBNavLink(4);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by OpinionLink failed. "+e);
		   		Assert.fail("Bull board list by OpinionLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void OpinionLink()
	 /*
	  * Check the bull board page navigation links Level II.
	  */
	 @Test(groups={"BrowserCertificationTestCase"}, priority=12)
	 public void LevelLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String[] txt=bullboardPage.getTextOfBBNavLink(5).split(" ");
			 bullboardPage.clickOnBBNavLink(5);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt[0].toLowerCase()+"2/t.bb/blackberry"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by LevelLink failed. "+e);
		   		Assert.fail("Bull board list by LevelLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void LevelLink()
	 /*
	  * Check the bull board page navigation links ChartsLink.
	  */
	 @Test(groups={"BrowserCertificationTestCase"}, priority=13)
	 public void ChartsLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink(6);
			 bullboardPage.clickOnBBNavLink(6);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by ChartsLink failed. "+e);
		   		Assert.fail("Bull board list by ChartsLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void ChartsLink()
	 /*
	  * Check the bull board page navigation links ProfileLink.
	  */
	 @Test(groups={"BrowserCertificationTestCase"}, priority=14)
	 public void ProfileLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			/// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink(7);
			 bullboardPage.clickOnBBNavLink(7);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
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
	 @Test(groups={"BrowserCertificationTestCase"}, priority=15)
	 public void FinancialLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink(8);
			 bullboardPage.clickOnBBNavLink(8);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
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
	 @Test(groups={"BrowserCertificationTestCase"}, priority=16)
	 public void OptionsLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink(9);
			 bullboardPage.clickOnBBNavLink(9);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
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
	 @Test(groups={"BrowserCertificationTestCase"}, priority=17)
	 public void PriceHistoryLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String[] txt=bullboardPage.getTextOfBBNavLink(10).split(" ");
			 bullboardPage.clickOnBBNavLink(10);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt[1].toLowerCase()+"/t.bb/blackberry"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by PriceHistoryLink failed. "+e);
		   		Assert.fail("Bull board list by PriceHistoryLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void PriceHistoryLink()
	 /*
	  * Check the bull board page navigation links AnalystsLink.
	  */
	 @Test(groups={"BrowserCertificationTestCase"}, priority=18)
	 public void AnalystsLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink(11);
			 bullboardPage.clickOnBBNavLink(11);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by AnalystsLink failed. "+e);
		   		Assert.fail("Bull board list by AnalystsLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void AnalystsLink()
	 /*
	  * Check the bull board page navigation links EarningsLink.
	  */
	 @Test(groups={"BrowserCertificationTestCase"}, priority=19)
	 public void EarningsLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			// Thread.sleep(80000);
			 String txt=bullboardPage.getTextOfBBNavLink(12);
			 bullboardPage.clickOnBBNavLink(12);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by EarningsLink failed. "+e);
		   		Assert.fail("Bull board list by EarningsLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void EarningsLink()
	 /*
	  * Check the bull board page navigation links InsidersLink.
	  */
	 @Test(groups={"BrowserCertificationTestCase"}, priority=20)
	 public void InsidersLink()
	 {
		 try{
			 Bullboard bullboardPage = baseState();
			 String txt=bullboardPage.getTextOfBBNavLink(13);
			 bullboardPage.clickOnBBNavLink(13);
			 Thread.sleep(30000);
			 String url=BrowserInstance.driver.getCurrentUrl();
			
			 if(url.contains(txt.toLowerCase()+"/t.bb/blackberry"))
				 Assert.assertEquals(1, 1);
			 else
				 Assert.assertEquals(1, 0);
		  }catch(Exception e){
		   		LoggerInstance.logger.info("Bull board list by InsidersLink failed. "+e);
		   		Assert.fail("Bull board list by InsidersLink failed. "+e);
	   }//End catch(Exception e)
	}// End public void InsidersLink()

	public Bullboard baseState(){
		BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"companies/bullboard/t.bb/blackberry");
		 try{Thread.sleep(80000);}catch(Exception e){}

		//WebdriverUtility.waitForPageLoaded();
		Bullboard bullboardPage = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
		return bullboardPage;
	}
	
}
