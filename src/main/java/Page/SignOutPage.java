package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BaseClass.ParentClass;

public class SignOutPage extends ParentClass
{	
	
	//@FindBy(xpath = "//a[@text = 'Sign out' and @class = 'css-1toum3j et5cpij4']")
	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	WebElement signOutLink;
	
	public SignOutPage() 
	{
		PageFactory.initElements(driver, this);  // intialization page factory
	}
	
	public HomePage clickSignOut()
	{
		signInLink();
		signOutLink.click();
		return new HomePage();
	}
}
