package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentTest;
import baseclass.BaseClass;

public class HomePage extends BaseClass {
	public HomePage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
     	public MyHomePage clickOnCrmsfa() throws IOException {
    		try {
			driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
			reportStep("Pass","CRM/SFA is Clicked Successfully");
		} 
		catch (Exception e) {
			reportStep("Fail","CRM/SFA is Not Clicked Successfully" +e);
		}
    	 	return new MyHomePage(driver,node);
     }

}
