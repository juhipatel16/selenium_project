package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Util.TestUtil;

public class ParentClass {

		// Global Variable
		public static WebDriver driver;
		public static Properties prop;		
	
	public ParentClass()
	{
	// Read Properties from config.properties file.
		try
		{
			prop=new Properties();
			FileInputStream File= new FileInputStream("C:\\Users\\juhip\\eclipse-workspace\\TestBase\\src\\"
													+ "main\\java\\EnviornmentVariable\\config.properties");
			prop.load(File);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	} 
	
	public static void initalization()
	{
		//String broswerName=prop.getProperty("browser");
	
			System.setProperty("webdriver.gecko.driver", "C:\\QA_SW\\geckodriver.exe");
			driver = new FirefoxDriver();
	
			
		/*else if (broswerName=="Chrome") 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\QA_SW\\chromedriver.exe");
			driver = new ChromeDriver();
		}*/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// time can be changes according to page so we will put static in TestUtil.java class.
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}	
	
	public static void signInLink()
	{
		driver.findElement(By.xpath("//span[contains(text(),'My account')]")).click();  // Sign In Link
	}
}
