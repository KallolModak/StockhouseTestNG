package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Bullboard;
import pageObjects.HomePage;
import pageObjects.MiscellaneousPage;
import common.BaseSetup;
import common.BrowserInstance;
import common.CommonSections;
import common.LoggerInstance;
import common.ReadInputData;


public class MiscellaneousTestCases extends BaseSetup {

	private MiscellaneousPage miscellaneousPage;
	/*
	  * This is the base state.
	  */
	public MiscellaneousPage baseState(){
		BrowserInstance.driver.get(ReadInputData.HM_inputData.get("URL")+"companies/quote?symbol=bbry");
		 try{Thread.sleep(20000);}catch(Exception e){}
		 MiscellaneousPage miscellaneousPage = PageFactory.initElements(BrowserInstance.driver, MiscellaneousPage.class);
		return miscellaneousPage;
	}
	
	/*
	 * Test case for Most Active Members Block.
	 * Go to  url http://test.stockhouse.com/companies/quote?symbol=bbry
	 * Check For the presence of <link rel="canonical" href="/companies/quote/bbry/blackberry-limited">
	 */
	@Test(priority=1)
	public void VerifyCanonicalPresecence()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 1 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			MiscellaneousPage miscellaneousPage = baseState();
			Thread.sleep(20000);
			miscellaneousPage.cancelLoading();
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			String source=miscellaneousPage.getPageSource();
			Thread.sleep(20000);
			String text="canonical";//"<link rel="canonical" href="/companies/quote/bbry/blackberry-limited"";
			String text1="href=\"/companies/quote/bbry/blackberry-limited\"";
			if(source.contains(text)&& (source.contains(text1))){
			Assert.assertEquals(1, 1);
			}else{
				Assert.assertEquals(1, 0);
			}
			}catch(Exception e){
				LoggerInstance.logger.info(" VerifyCanonicalPresecence is failed. "+e);
			Assert.fail("VerifyCanonicalPresecence is failed.."+e);
		}//End catch(Exception e)
	}// End  VerifyCanonicalPresecence is failed.()
	
}
	
	
	
	
	
	
	
	
	
	

