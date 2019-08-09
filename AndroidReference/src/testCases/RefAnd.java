package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import pageFactory.HomePage;


public class RefAnd  {
	
//Create the object for HomePage class
static HomePage objHomePage;

//Initializing the Android Driver
public static AndroidDriver<MobileElement> driver;

 @BeforeTest
public void beforeTest() throws MalformedURLException {
System.out.println("BeforeTest Method Executed");

//Setting the Desired Capabilities to Select the device and Launch the Application
	DesiredCapabilities capabilities=DesiredCapabilities.android();   
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");			
	capabilities.setCapability("deviceName", "SM-A500G");
	capabilities.setCapability("platformVersion", "6.0.1");	
	capabilities.setCapability("UDID", "ad33dc21");
	capabilities.setCapability("platformName", "Android");		
	capabilities.setCapability("appPackage", "com.abnamro.apps.referenceandroid");
	capabilities.setCapability("appActivity", "com.abnamro.apps.referenceandroid.MainActivity");
	capabilities.setCapability("noReset", "true");

//Initializing Appium Server
	driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
}
	

@Test(priority=0)
public void TC_1_NavigationCheck() throws IOException {

//Create Home Page object
objHomePage = new HomePage(driver);

//Verify if the App launched successfully
Assert.assertEquals(objHomePage.getHomePageTitle(),"ReferenceAndroid","Reference Android App Not Launched");	

//Taking Screen Shot*********************
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("D:/Workspace/AndroidReference/ScreenShots/TC_1_NavigationCheck.jpg"));
//**********************************

}

 @Test(priority=1)
public void TC_2_FieldVerification() throws IOException {

//Create Home Page object
objHomePage = new HomePage(driver);	  
SoftAssert softAssertion = new SoftAssert();

//Verify the Welcome Message
softAssertion.assertEquals(objHomePage.getWelcomeMsg(),"Hello World!","Welcome Message is Not Correct");

//Verify the Burger/More Menu button
softAssertion.assertEquals(objHomePage.getMoreButtonID(),"More options","More Menu Not Found");	 

//Verify the Mailer Icon
softAssertion.assertEquals(objHomePage.getMailerButtonID(),"com.abnamro.apps.referenceandroid:id/fab","Mailer Icon is Not Found");	   
 
//Taking Screen Shot*********************
File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(scrFile2, new File("D:/Workspace/AndroidReference/ScreenShots/TC_2_FieldVerification.jpg"));
//**********************************

}
  
  @Test(priority=2)
public void TC_3_BurgerMenu_FieldVerification() throws IOException {

//Create Home Page object	  
objHomePage = new HomePage(driver);	

// Tapping on More button 
objHomePage.clickMoreMenu();

//Verify if the option present under More Menu
Assert.assertEquals(objHomePage.getMoreMenuText(),"Settings","More Menu Option Text is not correct");	

//Taking Screen Shot*********************
File scrFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(scrFile3, new File("D:/Workspace/AndroidReference/ScreenShots/TC_3_BurgerMenu_FieldVerification.jpg"));
//**********************************

//Tapping on More Menu Option 
objHomePage.clickMoreMenuOption();

}
  
  @Test(priority=3)
public void TC_4_MailerButton_Msg_Verification() throws IOException {

//Create Home Page object	  
objHomePage = new HomePage(driver);	

// Tapping on Mailer Icon button 
objHomePage.clickMailerButton(); 
 
//Verify the Action Message on tap of mailer Icon
Assert.assertEquals(objHomePage.getMailActionText(),"Replace with your own action","Tapping on mailer Buitton error text is Not Appeared");	

//Taking Screen Shot*********************
File scrFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(scrFile3, new File("D:/Workspace/AndroidReference/ScreenShots/TC_4_MailerButton_Msg_Verification.jpg"));
//**********************************	

}

  
  @AfterTest
public void CloseApp(){
System.out.println("AfterTest Method Executed");
//Closing the APP	  
driver.closeApp();
}

}
