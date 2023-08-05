package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateNewDashboard1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateNewDashboard")
	public void CreateNewDashboard(String name) {
		//3. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement dashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		Actions action=new Actions(driver);
		action.moveToElement(dashboards).click(dashboards).perform();
	    //Thread.sleep(2000);
	    //5. Click on the New Dashboard option
	    driver.findElement(By.xpath("//a[@title='New Dashboard']")).click();
	    //6. Enter Name as 'Salesforce Automation by *Your Name* ' and Click on Create.
	    WebElement frame1 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
	    driver.switchTo().frame(frame1);
	    driver.findElement(By.xpath("//label[@for='dashboardNameInput']")).click();
	    driver.findElement(By.xpath("(//input[@class='slds-input'])[1]")).sendKeys(name,Keys.ENTER);
	    driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
	    //Thread.sleep(2000);
        driver.switchTo().defaultContent();
	    //7.Click on Save and Verify Dashboard name.
        WebElement frame2 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
        driver.switchTo().frame(frame2);
	    WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
	    action.moveToElement(save).click(save).perform();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[text()='Done']")).click();
	    String dashboardName = driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']")).getText();
	    System.out.println("Dashboard Name is " +dashboardName);
	    if(dashboardName.contains(name)) {
	    	System.out.println("Dashboard is Created");
	    }
	    else {
	    	System.out.println("Dashboard is Not Created");
	    }

	}
	@DataProvider(name="CreateNewDashboard")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Salesforce Automation by Poojaashree";
        data[1][0]="Automation by Poojaashree";
        return data;	
    }
	

}
