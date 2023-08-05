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

public class CreateIndividualsWithoutMandatoryFields1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateIndividualsWithoutMandatoryFields")
	public void CreateIndividualsWithoutMandatoryFields(String fname) {
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
	    //7.Select Salutation as 'Mr'
	    WebElement salutation = driver.findElement(By.xpath("(//a[@class='select'])[1]"));
        action.moveToElement(salutation).click(salutation).perform();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Mr.']")).click();
        //8.Enter the first name
        driver.findElement(By.xpath("//span[text()='First Name']")).click();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(fname,Keys.ENTER);
        //9. Click on Save
        driver.findElement(By.xpath("//button[@title='Save']")).click();
        //Thread.sleep(2000);
        //10. Verify the Alert message (Complete this field) displayed for the Last Name
        String alertMessage = driver.findElement(By.xpath("//ul[@class='errorsList']")).getText();
        System.out.println("Alert Message is displayed as " +alertMessage ); //"These required fields must be completed: Last Name"
        if(alertMessage.contains("Last Name")) {
        	System.out.println("The Alert Message is Displayed");
        }
        else {
        	System.out.println("The Alert Message is not Displayed");
        }
	    
	}
	@DataProvider(name="CreateIndividualsWithoutMandatoryFields")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Poojaashree";
        data[1][0]="Sri";
        return data;	
    }
	

}
