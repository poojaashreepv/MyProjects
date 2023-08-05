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

public class DeleteWorkTypeGroup1 extends BaseClass {
	String[][] data;
	@Test 
	public void DeleteWorkTypeGroup(String worktypegroupname) {
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
	    //Thread.sleep(2000);
	    WebElement workTypeGroupsTab = driver.findElement(By.xpath("//a[@title='Work Type Groups']"));
	    action.moveToElement(workTypeGroupsTab).click(workTypeGroupsTab).perform();
	    //Thread.sleep(2000);
	    //6. Search the Work Type Group 
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(worktypegroupname,Keys.ENTER);
        //Thread.sleep(2000);
        //7. Click on the Dropdown icon and Select Delete
        WebElement workTypeGroupsdd = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[5]/span/div/a"));
        action.moveToElement(workTypeGroupsdd).perform();
	    //Thread.sleep(2000);
	    workTypeGroupsdd.click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@title='Delete']")).click();
	    //8.Click on the Delete option in the displayed popup window.
	    driver.findElement(By.xpath("//button[@title='Delete']")).click();
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(text);
        //9. Verify Whether Work Type group is Deleted using Work Type Group Name
        if(text.contains(worktypegroupname)) {
        	System.out.println("Work Type Group was Deleted");
        }
        else {
        	System.out.println("Work Type Group was Not Deleted");
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
