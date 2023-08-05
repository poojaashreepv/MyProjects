package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateTaskWithoutMandatoryFields1 extends BaseClass{
	String[][] data;
	@Test(dataProvider="CreateTaskWithoutMandatoryFields")
	public void CreateTaskWithoutMandatoryFields(String comments) {
		//3) Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4) Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//Thread.sleep(2000);
		//5) Click ontask and click New Task
		WebElement tasks = driver.findElement(By.xpath("//span[text()='Tasks']"));
		Actions action=new Actions(driver);
		action.moveToElement(tasks).click(tasks).perform();
	    //Thread.sleep(2000);
	    WebElement tasksdd = driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[3]"));
	    action.moveToElement(tasksdd).click(tasksdd).perform();
	    //Thread.sleep(2000);
	    WebElement newTask = driver.findElement(By.xpath("//span[text()='New Task']"));
	    action.moveToElement(newTask).click(newTask).perform();
	    //Thread.sleep(2000);
	    //6) Select Name from Dropdown
	    driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
	    driver.findElement(By.xpath("//div[@title='Poojaashree P V']")).click();
	    //7) Enter Comments
	    driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(comments);
	    //8) Click on Save 
	    driver.findElement(By.xpath("//button[@title='Save']")).click();
	    //9) Get the text of Error message Displayed and Verify the message
	    String text = driver.findElement(By.xpath("//div[@class='pageLevelErrors']")).getText();
	    System.out.println(text);
	    String text2 = driver.findElement(By.xpath("//div[@class='slds-form-element__help']")).getText();
	    System.out.println(text2);
	    if(text.contains("These required fields must be completed: Subject")) {
	    	System.out.println("Complete this field error message is displayed for Subject field");
	    }
	    else {
	    	System.out.println("Complete this field error message is Not displayed");
	    }

	}
	@DataProvider(name="CreateAccount")
	public String[][] sendData() {	
		data=new String[2][1];	
        data[0][0]="SALES FORCE Automation Using Selenium";
        data[1][0]="Software Testing";
	    return data;
		
    }

}
