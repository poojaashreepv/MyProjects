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

public class CreateIndividuals1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateIndividuals")
	public void CreateIndividuals(String lname) {
		//3. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click View All and click Individuals from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement individuals = driver.findElement(By.xpath("//p[text()='Individuals']"));
		Actions action=new Actions(driver);
		action.moveToElement(individuals).click(individuals).perform();
	    //Thread.sleep(2000);
	    //5. Click on the Dropdown icon in the Individuals tab
	    WebElement individualsdd = driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]"));
	    action.moveToElement(individualsdd).click(individualsdd).perform();
	    //Thread.sleep(2000);
	    //6. Click on New Individual
	    WebElement newIndividual = driver.findElement(By.xpath("//span[text()='New Individual']"));
	    action.moveToElement(newIndividual).click(newIndividual).perform();
	    //Thread.sleep(2000);
	    //7. Enter the Last Name 
	    driver.findElement(By.xpath("//span[text()='Last Name']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lname,Keys.ENTER);
	    //8.Click save and verify Individuals Name
	    driver.findElement(By.xpath("//button[@title='Save']")).click();
	    String individualName = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]")).getText();
	    System.out.println("Individual Name is " +individualName);
	    if(individualName.contains(lname)) {
	    	System.out.println("Individual is Created");
	    }
	    else {
	    	System.out.println("Individual is Not Created");
	    }
	    
	}
	@DataProvider(name="CreateIndividuals")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Shree";
        data[1][0]="Sri";
        return data;	
    }

}
