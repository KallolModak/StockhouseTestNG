package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import common.BaseSetup;
import common.LoggerInstance;

//import org.testng.annotations.Test;

//import com.google.common.base.Charsets;
//import com.google.common.io.Files;

public class FileCountAndRead {

	private static File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    
	    return lastModifiedFile;
	} // End of getLatestFilefromDir()
	
	//@Test(priority =1)
	public static void main(String[] args){
		//public void Test(){
	try{
		
		 int totalFail=0;
		 int totalPercent=0;
		// Get the absolute path of directory.
		 	File directory1 = new File ("");
			String absolutepath	= directory1.getAbsolutePath();
			File latestFile=getLatestFilefromDir(absolutepath+File.separator+"Output");
			String latestFileName=latestFile.getName();
			//String x="Output"+File.separator+latestFileName;
			String directoryPath =absolutepath+File.separator+"Output"+File.separator+latestFileName+File.separator+"report"+File.separator+"html";
			
			File directory = new File(directoryPath);
		
		// Get the path of directory.
		File[] myarray=directory.listFiles();
		// Find the suite_result files.
		for (int a = 0; a < myarray.length; a++)
		{
		       File path=myarray[a];
		       String fileName=path.getName();
		       if(fileName.contains("results")){
			       FileReader fr = new FileReader(path);
			       BufferedReader br = new BufferedReader(fr);
			       String resultFileContent ="";
			       while (br.ready()) {
			    	   resultFileContent += br.readLine();
			       }
			       resultFileContent =resultFileContent.trim().replaceAll("\\s+", " ");
				  
			       String[] tableArray= resultFileContent.split("<table");

			       // If there is only either failed TestCases or  pass TestCases.
			       if(tableArray.length<3){
			    	   String text = null;
			    	   String onlyFailTable=tableArray[1];
			    	   Matcher m = Pattern.compile("<th colspan=\"3\" class=\"header(.*?)</th>").matcher(onlyFailTable);
			    	   while (m.find()) {
			    		   text=m.group(1);
			    	   }
			    	   
			        // If only failed TestCases.
			    	if(text.contains("Failed Tests")){
			    		String[] trFailArray = tableArray[1].split("<tr>");
			    		String[] nameFailArray = new String[trFailArray.length-3];
			    		int count=0;
							
			    		// Find the name of failed testcases.
			    		for(int tr=3;tr<trFailArray.length;tr++){
			    			String str=trFailArray[tr];
			    			m = Pattern.compile("<td class=\"method\">(.*?)</td>").matcher(str);
			    			while (m.find()) {
			    				text=m.group(1);
			    				nameFailArray[count]=text.trim();
							}
							count++;
						}
						// Remove double occurance of failed testcases.
						for(int i=0;i<nameFailArray.length;i++){
							for(int j=i+1;j<nameFailArray.length;j++){
				
								if(nameFailArray[i].equals(nameFailArray[j])){
									if(trFailArray[i+3].contains("</table>"))
										resultFileContent=resultFileContent.replace("<tr>"+trFailArray[i+3], " </table>");
									else
										resultFileContent=resultFileContent.replace("<tr>"+trFailArray[i+3], " ");
									break;
								} 
							} 
						} 
						// Overwrite the original results file.
						BufferedWriter writer = null;
									
						writer = new BufferedWriter(new FileWriter(path));
		      			writer.write(resultFileContent);
						if ( writer != null)
							writer.close( );
						          
						
						// Find the number of passed testcases, failed testcases and their percentage.
					    tableArray= resultFileContent.split("<table");
					    String[] trArray1 = tableArray[1].split("<tr>");
					    int failedtestcases = trArray1.length-3;
					    
					    // Overview File.
					    File overview=new File(directoryPath+File.separator+"overview.html");
				   	    
						  fr = new FileReader(overview);
						  br = new BufferedReader(fr);
						  String overviewContent ="";
						  while (br.ready()) {
							  overviewContent += br.readLine();
						  }
						  overviewContent=overviewContent.trim().replaceAll("\\s+", " ");
						  String[] trNumArray = overviewContent.split("<tr class");
						    
						  // Get the name of Test suite.
						   count=0;
						   String text1=null;
						   for(int tr=2;tr<trNumArray.length;tr++){////tr=3
							  String str=trNumArray[tr];
							  m = Pattern.compile("<a href=\""+fileName+"\">(.*?)</a>").matcher(str);
							  while (m.find()) {
								  text1=m.group(1).trim();
							  }
							count++; 
						   } //End of Get the name of Test suite.
						
						   // Replacing with new number of failed testcases.
						   
						   for(int i=2;i<trNumArray.length;i++){/////i=3
						    	
							 if(trNumArray[i].contains(text1)){
						    	m = Pattern.compile("class=\"failed number\">(.*?)</td>").matcher(trNumArray[i]);
						    	while (m.find()) {
									String text2=m.group(1);
									String failedString=trNumArray[i].replace("class=\"failed number\">"+text2, "class=\"failed number\">"+failedtestcases);
									overviewContent=overviewContent.replace(trNumArray[i], failedString);
									trNumArray[i]=failedString;
									totalFail=(totalFail)+(failedtestcases);
										  
						    	 } 
						    		
						  // Total Fail TestCases. 
						  m = Pattern.compile("class=\"failed number\">(.*?)</td>").matcher(trNumArray[trNumArray.length-1]);
						  while (m.find()) {
				    		String text2=m.group(1);
							String totalFailString=trNumArray[trNumArray.length-1].replace("class=\"failed number\">"+text2, "class=\"failed number\">"+totalFail);
							overviewContent=overviewContent.replace(trNumArray[trNumArray.length-1], totalFailString);
							trNumArray[trNumArray.length-1]=totalFailString;
				    	 }

						// Overwrite the original overview file.
						BufferedWriter writer1 = null;
						    writer1 = new BufferedWriter(new FileWriter(directoryPath+File.separator+"overview.html"));
						    writer1.write(overviewContent);
						 	if ( writer1 != null)
						 		writer1.close( );
							 } 
				    }//End of Replacing with new number of failed testcases.		
		       		
		        }//end of If only failed TestCases
		}else{
			
			// Suite_result Files which have both failed and passed TestCases.			
			String[] trFailArray = tableArray[1].split("<tr>");
			String[] nameFailArray = new String[trFailArray.length-3];
			int count=0;
						
			// Find the name of failed testcases.
			for(int tr=3;tr<trFailArray.length;tr++){
				String str=trFailArray[tr];
				Matcher m = Pattern.compile("<td class=\"method\">(.*?)</td>").matcher(str);
				while (m.find()) {
					String text=m.group(1);
					nameFailArray[count]=text.trim();
				}
				count++;
			}// End of Find the name of failed testcases.
						
			// Find the name of passed testcases.
			String[] trPassArray = tableArray[2].split("<tr>");
			String[] namePassArray = new String[trPassArray.length-3];
			count=0;
			for(int tr=3;tr<trPassArray.length;tr++){
				String str=trPassArray[tr];
				Matcher m = Pattern.compile("<td class=\"method\">(.*?)</td>").matcher(str);
				while (m.find()) {
					String text=m.group(1);
					namePassArray[count]=text.trim();
				}
				count++;
			} // End of Find the name of passed testcases. 
			
			// Compare the name of passed testcase with failed testcases.
			for(int i=0;i<nameFailArray.length;i++){
				
				for(int j=i;j<namePassArray.length;j++){
					
					if(nameFailArray[i]!=null){
						
						if(nameFailArray[i].equals(namePassArray[j])){
							
							if(trFailArray[i+3].contains("</table>"))//trFailArray[i+3]
								resultFileContent=resultFileContent.replace("<tr>"+trFailArray[i+3], " </table>");
							else
								resultFileContent=resultFileContent.replace("<tr>"+trFailArray[i+3], " ");
							break;
						} 
									
					} 
				} 
			} // End of Compare the name of passed testcase with failed testcases.
						
			// Remove double occurance of failed testcases.
			for(int i=0;i<nameFailArray.length;i++){
				for(int j=i+1;j<nameFailArray.length;j++){
					
					if(nameFailArray[i].equals(nameFailArray[j])){
						//content.replace(trArray[j+3], "\n");
						if(trFailArray[i+3].contains("</table>"))
							resultFileContent=resultFileContent.replace("<tr>"+trFailArray[i+3], " </table>");
						else
							resultFileContent=resultFileContent.replace("<tr>"+trFailArray[i+3], " ");
						break;
					} 
				} 
			} // End of Remove double occurance of failed testcases.
						
			// Overwrite the original result file.
			BufferedWriter writer = null;
			
			writer = new BufferedWriter(new FileWriter(path));
			writer.write(resultFileContent);
			if ( writer != null)
				writer.close( );
			          
			// Find the number of passed testcases, failed testcases and their percentage.
			int failedtestcases=0;
		    tableArray= resultFileContent.split("<table");
		    String[] trArray1 = tableArray[1].split("<tr>");
		    
		    // All testcases are passed.
		    if(trArray1.length<4)
		    {
		    	String noFailTable=tableArray[1];
		    	resultFileContent=resultFileContent.replace("<table"+noFailTable," ");
		    	
		    	// Overwrite the original result file.
				writer = null;
				writer = new BufferedWriter(new FileWriter(path));
				writer.write(resultFileContent);
				if ( writer != null)
					writer.close( );
				 
				 failedtestcases=0;
		    }
		    else{
		    	failedtestcases = trArray1.length-3;
		    }
		    
		    String[] trArray2 = tableArray[2].split("<tr>");
		    int passedtestcases = (trArray2.length)-3;
		    
		    int percentage= (passedtestcases*100)/(passedtestcases+failedtestcases);		    
		    
		    // Overview File.
		    File overview=new File(directoryPath+File.separator+"overview.html");
		    fr = new FileReader(overview);
		    br = new BufferedReader(fr);
		    String overviewContent ="";
		    while (br.ready()) {
		    	overviewContent += br.readLine();
		    }
		    overviewContent=overviewContent.trim().replaceAll("\\s+", " ");
		    String[] trNumArray = overviewContent.split("<tr class");
		    
		   // Get the name of Test suite.
		   count=0;
		   String text1=null;
		   for(int tr=2;tr<trNumArray.length;tr++){////tr=3
		    	
			  String str=trNumArray[tr];
			  Matcher m = Pattern.compile("<a href=\""+fileName+"\">(.*?)</a>").matcher(str);
				
			  while (m.find()) {
				 text1=m.group(1).trim();
				  
			  }
			  count++; 
		   } //End of Get the name of Test suite.
		
		 // Replacing with new number of failed testcases.
		 for(int i=2;i<trNumArray.length;i++){ //i=3
		    	
			 if(trNumArray[i].contains(text1)){
		    	
				 // When there are no failed TestCases.
				 if(failedtestcases==0){
					 Matcher m = Pattern.compile("class=\"failed number\">(.*?)</td>").matcher(trNumArray[i]);
					 while (m.find()) {
								//String txt=m.group(1);
								
						 String fail=trNumArray[i].replace("class=\"failed number\">", "class=\"zero number\">");
						 overviewContent=overviewContent.replace(trNumArray[i], fail);
								
						 trNumArray[i]=fail;
						 totalFail=(totalFail)+(failedtestcases);
						 
						 // SUITE FILE //
						 File suites=new File(directoryPath+File.separator+"suites.html");
						 fr = new FileReader(suites);
						 br = new BufferedReader(fr);
						 //String s = "";
						 String suitesContent ="";
						 while (br.ready()) {
							 suitesContent += br.readLine();
						 }
						 suitesContent=suitesContent.trim().replaceAll("\\s+", " ");
						 String[] suiteTrArray=suitesContent.split("<tr>");
							    
						 for(int k=1;k<suiteTrArray.length;k++){
							 if(suiteTrArray[k].contains(text1)){
								 m = Pattern.compile("<span(.*?)</span>").matcher(suiteTrArray[k]);
								 while (m.find()) {
									 String FIndicator=suiteTrArray[k].replace("\"failureIndicator\"", "\"successIndicator\"");
									 suitesContent=suitesContent.replace(suiteTrArray[k], FIndicator);
									 suiteTrArray[k]=FIndicator;
									 
									 String title=suiteTrArray[k].replace("Some tests failed.","All tests passed.");
									 suitesContent=suitesContent.replace(suiteTrArray[k], title);
									 suiteTrArray[k]=title;
												
									 String colCode=suiteTrArray[k].replace("&#x2718;","&#x2714;");
									 suitesContent=suitesContent.replace(suiteTrArray[k], colCode);
									 suiteTrArray[k]=colCode;
									 
								 }
								 // Overwrite the original suite file.
								 writer = null;
													
								 writer = new BufferedWriter(new FileWriter(directoryPath+File.separator+"suites.html"));
								 writer.write(suitesContent);
								 if ( writer != null)
									 writer.close( );
						
							}
							    
						}
								
					}
						 
				} // End of When there are no failed TestCases.
		    		 
				Matcher m = Pattern.compile("class=\"failed number\">(.*?)</td>").matcher(trNumArray[i]);
				while (m.find()) {
					String text2=m.group(1);
					String failedString=trNumArray[i].replace("class=\"failed number\">"+text2, "class=\"failed number\">"+failedtestcases);
					overviewContent=overviewContent.replace(trNumArray[i], failedString);
					trNumArray[i]=failedString;
					totalFail=(totalFail)+(failedtestcases);
						  
				} //End of Replacing with new number of failed testcases.
		    		 
		     // Replacing with new percentage.
		     m = Pattern.compile("class=\"passRate\">(.*?)</td>").matcher(trNumArray[i]);
		     while (m.find()) {
				 String text2=m.group(1);
				 String perString=trNumArray[i].replace("class=\"passRate\">"+text2, "class=\"passRate\">"+percentage+"%");
	    		 overviewContent=overviewContent.replace(trNumArray[i], perString);
			} // End of Replacing with new percentage.
		    		
		    // Total Fail TestCases. 
		    m = Pattern.compile("class=\"failed number\">(.*?)</td>").matcher(trNumArray[trNumArray.length-1]);
    		while (m.find()) {
    		 String text2=m.group(1);
    		 String totalFailString=trNumArray[trNumArray.length-1].replace("class=\"failed number\">"+text2, "class=\"failed number\">"+totalFail);
    		 overviewContent=overviewContent.replace(trNumArray[trNumArray.length-1], totalFailString);
    		 trNumArray[trNumArray.length-1]=totalFailString;
    	   } // End of Total Fail TestCases.
		     
    	   // Total Pass TestCases.
    	   String per=null;
    	   m = Pattern.compile("class=\"passed number\">(.*?)</td>").matcher(trNumArray[trNumArray.length-1]);
    	   while (m.find()) {
    		   per=m.group(1);
    	   }
    	    int totalPass=Integer.parseInt(per); //End of Total Pass TestCases.
    		 
    	   // Total Percentage.
    	   totalPercent= (totalPass*100)/(totalPass+totalFail);
    	   m = Pattern.compile("class=\"passRate suite\">(.*?)</td>").matcher(trNumArray[trNumArray.length-1]);
    	   while (m.find()) {
    		   String text2=m.group(1);
    		   String totalPercentString=trNumArray[trNumArray.length-1].replace("class=\"passRate suite\">"+text2, "class=\"passRate suite\">"+totalPercent+"%");
    		   overviewContent=overviewContent.replace(trNumArray[trNumArray.length-1], totalPercentString);
    		   trNumArray[trNumArray.length-1]=totalPercentString;
    	   } //End of Total Percentage.
		     
		  // Overwrite the original overview file.
		  BufferedWriter writer1 = null;
		  writer1 = new BufferedWriter(new FileWriter(directoryPath+File.separator+"overview.html"));
		  writer1.write(overviewContent);
		  if ( writer1 != null)
			  writer1.close( );
		  } //End of if(trNumArray[i].contains(text1))
		} // End of Replacing with new number of failed testcases.
		  
		} // end of else		
						
		}// end of first if.......
		}// End of Find the suite_result files.
		}catch(Exception e){
			System.out.println("This is error message "+e);
		}
	} // End of main()
} // End of FileCountAndRead()

