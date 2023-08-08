package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateServiceResources extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateServiceResources")
	public void CreateServiceResources(String name) throws InterruptedException {
		//3) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		//4) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//5) Click on Service Resources
		WebElement serviceResources = driver.findElement(By.xpath("//p[text()='Service Resources']"));
		driver.executeScript("arguments[0].click();", serviceResources);
		//6) Click on Show one more action Dropdown
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		//7) Click on edit
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//8) Change the Name
		driver.findElement(By.xpath("//input[@name='Name']")).clear();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		//9) Click on save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(2000);
		//10) Verify the new name has changed
		String text = driver.findElement(By.xpath("//div[@role='alertdialog']")).getText();
		if(text.contains(name)) {
			System.out.println("The New Name has changed");
		}
		else {
			System.out.println("The New Name has not changed");
		}
		
	}
	@DataProvider(name="CreateServiceResources")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Poojaashree";
        	data[1][0]="Sri";
        	return data;	
    }
	

}
