package test;

import java.sql.Driver;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Bullboard;
import pageObjects.FlyinSideBar;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MailinatorInbox;
import pageObjects.ProfilePage;
import pageObjects.RegisterPage;
import pageObjects.RegistrationPage;
import pageObjects.ResetPasswordPage;
import common.BaseSetup;
import common.BrowserInstance;
import common.JavaUtility;
import common.LoggerInstance;
import common.ReadInputData;
import common.WebdriverUtility;

public class RegistryAndLogin extends BaseSetup {

	/*
	 * Check functionality of registration from "Join The Community" on the top of home page.
	 */
	@Test(priority =1)
	public void RegistrationJoinTheCommunity()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 1 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				Thread.sleep(15000);
				homepage.cancelLoading();
				homepage.clickOnJoinTheCommunity();
				Thread.sleep(20000);
				int num=JavaUtility.randInt(1, 10000);
				String mailId="mtest"+num+"@mailinator.com";
				homepage.enterEmailAddressOnJoinCommunityPopup(mailId);
				Thread.sleep(10000);
				homepage.clickOnSubmitBtnOnJoinCommunityPopup();
				Thread.sleep(20000);
				homepage.cancelLoading();
				Assert.assertTrue(homepage.isWelcomeToStockhousePopupExist());
				Assert.assertEquals(homepage.getMailIdInWelcomeStockhousePopup(), mailId);
				Assert.assertTrue(homepage.isResendConfirmationEmailOnWelcomeToStockhousePresent());
				Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "Unverified");
				//BrowserInstance.driver.get("https://www.mailinator.com/inbox2.jsp?public_to=testForForgotPassword#/#public_maildirdiv");
				//BrowserInstance.driver.get("https://mailinator.com/inbox.jsp?public_to=mtest#/#public_maildirdiv"+num);
				BrowserInstance.driver.get("https://www.mailinator.com/inbox2.jsp?public_to=mtest"+num+"#/#public_maildirdiv");
				Thread.sleep(20000);
				MailinatorInbox mailinatorInbox = PageFactory.initElements(BrowserInstance.driver, MailinatorInbox.class);
				mailinatorInbox.clickOnRegistractionRequest();
				
				RegistrationPage registrationPage =mailinatorInbox.clickOnLinkForRegistration();
				Thread.sleep(30000);
				String password=ReadInputData.HM_inputData.get("Password");
				registrationPage.typeAddYourPassword(password);
				registrationPage.typeConfirmYourPassword(password);
				registrationPage.clickOnNextStep();
				Thread.sleep(30000);
				Assert.assertNotNull(registrationPage.getTextOnSecondPage());
				registrationPage.clickOnNextStep();
				Thread.sleep(30000);
				registrationPage.typeDisplayName("mtest"+num);
				registrationPage.clickOnCheckAvailability();
				Thread.sleep(30000);
				Assert.assertEquals("Display Name is available", registrationPage.getTextForCheckAvailabilityResult());
				registrationPage.clickOnNextStep();
				Thread.sleep(10000);
				for (int i=1;i<=4;i++){
					Assert.assertNotNull(registrationPage.getTextOnStepFour(i));
				}
				registrationPage.clickOnNextStep();
				Thread.sleep(30000);
				Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"registration/thank-you");
				homepage.clickOnLogo();
				Thread.sleep(30000);
				Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "mtest"+num);
			}catch(Exception e){
				LoggerInstance.logger.info("Test case RegistrationJoinTheCommunity is failed. "+e); 
				Assert.fail("Test case RegistrationJoinTheCommunity is failed. "+e);
		}//End catch(Exception e)
	}// End public void RegistrationJoinTheCommunity()
	
	/*
	 * Check functionality of registration from "Join The Community" on the Login page.
	 */
	@Test(priority =2)
	public void RegistrationLoginPage()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 2 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"login");
			LoginPage loginPage = PageFactory.initElements(BrowserInstance.driver, LoginPage.class);
			Thread.sleep(15000);
			loginPage.cancelLoading();
			RegisterPage registerPage = loginPage.clickOnJoinTheCommunity();
			int num=JavaUtility.randInt(1, 10000);
			String mailId="mtest"+num+"@mailinator.com";
			registerPage.typeEmail(mailId);
			String password=ReadInputData.HM_inputData.get("Password");
			registerPage.typePassword(password);
			registerPage.clickOnJoinTheCommunity();
			for(int i=1;i<=4;i++){
				Assert.assertNotNull(registerPage.getTxtOnChooseDisplayName(i));
			}
			registerPage.typeUserNameOnChooseDisplayName("mtest"+num);
			registerPage.clickOnCheckAvaibilityOnChooseDisplayName();
			Thread.sleep(20000);
			registerPage.cancelLoading();
			Assert.assertEquals("Name is available!", registerPage.getTxtResultforCheckAvaibilityOnChooseDisplayName());
			registerPage.clickOnSubmitOnChooseDisplayName();
			Thread.sleep(20000);
			registerPage.cancelLoading();
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL"));
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"companies/bullboard/t.bb/blackberry");
			Thread.sleep(20000);
			Bullboard bullboard = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			bullboard.clickOnNewPostButton();
			Thread.sleep(20000);
			registerPage.cancelLoading();
			Assert.assertEquals("Your current email address has not been verified yet. Your access to this feature has been restricted.", bullboard.getTxtForUnverifiedUser());
			BrowserInstance.driver.get("https://mailinator.com/inbox.jsp?to=mtest"+num);
			Thread.sleep(30000);
			MailinatorInbox mailinatorInbox = PageFactory.initElements(BrowserInstance.driver, MailinatorInbox.class);
			mailinatorInbox.clickOnRegistractionRequest();
			Thread.sleep(30000);
			mailinatorInbox.clickOnLinkForRegistration();
			Thread.sleep(30000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"registration/thank-you");
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			homepage.clickOnLogo();
			Thread.sleep(30000);
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "mtest"+num);
			}catch(Exception e){
				LoggerInstance.logger.info("Test case RegistrationLoginPage is failed. "+e); 
				Assert.fail("Test case RegistrationLoginPage is failed. "+e);
		}//End catch(Exception e)
	}// End public void RegistrationLoginPage()
	
	/*
	 *  Check functionality of registration from "Join The Community" on the Flyin side bar.
	 */
	@Test( priority =3)
	public void RegistrationFlyinSideBar()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 3 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			FlyinSideBar flyinSideBar = PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
			Thread.sleep(15000);
			flyinSideBar.cancelLoading();
			flyinSideBar.selectCheckboxes(1);
			flyinSideBar.selectCheckboxes(2);
			String txt1=flyinSideBar.getTxtOfCheckboxes(1);
			String txt2=flyinSideBar.getTxtOfCheckboxes(2);
			int num=JavaUtility.randInt(1, 10000);
			String mailId="mtest"+num+"@mailinator.com";
			flyinSideBar.typeEmailAddress(mailId);
			flyinSideBar.clickSubmitButton();
			Thread.sleep(10000);
			flyinSideBar.cancelLoading();
			if(flyinSideBar.isConfirmEmailAddressPresent()){
				flyinSideBar.typeConfirmEmailAddress(mailId);
				flyinSideBar.clickSubmitButton();
				Thread.sleep(10000);
			}
			Assert.assertTrue(flyinSideBar.isThankYouMessagePresent());
			if(flyinSideBar.getTxtOfYourSelection(1).contains(txt1))
				Assert.assertEquals(1, 1);
			else
				Assert.assertEquals(1, 0);
			if(flyinSideBar.getTxtOfYourSelection(2).contains(txt2))
				Assert.assertEquals(1, 1);
			else
				Assert.assertEquals(1, 0);
			Assert.assertTrue(flyinSideBar.isCrossPresent());
			flyinSideBar.clickOnCross();
			Thread.sleep(10000);
			if(flyinSideBar.getstyleOfFlyinSideBar().contains("display: none;"))
				Assert.assertEquals(1, 1);
			else
				Assert.assertEquals(1, 0);
		//	Assert.assertEquals(flyingSideBar.getstyleOfFlyinSideBar(),"display: none;");
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Assert.assertTrue(homepage.isWelcomeToStockhousePopupExist());
			Assert.assertEquals(homepage.getMailIdInWelcomeStockhousePopup(), mailId);
			Assert.assertTrue(homepage.isResendConfirmationEmailOnWelcomeToStockhousePresent());
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "Unverified");
			BrowserInstance.driver.get("https://www.mailinator.com/inbox2.jsp?public_to=mtest"+num+"#/#public_maildirdiv");
			//BrowserInstance.driver.get("https://mailinator.com/inbox2.jsp#/public_to=mtest"+num);
			                          //  https://mailinator.com/inbox2.jsp#/#public_maildirdiv
			//BrowserInstance.driver.get("https://mailinator.com/inbox.jsp?to=mtest"+num);
			Thread.sleep(10000);
			MailinatorInbox mailinatorInbox = PageFactory.initElements(BrowserInstance.driver, MailinatorInbox.class);
			mailinatorInbox.clickOnRegistractionRequest();
			Thread.sleep(10000);
			RegistrationPage registrationPage =mailinatorInbox.clickOnLinkForRegistration();
			Thread.sleep(10000);
			String password=ReadInputData.HM_inputData.get("Password");
			registrationPage.typeAddYourPassword(password);
			System.out.println("password==="+password);
			registrationPage.typeConfirmYourPassword(password);
			registrationPage.clickOnNextStep();
			Thread.sleep(10000);
			Assert.assertNotNull(registrationPage.getTextOnSecondPage());
			registrationPage.clickOnNextStep();
			Thread.sleep(10000);
			registrationPage.typeDisplayName("mtest"+num);
			registrationPage.clickOnCheckAvailability();
			Thread.sleep(10000);
			Assert.assertEquals("Display Name is available", registrationPage.getTextForCheckAvailabilityResult());
			registrationPage.clickOnNextStep();
			Thread.sleep(10000);
			for (int i=1;i<=4;i++){
				Assert.assertNotNull(registrationPage.getTextOnStepFour(i));
			}
			registrationPage.clickOnNextStep();
			Thread.sleep(10000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"registration/thank-you");
			homepage.clickOnLogo();
			Thread.sleep(10000);
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "mtest"+num);
			}catch(Exception e){
				LoggerInstance.logger.info("Test case RegistrationFlyinSideBar is failed. "+e); 
				Assert.fail("Test case RegistrationFlyinSideBar is failed. "+e);
		}//End catch(Exception e)
	}// End public void RegistrationFlyinSideBar()

	
	/*
	 * Test case to check login functionality from navigation on home page.
	 */
	@Test( priority =4)
	public void SignInFromHomePage()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 4 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(15000);
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
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "testForLogin1");
			FlyinSideBar flyingSideBar = PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
			if(flyingSideBar.getTxtOfCurrentEmailAddressSection().contains("testForLogin@mailinator.com"))
				Assert.assertEquals(1, 1);
			else
				Assert.assertEquals(1, 0);
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case SignInFromHomePage is failed. "+e); 
				Assert.fail("Test case SignInFromHomePage is failed. "+e);
		}//End catch(Exception e)
	}// End public void SignInFromHomePage()
	
