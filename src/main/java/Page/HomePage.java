package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClass.ParentClass;

public class HomePage extends ParentClass
{	
	@FindBy(xpath="//span[contains(text()='Hi ','juhi')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'My Lists')]")
//	@CacheLookup  // it will store the web element in the cache memory
	WebElement myListLink;
	
	@FindBy(linkText="Toys")
	WebElement toysLink;
	
	@FindBy(className="css-1wjacxm ekai0sg1")
	WebElement myShoppingCart;
	
	@FindBy(id="global-search")
	WebElement searchClick;
	
	@FindBy(xpath="//button[@type='submit' and @class='btn-icon button-submit button-companion-right']")
	WebElement searchSubmitBtn;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);  
	}
	
	// Actions:
	
	public String HomePageTitle()
	{
		return driver.getTitle();
	}
	
    public boolean verifyUserName()
	{
		return userNameLabel.isDisplayed();
	}

	public void searchingProduct() 
	{	
		// Searching
		searchClick.sendKeys("fruit");
		searchSubmitBtn.click(); 
		System.out.println("Searching Done");		
	}
	
	public void pagination()
	{
		// Pagination
				// Check that all items on next page are different to the previous page, i.e. no duplicates
				List pagesElements = driver.findElements(By.xpath("//a[@id='loadmore' and @class='page-select-list-btn']"));
				
				// check if pagination link exists
				
				if(pagesElements.size()>0)
				{
					
				System.out.println("page exists"+pagesElements.size());
				
				// click on pagination link
				for(int i=0; i<pagesElements.size(); i++)
				{
					((WebElement) pagesElements.get(i)).click();
				}
				
				}
				else
				{
					System.out.println("no page");
				}
				
			Select rangePage = new Select(driver.findElement(By.xpath("//select[@class='page-select']")));  
			rangePage.deselectByIndex(1);
	}
	
	public void sortingBy() throws InterruptedException
	{
		// Sorting
		driver.findElement(By.linkText("Newest")).click();
		System.out.println("Sort products by Newest");
		Thread.sleep(1000);
		 
		driver.findElement(By.linkText("Price")).click();
		System.out.println("Sort products by Price in ascending order"); 
		Thread.sleep(1000); 
	}
	
	public void filteringBy() 
	{
		// Filtering
		
		// Page scroll down
		  JavascriptExecutor js= (JavascriptExecutor)driver; 
		  js.executeScript("window.scrollBy(0,1000)");
		  
		  // Switch to iframe
		 // driver.switchTo().frame("et-subscription-ifrm");
		 
		  driver.findElement(By.cssSelector("#rm-Price > button:nth-child(1) > span:nth-child(1)")).click();
		 
		  driver.findElement(By.cssSelector("#rmi-brand-id-3 > a:nth-child(1) > label:nth-child(2) > span:nth-child(2)")).click();
	}
	
	public String recommendationLink()
	{
		driver.get("https://www.walmart.ca/my-account/recommendations");
		System.out.println("People with a similar purchase history also viewed:");
		return driver.getTitle();
	}
	
	public ShoppingCartPage clickMyListLink()
	{
		//signInLink();
		
		// mouse hover on my list link
		Actions action = new Actions(driver);
		action.moveToElement(myListLink).build().perform();
		myListLink.click();
		return new ShoppingCartPage();	
	}

	public ToysPage clickToysLink()
	{
		toysLink.click();
		return new ToysPage();
	}
	
	public ShoppingCartPage clickShoppingCart()
	{
		myShoppingCart.click();
		return new ShoppingCartPage();
	}

}
