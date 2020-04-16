package com.Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestData.ExcelSheet;

import BaseClass.ParentClass;
import Page.MyAccountPage;
import Page.SignUpPage;

public class SignUpPageTest extends ParentClass
{
	
	SignUpPage sup;  // Object of signupage class
	MyAccountPage myactpage;  // Object of myaccountpage class
	
	public SignUpPageTest() // Constructor
	{
		super();  // Call methods of parent classs
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initalization();
		signInLink();
		sup = new SignUpPage();
		myactpage = new MyAccountPage();
	    
	}
	
	@Test(priority = 1)
	public void signUpPageTitleTest()
	{
		String title=sup.SignUpPageTitle();
		Assert.assertEquals(title, "Walmart Canada");
	}

	// to fetch data from excel sheet
	@DataProvider
	public Object[][] UserData()
	{
		Object result[][] = ExcelSheet.readExcelData("Usersheet");
		return result;	
	}
	
	@Test(priority = 2,dataProvider = "UserData") // Excel sheet name
	public void clickCreateAccountTest(String eid,String phno,String fname,String lname,String pwd,String cpwd)
	{
		driver.findElement(By.className("create-account-email")).sendKeys("juhi1234@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Create my account')]")).click();

		myactpage = sup.createMyAccountBtn(eid,phno,fname,lname,pwd,cpwd);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.walmart.ca/my-account");
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}
}
