/*
 * This class will be running before starting the suite. This will initialize driver object and browser. 
 * And login to the intellicus application.
 */
package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import common.BrowserInstance;
import common.LoggerInstance;

public class BeforeSuiteClass {
	//WebDriver driver;
	public LoginPage loginPage;
	public  HomePage homePage;
	//public Logger logger;
	BrowserInstance browserInstance;
	
	 @BeforeSuite(alwaysRun = true)
	 /*
	  * This method is used to : 1)Initiate driver object and browser. 2) It will initiate the log file and input file object.
	  */
	 public void InitializeSuit()
	 {
		try
		{
			//This will initiate browser instance and driver object.
			browserInstance=new BrowserInstance();
			LoggerInstance.logger.info("Suite initialized successfully.");
			BrowserInstance.driver.manage().window().maximize();
			BrowserInstance.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 }//End of try block
		 catch (Exception e)
		 {
			 LoggerInstance.logger.info("Failed to initiate the suite.");
		 }//End of catch
	}//End of public void InitializeSuit()
}//End of  public class LoginBeforeSuite
