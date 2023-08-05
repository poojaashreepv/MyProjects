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

public class CreateWorkTypeGroup1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateWorkTypeGroup")
	public void CreateWorkTypeGroup(String worktypegroupname) {
		//3. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        //4. Click View All and click Work Type Groups from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement workTypeGroups = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		Actions action=new Actions(driver);
		action.moveToElement(workTypeGroups).click(workTypeGroups).perform();
	    //Thread.sleep(2000);
	    //5. Click on the Dropdown icon in the Work Type Groups tab
	    WebElement workTypeGroupsdd = driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]"));
	    action.moveToElement(workTypeGroupsdd).click(workTypeGroupsdd).perform();
	    //Thread.sleep(2000);
	    //6. Click on New Work Type Group
	    WebElement newWorkTypeGroup = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
	    action.moveToElement(newWorkTypeGroup).click(newWorkTypeGroup).perform();
	    //Thread.sleep(2000);
	    //7. Enter Work Type Group Name
	    driver.findElement(By.xpath("(//label[@part='label'])[2]")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(worktypegroupname,Keys.ENTER);
	    //8.Click save and verify Work Type Group Name
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    String workTypeGroupName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
	    System.out.println("Work Type Group Name is " +workTypeGroupName);
	    if(workTypeGroupName.contains(worktypegroupname)) {
	    	System.out.println("Work Type Group is created");
	    }
	    else {
	    	System.out.println("Work Type Group is not created");
	    }
	}
	@DataProvider(name="CreateWorkTypeGroup")
	public String[][] sendData() {	
		data=new String[2][1];	
        data[0][0]="Salesforce Automation by Poojaashree";
        data[1][0]="Automation by Poojaashree";
	    return data;
		
    }

}
