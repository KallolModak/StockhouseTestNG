/*
 * This class will be running after completion of suite. This will release driver object and browser. 
 */
package test;

import org.testng.annotations.AfterSuite;

import common.BrowserInstance;
import common.LoggerInstance;


public class CloseDriverAfterSuit {
	//WebDriver driver;
	//public Logger logger;
	//BrowserInstance obj_browserInstance;
	
	@AfterSuite(alwaysRun = true)
	 /*
	  * This method is used to : 1)Close the browser. 2)Release driver object.
	  */
	 public void CloseDriverAndBrowser()
	 {
		try
		{
			//Close the browser.
			BrowserInstance.driver.close();
			LoggerInstance.logger.info("Browser closed successfully.");
			//Release driver object.
			BrowserInstance.driver.quit();
			LoggerInstance.logger.info("WebDriver object released successfully.");
		 }//End of try block
		 catch (Exception e)
		 {
			 LoggerInstance.logger.info("Failed to Release object.");
		 }//End of catch
	}//End of public void CloseDriverAndBrowser()
}//End of public class CloseDriverAfterSuit
