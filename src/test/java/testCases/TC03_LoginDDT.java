package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MyAccountPage;
import pageObject.logInPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_LoginDDT  extends BaseClass{
@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups = "DataDriven") 
	public void verify_LoginDDT(String uname, String pwd,String exp) {
	logger.info("*****Starting TC002_LoginDDT ******** ");
	try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logInPage lp = new logInPage(driver);
		lp.setUsername(uname);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean targetPage = myacc.isMyAccountPageExist();
		/*Data is Valid - Login Success - test pass -->logout
		Data is Valid - Login Fail - test fail

		Data is InValid - Login Success - test fail -->logout
		Data is InValid - Login fail - test pass */
		
		if (exp.equalsIgnoreCase("valid")) {
			if (targetPage==true) {
				myacc.clickLogout();
				Assert.assertTrue(true);
			}else {
					Assert.assertTrue(false);
				}
			}
		
		
		if (exp.equalsIgnoreCase("invalid")) {
			if (targetPage==true) {
				myacc.clickLogout();
				Assert.assertTrue(false);
			} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		
	logger.info("*****Finished TC003_LoginDDT ******** ");	
		
		
		
	}
}
