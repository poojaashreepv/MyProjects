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

public class CreateServiceTerritories extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateServiceTerritories")
	public void CreateServiceTerritories(String name,String city,String state,String country,String zipcode) throws InterruptedException {
	    //3) Click on the App Laucher Icon left to Setup
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    //4) Click on View All
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    //5) Click on Service Territories
	    WebElement serviceTerritories = driver.findElement(By.xpath("//p[text()='Service Territories']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(serviceTerritories).click(serviceTerritories).perform();
	    Thread.sleep(2000);
	    //6) Click on New 
	    driver.findElement(By.xpath("//a[@title='New']")).click();
	    //7) Enter Your Name
	    driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name,Keys.ENTER);
	    //8) Click on Operating Hours and Choose the First option
	    driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[2]")).click();
	    driver.findElement(By.xpath("(//span[@class='slds-media__body'])[1]")).click();
	    //9) Check Active Field
	    WebElement activeField = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
	    driver.executeScript("arguments[0].click();", activeField);
	    //10) Enter the City your residing in City Field
	    driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city,Keys.ENTER);
	    //11) Enter the State your residing in State Field
	    driver.findElement(By.xpath("//input[@name='province']")).sendKeys(state,Keys.ENTER);
	    //12) Enter the Country your residing in Country Field
	    driver.findElement(By.xpath("//input[@name='country']")).sendKeys(country,Keys.ENTER);
	    //13) Enter your current Postal Zip Code 
	    driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(zipcode,Keys.ENTER);
	    //14) Click on Save
	    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    //15) Verify Service Territory is created Successfully
	    String serviceTerritoryName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
	    System.out.println("Service Territory Name : " +serviceTerritoryName);
	    if(serviceTerritoryName.contains("Poojaashree")) {
	    	System.out.println("Service Territory is Created");
	    }
	    else {
	    	System.out.println("Service Territory is Not Created");
	    }
	    
	}
	@DataProvider(name="CreateServiceTerritories")
	public String[][] sendData() {	
		data=new String[2][5];
		data[0][0]="Poojaashree";
        	data[0][1]="Salem";
        	data[0][2]="Tamil Nadu";
        	data[0][3]="India";
        	data[0][4]="636030";
        	data[1][0]="Sri";
        	data[1][1]="Coimbatore";
        	data[1][2]="Tamil Nadu";
        	data[1][3]="India";
        	data[1][4]="641001";
        	return data;	
    }

}
