package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EditTask extends BaseClass {
	String[][] data;
	@Test
	public void EditTask() throws InterruptedException {
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
	        Thread.sleep(2000);
	    	driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-container-more']")).click();
        	driver.findElement(By.xpath("//li[@title='Table']")).click();
        	//6.Click on Dropdown icon available under tasks and select value as Recently viewed
        	driver.findElement(By.xpath("//button[@class='slds-button slds-button--reset downIcon slds-m-top_xxx-small slds-p-right_xxx-small']")).click();
        	driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();
        	Thread.sleep(2000);
        	//7. Click the Dropdown for Bootcamp task and select Edit
        	driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[7]/span/div/a/span")).click();
        	driver.findElement(By.xpath("//a[@title='Edit']")).click();
        	//8. Select todays date as Due date
        	driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).click();
        	driver.findElement(By.xpath("//button[text()='Today']")).click();
        	//9. Select Priority as low
        	driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
        	driver.findElement(By.xpath("//a[@title='Low']")).click();
        	//10. Click save and verify Subject
        	driver.findElement(By.xpath("//button[@title='Save']")).click();
        	String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        	System.out.println(text);
        	Thread.sleep(2000);
        	if(text.contains("Bootcamp")) {
        	   System.out.println("Task was Edited");
        	}
        	else {
        	   System.out.println("Task was Not Edited");
        	}
	}
}
