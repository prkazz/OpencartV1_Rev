package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public  MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h2[normalize-space()='My Account']") 
	WebElement myAccount;
	
	@FindBy(xpath="(//a[@class='list-group-item'][normalize-space()='Logout'])[1]")
	WebElement lnkLogout;
	
	
	public boolean isMyAccountPageExist() {
		try {
			boolean displayed = myAccount.isDisplayed();
			return displayed;
		} catch (Exception e) {
			System.out.println("my account is not exist");
			return false;
		}
		
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
