package Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil
{
	public static WebDriver driver;
	
	// Page_timeout can be changed according to different websites so we are make it static & public.
	public static long Page_timeout=40; 
	
	public static long implicit_wait=40;
	
	public static void takeScreenShotAtEndOfTest() throws IOException
	{
	//Take screen shot of test
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(srcFile, new File(currentDir + "/ScreenShots/" + System.currentTimeMillis() + ".png"));
	}
}
