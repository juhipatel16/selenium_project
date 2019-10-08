package com.Testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.ParentClass;
import Page.HomePage;
import Page.SignInPage;

public class SignInPageTest extends ParentClass
{
	SignInPage signinPage;
	HomePage homePage;
	
	public SignInPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initalization();
		signInLink();
		signinPage = new SignInPage();
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
	public void signInPageTitleTest()
	{
		String title= signinPage.validateSignInPageTitle();
		Assert.assertEquals(title, "Walmart Canada");
	}
	
	@Test(priority = 2)
	public void signInTest() throws IOException
	{
		homePage = signinPage.signIn(prop.getProperty("email"),prop.getProperty("password")); 
		
		  //Take screen shot of test File
		  File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(srcFile, new File("C:\\Users\\juhip\\eclipse-workspace\\TestBase\\ScreenShots\\login.png"));
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
}
