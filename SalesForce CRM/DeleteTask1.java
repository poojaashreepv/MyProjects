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

public class DeleteTask1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="DeleteOpportunity")
	public void DeleteTask(String tname) {
		//3. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//Thread.sleep(2000);
		//5. Click on Tasks tab 
		WebElement tasks = driver.findElement(By.xpath("//span[text()='Tasks']"));
		Actions action=new Actions(driver);
		action.moveToElement(tasks).click(tasks).perform();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-container-more']")).click();
        driver.findElement(By.xpath("//li[@title='Table']")).click();
	    //6.Click on Dropdown icon available under tasks and select value as Recently viewed
        driver.findElement(By.xpath("//button[@class='slds-button slds-button--reset downIcon slds-m-top_xxx-small slds-p-right_xxx-small']")).click();
        driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();
        //Thread.sleep(2000);
        //7. Click the Dropdown for Bootcamp task and select Delete
        driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[7]/span/div/a/span")).click();
        driver.findElement(By.xpath("//a[@title='Delete']")).click();
        driver.findElement(By.xpath("//button[@title='Delete']")).click();
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(text);
        //Thread.sleep(2000);
        //8. Verfiy the Task is Deleted 
        driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(tname,Keys.ENTER);
        //Thread.sleep(2000);
        String text2 = driver.findElement(By.xpath("//div[@class='emptyContentInner slds-text-align_center']")).getText();
        if(text2.contains("No items to display.")) {
        	System.out.println("Task was Deleted");
        }
        else {
        	System.out.println("Task was Not Deleted");
        }
	
	}
	@DataProvider(name="DeleteTask")
	public String[][] sendData() {	
		data=new String[1][1];	
        data[0][0]="Bootcamp";
	    return data;
		
    }

}
