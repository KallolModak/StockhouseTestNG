package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Bullboard;
import pageObjects.FlyinSideBar;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MailinatorInbox;
import pageObjects.RegisterPage;
import pageObjects.RegistrationPage;

import common.BaseSetup;
import common.BrowserInstance;
import common.JavaUtility;
import common.LoggerInstance;
import common.ReadInputData;

public class RegistryAndLogin extends BaseSetup {

	/*
	 * Check functionality of registration from "Join The Community" on the top of home page.
	 */
	@Test(priority =1)
	public void RegistrationJoinTheCommunity()
	{
		
		try{
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Thread.sleep(30000);
			homepage.clickOnJoinTheCommunity();
			Thread.sleep(10000);
			int num=JavaUtility.randInt(1, 10000);
			String mailId="mtest"+num+"@mailinator.com";
			homepage.enterEmailAddressOnJoinCommunityPopup(mailId);
			Thread.sleep(10000);
			homepage.clickOnSubmitBtnOnJoinCommunityPopup();
			Thread.sleep(10000);
			Assert.assertTrue(homepage.isWelcomeToStockhousePopupExist());
			Assert.assertEquals(homepage.getMailIdInWelcomeStockhousePopup(), mailId);
			Assert.assertTrue(homepage.isResendConfirmationEmailOnWelcomeToStockhousePresent());
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "Unverified");
			BrowserInstance.driver.get("https://mailinator.com/inbox.jsp?to=mtest"+num);
			Thread.sleep(10000);
			MailinatorInbox mailinatorInbox = PageFactory.initElements(BrowserInstance.driver, MailinatorInbox.class);
			mailinatorInbox.clickOnRegistractionRequest();
			Thread.sleep(10000);
			RegistrationPage registrationPage =mailinatorInbox.clickOnLinkForRegistration();
			Thread.sleep(10000);
			registrationPage.typeAddYourPassword("M()dak12");
			registrationPage.typeConfirmYourPassword("M()dak12");
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
				LoggerInstance.logger.info("Test case RegistrationJoinTheCommunity is failed. "+e); 
				Assert.fail("Test case RegistrationJoinTheCommunity is failed. "+e);
		}//End catch(Exception e)
	}// End public void RegistrationJoinTheCommunity()

	
	
	/*
	 * Check functionality of registration from "Join The Community" on the Login page.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority =2)
	public void RegistrationLoginPage()
	{
		
		try{
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"login");
			LoginPage loginPage = PageFactory.initElements(BrowserInstance.driver, LoginPage.class);
			Thread.sleep(30000);
			RegisterPage registerPage = loginPage.clickOnJoinTheCommunity();
			int num=JavaUtility.randInt(1, 10000);
			String mailId="mtest"+num+"@mailinator.com";
			registerPage.typeEmail(mailId);
			registerPage.typePassword("M()dak12");
			registerPage.clickOnJoinTheCommunity();
			for(int i=1;i<=4;i++){
				Assert.assertNotNull(registerPage.getTxtOnChooseDisplayName(i));
			}
			registerPage.typeUserNameOnChooseDisplayName("mtest"+num);
			registerPage.clickOnCheckAvaibilityOnChooseDisplayName();
			Thread.sleep(5000);
			Assert.assertEquals("Name is available!", registerPage.getTxtResultforCheckAvaibilityOnChooseDisplayName());
			registerPage.clickOnSubmitOnChooseDisplayName();
			Thread.sleep(10000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL"));
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"companies/bullboard/t.bb/blackberry");
			Thread.sleep(10000);
			Bullboard bullboard = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			bullboard.clickOnNewPostButton();
			Thread.sleep(10000);
			Assert.assertEquals("Your current email address has not been verified yet. Your access to this feature has been restricted.", bullboard.getTxtForUnverifiedUser());
			BrowserInstance.driver.get("https://mailinator.com/inbox.jsp?to=mtest"+num);
			Thread.sleep(10000);
			MailinatorInbox mailinatorInbox = PageFactory.initElements(BrowserInstance.driver, MailinatorInbox.class);
			mailinatorInbox.clickOnRegistractionRequest();
			Thread.sleep(10000);
			mailinatorInbox.clickOnLinkForRegistration();
			Thread.sleep(10000);
			Assert.assertEquals(BrowserInstance.driver.getCurrentUrl(),ReadInputData.HM_inputData.get("URL")+"registration/thank-you");
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			homepage.clickOnLogo();
			Thread.sleep(10000);
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "mtest"+num);
			
			
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case RegistrationLoginPage is failed. "+e); 
				Assert.fail("Test case RegistrationLoginPage is failed. "+e);
		}//End catch(Exception e)
	}// End public void RegistrationLoginPage()
	
	/*
	 *  Check functionality of registration from "Join The Community" on the Flyin side bar.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority =3)
	public void RegistrationFlyinSideBar()
	{
		
		try{
			FlyinSideBar flyinSideBar = PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
			Thread.sleep(30000);
			flyinSideBar.selectCheckboxes(1);
			flyinSideBar.selectCheckboxes(2);
			String txt1=flyinSideBar.getTxtOfCheckboxes(1);
			String txt2=flyinSideBar.getTxtOfCheckboxes(2);
			int num=JavaUtility.randInt(1, 10000);
			String mailId="mtest"+num+"@mailinator.com";
			flyinSideBar.typeEmailAddress(mailId);
			flyinSideBar.clickSubmitButton();
			Thread.sleep(10000);
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
			System.out.println("###################### "+flyinSideBar.getstyleOfFlyinSideBar());
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
			BrowserInstance.driver.get("https://mailinator.com/inbox.jsp?to=mtest"+num);
			Thread.sleep(10000);
			MailinatorInbox mailinatorInbox = PageFactory.initElements(BrowserInstance.driver, MailinatorInbox.class);
			mailinatorInbox.clickOnRegistractionRequest();
			Thread.sleep(10000);
			RegistrationPage registrationPage =mailinatorInbox.clickOnLinkForRegistration();
			Thread.sleep(10000);
			registrationPage.typeAddYourPassword("M()dak12");
			registrationPage.typeConfirmYourPassword("M()dak12");
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
	@Test(groups={"BrowserCertificationTestCase"}, priority =4)
	public void SignInFromHomePage()
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
	
	/*
	 * Test case to check login functionality from login page.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority =5)
	public void SignInFromLoginPage()
	{
		
		try{
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"login");
			Thread.sleep(20000);
			LoginPage loginPage = PageFactory.initElements(BrowserInstance.driver, LoginPage.class);
			loginPage.EnterUserName("testForLogin@mailinator.com");
			loginPage.EnterPassword("M()dak12");
			loginPage.clickOnSignInBtn();
			Thread.sleep(20000);
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "testForLogin1");
			FlyinSideBar flyingSideBar = PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
			if(flyingSideBar.getTxtOfCurrentEmailAddressSection().contains("testForLogin@mailinator.com"))
				Assert.assertEquals(1, 1);
			else
				Assert.assertEquals(1, 0);
			Assert.assertTrue(loginPage.isLogoutButtonPresent());
			
			}catch(Exception e){
				LoggerInstance.logger.info("Test case SignInFromLoginPage is failed. "+e); 
				Assert.fail("Test case SignInFromLoginPage is failed. "+e);
		}//End catch(Exception e)
	}// End public void SignInFromLoginPage()
	
	/*
	 * Test case to check functionality of login from Slyin bar.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority =6)
	public void SignInFromFlyinSideBar()
	{
		try{
			FlyinSideBar flyingSideBar = PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
			Thread.sleep(30000);  
			flyingSideBar.selectCheckboxes(1);
			flyingSideBar.selectCheckboxes(2);
			String txt1=flyingSideBar.getTxtOfCheckboxes(1);
			String txt2=flyingSideBar.getTxtOfCheckboxes(2);
			flyingSideBar.typeEmailAddress("testForLogin@mailinator.com");
			flyingSideBar.clickSubmitButton();
			Thread.sleep(5000);  
			flyingSideBar.typePassword("M()dak12");
			flyingSideBar.clickSubmitButton();
			Thread.sleep(40000);  
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
			System.out.println("###################### "+flyingSideBar.getstyleOfFlyinSideBar());
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
	@Test(groups={"BrowserCertificationTestCase"}, priority =6)
	public void SignInFromBullboard()
	{
		try{
			BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"companies/bullboard/t.bb/blackberry");
			Thread.sleep(40000);
			Bullboard bullBoard = PageFactory.initElements(BrowserInstance.driver, Bullboard.class);
			bullBoard.clickOnNewPostButton();
			Thread.sleep(10000);
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			homepage.typeUserIdOnSignInPopup("testForLogin@mailinator.com");
			homepage.typePasswordOnSignInPopup("M()dak12");
			homepage.clickOnSignInBtnOnSigninPopup();
			Thread.sleep(20000);
			Assert.assertEquals(homepage.getTxtOfLoggedinUser(), "testForLogin1");
			}catch(Exception e){
				LoggerInstance.logger.info("Test case SignInFromBullboard is failed. "+e); 
				Assert.fail("Test case SignInFromBullboard is failed. "+e);
		}//End catch(Exception e)
	}// End public void SignInFromBullboard()
}
