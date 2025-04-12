package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_DDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriven") // Getting data from different class
	public void veryfy_loginDDT(String email, String pwd, String exp)
	{
		logger.info("****Strating TC_003_DDT***");

		try {
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();

		// Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();

		// MyAccount Page

		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();

		if (exp.equalsIgnoreCase("valid"))
		{
			if (targetPage == true) 
			{
				Assert.assertTrue(true);
				macc.clickLogout();
			} else
{
				Assert.assertTrue(false);
			}

		}

		if (exp.equalsIgnoreCase("invalid")) {
			if (targetPage == true) {

				macc.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}

		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Finshed TC_003_DDT***");

	}
}
