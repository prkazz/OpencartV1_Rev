package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class logInPage extends BasePage{

	public logInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txteMail;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@value='Login']") 
	WebElement btnlogin;
	
	
	public void setUsername(String uname) {
		txteMail.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtpwd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnlogin.click();;
	}
}
