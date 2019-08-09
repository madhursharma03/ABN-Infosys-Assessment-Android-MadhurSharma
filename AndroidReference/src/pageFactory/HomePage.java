package pageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	
public AndroidDriver<MobileElement> driver;

public HomePage(AndroidDriver<MobileElement> driver) {
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}
	

// * All MobileElements are identified by @@AndroidFindBy annotation
	
@AndroidFindBy(xpath = "//android.widget.TextView[@text='ReferenceAndroid']")
public
MobileElement App_Heading;

@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hello World!']")
MobileElement Welcome_Msg;

@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
MobileElement Burger_Menu;

@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.abnamro.apps.referenceandroid:id/fab']")
MobileElement Mailer_Button;

@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
MobileElement BurgerMenu_Option;

@AndroidFindBy(xpath = "//android.widget.TextView[@text='Replace with your own action' and @resource-id= 'com.abnamro.apps.referenceandroid:id/snackbar_text']")
MobileElement Mailer_Action_Text;

 
//Get the title of Home Page
public String getWelcomeMsg(){

 return  Welcome_Msg.getText();

}

//Get the Welcome Message Text
public String getHomePageTitle(){

return  App_Heading.getText();

}

//Get the ID of Mailer_Button
public String getMailerButtonID(){

return  Mailer_Button.getId();

}

//Get the ID of More Button
public String getMoreButtonID(){

return  Burger_Menu.getAttribute("contentDescription");

}

//Click on Mailer icon 
public void clickMailerButton(){

	Mailer_Button.click();
}  

//Click on More Menu
public void clickMoreMenu(){

	Burger_Menu.click();
}  

//Get the title of More Menu Option
public String getMoreMenuText(){

return  BurgerMenu_Option.getText();

}

//Click on More Menu
public void clickMoreMenuOption(){

	BurgerMenu_Option.click();
}  


//Get the title of More Menu Option
public String getMailActionText(){

return  Mailer_Action_Text.getText();

}

}
