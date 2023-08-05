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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
		node = test.createNode(testName);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
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
		ExtentHtmlReporter repo=new ExtentHtmlReporter("./report/LeafTapsLeadsReport.html");
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
    public void switchToWindow(int index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<String>(allWindows);
			String exWindow = allhandles.get(index);
			driver.switchTo().window(exWindow);
			System.out.println("The Window With index: "+index+" switched successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With index: "+index+" not found");	
		}
	}
	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}



