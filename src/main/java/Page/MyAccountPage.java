package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BaseClass.ParentClass;

public class MyAccountPage extends ParentClass
{
	  @FindBy(id="login-form-email") 
	  WebElement email;
	  
	  @FindBy(name="password") 
	  WebElement password;
	  
	  @FindBy(linkText="/forgot-password") 
	  WebElement forgotPassword;
	  
	  @FindBy(xpath="//*[@id=\'sign-in-remember-me-container\']/label") 
	  WebElement checkBox;
	  
	  @FindBy(id="account-signin-btn") 
	  WebElement signInBtn;
	  
	  @FindBy(id = "add-recent-order-number")
	  WebElement orderNo;

	  @FindBy(xpath = "//*[@id=\"add-recent-order\"]/div/div/button")
	  WebElement submitBtn;

	// initialize page objects:

	public MyAccountPage() 
	{
		PageFactory.initElements(driver, this); // call methods of current class only.
	}

	public String MyAccountPageTitle() 
	{
		return driver.getTitle();
	}

	public HomePage signInBtnClick() 
	{
		email.sendKeys("juhi1234@gmail.com");
		password.sendKeys("Test@1234"); // forgotPassword.click();
		checkBox.isSelected();
		signInBtn.click();
		driver.get(prop.getProperty("url"));
				
		return new HomePage();
	}
}
