package utils;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;

public class Apputils 

{
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static HTMLReporter html;
	
	@BeforeTest
	public static void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Date d = new Date();
		String reportName = d.toString().replace(" ", "-").replace(":", "-");
		report = new ExtentReports(".//extentreports//" + reportName +".html", true);
		test = report.startTest("GreenCart");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	@AfterClass
	public void endTest()
	{
		report.endTest(test);
		report.flush();
	}
	/*@AfterTest
	public static void closeBrowser()
	{
		driver.close();
		report.endTest(test);
		report.flush();
	}*/
	
}
