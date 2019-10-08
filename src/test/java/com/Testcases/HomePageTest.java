package com.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.ParentClass;
import Page.HomePage;
import Page.SignInPage;

public class HomePageTest extends ParentClass
{
	SignInPage signinPage;
	HomePage homePage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initalization();
		signInLink();
		signinPage = new SignInPage();
		homePage = new HomePage();
		homePage = signinPage.signIn(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void titleTest()
	{
		String title = homePage.HomePageTitle();
		Assert.assertEquals(title, "Walmart Canada");
	}
	
	@Test(priority = 2)
	public void searchingTest() throws InterruptedException
	{
		homePage.searchingProduct();
		homePage.sortingBy();	
	}
	
	@Test(priority = 3)
	public void paginationTest() throws InterruptedException
	{
		homePage.pagination();
		homePage.filteringBy();
	}
		
	@Test(priority = 4)
	public void recommendationLinkTest()
	{
		homePage.recommendationLink();
	}

	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
}
