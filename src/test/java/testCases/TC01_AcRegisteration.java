package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegisterPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC01_AcRegisteration extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("****Starting TC01_AcRegisteration***");
		try
		{
				
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("****clicked on MyAccount Link***");
		hp.clickRegister();
		logger.info("****clicked on Register Link***");
	
		
		AccountRegisterPage reg = new AccountRegisterPage(driver);
		logger.info("****providing customer details***");
		reg.fname(randomString());
		reg.lname(randomString());
		reg.email(randomString()+"@gmail.com");
		reg.telephone(randomNumber());
		String randompasswd = randomAlphanumberic();
		reg.passwd(randompasswd);
		reg.cfnpasswd(randompasswd);
		reg.agree();
		reg.cont();
		logger.info("****Validating expected msg***");
		String msgConfirmation = reg.msgconfn();
		if (msgConfirmation.equals("Your Account Has Been Created!")) {     // this if block take care of verification msg right or wrong
			
			Assert.assertTrue(true);
			
		} else {
			logger.error("expected msg failed");
			logger.debug("Debug logs..");
			System.out.println("false");
			Assert.assertTrue(false);
		}
		
		
		} catch (Exception e) {                                            // this catch block will come in to play once it find any error in main program
			logger.error("test failed");
			System.out.println("false123");
			Assert.fail();
			
		}
		
		logger.info("**** Finished TC001_AccountRegistration ****");
	}

}
