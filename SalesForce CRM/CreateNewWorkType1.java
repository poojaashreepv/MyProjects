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

public class CreateNewWorkType1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateNewWorkType")
	public void CreateNewWorkType(String wname,String desc,String ohours,String estduration) {
		//3) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//5) Click on Work Types
		WebElement workTypes = driver.findElement(By.xpath("//p[text()='Work Types']"));
		Actions action=new Actions(driver);
		action.moveToElement(workTypes).click(workTypes).perform();
	    //Thread.sleep(2000);
	    //6) Click on New
	    driver.findElement(By.xpath("//div[@title='New']")).click();
	    //7) Enter Work Type Name 
	    driver.findElement(By.xpath("(//span[text()='Work Type Name'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(wname,Keys.ENTER);
	    //8) Enter Description as 'Specimen'
	    driver.findElement(By.xpath("(//span[text()='Description'])[2]")).click();
	    driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(desc,Keys.ENTER);
	    //9) Create new operating hours by Entering a name as 'UK Shift'
	    driver.findElement(By.xpath("//input[@placeholder='Search Operating Hours...']")).click();
	    driver.findElement(By.xpath("//span[text()='New Operating Hours']")).click();
	    driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys(ohours);
	    driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
	    //Thread.sleep(2000);
	    //10) Enter Estimated Duration as '7'
	    WebElement estimatedDuration = driver.findElement(By.xpath("(//span[text()='Estimated Duration'])[2]"));
	    driver.executeScript("arguments[0].click();", estimatedDuration);
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(estduration,Keys.ENTER);
	    //Thread.sleep(2000);
	    //11) Click on Save
	    driver.findElement(By.xpath("//button[@title='Save']")).click();
	    //Thread.sleep(2000);
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(text);
        //Thread.sleep(2000);
	    //12) Verify the Created message 
	    String workTypeName = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]")).getText();
	    System.out.println("The Work Type Name is " +workTypeName);
	    if(workTypeName.contains(wname)) {
	    	System.out.println("Work Type was Created");
	    }
	    else {
	    	System.out.println("Work Type was Not Created");
	    }
		

	}
	@DataProvider(name="CreateNewWorkType")
	public String[][] sendData() {	
		data=new String[2][4];
		data[0][0]="Salesforce Project";
        data[0][1]="Specimen";
        data[0][2]="UK Shift";
        data[0][3]="7";
		data[1][0]="Salesforce Project";
        data[1][1]="Automation Testing";
        data[1][2]="UK Shift";
        data[1][3]="8";
        return data;	
    }

}
