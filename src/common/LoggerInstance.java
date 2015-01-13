package common;

import java.io.File;
import java.util.Properties;

import org.apache.log4j.*;

public class LoggerInstance {
	
	public static Logger logger;
	File directory = new File ("");
	String absolutepath	=	directory.getAbsolutePath();
	//This is to get location for creating log file. This value is comming from build.xml 
	Properties Sys_property = System.getProperties();
	String str_LocationForLogFileToCreate = Sys_property.getProperty("LogFolder");
	String str_logFilePath = absolutepath+File.separator+"Output"+File.separator+str_LocationForLogFileToCreate+File.separator+"AutomationLogFile.log";
	
	public LoggerInstance()
	{
	if(logger==null)
		{
		try{
			logger = Logger.getLogger("IntellicusAutomation");
			FileAppender apndr = new FileAppender(new PatternLayout("%p %t %c - %m%n"),str_logFilePath,true);
			//apndr.setAppend(true);
			logger.addAppender(apndr);
		}
		catch(Exception e)
		{
			System.out.println("Log file is not initialized");
		}
		}
	}
}