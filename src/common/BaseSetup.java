package common;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseSetup {
	BrowserInstance browserInstance;
	public static Properties Sys_property = System.getProperties();
	public static String outputDir = Sys_property.getProperty("OutputFolder");
	
	public static File directory = new File ("");
	public static String absolutepath	=	directory.getAbsolutePath();
	public static String failureScreenshotPath =absolutepath+File.separator+outputDir+File.separator+"FailureScreenshots";

	
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
			//BrowserInstance.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 }//End of try block
		 catch (Exception e)
		 {
			 LoggerInstance.logger.info("Failed to initiate the suite.");
		 }//End of catch
	}//End of public void InitializeSuit()

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
	
	 
	 @BeforeMethod(alwaysRun = true)
	 /*
	  * This method is used to : 1)Initiate driver object and browser. 2) It will initiate the log file and input file object.
	  */
	 public void InitialiseTest()
	 {
		try
		{
			if(BrowserInstance.driver==null){
				browserInstance=new BrowserInstance();
			//This will initiate browser instance and driver object.
		//	String url=ReadInputData.HM_inputData.get("URL");
		//	driver.get(url);
			//BrowserInstance.driver.get(url);
			BrowserInstance.driver.manage().window().maximize();
			//BrowserInstance.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			}
			//This will initiate browser instance and driver object.
			String url=ReadInputData.HM_inputData.get("URL");
			BrowserInstance.driver.get(url);
		 }//End of try block
		 catch (Exception e)
		 {
			 LoggerInstance.logger.info("Failed to initiate the suite.");
		 }//End of catch
	}//End of public void InitializeSuit()
	 
	 
	 @AfterMethod(alwaysRun=true)
	    public void quit(ITestResult result)  throws Exception{
		 try{
	    	System.out.println(result.getStatus());
	    	if(BrowserInstance.driver==null){}else{
		    		if(result.getStatus()==2){
		    				
			    			File file1 = new File(failureScreenshotPath);
			    			if (!file1.exists()){
			    				file1.mkdir();
			    			}
			    			File Imagefile = ((TakesScreenshot) BrowserInstance.driver).getScreenshotAs(OutputType.FILE);
			    			String FailureImageFileName = result.getMethod().getMethodName()+ ".png";
			    			//File screenshotDestDirectory = new File(failureScreenshotPath+File.separator+ FailureImageFileName);
			    			//FileUtils.moveFile(Imagefile, screenshotDestDirectory);
			    			FileUtils.copyFile(Imagefile, new File(failureScreenshotPath+File.separator+ FailureImageFileName));
		    		}
		    		BrowserInstance.driver.close();
		    		BrowserInstance.driver.quit();
		    		}
	    	BrowserInstance.driver=null;
	    	}catch(Exception e){
	    		BrowserInstance.driver=null;
	    	}
	    }

//	 @AfterMethod(alwaysRun = true)
//	 /*
//	  * This method is used to : 1)Close the browser. 2)Release driver object.
//	  */
//	 public void CloseBrowser()
//	 {
//		try
//		{
//			//Close the browser.
//			BrowserInstance.driver.close();
//			LoggerInstance.logger.info("Browser closed successfully.");
//			//Release driver object.
//			BrowserInstance.driver.quit();
//			BrowserInstance.driver=null;
//			LoggerInstance.logger.info("WebDriver object released successfully.");
//		 }//End of try block
//		 catch (Exception e)
//		 {
//			 LoggerInstance.logger.info("Failed to Release object.");
//		 }//End of catch
//	}//End of public void CloseDriverAndBrowser()

}
