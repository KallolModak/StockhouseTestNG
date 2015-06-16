package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import common.BaseSetup;
import common.BrowserInstance;
import common.LoggerInstance;
import common.ReadInputData;
import common.WebdriverUtility;

import pageObjects.Bullboard;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class BullBoardTestcases extends BaseSetup {
	private LoginPage loginPage;
	private String jobName,reportName,frquency,jobType,selectTask;
	

	@Test(groups={"BrowserCertificationTestCase"}, priority=3)
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
	@Test(groups={"BrowserCertificationTestCase"}, priority=4)
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
			bullboardPage.clickOnNewPostButton();
			Thread.sleep(20000);
			bullboardPage.typeSubject("Test");
			bullboardPage.typeMessage("TestMessage");
			bullboardPage.clickOnPost();
			}catch(Exception e){
				LoggerInstance.logger.info("New post functionality failed. "+e);
			Assert.fail("New post functionality failed. "+e);
		}//End catch(Exception e)
	}// End public void Job_TC_5()
	
//	


	/*
	 * Check add to favorite and remove from favorite.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=5)
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

	
	
	public Bullboard baseState(){
		BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"/companies/bullboard/t.bb/blackberry");
		WebdriverUtility.waitForPageLoaded();
		Bullboard bullboardPage = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
		return bullboardPage;
	}
	
}
