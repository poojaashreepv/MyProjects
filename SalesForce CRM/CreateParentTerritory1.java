package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateParentTerritory1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateParentTerritory")
	public void CreateParentTerritory(String name,String name1) {
		//3) Click on the App Launcher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//5) Click on Service Territories
		WebElement serviceTerritories = driver.findElement(By.xpath("//p[text()='Service Territories']"));
		Actions action=new Actions(driver);
		action.moveToElement(serviceTerritories).click(serviceTerritories).perform();
		//Thread.sleep(2000);
		//6) Click on Parent Territory Input field of newly created Service Territory
		WebElement parentTerritory = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[5]"));
		WebElement button = driver.findElement(By.xpath("(//button[@class='slds-button trigger slds-button_icon-border'])[4]"));
		action.moveToElement(parentTerritory).click(button).perform();
		//7) Under that Click on New Service Territory
		driver.findElement(By.xpath("//span[@title='New Service Territory']")).click();
		//8) Enter Name
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(name);
		//9) Click on Search Operating Hours
		driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).click();
		//10)  Click New Operating Hours in the DropDown
		driver.findElement(By.xpath("//span[text()='New Operating Hours']")).click();
		//11) Enter Name
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys(name1);
		//12) Select Time as India standard Time(Asia/Kolkata)
		driver.findElement(By.xpath("(//div[@class='uiMenu'])[3]")).click();
		driver.findElement(By.xpath("//a[@title='(GMT+05:30) India Standard Time (Asia/Kolkata)']")).click();
		//13) Click on Save
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		//14) Verify Name of Operating Hours
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(text);
        //Thread.sleep(2000);
        String text1 = driver.findElement(By.xpath("//span[@class='pillText']")).getText();
        System.out.println(text1);
        //Thread.sleep(2000);
        if(text1.contains("Mukesh Ambani")) {
        	System.out.println("Operating Hours is Created by Name Mukesh Ambani");
        }
        else {
        	System.out.println("Operating Hours is Not Created");
        }
        //15) Click on Save
        driver.findElement(By.xpath("(//button[@title='Save'])[1]")).click();
        //16) Verify Whether Parent Territory is Created Successfully 
        String text2 = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(text2);
        //Thread.sleep(2000);
        String text3 = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[5]")).getText();
        System.out.println(text3);
        if(text3.contains(name)) {
        	System.out.println("Parent Territory is Created");
        }
        else {
        	System.out.println("Parent Territory is Not Created");
        }
        

	}
	@DataProvider(name="CreateParentTerritory")
	public String[][] sendData() {	
		data=new String[2][2];
		data[0][0]="Mukesh Ambani";
        data[0][1]="Mukesh Ambani";
        data[1][0]="Ambani";
        data[1][1]="Ambani";
        return data;	
    }

}
