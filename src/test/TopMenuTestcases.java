package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.IgnoreListPage;
import pageObjects.InboxPage;
import pageObjects.MessagePage;
import pageObjects.PortfolioPage;
import common.BaseSetup;
import common.BrowserInstance;
import common.JavaUtility;
import common.LoggerInstance;
import common.ReadInputData;
import common.WebdriverUtility;

public class TopMenuTestcases extends BaseSetup {
	
	/*
	 * Use-Case :Verify the messages icon working
	 * Test-Case :"1. Go to test.stpckhouse.com
					2. Login as a user
					3. Click on ""Messages"" Icon in the member bar"
	 */
	@Test(priority =1)
	public void MessageIcon()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 1 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			String username=ReadInputData.HM_inputData.get("UserId");
			String password=ReadInputData.HM_inputData.get("Password");
			SignIn(username,password);
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "kallol1");
			
			MessagePage messagePage = PageFactory.initElements(BrowserInstance.driver, MessagePage.class);
			homepage.clickOnTopMenuOptions(4); //messages
			Thread.sleep(20000);
			homepage.cancelLoading();
			String[] url=BrowserInstance.driver.getCurrentUrl().split("com/");
			Assert.assertEquals(url[1],"members/profile/messages");
			Assert.assertTrue(messagePage.isHeadOnMessagePagePresent());
			Assert.assertTrue(messagePage.isNewMessageLinkPresent());
			
		}catch(Exception e){
			LoggerInstance.logger.info("Test case RegistrationJoinTheCommunity is failed. "+e); 
			Assert.fail("Test case RegistrationJoinTheCommunity is failed. "+e);
		}//End catch(Exception e)
	}// End public void MessageIcon()
	/*
	 * Use-Case :Verify sending "New Message".
	 * Test-Case :1. Go to test.stpckhouse.com & Login as a User
				  2. Click on ""Messages"" Icon.
				  3. Click on ""New Message"" Link
				  4. Enter Valid Username (usrQA2 or usrQA1) in To text field
				  5. Enter Subject
				  6. Enter TEXT in the text area
				  7. Click on ""SEND"" button
	 */
	@Test(priority =2)
	public void NewMessage()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 2 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			String username=ReadInputData.HM_inputData.get("UserId");
			String password=ReadInputData.HM_inputData.get("Password");
			SignIn(username,password);
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "kallol1");
			MessagePage messagePage = PageFactory.initElements(BrowserInstance.driver, MessagePage.class);
			homepage.clickOnTopMenuOptions(4); //message icon
			Thread.sleep(20000);
			homepage.cancelLoading();
			messagePage.clickOnNewMessageLink();
			homepage.cancelLoading();
			InboxPage inbox = PageFactory.initElements(BrowserInstance.driver, InboxPage.class);
			inbox.putTextInReceiverTextBox("usrQA2");
			inbox.putTextInSubjectTextBox("This is subject testing");
			inbox.putTextInMsgTextBox("This is Message testing");
			inbox.clickOnSendBtn();
			Thread.sleep(20000);
			String txt=messagePage.getTextOfSuccessMsg();
			Assert.assertEquals(txt,"Message has been successfully sent.");
		}catch(Exception e){
			LoggerInstance.logger.info("Test case NewMessage is failed. "+e); 
			Assert.fail("Test case NewMessage is failed. "+e);
		}//End catch(Exception e)
	}// End public void NewMessage()
	/*
	 * Use-Case :Verify the "DELETE" message.(inbox)
	 * Test-Case :  1. Go to test.stpckhouse.com & Login as a user
					2. Click on ""Messages"" Icon.
					3. Click on ""DELETE"" ICON
					4. Click on OK in Cancellation authentication pop-up.
	 */
	@Test(priority =3)
	public void DeleteMessage()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 3 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(10000);
			homepage.cancelLoading();
			String username=ReadInputData.HM_inputData.get("UserId");
			String password=ReadInputData.HM_inputData.get("Password");
			SignIn(username,password);
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "kallol1");
			MessagePage messagePage = PageFactory.initElements(BrowserInstance.driver, MessagePage.class);
			homepage.clickOnTopMenuOptions(4); //message icon
			Thread.sleep(20000);
			homepage.cancelLoading();
			
			messagePage.clickOnNewMessageLink();
			homepage.cancelLoading();
			InboxPage inbox = PageFactory.initElements(BrowserInstance.driver, InboxPage.class);
			inbox.putTextInReceiverTextBox("usrQA1");
			inbox.putTextInSubjectTextBox("This is subject for deleting.");
			inbox.putTextInMsgTextBox("This is Message for deleting.");
			inbox.clickOnSendBtn();
			String txtSuccess=messagePage.getTextOfSuccessMsg();
			Assert.assertEquals(txtSuccess,"Message has been successfully sent.");
			homepage.clickOnLoggedinUser(5);
			homepage.clickOnLogout();
			username=ReadInputData.HM_inputData.get("UserIdForQA");
			password=ReadInputData.HM_inputData.get("Password");
			SignIn(username,password);//"usrQA1","M()dak12"
			homepage.clickOnTopMenuOptions(4); //message icon
			
			messagePage.clickOnDeleteViewInMsgList(2,"delete"); //inbox
			homepage.AlertExistsAndAccepted(2000);
			Thread.sleep(20000);
			String txtdelete=messagePage.getTextOfSuccessMsg();
			Assert.assertEquals(txtdelete,"Message has been successfully deleted.");
		}catch(Exception e){
			LoggerInstance.logger.info("Test case DeleteMessage is failed. "+e); 
			Assert.fail("Test case DeleteMessage is failed. "+e);
		}//End catch(Exception e)
	}// End public void DeleteMessage()
	/*
	 * Use-Case :Verify the "VIEW" message functionality.(inbox)
	 * Test-Case : 1. Go to test.stockhouse.com & Login as a user
					2. Click on ""Messages"" Icon.
					3. Click on VIEW icon.
	 */
	@Test(priority =4)
	public void ViewMessage()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 4 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(10000);
			homepage.cancelLoading();
			String username=ReadInputData.HM_inputData.get("UserId");
			String password=ReadInputData.HM_inputData.get("Password");
			SignIn(username,password);
			
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "kallol1");
			MessagePage messagePage = PageFactory.initElements(BrowserInstance.driver, MessagePage.class);
			homepage.clickOnTopMenuOptions(4); //message icon
			Thread.sleep(20000);
			homepage.cancelLoading();
			
			messagePage.clickOnNewMessageLink();
			homepage.cancelLoading();
			InboxPage inbox = PageFactory.initElements(BrowserInstance.driver, InboxPage.class);
			inbox.putTextInReceiverTextBox("usrQA1");
			inbox.putTextInSubjectTextBox("This is subject for viewing message.");
			inbox.putTextInMsgTextBox("This is Message for viewing message.");
			inbox.clickOnSendBtn();
			String txtSuccess=messagePage.getTextOfSuccessMsg();
			Assert.assertEquals(txtSuccess,"Message has been successfully sent.");
			homepage.clickOnLoggedinUser(5);
			homepage.clickOnLogout();
			username=ReadInputData.HM_inputData.get("UserIdForQA");
			password=ReadInputData.HM_inputData.get("Password");
			SignIn(username,password);
			homepage.clickOnTopMenuOptions(4); //message icon
			
			messagePage.clickOnDeleteViewInMsgList(2,"view");
			Thread.sleep(10000);
			Assert.assertNotNull(inbox.isViewMsgWindowTextPresent());
			Assert.assertTrue(inbox.isViewMsgWindowHeadPresent());
			
		}catch(Exception e){
			LoggerInstance.logger.info("Test case ViewMessage is failed. "+e); 
			Assert.fail("Test case ViewMessage is failed. "+e);
		}//End catch(Exception e)
	}// End public void ViewMessage()
	/*
	 * Use-Case :Verify that the message sent is displayed in the outbox.
	 * Test-Case : 1. Go to test.stockhouse.com 
				   2. login as a user 
	 			   3. Click on message sign at top profile bar.
				   4. Click Outbox tab
	 */
	@Test(priority =5)
	public void SentMessage()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 5 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(10000);
			homepage.cancelLoading();
			
			String username=ReadInputData.HM_inputData.get("UserId");
			String password=ReadInputData.HM_inputData.get("Password");
			SignIn(username,password);

			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "kallol1");
			MessagePage messagePage = PageFactory.initElements(BrowserInstance.driver, MessagePage.class);
			homepage.clickOnTopMenuOptions(4); //message icon
			Thread.sleep(20000);
			homepage.cancelLoading();
			messagePage.clickOnNewMessageLink();
			InboxPage inbox = PageFactory.initElements(BrowserInstance.driver, InboxPage.class);
			inbox.putTextInReceiverTextBox("usrQA2");
			inbox.putTextInSubjectTextBox("This is sent subject testing");
			inbox.putTextInMsgTextBox("This is sent message testing");
			inbox.clickOnSendBtn();
			Thread.sleep(20000);
			messagePage.clickOnMsgControlTabs(5); //outbox
			Thread.sleep(10000);
			String txt=messagePage.getMsgTextInMsgList(2,4);
			Assert.assertEquals(txt, "This is sent subject testing");
			
		}catch(Exception e){
			LoggerInstance.logger.info("Test case SentMessage is failed. "+e); 
			Assert.fail("Test case SentMessage is failed. "+e);
		}//End catch(Exception e)
	}// End public void SentMessage()
	/*
	 * Use-Case : Verify the "My Portfolio" link is working.
	 * Test-Case : 1. Go to test.stockhouse.com
					2. Login with any user
					3. Click on "My Portfolio" tab.
	 */
	@Test(priority =6)
	public void Portfolio()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 6 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(10000);
			homepage.cancelLoading();
			String username=ReadInputData.HM_inputData.get("UserIdForHomePage"); //("UserIdForArsalan");
			String password=ReadInputData.HM_inputData.get("Password"); //("PasswordForArsalan");
			SignIn(username,password);

			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "testForLogin1");//"arsalan7u");
			homepage.clickOnTopMenuOptions(3); //My portfolio icon
			Thread.sleep(20000);
			String url=BrowserInstance.driver.getCurrentUrl();
			if(url.contains("portfolio"))
				Assert.assertEquals(1,1);
			else
				Assert.assertEquals(1,0);
			PortfolioPage portfolio = PageFactory.initElements(BrowserInstance.driver, PortfolioPage.class);
			Thread.sleep(20000);
			System.out.println("portfolio.isPortfolioTxtPresent()==="+portfolio.isPortfolioTxtPresent());
			//Assert.assertTrue(portfolio.isPortfolioTxtPresent());
//			System.out.println("portfolio.isPortfolioTxtPresent()==="+portfolio.isPortfolioTxtPresent());
			if(portfolio.isPortfolioTxtPresent()){
				Assert.assertEquals(1, 1);
			}else{
				Assert.assertEquals(1,0);
			}
			
		
		}catch(Exception e){
			LoggerInstance.logger.info("Test case Portfolio is failed. "+e); 
			Assert.fail("Test case Portfolio is failed. "+e);
		}//End catch(Exception e)
	}// End public void Portfolio()
	
	public void SignIn(String userName, String password){
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(30000);
			homepage.clickOnSignIn();
			Thread.sleep(10000);
			homepage.typeUserIdOnSignInPopup(userName); 
			homepage.typePasswordOnSignInPopup(password);
			homepage.clickOnSignInBtnOnSigninPopup();
			Thread.sleep(20000);
			//Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "kallol1");
		
		}catch(Exception e){}
	}
}
