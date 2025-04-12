package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver diver) {
		super(diver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	
	@FindBy(xpath = "//input[@name=\"firstname\"]")
	WebElement txtFistname;
	
	@FindBy(xpath = "//input[@name=\"lastname\"]")
	WebElement txtLastname;
	
	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@name=\"telephone\"]")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name=\"confirm\"]")
	WebElement txtconfmPassword;
	
	@FindBy(xpath="//input[@type=\"checkbox\"]")
	WebElement chkpolicy;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[text()=\"Your Account Has Been Created!\"]")
	WebElement msgConfirmation;
	
	//Your Account Has Been Created!
	//Acton
	
	public void setFirstName(String fname)
	{
		txtFistname.sendKeys(fname);	
	}
	
	public void setLastNmae(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txtconfmPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkpolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfurmationMsg() {
		try {
			return (msgConfirmation.getText());
		}catch (Exception e) {
			return ( e.getMessage());
		}
	}
	
	
	
	
	
	
	

}
