package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import utils.SeleniumUtils;

public class HomePage extends SeleniumUtils{
	
	@FindBy(how =How.ID,using="origin_R_0")
	WebElement source;
	@FindBy(how =How.ID,using="destination_label_0")
	WebElement destination;
	@FindBy(how =How.XPATH,using="//label[@for='oneWay']")
	WebElement oneWay;
	
	

	public HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
		
	}
	public void verifyTtitle(String expected)
	{
		compareValues(driver.getTitle(), expected);
	}

	public void fillDetails()
	{
		click(oneWay, "oneWay");
		sendData(source, "DEl", "Source");
		sendData(destination, "Hyd", "destination");
	}
}
