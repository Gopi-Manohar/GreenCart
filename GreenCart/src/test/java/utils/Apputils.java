package utils;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;

public class Apputils 

{
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static HTMLReporter html;
	
	@BeforeSuite
	public static void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SPURGE\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Date d = new Date();
		String reportName = d.toString().replace(" ", "-").replace(":", "-");
		report = new ExtentReports(".//extentreports//" + reportName +".html", true);
		test = report.startTest("SBI test");
		driver.get("https://sbi.co.in");
	}
	
	@AfterClass
	public void endTest()
	{
		report.endTest(test);
		report.flush();
	}
	@AfterSuite
	public static void closeBrowser()
	{
		driver.close();
		report.endTest(test);
		report.flush();
	}
	
}
