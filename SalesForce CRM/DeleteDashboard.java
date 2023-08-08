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

public class DeleteDashboard extends BaseClass {
	String[][] data;
	@Test(dataProvider="DeleteDashboard")
	public void DeleteDashboard(String dname,String dsname) throws InterruptedException {
	    //3. Click on the toggle menu button from the left corner
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    //4. Click View All and click Dashboards from App Launcher
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    WebElement dashboards = driver.findElement(By.xpath("//p[text()='Dashboards']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(dashboards).click(dashboards).perform();
	    Thread.sleep(2000);
	    //5. Click on the Dashboards tab 
	    WebElement dashboards1 = driver.findElement(By.xpath("(//span[text()='Dashboards'])[1]"));
	    action.moveToElement(dashboards1).click(dashboards1).perform();
	    //Thread.sleep(2000);
	    //6. Search the Dashboard 
	    driver.findElement(By.xpath("//input[@type='text']")).click();
	    WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
	    search.sendKeys(dname,Keys.ENTER);//couldnt search full name able to enter upto Salesforce Automation by
	    //Thread.sleep(2000);
	    //7. Click on the Dropdown icon and Select Delete
	    WebElement optiondd = driver.findElement(By.xpath("//table[contains(@class,'slds-table slds-table_header')]/tbody/tr[1]//td[6]/lightning-primitive-cell-factory/span/div/lightning-primitive-cell-actions/lightning-button-menu/button"));
	    action.moveToElement(optiondd).perform();
            Thread.sleep(2000);
            optiondd.click();
            Thread.sleep(2000);
            WebElement delete = driver.findElement(By.xpath("//span[text()='Delete']"));
            action.moveToElement(delete).perform();
            Thread.sleep(2000);
            delete.click();
            //8.Click on the Delete option in the displayed popup window.
            driver.findElement(By.xpath("//button[@title='Delete']")).click();
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
            System.out.println(text);
            //9. Verify Whether Dashboard is Deleted using Dashboard Name
            search.clear();
            search.sendKeys(dsname,Keys.ENTER);
            String text2 = driver.findElement(By.xpath("//div[@class='emptyMessageContainer folderListView']")).getText();
	    if(text2.equals("No results found")) {
	    	System.out.println("Dashboard was Deleted");
	    	
	    }
	    else {
	    	System.out.println("Dashboard was Not Deleted");
	    }
        
	}
	@DataProvider(name="DeleteDashboard")
	public String[][] sendData() {	
		data=new String[1][2];
		data[0][0]="Salesforce Automation by Poojaashree";
        	data[0][1]="Salesforce Automation by Poojaashree";
		return data;
		
    }

}
