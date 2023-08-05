package pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.aventstack.extentreports.ExtentTest;
import baseclass.BaseClass;

public class MyHomePage1 extends BaseClass {
	public MyHomePage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	
	public MyLeadsPage clickOnLeadsButton() throws IOException {
		try {
			driver.findElement(By.xpath("//a[text()='Leads']")).click();
			reportStep("Pass", "Leads Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail","Leads Button is Not Clicked Successfully" +e);
		}
		return new MyLeadsPage(driver , node);
	}

}
