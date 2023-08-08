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

public class EditDashboard extends BaseClass {
	String[][] data;
	@Test 
	public void EditDashboard(String dname,String desc) throws InterruptedException {
		//3. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement dashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		Actions action=new Actions(driver);
		action.moveToElement(dashboards).click(dashboards).perform();
	        Thread.sleep(2000);
	        5. Click on the Dashboards tab 
	        WebElement dashboards1 = driver.findElement(By.xpath("(//span[text()='Dashboards'])[1]"));
	        action.moveToElement(dashboards1).click(dashboards1).perform();
	        Thread.sleep(2000);
	        //6. Search the Dashboard 'Salesforce Automation by *Your Name*'
	    	driver.findElement(By.xpath("//input[@type='text']")).click();
	    	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(dname,Keys.ENTER);
	    	Thread.sleep(2000);
	    	//7. Click on the Dropdown icon and Select Edit
	    	WebElement optiondd = driver.findElement(By.xpath("//table[contains(@class,'slds-table slds-table_header')]/tbody/tr[1]//td[6]/lightning-primitive-cell-factory/span/div/lightning-primitive-cell-actions/lightning-button-menu/button"));
	    	action.moveToElement(optiondd).perform();
        	Thread.sleep(2000);
        	optiondd.click();
        	Thread.sleep(2000);
        	WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
        	action.moveToElement(edit).perform();
        	Thread.sleep(2000);
        	edit.click();
        	//8.Click on the Edit Dashboard Properties icon
        	WebElement frame1 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
	        driver.switchTo().frame(frame1);
        	WebElement editDashboardProperties = driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']"));
        	action.moveToElement(editDashboardProperties).click(editDashboardProperties).perform();
	        Thread.sleep(2000);
	    	//9. Enter Description as 'SalesForce' and click on save.
	    	driver.findElement(By.xpath("//label[text()='Description']")).click();
	    	driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys(desc,Keys.ENTER);
	    	driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
	    	Thread.sleep(1000);
	    	//10. Click on Done and  Click on save in the popup window displayed.
	    	driver.findElement(By.xpath("//button[text()='Done']")).click();
	    	driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	    	//10. Verify the Description.
	    	String description = driver.findElement(By.xpath("//p[@class='slds-page-header__info']")).getText();
	    	System.out.println("The Description is " +description);
	    	if(description.contains(desc)) {
	    	   System.out.println("The Description is added to Dashboard");
	    	}
	    	else {
	    	   System.out.println("The Description is not added to Dashboard");
	    	}
	    
	}
	@DataProvider(name="EditDashboard")
	public String[][] sendData() {	
		data=new String[2][2];
		data[0][0]="Salesforce Automation by Poojaashree";
		data[0][1]="SalesForce";
        	data[1][0]="Automation by Poojaashree";
        	data[1][1]="Automation Testing";
        	return data;	
    }

}
