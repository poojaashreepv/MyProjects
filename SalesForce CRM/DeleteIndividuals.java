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

public class DeleteIndividuals extends BaseClass {
	String[][] data;
	@Test(dataProvider="DeleteIndividuals")
	public void DeleteIndividuals(String iname) throws InterruptedException {
	    //3. Click on the toggle menu button from the left corner
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    //4. Click View All and click Individuals from App Launcher
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    WebElement individuals = driver.findElement(By.xpath("//p[text()='Individuals']"));
            Actions action=new Actions(driver);
	    action.moveToElement(individuals).click(individuals).perform();
	    Thread.sleep(2000);
	    //5. Click on the Individuals tab
	    WebElement individualsTab = driver.findElement(By.xpath("(//span[text()='Individuals'])[1]"));
	    action.moveToElement(individualsTab).click(individualsTab).perform();
	    Thread.sleep(2000);
	    //6. Search the Individuals 
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(iname,Keys.ENTER);
	    Thread.sleep(2000);
	    WebElement lastModifiedDate = driver.findElement(By.xpath("//span[@title='Last Modified Date']"));
	    action.moveToElement(lastModifiedDate).click(lastModifiedDate).perform();
	    //Thread.sleep(2000);
	    //7. Click on the Dropdown icon and Select Delete
	    WebElement optiondd = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[6]/span/div/a"));
	    action.moveToElement(optiondd).perform();
            Thread.sleep(2000);
            optiondd.click();
            Thread.sleep(2000);
            WebElement delete = driver.findElement(By.xpath("//a[@title='Delete']"));
            action.moveToElement(delete).perform();
            Thread.sleep(2000);
            delete.click();
            //8.Click on the Delete option in the displayed popup window.
            driver.findElement(By.xpath("//button[@title='Delete']")).click();
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
            System.out.println(text);
            //9. Verify Whether Individual is Deleted using Individual last name
            if(text.contains("Kumar")) {
         	System.out.println("Individual is Deleted using Individual last name");
            }
            else {
        	System.out.println("Individual is Not Deleted using Individual last name");
            }

	}
	@DataProvider(name="DeleteIndividuals")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Shree";
        	data[1][0]="Sri";
        	return data;	
    }

}
