package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {
	
	public WebDriver driver;
	
	//constructor
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement txtfirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement txtlastName;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txteMail;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement txtpasswordConfirm;
	
	@FindBy(xpath="//input[@name='agree']") 
	WebElement chkboxagree;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confnMsg;
	
	
	//actions
	
	public void fname(String fn) {
		txtfirstName.sendKeys(fn);
	}
	
	public void lname(String ln) {
		txtlastName.sendKeys(ln);
	}
	
	public void email(String mail) {
		txteMail.sendKeys(mail);
	}
	
	public void telephone(String phno) {
		txttelephone.sendKeys(phno);
	}
	
	public void passwd(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void cfnpasswd(String cpwd) {
		txtpasswordConfirm.sendKeys(cpwd);
	}
	
	public void agree() {
		chkboxagree.click();;
	}
	
	public void cont() {
		btncontinue.click();;
	}
	
	public String msgconfn() {
		try {
			return(confnMsg.getText());	
		} catch (Exception e) {
			return(e.getMessage());
		}
		
	}
}
