package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditServiceTerritories extends BaseClass {
	String[][] data;
	@Test(dataProvider="EditServiceTerritories")
	public void EditServiceTerritories(String cname) throws InterruptedException {
	    //3) Click on the App Launcher Icon left to Setup
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    //4) Click on View All
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    //5) Click on Service Territories
	    WebElement serviceTerritories = driver.findElement(By.xpath("//p[text()='Service Territories']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(serviceTerritories).click(serviceTerritories).perform();
	    Thread.sleep(2000);
	    //6) Click on Down Arrow DropDown and choose edit
	    driver.findElement(By.xpath("(//table[@role='grid']/tbody/tr[1]/td[8]/span/div/a/span/span)[1]")).click();
	    driver.findElement(By.xpath("//a[@title='Edit']")).click();
	    //7) Get the System Information Created by Using Regex print the name alone
	    String createdBy = driver.findElement(By.xpath("(//slot[text()='POOJAASHREE P V'])[2]")).getText();
	    System.out.println("Created By : " +createdBy);
	    //8) Get the System Information Modified By Using Regex print the name alone
	    String modifiedBy = driver.findElement(By.xpath("(//slot[text()='POOJAASHREE P V'])[3]")).getText();
	    System.out.println("Modified By : " +modifiedBy);
	    //9) Get the text of the owner
	    String owner = driver.findElement(By.xpath("(//slot[text()='POOJAASHREE P V'])[1]")).getText();
	    System.out.println("Owner : " +owner);
	    if(createdBy.equals(modifiedBy)) {
	    	if(owner.contains(createdBy) && owner.contains(modifiedBy)) {
	    		
	    	System.out.println("Owner,Created By and Modified By Name was Same");
	    	}
	    }
	    else {
	    	System.out.println("Owner,Created By and Modified By Name was Different");
	    }
	    //10) Change the Country name To  North America
	    driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(cname);
	    //11) Click on Save 
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    //12) Verify LastModified date 
	    String lastModifiedDate = driver.findElement(By.xpath("(//table[@role='grid']/tbody/tr[1]/td[6]/span/span)[1]")).getText();
	    System.out.println("Last Modified Date : " +lastModifiedDate);
	    
	}
	@DataProvider(name="EditServiceTerritories")
	public String[][] sendData() {	
		data=new String[1][1];
		data[0][0]="North America";
		return data;

}
}
