/*
 * This is Class to Read Input data for test related to Intellicus
 */

package common;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.io.BufferedReader;

public class ReadInputData {
	File directory = new File ("");
	String absolutepath	=	directory.getAbsolutePath();
	String inputDataFilePath = absolutepath+File.separator+"InputData"+File.separator+"InputData.csv";
	//LoggerInstance.logger.info("inputDataFilePath   "+ inputDataFilePath);
	public static HashMap<String, String> HM_inputData = new HashMap<String, String>();
	BufferedReader br_readInputFile= null;
	String line = null;
	String cvsSplitBy = ",";
	public ReadInputData()
	{
		try
		{
			br_readInputFile = new BufferedReader(new FileReader(inputDataFilePath));
			while ((line = br_readInputFile.readLine()) != null) 
			{
				String[] values = line.split(cvsSplitBy);
				HM_inputData.put(values[0], values[1]);	
				//LoggerInstance.logger.info("values   "+ values[1]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

