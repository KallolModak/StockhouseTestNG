package test;



import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BrowserInstance;
import common.LoggerInstance;
import common.ReadInputData;
import pageObjects.GmailUtility;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchListPage;

public class Testcases {
 private LoginPage loginPage; 
 private HomePage homePage;
 private SearchListPage searchListPage;
 private GmailUtility gmailUtility;
 /*
  * Login to the application.
  */
 @Test(groups={"Regression Test"}, priority=1)
 public void Login()
 {
  try
  {
   loginPage = PageFactory.initElements(BrowserInstance.driver, LoginPage.class);
   loginPage.login();
   homePage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
   homePage.clickOnSearchListing();
   searchListPage = PageFactory.initElements(BrowserInstance.driver, SearchListPage.class);
   String propertyAddress=searchListPage.getPropertyText(1);
   String[] forGmailOperation = propertyAddress.split("\n");
   
   System.out.println("###############3 "+forGmailOperation[0]);
   searchListPage.selectProperty(1);
   searchListPage.clickRequestShowing();
   searchListPage.clickOnNext();
   searchListPage.typeIntoMessageBox("hello");
   searchListPage.clickOnsend();
   searchListPage.clickOkOnShowingRequestSent();
   gmailUtility = PageFactory.initElements(BrowserInstance.driver, GmailUtility.class);
   gmailUtility.typeEmail(ReadInputData.HM_inputData.get("EmailId"));
   gmailUtility.typePassword(ReadInputData.HM_inputData.get("EmailPassword"));
   gmailUtility.clickSignin();
   Thread.sleep(120000);
   
   for (int i=1;i<=2;i++)
   {
	   String emailSubject = gmailUtility.getTextOfEmailSubject(i);
   		if (emailSubject.contains("Request to show "+forGmailOperation[0]))
   		{
   			gmailUtility.openEmail(i);
   		}
   	}
   //System.out.println("@@@@@@@@@@@@@@@ "+gmailUtility.getTextOfEmailSubject());
   
   try{
	Thread.sleep(2000);   
   }catch(Exception e){}
   
  }catch(Exception e){
   LoggerInstance.logger.info("Failed to login to the application "+e);
   Assert.fail("Failed to login to the application "+e);
  }//End catch(Exception e)
 }// End Login()
 
 
 

 
}