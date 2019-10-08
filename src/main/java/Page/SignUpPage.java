package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BaseClass.ParentClass;

public class SignUpPage extends ParentClass
{
	// Page Factory- Object Repository:
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id="firstName")
	WebElement firstname;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="confirmPassword")
	WebElement confirmpass;
	
	@FindBy(id="tnc")
	WebElement policyChkBox;
	
	@FindBy(id="emailOptIn")
	WebElement subscribeChkBox;
	
	@FindBy(xpath="//*[@id=\'create-account-btn\']")
	WebElement createAccountBtn;
	
	// initialize page objects:
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);  // call methods of current class only.
	}
	
	// Actions:
	
	public String SignUpPageTitle()
	{
		return driver.getTitle();
	}

	public MyAccountPage createMyAccountBtn(String eid,String phno,String fname,String lname,String pwd,String cpwd)
	{
		email.sendKeys(eid);
		phone.sendKeys(phno);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		password.sendKeys(pwd);
		confirmpass.sendKeys(cpwd);
		policyChkBox.isSelected();
	//	subscribeChkBox.click();
		createAccountBtn.submit();
		
		return new MyAccountPage();  // navigate to MyAccountPage
	}
	
	
}
