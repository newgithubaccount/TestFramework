package testing.com.NiramalaFramework;

import org.testng.annotations.Test;

import pageobjects.HomePage;

import com.aventstack.extentreports.Status;

public class FirstTest extends BaseTest{
	@Test
	public void verifyTitle()
	{
		test=extent.createTest("Verify Title");
		HomePage homePage=new HomePage(driver, test);
		homePage.verifyTtitle("Air Canada - The Official Website");
	//	homePage.fillDetails();
		
	}
//	@Test
	public void verifyTitle1()
	{
		test=extent.createTest("Verify Title1");
		HomePage homePage=new HomePage(driver, test);
		homePage.verifyTtitle("Air Canada - The Official Website1");
	}
}
