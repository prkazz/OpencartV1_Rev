package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MyAccountPage;
import pageObject.logInPage;
import testBase.BaseClass;

public class TC02_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {
		try {
		logger.info("****Starting TC02_LoginTest********");
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logInPage lp = new logInPage(driver);
		logger.info("****Provinding username and password********");
		lp.setUsername(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean targetPage = myacc.isMyAccountPageExist();
		//Assert.assertTrue(targetPage);
		Assert.assertEquals(targetPage,true,"Login Failed prakaz");
		logger.info("my account page validated successfully");
		logger.info("****sucessfully logged in********");
		//myacc.clickLogout();
		
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("**********Finished TC02_LoginTest**********");
		System.out.println("username "+System.getProperty("user.name"));
	}
}
