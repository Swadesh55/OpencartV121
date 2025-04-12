package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
//Constructor
	
	public HomePage(WebDriver diver) {
		super(diver);
		// TODO Auto-generated constructor stub
	}
	
// Locator
	@FindBy(xpath = "//span[text() = \"My Account\"]")
	WebElement lnkMyaccount;
	
	@FindBy(xpath = "//a[text()=\"Register\"]")
	WebElement lnkRegister;
	
	@FindBy(xpath ="//a[text()=\"Login\"]")
	WebElement lnkLogin;
	
	//Action
	public void ClickMyAccount()
	{
		lnkMyaccount.click();
	}
	
	
 public void ClickRegister() 
 {
	 
	 lnkRegister.click();
 }
 
 
 public void ClickLogin()
 {
	 lnkLogin.click();
 }
 
}
