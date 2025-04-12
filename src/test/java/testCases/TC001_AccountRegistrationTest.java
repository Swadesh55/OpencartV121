package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
	 logger.info("*****Starting TC001_AccountRegistrationTest");
		
	 try {
		 
	 
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		 logger.info("Clicked on MyAccount Link");
		hp.ClickRegister();
		logger.info("Clicked on Register Link");
		
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		
		logger.info("Providing customer details...");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastNmae(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password = randomeAlphaNumberic();
		
		regpage.setPassword(password );
		regpage.setConfirmPassword(password );
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		//for confirmation 
		
		logger.info("Validating expected massege....");
		String confmsg = regpage.getConfurmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");	
		
	}
	 catch(Exception e)
	 {
		 logger.error("Test failed..");
		 //logger.debug("Debug logs..");
		 Assert.fail();
	 }
	
	 logger.info("*****Finished TC001_AccountRegistrationTest");
	}
	}
	

