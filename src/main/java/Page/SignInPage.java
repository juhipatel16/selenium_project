package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.ParentClass;

public class SignInPage extends ParentClass
{
	// Page Factory - Object Repo
	@FindBy(xpath="//*[@id=\'login-form-email\']")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='sign-in-remember-me-container']/label")
	WebElement checkBox;
	
	@FindBy(id="account-signin-btn")
	WebElement SignInBtn;
	
	@FindBy(className="create-account-email")
	WebElement emailCreate;
	
	@FindBy(xpath="//button[contains(text(),'Create my account')]")
	WebElement createAccBtn;

	public SignInPage()
	{
		PageFactory.initElements(driver, this);  // intialization page factory
	}
	
	public String validateSignInPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage signIn(String eid,String pass)
	{
		email.sendKeys(eid);
		password.sendKeys(pass);
		checkBox.click();
		SignInBtn.submit();
		
		return new HomePage();
	}
	
	public void createAcc(String email)
	{
		emailCreate.sendKeys(email);
		createAccBtn.click();
	}

}
