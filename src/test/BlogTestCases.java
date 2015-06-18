package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Blog;
import pageObjects.FlyinSideBar;
import pageObjects.HomePage;
import common.BaseSetup;
import common.BrowserInstance;
import common.CommonSections;
import common.LoggerInstance;

public class BlogTestCases extends BaseSetup {
	
	/*
	 * Test case for Most Active Members Block.
	 * Go to Blog page from navigation link community.
	 * Check For the presence of Most Active Members Block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=1)
	public void MostActiveMembersBlock()
	{
		try{
			
			HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
			CommonSections common=PageFactory.initElements(BrowserInstance.driver, CommonSections.class);
			Thread.sleep(30000);
			homepage.clickOnNavigationSubLink(2, 2);
			Thread.sleep(30000);
			Assert.assertTrue(common.ismostActiveMembersHeadPresent());
			for(int i=1;i<=4;i++){
				Assert.assertTrue(common.ismostActiveMembersSectionPresent(i));
			}
			}catch(Exception e){
				LoggerInstance.logger.info("BlogTestCase MostActiveMembers is failed. "+e);
			Assert.fail("BlogTestCase MostActiveMembers is failed."+e);
		}//End catch(Exception e)
	}// End public void MostActiveMembers()
	
	/*
	 * Test case for Read Block.
	 * Go to Blog page from navigation link community.
	 * Check For the presence of Read Block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=2)
	public void ReadBlock()
	{
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				CommonSections common=PageFactory.initElements(BrowserInstance.driver, CommonSections.class);
				Thread.sleep(30000);
				homepage.clickOnNavigationSubLink(2, 2);
				Thread.sleep(30000);
				//common.clickOnReadSharedDiscussedHead(1);
				Assert.assertTrue(common.isreadSharedDiscussedHeadPresent(1));
				Assert.assertTrue(common.isreadSharedDiscussedSectionPresent(1));
			}catch(Exception e){
				LoggerInstance.logger.info("BlogTestCase ReadBlock is failed. "+e);
			Assert.fail("BlogTestCase ReadBlock is failed."+e);
		}//End catch(Exception e)
	}// End public void ReadBlock()
	/*
	 * Test case for Shared Block.
	 * Go to Blog page from navigation link community.
	 * Check For the presence of Read Block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=3)
	public void ShareBlock()
	{
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				CommonSections common=PageFactory.initElements(BrowserInstance.driver, CommonSections.class);
				Thread.sleep(30000);
				homepage.clickOnNavigationSubLink(2, 2);
				Thread.sleep(30000);
				common.clickOnReadSharedDiscussedHead(2);
				Assert.assertTrue(common.isreadSharedDiscussedHeadPresent(2));
				Assert.assertTrue(common.isreadSharedDiscussedSectionPresent(2));
			}catch(Exception e){
				LoggerInstance.logger.info("BlogTestCase ShareBlock is failed. "+e);
			Assert.fail("BlogTestCase ShareBlock is failed."+e);
		}//End catch(Exception e)
	}// End public void ShareBlock()
	/*
	 * Test case for Discuss Block.
	 * Go to Blog page from navigation link community.
	 * Check For the presence of Read Block.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=4)
	public void DiscussBlock()
	{
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
				LoggerInstance.logger.info("BlogTestCase DiscussBlock is failed. "+e);
			Assert.fail("BlogTestCase DiscussBlock is failed."+e);
		}//End catch(Exception e)
	}// End public void DiscussBlock()
	/*
	 * Test Case for 'date created' mode.
	 * Go to Blog page from navigation link community.
	 * Select 'date created' mode from order by combo.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=5)
	public void OrderByDateCreated()
	{
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				Blog blog= PageFactory.initElements(BrowserInstance.driver, Blog.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 2);
				Thread.sleep(30000);
				blog.selectViewMode("Trending");
				Thread.sleep(30000);
				String txt2= blog.getTextOfBlogSummaryHead(1);
				blog.selectViewMode("Date created");
				Thread.sleep(30000);
				String txt1= blog.getTextOfBlogSummaryHead(1);
				Assert.assertNotEquals(txt1, txt2);
			}catch(Exception e){
				LoggerInstance.logger.info("BlogTestCase OrderByDateCreated is failed. "+e);
			Assert.fail("BlogTestCase OrderByDateCreated is failed."+e);
		}//End catch(Exception e)
	}// End public void OrderByDateCreated()
	/*
	 * Test Case for 'Blog Name' mode.
	 * Go to Blog page from navigation link community.
	 * Select 'Blog Name' mode from order by combo.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=6)
	public void OrderByBlogName()
	{
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				Blog blog= PageFactory.initElements(BrowserInstance.driver, Blog.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 2);
				Thread.sleep(30000);
	//			blog.selectViewMode("Date created");
	//			Thread.sleep(30000);
				String txt1= blog.getTextOfBlogSummaryHead(1);
				blog.selectViewMode("Blog name");
				Thread.sleep(30000);
				String txt2= blog.getTextOfBlogSummaryHead(1);
				Assert.assertNotEquals(txt1, txt2);
			}catch(Exception e){
				LoggerInstance.logger.info("BlogTestCase OrderByBlogName is failed. "+e);
			Assert.fail("BlogTestCase OrderByBlogName is failed."+e);
		}//End catch(Exception e)
	}// End public void OrderByBlogName()
	/*
	 * Test Case for 'Trending' mode.
	 * Go to Blog page from navigation link community.
	 * Select 'Trending' mode from order by combo.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=7)
	public void OrderByTrending()
	{
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				Blog blog= PageFactory.initElements(BrowserInstance.driver, Blog.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 2);
				Thread.sleep(30000);
				String txt1= blog.getTextOfBlogSummaryHead(1);
				blog.selectViewMode("Trending");
				Thread.sleep(30000);
				String txt2= blog.getTextOfBlogSummaryHead(1);
				Assert.assertNotEquals(txt1, txt2);
			}catch(Exception e){
				LoggerInstance.logger.info("BlogTestCase OrderByTrending is failed. "+e);
			Assert.fail("BlogTestCase OrderByTrending is failed."+e);
		}//End catch(Exception e)
	}// End public void OrderByTrending()
	/*
	 * Test Case for 'Author Name' mode.
	 * Go to Blog page from navigation link community.
	 * Select 'Author Name' mode from order by combo.
	 */
	@Test(groups={"BrowserCertificationTestCase"}, priority=8)
	public void OrderByAuthorName()
	{
		try{
				HomePage homepage = PageFactory.initElements(BrowserInstance.driver, HomePage.class);
				Blog blog= PageFactory.initElements(BrowserInstance.driver, Blog.class);
				Thread.sleep(60000);
				homepage.clickOnNavigationSubLink(2, 2);
				Thread.sleep(30000);
	//			blog.selectViewMode("Date created");
	//			Thread.sleep(30000);
				String txt1= blog.getTextOfBlogSummaryHead(1);
				blog.selectViewMode("Author name");
				Thread.sleep(30000);
				String txt2= blog.getTextOfBlogSummaryHead(1);
				Assert.assertNotEquals(txt1, txt2);
			}catch(Exception e){
				LoggerInstance.logger.info("BlogTestCase OrderByAuthorName is failed. "+e);
			Assert.fail("BlogTestCase OrderByAuthorName is failed."+e);
		}//End catch(Exception e)
	}// End public void OrderByAuthorName()
}
