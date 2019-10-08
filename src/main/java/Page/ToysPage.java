package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.ParentClass;

public class ToysPage extends ParentClass
{
	@FindBy(xpath="//*[@id='rbV6rQ5']/div[3]/a/article") // 5-7 years
	WebElement fiveYearsLink;
	
	public ToysPage() 
	{
		PageFactory.initElements(driver, this); // call methods of current class only.
	}

	public String toysPageTitle() 
	{
		return driver.getTitle();
	}
	
	public ShoppingCartPage clickLearningToys()
	{
		driver.findElement(By.xpath("//*[@id=\'rbV6rQ5\']/div[4]/a/article")).click();  // 5-7 years link
		driver.findElement(By.xpath("//img[contains(class(),'image lazy-img')]")).click();  // jungle friends gear toy
		driver.findElement(By.xpath("//*[@id=\'thumb-6000198405343\']/a/div[3]/div[1]/div[1]/h2")).click();  // Learning toys link
		driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();  // add to cart link
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();  // checkout link
		
		return new ShoppingCartPage();
	}
}
