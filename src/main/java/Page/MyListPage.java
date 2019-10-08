package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import BaseClass.ParentClass;

public class MyListPage extends ParentClass
{
	
	MyListPage mylistPage;
	
	public MyListPage() 
	{
		PageFactory.initElements(driver, this);  
	}
	
	public void createNewList()
	{
		// create your new list
		driver.findElement(By.id("save-list-input")).sendKeys("Grocery");
		driver.findElement(By.id("save-list-button")).submit();
				
		// search product to add your list
		driver.findElement(By.name("embedded-search-form-input")).sendKeys("apple");
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).submit();	
	}
}
