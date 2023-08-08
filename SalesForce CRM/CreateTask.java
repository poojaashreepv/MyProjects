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

public class CreateTask extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateTask")
	public void CreateTask(String search,String sub) throws InterruptedException {
	    //3) Click on Global Actions SVG icon
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    //4) Click view all
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    //5) Type task and select task
	    driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys(search,Keys.ENTER);
	    WebElement tasks = driver.findElement(By.xpath("//a[@data-label='Tasks']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(tasks).click(tasks).perform();
	    Thread.sleep(2000);
            //6) Click New Task under dropdown icon
	    WebElement tasksdd = driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[3]"));
	    action.moveToElement(tasksdd).click(tasksdd).perform();
	    Thread.sleep(2000);
	    WebElement newTask = driver.findElement(By.xpath("//span[text()='New Task']"));
	    action.moveToElement(newTask).click(newTask).perform();
	    Thread.sleep(2000);
	    //7) Enter subject 
	    driver.findElement(By.xpath("//label[@class='slds-form-element__label']")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(sub,Keys.ENTER);
	    //8) Select status as 'Waiting on someone else'
	    driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
	    driver.findElement(By.xpath("//a[@title='Waiting on someone else']")).click();
	    //9) Save and verify the 'Task created' message
	    driver.findElement(By.xpath("//button[@title='Save']")).click();
	    String taskName = driver.findElement(By.xpath("//span[@class='uiOutputText']")).getText();
	    System.out.println("Task Name is " +taskName);
	    if(taskName.contains(sub)) {
	    	System.out.println("Task is Created");
	    }
	    else {
	    	System.out.println("Task is Not Created");
	    }
	    
	}
	@DataProvider(name="CreateTask")
	public String[][] sendData() {	
		data=new String[1][2];	
        	data[0][0]="task";
        	data[0][1]="Bootcamp";
        	return data;
		
    }

}
