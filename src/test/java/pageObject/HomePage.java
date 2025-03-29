package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public WebDriver driver;
	
	//constructor
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") 
	WebElement lnkLogin;
	
	//actions
	public void clickMyAccount() {
		
	lnkMyaccount.click();
		
	}

	public void clickRegister() {
		
		lnkRegister.click();
	}
	
public void clickLogin() {
		
		lnkLogin.click();
	}
}
