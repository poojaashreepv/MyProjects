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

public class EditWorkTypeGroup1 extends BaseClass{
	String[][] data;
	@Test(dataProvider="EditWorkTypeGroup")
	public void EditWorkTypeGroup(String worktypegroupname,String desc) {
		//3. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click View All and click Work Type Groups from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement workTypeGroups = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		Actions action=new Actions(driver);
		action.moveToElement(workTypeGroups).click(workTypeGroups).perform();
	    //Thread.sleep(2000);
	    //5. Click on the Work Type Group tab 
	    driver.navigate().refresh();
	    WebElement workTypeGroupsTab = driver.findElement(By.xpath("//a[@title='Work Type Groups']"));
	    action.moveToElement(workTypeGroupsTab).click(workTypeGroupsTab).perform();
	    //Thread.sleep(2000);
	    //6. Search the Work Type Group 
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(worktypegroupname,Keys.ENTER);
        //Thread.sleep(2000);
        //7. Click on the Dropdown icon and Select Edit
        WebElement workTypeGroupsdd = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[5]/span/div/a"));
        action.moveToElement(workTypeGroupsdd).perform();
	    //Thread.sleep(2000);
	    workTypeGroupsdd.click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@title='Edit']")).click();
	    //8.Enter Description as 'Automation'.
	    driver.findElement(By.xpath("//label[text()='Description']")).click();
	    driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow textarea-container']")).sendKeys(desc,Keys.ENTER);
	    //9.Select Group Type as 'Capacity'
	    WebElement groupType = driver.findElement(By.xpath("//button[@role='combobox']"));
	    action.moveToElement(groupType).perform();
	    //Thread.sleep(2000);
	    groupType.click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Capacity']")).click();
	    //10.Click on Save
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    //Thread.sleep(2000);
	    //11. Click on Work type Group Name and Verify Description
	    driver.findElement(By.xpath("(//a[@data-refid='recordId'])[1]")).click();
	    //Thread.sleep(2000);
	    String description = driver.findElement(By.xpath("(//lightning-formatted-text[@slot='outputField'])[2]")).getText();
	    System.out.println("The Description is " +description);
	    if(description.contains(desc)) {
	    	System.out.println("The Work Type Group is Edited the Description is Automation");
	    }
	    else {
	    	System.out.println("The Work Type Group is Not Edited");
	    }
	    
	}
	@DataProvider(name="EditWorkTypeGroup")
	public String[][] sendData() {	
		data=new String[2][2];	
        data[0][0]="Salesforce Automation by Poojaashree";
        data[0][1]="Automation Testing";
        data[1][0]="Automation by Poojaashree";
        data[1][1]="Software Testing";
	    return data;
		
    }

}