//	/*
//	 * Test case to check login functionality from login page.
//	 */
//	@Test( priority =5)
//	public void SignInFromLoginPage()
//	{
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 5 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		try{
//			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"login");
//			Thread.sleep(20000);
//			
//			LoginPage loginPage = PageFactory.initElements(BrowserInstance.driver, LoginPage.class);
//			String username=ReadInputData.HM_inputData.get("UserIdForHomePage");
//			String password=ReadInputData.HM_inputData.get("Password");
//			loginPage.EnterUserName(username);
//			loginPage.EnterPassword(password);
//			loginPage.clickOnSignInBtn();
//			Thread.sleep(15000);
//			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
//			homepage.cancelLoading();
//			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "testForLogin1");
//			FlyinSideBar flyingSideBar = PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
//			Thread.sleep(20000);
//			homepage.cancelLoading();
//			if(flyingSideBar.getTxtOfCurrentEmailAddressSection().contains("testForLogin@mailinator.com"))
//				Assert.assertEquals(1, 1);
//			else
//				Assert.assertEquals(1, 0);
//			Assert.assertTrue(loginPage.isLogoutButtonPresent());
//			
//			}catch(Exception e){
//				LoggerInstance.logger.info("Test case SignInFromLoginPage is failed. "+e); 
//				Assert.fail("Test case SignInFromLoginPage is failed. "+e);
//		}//End catch(Exception e)
//	}// End public void SignInFromLoginPage()
	
	/*
	 * Test case to check functionality of login from Flyin Side bar.
	 */
	@Test( priority =6)
	public void SignInFromFlyinSideBar()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 6 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			FlyinSideBar flyingSideBar = PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
			Thread.sleep(15000); 
			flyingSideBar.cancelLoading();
			flyingSideBar.selectCheckboxes(1);
			flyingSideBar.selectCheckboxes(2);
			String txt1=flyingSideBar.getTxtOfCheckboxes(1);
			String txt2=flyingSideBar.getTxtOfCheckboxes(2);
			flyingSideBar.typeEmailAddress("testForLogin@mailinator.com");
			flyingSideBar.clickSubmitButton();
			Thread.sleep(20000);
			flyingSideBar.cancelLoading();
			String password=ReadInputData.HM_inputData.get("Password");
			flyingSideBar.typePassword(password);
			flyingSideBar.clickSubmitButton();
			Thread.sleep(20000);  
			flyingSideBar.cancelLoading();
			Assert.assertTrue(flyingSideBar.isThankYouForSubscribingPresent());
			if(flyingSideBar.getTxtOfYourSelection(1).contains(txt1))
				Assert.assertEquals(1, 1);
			else
				Assert.assertEquals(1, 0);
			if(flyingSideBar.getTxtOfYourSelection(2).contains(txt2))
				Assert.assertEquals(1, 1);
			else
				Assert.assertEquals(1, 0);
			Assert.assertTrue(flyingSideBar.isCrossPresent());
			flyingSideBar.clickOnCross();
			Thread.sleep(10000);
			if(flyingSideBar.getstyleOfFlyinSideBar().contains("display: none;"))
				Assert.assertEquals(1, 1);
			else
				Assert.assertEquals(1, 0);
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);

			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "testForLogin1");
			}catch(Exception e){
				LoggerInstance.logger.info("Test case SignInFromFlyinSideBar is failed. "+e); 
				Assert.fail("Test case SignInFromFlyinSideBar is failed. "+e);
		}//End catch(Exception e)
	}// End public void SignInFromFlyinSideBar()

	/*
	 * Test case to check login functionality from bullboard page.
	 */
	@Test( priority =7)
	public void SignInFromBullboard()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 7 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"companies/bullboard/t.bb/blackberry");
			Thread.sleep(15000);
			Bullboard bullBoard = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			bullBoard.cancelLoading();
			bullBoard.clickOnNewPostButton();
			Thread.sleep(10000);
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			String username=ReadInputData.HM_inputData.get("UserIdForHomePage");
			String password=ReadInputData.HM_inputData.get("Password");
			homepage.typeUserIdOnSignInPopup(username);
			homepage.typePasswordOnSignInPopup(password);
			homepage.clickOnSignInBtnOnSigninPopup();
			Thread.sleep(20000);
			homepage.cancelLoading();
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "testForLogin1");
			}catch(Exception e){
				LoggerInstance.logger.info("Test case SignInFromBullboard is failed. "+e); 
				Assert.fail("Test case SignInFromBullboard is failed. "+e);
		}//End catch(Exception e)
	}// End public void SignInFromBullboard()
	/*
	 * Test case to check Sign out functionality from navigation on home page.
	 */
	@Test( priority =8)
	public void SignOutFromHomePage()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 8 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(15000);
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
			homepage.clickOnLoggedinUser(5);
			homepage.clickOnLogout();
			Thread.sleep(10000);
			String txt=homepage.getTextOfSignIn();
			Assert.assertEquals(txt, "Sign In");
			}catch(Exception e){
				LoggerInstance.logger.info("Test case SignOutFromHomePage is failed. "+e); 
				Assert.fail("Test case SignOutFromHomePage is failed. "+e);
		}//End catch(Exception e)
	}// End public void SignOutFromHomePage()
	/*
	 * Test case to check sign out functionality from login page.
	 */
	@Test( priority =9)
	public void SignOutFromLoginPage()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 9 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"login");
			Thread.sleep(15000);
			LoginPage loginPage = PageFactory.initElements(BrowserInstance.driver, LoginPage.class);
			loginPage.cancelLoading();
			String username=ReadInputData.HM_inputData.get("UserIdForHomePage");
			String password=ReadInputData.HM_inputData.get("Password");
			loginPage.EnterUserName(username);
			loginPage.EnterPassword(password);
			loginPage.clickOnSignInBtn();
			Thread.sleep(20000);
			loginPage.clickOnLogoutButton();
			Thread.sleep(10000);
			loginPage.cancelLoading();
			Assert.assertTrue(loginPage.isSigninBtnPresent());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case SignOutFromLoginPage is failed. "+e); 
				Assert.fail("Test case SignOutFromLoginPage is failed. "+e);
		}//End catch(Exception e)
	}// End public void SignOutFromLoginPage()
	/*
	 * Test case to check functionality of log out from Flyin Side bar.
	 */
	@Test( priority =10)
	public void SignOutFromFlyinSideBar()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 10 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			FlyinSideBar flyingSideBar = PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(15000);  
			homepage.cancelLoading();
			flyingSideBar.selectCheckboxes(1);
			flyingSideBar.selectCheckboxes(2);
			flyingSideBar.typeEmailAddress("testForLogin@mailinator.com");
			flyingSideBar.clickSubmitButton();
			homepage.cancelLoading();
			String password=ReadInputData.HM_inputData.get("Password");
			flyingSideBar.typePassword(password);
			homepage.scrollUSPressRelease();
			Thread.sleep(5000);  
			flyingSideBar.clickSubmitButton();
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnLoggedinUser(5);
			homepage.clickOnLogout();
			Thread.sleep(10000);
			homepage.cancelLoading();
			String txt=homepage.getTextOfSignIn();
			Assert.assertEquals(txt, "Sign In");
			}catch(Exception e){
				LoggerInstance.logger.info("Test case SignOutFromFlyinSideBar is failed. "+e); 
				Assert.fail("Test case SignOutFromFlyinSideBar is failed. "+e);
		}//End catch(Exception e)
	}// End public void SignInFromFlyinSideBar()
	/*
	 * Test case to check log out functionality from bullboard page.
	 */
	@Test( priority =11)
	public void SignOutFromBullboard()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 11 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"companies/bullboard/t.bb/blackberry");
			Thread.sleep(15000);
			Bullboard bullBoard = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			bullBoard.cancelLoading();
			bullBoard.clickOnNewPostButton();
			Thread.sleep(10000);
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			String username=ReadInputData.HM_inputData.get("UserIdForHomePage");
			String password=ReadInputData.HM_inputData.get("Password");
			homepage.typeUserIdOnSignInPopup(username);
			homepage.typePasswordOnSignInPopup(password);
			homepage.clickOnSignInBtnOnSigninPopup();
			Thread.sleep(20000);
			homepage.cancelLoading();
			homepage.clickOnLoggedinUser(5);
			homepage.clickOnLogout();
			Thread.sleep(10000);
			String txt=homepage.getTextOfSignIn();
			Assert.assertEquals(txt, "Sign In");
			}catch(Exception e){
				LoggerInstance.logger.info("Test case SignOutFromBullboard is failed. "+e); 
				Assert.fail("Test case SignOutFromBullboard is failed. "+e);
		}//End catch(Exception e)
	}// End public void SignInFromBullboard()
	/*
	 * Test case for forgot password.
	 * Go to Sign in and select for I don't know password.
	 * Send mail to email address for recovering forgotten password.
	 */
	@Test( priority =12)
	public void HomePageForgotPassword()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 12 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			MailinatorInbox mailinator= PageFactory.initElements(BrowserInstance.driver, MailinatorInbox.class);
			ResetPasswordPage resetPassword= PageFactory.initElements(BrowserInstance.driver, ResetPasswordPage.class);
			
			Thread.sleep(15000);
			homepage.cancelLoading();
			homepage.clickOnSignIn();
			Thread.sleep(10000);
			homepage.typeUserIdOnSignInPopup("testForForgotPassword@mailinator.com");
			Thread.sleep(5000);
			homepage.clickOnForgotPassword();
			Thread.sleep(10000);
			homepage.clickOnSubmitForgotPassword();
			Thread.sleep(10000);
			String txt=homepage.getTextOfResetPasswordMsg();
			Assert.assertNotNull(txt);
			//homepage.clickOnResetPasswordClose();
			Thread.sleep(10000);

			//
			BrowserInstance.driver.get("https://www.mailinator.com/inbox2.jsp?public_to=testForForgotPassword#/#public_maildirdiv");
			mailinator.clickOnForgotPasswordRequest();
			Thread.sleep(10000);
			mailinator.clickOnLinkForGenerateNewPassword();
			Thread.sleep(20000);
			resetPassword.putTextInNewPasswordBox("M()dak11");
			resetPassword.putTextInConfirmNewPasswordBox("M()dak11");
			resetPassword.clickOnResetButton();
			Thread.sleep(20000);

			//
			homepage.clickOnSignIn();
			Thread.sleep(10000);
			homepage.typeUserIdOnSignInPopup("testForForgotPassword@mailinator.com");
			homepage.typePasswordOnSignInPopup("M()dak11");
			
			try {
				homepage.clickOnSignInBtnOnSigninPopup();
			} catch (UnhandledAlertException f) {
			    try {
			        Alert alert = BrowserInstance.driver.switchTo().alert();
			        String alertText = alert.getText();
			        System.out.println("Alert data: " + alertText);
			        alert.accept();
			    } catch (NoAlertPresentException e) {
			        e.printStackTrace();
			    }
			}
			Thread.sleep(10000);
