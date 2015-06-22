package pageObjects;

import org.openqa.selenium.By;

import common.WebdriverUtility;

public class ProfilePage extends WebdriverUtility{
	

	/*
	 * Constructor to initialize the class.
	 */
	public ProfilePage()
	{
	}//End public ProfilePage(WebDriver driver)

	/*
	 *Locator for user name in header. 
	 */
	private By userNameInHeader(String userName){
		return By.xpath("//h2[text()='"+userName+"']");
	}
	/*
	 * Function to check the presence of user name in header.
	 */
	public boolean isUserNameInHeaderPresent(String userName){
		return isElementPresent(userNameInHeader(userName),MEDIUMWAIT);
	}
	
	/*
	 *Locator for My Profile text present.
	 */
	private By myProfileTxt(){
		return By.xpath("//h4[text()='My Profile']");
	}
	/*
	 * Function to check the presence of My Profile text.
	 */
	public boolean isMyProfilePresent(){
		return isElementPresent(myProfileTxt(),MEDIUMWAIT);
	}
	
	/*
	 *Locator for Profile section.
	 */
	private By profileDetail(){
		return By.xpath("//div[@class='my-profile']");
	}
	/*
	 * Function to check the presence of Profile Details section.
	 */
	public boolean isMyProfileDetailsPresent(){
		return isElementPresent(profileDetail(),MEDIUMWAIT);
	}
	
	/*
	 *Locator for About Me text.
	 */
	private By aboutMe(){
		return By.xpath("//h4[contains(text(),'About Me')]");
	}
	/*
	 * Function to check the presence of About Me text.
	 */
	public boolean isAboutMePresent(){
		return isElementPresent(aboutMe(),MEDIUMWAIT);
	}
	
	/*
	 *Locator for My Rating text.
	 */
	private By myRating(){
		return By.xpath("//h4[contains(text(),'My Rating')]");
	}
	/*
	 * Function to check the presence of My Rating text.
	 */
	public boolean isMyRatingPresent(){
		return isElementPresent(myRating(),MEDIUMWAIT);
	}
	
	/*
	 *Locator for connections text.
	 */
	private By connections(){
		return By.xpath("//h4[contains(text(),'Connections')]");
	}
	/*
	 * Function to check the presence of connections text.
	 */
	public boolean isConnectionsPresent(){
		return isElementPresent(connections(),MEDIUMWAIT);
	}
}
