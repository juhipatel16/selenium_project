package com.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.ParentClass;
import Page.HomePage;
import Page.MyAccountPage;

public class MyAccountPageTest extends ParentClass
{
	MyAccountPage myactpage;  // Object of myaccountpage class
	HomePage homePage;
	
	public MyAccountPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initalization();
		signInLink();
		myactpage = new MyAccountPage();
		homePage = new HomePage();
		myactpage=new MyAccountPage();
	}
	
	@Test(priority = 1)
	public void MyAccountPageTitleTest()
	{
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority = 2)
	public void signInBtnClickTest()
	{ 
		homePage = myactpage.signInBtnClick(); 
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
}
