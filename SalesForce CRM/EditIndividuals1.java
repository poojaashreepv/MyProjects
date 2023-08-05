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

public class EditIndividuals1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="EditIndividuals")
	public void EditIndividuals(String iname,String fname) {
		//3. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click View All and click Individuals from App Launcher 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement individuals = driver.findElement(By.xpath("//p[text()='Individuals']"));
		Actions action=new Actions(driver);
		action.moveToElement(individuals).click(individuals).perform();
	    //Thread.sleep(2000);
	    //5. Click on the Individuals tab 
	    WebElement individualsTab = driver.findElement(By.xpath("(//span[text()='Individuals'])[1]"));
	    action.moveToElement(individualsTab).click(individualsTab).perform();
	    //Thread.sleep(2000);
	    //6. Search the Individuals 'Kumar'
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(iname,Keys.ENTER);
	    //Thread.sleep(2000);
	    WebElement lastModifiedDate = driver.findElement(By.xpath("//span[@title='Last Modified Date']"));
	    action.moveToElement(lastModifiedDate).click(lastModifiedDate).perform();
	    //Thread.sleep(2000);
	    //7. Click on the Dropdown icon and Select Edit
	    WebElement optiondd = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[6]/span/div/a"));
	    action.moveToElement(optiondd).perform();
        //Thread.sleep(2000);
        optiondd.click();
        //Thread.sleep(2000);
        WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']"));
        action.moveToElement(edit).perform();
        //Thread.sleep(2000);
        edit.click();
        //8.Select Salutation as 'Mr'
        WebElement salutation = driver.findElement(By.xpath("(//a[@class='select'])[1]"));
        action.moveToElement(salutation).click(salutation).perform();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Mr.']")).click();
        //9.Enter the first name
        driver.findElement(By.xpath("//span[text()='First Name']")).click();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(fname,Keys.ENTER);
        //10. Click on Save and Verify the first name 
        driver.findElement(By.xpath("//button[@title='Save']")).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@data-refid='recordId'])[1]")).click();
        String individualName = driver.findElement(By.xpath("//span[@class='uiOutputText']")).getText();
        System.out.println("Individual Name is " +individualName);
        if(individualName.contains(fname)) {
        	System.out.println("Individual is edited First Name is Ganesh");
        }
        else {
        	System.out.println("Individual is edited First Name is not Ganesh");
        }
	}
	@DataProvider(name="EditIndividuals")
	public String[][] sendData() {	
		data=new String[2][2];
		data[0][0]="Shree";
		data[0][1]="Poojaa";
        data[1][0]="Sri";
        data[1][1]="Kavya";
        return data;	
    }

}
