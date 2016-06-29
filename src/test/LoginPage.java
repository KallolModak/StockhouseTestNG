package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPage {

	
	 
	   public static void main(String[] args){
		   WebDriver driver;
		     System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		   //Initialising the web driver.
		     driver = new ChromeDriver();
		   //Redirecting to website.
		     driver.get("http://www.stockhouse.com/login");
		     driver.manage().window().maximize();
		 //Path for username.
		    driver.findElement(By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_SignIn_Login1_UserName']")).sendKeys("mikeross1@mailinator.com");
		   // Path for password.
		    driver.findElement(By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_SignIn_Login1_Password']")).sendKeys("Testing@1");
		    // Path for sign-in button.
		    driver.findElement(By.xpath("//input[@id='p_lt_zoneContent_SubContent_p_lt_zoneLeft_SignIn_Login1_LoginButton']")).click();
		    try{
				 Thread.sleep(10000);
			 }catch(Exception e){}
		  //Closing the window.
			  driver.close();
			//End of test case.
			  driver.quit(); 
	 }
}
