package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Blog;
import pageObjects.FlyinSideBar;
import pageObjects.GroupsPage;
import pageObjects.HomePage;
import common.BaseSetup;
import common.BrowserInstance;
import common.CommonSections;
import common.LoggerInstance;

public class GroupTestCases extends BaseSetup {
	
	/*
	 * Test case for Most Active Members Block.
	 * Go to Group page from navigation link community.
	 * Check For the presence of Most Active Members Block.
	 */
	@Test(priority=1)
	
	public void MostActiveMembersBlock()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
			
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			CommonSections common=PageFactory.initElements(BrowserInstance.driver, CommonSections.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(2, 3);
			Thread.sleep(30000);
			Assert.assertTrue(common.ismostActiveMembersHeadPresent());
			for(int i=1;i<=4;i++){
				Assert.assertTrue(common.ismostActiveMembersSectionPresent(i));
			}
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase MostActiveMembers is failed. "+e);
			Assert.fail("GroupTestCase MostActiveMembers is failed."+e);
		}//End catch(Exception e)
	}// End public void MostActiveMembers()
	/*
	 * Test case for Read Block.
	 * Go to Group page from navigation link community.
	 * Check For the presence of Read Block.
	 */
	@Test(priority=2)
	public void ReadBlock()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				CommonSections common=PageFactory.initElements(BrowserInstance.driver, CommonSections.class);
				Thread.sleep(30000);
				homepage.clickOnNavigationSubLink(2, 3);
				Thread.sleep(30000);
				//common.clickOnReadSharedDiscussedHead(1);
				Assert.assertTrue(common.isreadSharedDiscussedHeadPresent(1));
				Assert.assertTrue(common.isreadSharedDiscussedSectionPresent(1));
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase ReadBlock is failed. "+e);
			Assert.fail("GroupTestCase ReadBlock is failed."+e);
		}//End catch(Exception e)
	}// End public void ReadBlock()
	/*
	 * Test case for Shared Block.
	 * Go to Group page from navigation link community.
	 * Check For the presence of Shared Block.
	 */
	@Test(priority=3)
	public void ShareBlock()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 3!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				CommonSections common=PageFactory.initElements(BrowserInstance.driver, CommonSections.class);
				Thread.sleep(30000);
				homepage.clickOnNavigationSubLink(2, 3);
				Thread.sleep(30000);
				common.clickOnReadSharedDiscussedHead(2);
				Assert.assertTrue(common.isreadSharedDiscussedHeadPresent(2));
				Assert.assertTrue(common.isreadSharedDiscussedSectionPresent(2));
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase ShareBlock is failed. "+e);
			Assert.fail("GroupTestCase ShareBlock is failed."+e);
		}//End catch(Exception e)
	}// End public void ShareBlock()
	/*
	 * Test case for Discuss Block.
	 * Go to Group page from navigation link community.
	 * Check For the presence of Discuss Block.
	 */
	@Test(priority=4)
	public void DiscussBlock()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 4 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				CommonSections common=PageFactory.initElements(BrowserInstance.driver, CommonSections.class);
				FlyinSideBar flyin=PageFactory.initElements(BrowserInstance.driver, FlyinSideBar.class);
				Thread.sleep(30000);
				homepage.clickOnNavigationSubLink(2, 3);
				Thread.sleep(30000);
				flyin.clickOnCross();
				common.clickOnReadSharedDiscussedHead(3);
				Assert.assertTrue(common.isreadSharedDiscussedHeadPresent(3));
				Assert.assertTrue(common.isreadSharedDiscussedSectionPresent(3));
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase DiscussBlock is failed. "+e);
			Assert.fail("GroupTestCase DiscussBlock is failed."+e);
		}//End catch(Exception e)
	}// End public void DiscussBlock()
	/*
	 * Test Case for 'size' mode.
	 * Go to Group page from navigation link community.
	 * Select 'size' mode from sort by combo.
	 */
	@Test(priority=5)
	public void SortBySize()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 5 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				GroupsPage groupPage=PageFactory.initElements(BrowserInstance.driver, GroupsPage.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 3);
				Thread.sleep(30000);
				groupPage.selectSortByViewMode("Popularity");
				Thread.sleep(30000);
				String txt2= groupPage.getTextOfVariousGroupsHead(1);
				groupPage.selectSortByViewMode("Size");
				Thread.sleep(30000);
				String txt1= groupPage.getTextOfVariousGroupsHead(1);
				Assert.assertNotEquals(txt1, txt2);
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase SortBySize is failed. "+e);
			Assert.fail("GroupTestCase SortBySize is failed."+e);
		}//End catch(Exception e)
	}// End public void SortBySize()
	/*
	 * Test Case for 'Popularity' mode.
	 * Go to Group page from navigation link community.
	 * Select 'Popularity' mode from sort by combo.
	 */
	@Test(priority=6)
	public void SortByPopularity()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 6 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				GroupsPage groupPage=PageFactory.initElements(BrowserInstance.driver, GroupsPage.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 3);
				Thread.sleep(30000);
				String txt1= groupPage.getTextOfVariousGroupsHead(1);
				groupPage.selectSortByViewMode("Popularity");
				Thread.sleep(30000);
				String txt2= groupPage.getTextOfVariousGroupsHead(1);
				Assert.assertNotEquals(txt1, txt2);
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase SortByPopularity is failed. "+e);
			Assert.fail("GroupTestCase SortByPopularity is failed."+e);
		}//End catch(Exception e)
	}// End public void SortByPopularity()
	/*
	 * Test Case for 'CreatedDate' mode.
	 * Go to Group page from navigation link community.
	 * Select 'CreatedDate' mode from sort by combo.
	 */
	@Test(priority=7)
	public void SortByCreatedDate()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 7 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				GroupsPage groupPage=PageFactory.initElements(BrowserInstance.driver, GroupsPage.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 3);
				Thread.sleep(30000);
				String txt1= groupPage.getTextOfVariousGroupsHead(1);
				groupPage.selectSortByViewMode("Created Date");
				Thread.sleep(30000);
				String txt2= groupPage.getTextOfVariousGroupsHead(1);
				Assert.assertNotEquals(txt1, txt2);
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase SortByCreatedDate is failed. "+e);
			Assert.fail("GroupTestCase SortByCreatedDate is failed."+e);
		}//End catch(Exception e)
	}// End public void SortByCreatedDate()
	/*
	 * Test Case for 'UpdateDate' mode.
	 * Go to Group page from navigation link community.
	 * Select 'UpdateDate' mode from sort by combo.
	 */
	@Test(priority=8)
	public void SortByUpdateDate()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 8 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				GroupsPage groupPage=PageFactory.initElements(BrowserInstance.driver, GroupsPage.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 3);
				Thread.sleep(30000);
				String txt1= groupPage.getTextOfVariousGroupsHead(1);
				groupPage.selectSortByViewMode("Updated Date");
				Thread.sleep(30000);
				String txt2= groupPage.getTextOfVariousGroupsHead(1);
				Assert.assertNotEquals(txt1, txt2);
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase SortByUpdateDate is failed. "+e);
			Assert.fail("GroupTestCase SortByUpdateDate is failed."+e);
		}//End catch(Exception e)
	}// End public void SortByUpdateDate()
	/*
	 * Test Case for Sorting Arrow.
	 * Go to Group page from navigation link community.
	 * Select sorting arrow for sorting the list accordingly.
	 * Check for sorted list.
	 */
	@Test(priority=9)
	public void SortingArrow()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 9 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				GroupsPage groupPage=PageFactory.initElements(BrowserInstance.driver, GroupsPage.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 3);
				Thread.sleep(30000);
				String txt1= groupPage.getTextOfVariousGroupsHead(1);
				groupPage.clickOnSortingArrow();
				Thread.sleep(30000);
				String txt2= groupPage.getTextOfVariousGroupsHead(1);
				Assert.assertNotEquals(txt1, txt2);
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase SortingArrow is failed. "+e);
			Assert.fail("GroupTestCase SortingArrow is failed."+e);
		}//End catch(Exception e)
	}// End public void SortingArrow()
	/*
	 * Test Case for filter groups by sectors.
	 * Go to Group page from navigation link community.
	 * Select Agriculture option from filter groups by sectors.
	 * Check for filtered list.
	 */
	@Test(priority=10)
	public void FilterBySectorsAgriculture()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 10 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				GroupsPage groupPage=PageFactory.initElements(BrowserInstance.driver, GroupsPage.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 3);
				Thread.sleep(30000);
				String txt1= groupPage.getTextOfVariousGroupsHead(1);
				groupPage.clickOnFilterBySectors();
				groupPage.selectOptionInFilterBySectors(2,1,"button");
				Thread.sleep(10000);
				String txt2=groupPage.getTextOptionInFilterBySectors(2,1,"label");
				groupPage.clickOnSubmitFilterBySectors();
				groupPage.isFilterSectorOptionOnPagePresent(txt2);
				Thread.sleep(40000);
				Assert.assertEquals(txt2, "Agriculture");
				String txt3= groupPage.getTextOfVariousGroupsHead(1);
				Assert.assertNotEquals(txt1, txt3);
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase FilterBySectorsAgriculture is failed. "+e);
			Assert.fail("GroupTestCase FilterBySectorsAgriculture is failed."+e);
		}//End catch(Exception e)
	}// End public void FilterBySectorsAgriculture()
	/*
	 * Test Case for filter groups by sectors.
	 * Go to Group page from navigation link community.
	 * Select Energy option from filter groups by sectors.
	 * Check for filtered list.
	 */
	@Test(priority=11)
	public void FilterBySectorsEnergy()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Test Case 11 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				GroupsPage groupPage=PageFactory.initElements(BrowserInstance.driver, GroupsPage.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 3);
				Thread.sleep(30000);
				String txt1= groupPage.getTextOfVariousGroupsHead(1);
				groupPage.clickOnFilterBySectors();
				groupPage.selectOptionInFilterBySectors(2,2,"button");
				String txt2=groupPage.getTextOptionInFilterBySectors(2,2,"label");
				groupPage.clickOnSubmitFilterBySectors();
				groupPage.isFilterSectorOptionOnPagePresent(txt2);
				Thread.sleep(30000);
				Assert.assertEquals(txt2, "Energy");
				String txt3= groupPage.getTextOfVariousGroupsHead(1);
				Assert.assertNotEquals(txt1, txt3);
			}catch(Exception e){
				LoggerInstance.logger.info("GroupTestCase FilterBySectorsEnergy is failed. "+e);
			Assert.fail("GroupTestCase FilterBySectorsEnergy is failed."+e);
		}//End catch(Exception e)
	}// End public void FilterBySectorsEnergy()


}
