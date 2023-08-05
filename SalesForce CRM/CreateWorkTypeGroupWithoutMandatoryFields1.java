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

public class CreateWorkTypeGroupWithoutMandatoryFields1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateWorkTypeGroupWithoutMandatoryFields")
	public void CreateWorkTypeGroupWithoutMandatoryFields(String desc) {
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
        //7.Enter Descriptionsss
	    driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow textarea-container']")).click();
	    driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow textarea-container']")).sendKeys(desc,Keys.ENTER);
        //8.Select Group Type as 'Capacity'
	    WebElement groupType = driver.findElement(By.xpath("//button[@role='combobox']"));
	    action.moveToElement(groupType).perform();
	    //Thread.sleep(2000);
	    groupType.click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Capacity']")).click();
	    //9. Click on Save
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    //Thread.sleep(2000);
	    //10. Verify the Alert message (Complete this field) displayed for Work Type Group Name
	    String alertMessage = driver.findElement(By.xpath("(//div[@role='dialog'])[3]")).getText();
	    System.out.println("Alert Message displayed is " +alertMessage);
	    System.out.println("***********");
	    String alertMessage1 = driver.findElement(By.xpath("(//div[@role='alert'])[1]")).getText();
	    System.out.println("The Alert Message is Displayed for Work Type Group Name as " +alertMessage1 );
	    System.out.println("***********");
	    if(alertMessage1.contains("Complete this field.")) {
	    	System.out.println("Complete this field message is displayed for Work Type Group Name field");
	    }
	    else {
	    	System.out.println("Complete this field message is not displayed for Work Type Group Name field");
	    }
	    
	}
	@DataProvider(name="CreateWorkTypeGroupWithoutMandatoryFields")
	public String[][] sendData() {	
		data=new String[2][1];	
        data[0][0]="Automation";
        data[1][0]="Software Testing";
	    return data;
		
    }

}
