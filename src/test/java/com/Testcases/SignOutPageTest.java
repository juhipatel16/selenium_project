package com.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.ParentClass;
import Page.HomePage;
import Page.SignInPage;
import Page.SignOutPage;

public class SignOutPageTest extends ParentClass
{
	SignOutPage signoutPage;
	SignInPage signinPage;
	HomePage homePage;
	
	public SignOutPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initalization();
		signinPage = new SignInPage();
		signoutPage = new SignOutPage();
	}
     
	@Test(priority = 1)
	public void signInTest()
	{
		signInLink();
		homePage = signinPage.signIn(prop.getProperty("email"),prop.getProperty("password")); 
	}
	
	@Test(priority = 2)
	public void signOutTest()
	{	
		signoutPage.clickSignOut();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
}