//			 try {
//			        Alert alert = BrowserInstance.driver.switchTo().alert();
//			        String alertText = alert.getText();
//			        System.out.println("Alert data: " + alertText);
//			        alert.accept();
//			    } catch (NoAlertPresentException e) {
//			        e.printStackTrace();
//			    }
			Thread.sleep(20000);
			homepage.cancelLoading();
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "forgotPassword");
			
			// Reset the changes.
			homepage.clickOnLoggedinUser(5);
			homepage.clickOnLogout();
			resetPasswordHomePage();
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case HomePageForgotPassword is failed. "+e); 
				Assert.fail("Test case HomePageForgotPassword is failed. "+e);
		}//End catch(Exception e)
	}// End public void HomePageForgotPassword()
	/*
	 * Test case for forgot password for login page.
	 * Go to Login page and select for forgot password.
	 * Send mail to email address for recovering forgotten password.
	 */
	@Test( priority =13)
	public void LoginPageForgotPassword()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 13 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			LoginPage loginPage = PageFactory.initElements(BrowserInstance.driver, LoginPage.class);
			ResetPasswordPage resetPassword= PageFactory.initElements(BrowserInstance.driver, ResetPasswordPage.class);
			
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"login");
			Thread.sleep(15000);
			loginPage.cancelLoading();
			loginPage.EnterUserName("testForForgotPassword@mailinator.com");
			loginPage.clickOnForgotPassword();
			Thread.sleep(10000);
			loginPage.putResetPwdUserName("testForForgotPassword@mailinator.com");
			loginPage.clickOnSendPassword();
			
			String txt=loginPage.getTextOfResetPasswordMsg();
			Assert.assertNotNull(txt);
			Thread.sleep(10000);
			//
			BrowserInstance.driver.get("https://www.mailinator.com/inbox2.jsp?public_to=testForForgotPassword#/#public_maildirdiv");
			MailinatorInbox mailinator= PageFactory.initElements(BrowserInstance.driver, MailinatorInbox.class);
			mailinator.clickOnForgotPasswordRequest();
			Thread.sleep(10000);
			mailinator.clickOnLinkForGenerateNewPassword();
			Thread.sleep(30000);
			resetPassword.putTextInNewPasswordBox("M()dak11");
			resetPassword.putTextInConfirmNewPasswordBox("M()dak11");
			resetPassword.clickOnResetButton();
			resetPassword.clickOnThisPageLink();
			Thread.sleep(40000);
			//
			loginPage.EnterUserName("testForForgotPassword@mailinator.com");
			loginPage.EnterPassword("M()dak11");
			loginPage.clickOnSignInBtn();
			Thread.sleep(20000);
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "forgotPassword");
			// Reset the changes.
