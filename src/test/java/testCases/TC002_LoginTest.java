package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest  extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****Starting TC_LoginTest*****");
		
		try
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		
		//Login Page
		LoginPage lp = new LoginPage(driver);	
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount Page
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		//Assert.assertEquals(targetPage, "Login failed");
		Assert.assertTrue(targetPage);
		}
		 
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished Tc_002_lOGINtEST*****");
		
		
		
		
		
		
	}
	
}
