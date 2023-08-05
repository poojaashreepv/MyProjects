package baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.ExcelData;

public class BaseClass {
	public ChromeDriver driver; 
	public String filename;
	public static String leadID;
	public static ExtentReports extent;
	public static ExtentTest test,node;
	public String testName,testDescription,testAuthor,testCategory,testinfo;
	@BeforeMethod
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		node = test.createNode(testName);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://dev94552.service-now.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@AfterMethod
	public void postCondition() {
		
		driver.close();
	}
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		return ExcelData.readData2(filename);
		
	}
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter repo=new ExtentHtmlReporter("./report/Report.html");
		repo.setAppendExisting(true);
		extent= new ExtentReports();
		extent.attachReporter(repo);
		
	}
	@BeforeClass
	public void testcaseDetails() {
		
		test=extent.createTest(testName,testDescription);
		
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
		test.info(testinfo);
	}
	
 	public void reportStep(String status,String message) throws IOException {
 		
 		if(status.equalsIgnoreCase("pass")) {
			node.pass(message,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".png").build());
		}
		else if(status.equalsIgnoreCase("fail")){
			node.fail(message,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".png").build());
			throw new RuntimeException("Please look into report for failure details");
		}	
    }
 	
    public int takeSnap() throws IOException {
    	
		int random=(int)( Math.random()*99999999);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./snaps/img"+random+".png");
		FileUtils.copyFile(source, destination);
		return random;
    }
    
	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}
