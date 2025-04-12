package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	//Constructor
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locator
	
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement txtPassWord;
	
	@FindBy(xpath="//input[@value=\"Login\"]")
	WebElement btnLogin;
	
	//acation
	public void setEmail(String email){
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassWord.sendKeys(pwd);
	}
		
	public void clickLogin() {
		btnLogin.click();
	}
	}
	
	
	
	
	
	
	
	

