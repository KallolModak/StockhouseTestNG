/*
This class will initialize webdriver object
*/
package common;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.*;
import org.apache.log4j.*;

public class BrowserInstance {
	//This is static driver object, available through out the application. 
	public static WebDriver driver = null;
	ReadInputData obj_readInputData;
	HashMap<String, String> HM_inputData;
	LoggerInstance obj_loggerInstance;
	Logger logger;
	//This is constructor to initialize webdriver object once.
	public BrowserInstance(){
		try
		{
			int int_BrowserType=1;
			obj_readInputData= new ReadInputData();
			obj_loggerInstance = new LoggerInstance();
			logger= LoggerInstance.logger;
			HM_inputData=obj_readInputData.HM_inputData;
			logger.info("Initiate driver.");
			String str_BrowserType= HM_inputData.get("BrowserName");
			logger.info("str_BrowserType  "+ str_BrowserType);
			if (str_BrowserType.equalsIgnoreCase("IE"))
				int_BrowserType=BrowserType.IE.getBrowserType();
			if (str_BrowserType.equalsIgnoreCase("FIREFOX"))
				int_BrowserType=BrowserType.FireFox.getBrowserType();
			if (str_BrowserType.equalsIgnoreCase("CHROME"))
				int_BrowserType=BrowserType.Crome.getBrowserType();
				
			if (driver==null)
			{
				//To initialize ReadInputData class object to read input data from csv file
				switch (int_BrowserType) {
				case 1:  driver = new FirefoxDriver();
						 logger.info("Initiate Firefox driver.");	
						 break;
				case 2:  System.setProperty("webdriver.ie.driver", "tools//IEDriverServer.exe");
						 DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
					     caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
					     caps.setCapability("nativeEvents", true);
					     driver = new InternetExplorerDriver(caps);
					     logger.info("Initiate InternetExplorer driver.");
						 break;
				case 3: 
					System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
						 driver = new ChromeDriver();
				 		 logger.info("Initiate Chrome driver.");
						 break;
				default: driver = new FirefoxDriver();
				 		 logger.info("Valid browser type is not found. So initiate Firefox driver.");
						 break;
				}//End of switch (int_BrowserType)
			//It will open intellicus link in browser.
				System.out.println("abcd");
			String url=ReadInputData.HM_inputData.get("URL");
			driver.get(url);
		}//End of if (driver==null)
			System.out.println("xyz");
		}//End of try
		catch (Exception e)
		{
			logger.info("InputData CSV file can not read. "+e.getMessage());
		}//End of catch (Exception e)
	} // End of public BrowserInstance(int int_BrowserType)
}//End of public class BrowserInstance 
