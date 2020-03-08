package testing.com.NiramalaFramework;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.PropertyReader;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	PropertyReader reader=new PropertyReader();
	
	@BeforeSuite
	public void reportInitialize()
	{
		String reportName="./reports/STMExtentReport_"+System.currentTimeMillis()+".html";
		htmlReporter = new ExtentHtmlReporter(reportName);
       extent = new ExtentReports();  
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Host Name", "Swapna");
    	extent.setSystemInfo("Environment", "Production");
	extent.setSystemInfo("User Name", "Swapna");
	htmlReporter.config().setDocumentTitle("Demo Project"); 
            // Name of the report
	htmlReporter.config().setReportName("Skota "); 
            // Dark Theme
	htmlReporter.config().setTheme(Theme.STANDARD);	
	reader.ReadProperties();
	}
	@BeforeMethod
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(reader.getBaseUrl());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		
		driver.quit();
		
	}
	@AfterSuite
	public void closeReport()
	{
		extent.flush();
	}
	

}
