/*
 * This is Home Page factory, contains all operations performed from home page.
 */

package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.BrowserInstance;
import common.LoggerInstance;
import common.WebdriverUtility;


public class HomePage extends WebdriverUtility{

 /*
  * Constructor to initialize required objects. 
  */
 public HomePage() {
 }//End public HomePage(WebDriver driver)
 
 

 /*
  * Locator for Email address text box.
  */
 private By searchListing(){
  return By.xpath("//aside[@id='sidebar']//div[@class='listview listview-body m-t-30 sidebar-menu']/a[contains(@href,'/listings')]/div/h2");
 }
 
 /*
  * Function to type email address in the email address text box.
  */
 public void clickOnSearchListing(){
  safeClick(searchListing(), VERYLONGWAIT);
 }
}