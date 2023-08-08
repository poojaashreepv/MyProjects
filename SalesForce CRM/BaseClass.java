package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	public RemoteWebDriver driver;
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void preCondition(String browser,String url,String username,String password) {
		//1. Launch Salesforce application.
		//2. Login with username and password.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		if(browser.equalsIgnoreCase("chrome")) 
		{
	           driver= new ChromeDriver(options);
	        }
                else if(browser.equalsIgnoreCase("edge"))
	        {
		driver=new EdgeDriver();
	        }
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}

}
