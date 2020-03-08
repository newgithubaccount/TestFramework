package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class SeleniumUtils {
	
	public WebDriver driver;
	public ExtentTest test;
	public SeleniumUtils(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
	}
	
	public void compareValues(String actual,String expected)
	{
		boolean result=actual.equals(expected);
		if(!result)
			test.log(Status.FAIL, "Comparision Failed, Actual: "+actual+",Expected: "+expected);
		else
			test.log(Status.PASS, "Comparision Passed, Actual: "+actual+",Expected: "+expected);
		Assert.assertEquals(actual, expected);
	}
	
	public void sendData(WebElement element,String data,String message)
	{
		element.sendKeys(data);
		test.log(Status.INFO, "Entering the data for "+message);
	}
	public void click(WebElement element,String message)
	{
		element.click();
		test.log(Status.INFO, "CLicking element "+message);
	}

}