//			homepage.clickOnLoggedinUser(5);
//			Thread.sleep(2000);
//			homepage.clickOnLogout();
			loginPage.clickOnLogoutButton();
			Thread.sleep(2000);
			resetPasswordLoginPage();
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case LoginPageForgotPassword is failed. "+e); 
				Assert.fail("Test case LoginPageForgotPassword is failed. "+e);
		}//End catch(Exception e)
	}// End public void LoginPageForgotPassword()
	
	/*
	 * Test case for check my profile for a user.
	 * Go to Login page and do login.
	 * Click on View profile page and verify name and my profile information.
	 */
	@Test( priority =14)
	public void ViewProfile()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 14 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			LoginPage loginPage = PageFactory.initElements(BrowserInstance.driver, LoginPage.class);
			
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"login");
			Thread.sleep(15000);
			loginPage.cancelLoading();
			String username=ReadInputData.HM_inputData.get("UserId");
			String password=ReadInputData.HM_inputData.get("Password");
			loginPage.EnterUserName(username);
			loginPage.EnterPassword(password);
			loginPage.clickOnSignInBtn();
			Thread.sleep(20000);
			loginPage.cancelLoading();
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			homepage.clickOnLoggedinUser(5);
			ProfilePage profilePage= homepage.clickOnMyProfile();
			Thread.sleep(20000);
			Assert.assertTrue(profilePage.isUserNameInHeaderPresent(username));
			Assert.assertTrue(profilePage.isMyProfilePresent());
			Assert.assertTrue(profilePage.isMyProfileDetailsPresent());
			Assert.assertTrue(profilePage.isAboutMePresent());
			Assert.assertTrue(profilePage.isMyRatingPresent());
			Assert.assertTrue(profilePage.isConnectionsPresent());
			}catch(Exception e){
				LoggerInstance.logger.info("Test case LoginPageForgotPassword is failed. "+e); 
				Assert.fail("Test case LoginPageForgotPassword is failed. "+e);
		}//End catch(Exception e)
	}// End public void LoginPageForgotPassword()
	/*
	 * Function for resetting the password.
	 */
		public void resetPasswordHomePage(){
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			MailinatorInbox mailinator= PageFactory.initElements(BrowserInstance.driver, MailinatorInbox.class);
			ResetPasswordPage resetPassword= PageFactory.initElements(BrowserInstance.driver, ResetPasswordPage.class);
			try{
				
				homepage.clickOnSignIn();
				Thread.sleep(10000);
				homepage.typeUserIdOnSignInPopup("testForForgotPassword@mailinator.com");
				Thread.sleep(5000);
				homepage.clickOnForgotPassword();
				Thread.sleep(10000);
				homepage.clickOnSubmitForgotPassword();
				Thread.sleep(10000);
				 String txt=homepage.getTextOfResetPasswordMsg();
				Assert.assertNotNull(txt);
				//homepage.clickOnResetPasswordClose();
				Thread.sleep(10000);
				//
				BrowserInstance.driver.get("https://www.mailinator.com/inbox2.jsp?public_to=testForForgotPassword#/#public_maildirdiv");
				//homepage.switchToNewWindow();
				mailinator.clickOnForgotPasswordRequest();
				Thread.sleep(10000);
				mailinator.clickOnLinkForGenerateNewPassword();
				Thread.sleep(20000);
				String password=ReadInputData.HM_inputData.get("Password");
				Thread.sleep(30000);
				mailinator.switchToNewWindow();
				resetPassword.putTextInNewPasswordBox(password);
				resetPassword.putTextInConfirmNewPasswordBox(password);
				resetPassword.clickOnResetButton();
				Thread.sleep(10000);
				//
				homepage.clickOnSignIn();
				Thread.sleep(10000);
				homepage.typeUserIdOnSignInPopup("testForForgotPassword@mailinator.com");
				homepage.typePasswordOnSignInPopup(password);
				Thread.sleep(10000);
				try {
					homepage.clickOnSignInBtnOnSigninPopup();
				} catch (UnhandledAlertException f) {
//				    try {
//				        Alert alert = BrowserInstance.driver.switchTo().alert();
//				        String alertText = alert.getText();
//				        System.out.println("Alert data: " + alertText);
//				        alert.accept();
//				    } catch (NoAlertPresentException e) {
//				        e.printStackTrace();
//				    }
				}
				Thread.sleep(10000);
				 try {
				        Alert alert = BrowserInstance.driver.switchTo().alert();
				        String alertText = alert.getText();
				        System.out.println("Alert data: " + alertText);
				        alert.accept();
				    } catch (NoAlertPresentException e) {
				        e.printStackTrace();
				    }
				Thread.sleep(20000);
				homepage.cancelLoading();
				Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "forgotPassword");
			}catch(Exception e){}
	}
    public void resetPasswordLoginPage(){
    	try{
    		LoginPage loginPage = PageFactory.initElements(BrowserInstance.driver, LoginPage.class);
			ResetPasswordPage resetPassword= PageFactory.initElements(BrowserInstance.driver, ResetPasswordPage.class);
			
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"login");
			Thread.sleep(30000);
			loginPage.EnterUserName("testForForgotPassword@mailinator.com");
			loginPage.clickOnForgotPassword();
			Thread.sleep(10000);
			loginPage.putResetPwdUserName("testForForgotPassword@mailinator.com");
			loginPage.clickOnSendPassword();
			String txt=loginPage.getTextOfResetPasswordMsg();
			Assert.assertNotNull(txt);
			Thread.sleep(10000);
			//
			BrowserInstance.driver.get("https://www.mailinator.com/inbox2.jsp?public_to=testForForgotPassword#/#public_maildirdiv");
			MailinatorInbox mailinator= PageFactory.initElements(BrowserInstance.driver, MailinatorInbox.class);
			mailinator.clickOnForgotPasswordRequest();
			Thread.sleep(10000);
			mailinator.clickOnLinkForGenerateNewPassword();
			Thread.sleep(20000);
			String password=ReadInputData.HM_inputData.get("Password");
			Thread.sleep(20000);
			mailinator.switchToNewWindow();
//			ArrayList<String> tabs2 = new ArrayList<String> (BrowserInstance.driver.getWindowHandles());
//			BrowserInstance.driver.switchTo().window(tabs2.get(1));
			resetPassword.putTextInNewPasswordBox(password);
			resetPassword.putTextInConfirmNewPasswordBox(password);
			resetPassword.clickOnResetButton();
			resetPassword.clickOnThisPageLink();
			Thread.sleep(30000);
			//
			loginPage.EnterUserName("testForForgotPassword@mailinator.com");
			loginPage.EnterPassword(password);
			loginPage.clickOnSignInBtn();
			Thread.sleep(20000);
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "forgotPassword");
    	}catch(Exception e){}
    }
}
