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

public class CreateLegalEntityWithoutManatoryFields1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateLegalEntityWithoutManatoryFields")
	public void CreateLegalEntityWithoutManatoryFields(String cname,String desc) {
		//3. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement legalEntities = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		Actions action=new Actions(driver);
		action.moveToElement(legalEntities).click(legalEntities).perform();
	    //Thread.sleep(2000);
	    //5. Click on the Dropdown icon in the legal Entities tab
	    WebElement legalEntitiesdd = driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]"));
	    action.moveToElement(legalEntitiesdd).click(legalEntitiesdd).perform();
	    //Thread.sleep(2000);
	    //6. Click on New Legal Entity
	    WebElement newLegalEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
	    action.moveToElement(newLegalEntity).click(newLegalEntity).perform();
	    //Thread.sleep(2000);
	    //7. Enter the Company name.
	    driver.findElement(By.xpath("//label[text()='Company Name']")).click();
        driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys(cname,Keys.ENTER);
        //8. Enter Description.
        driver.findElement(By.xpath("//label[text()='Description']")).click();
        driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(desc,Keys.ENTER);
        //9. Select Status as 'Active'
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        //Thread.sleep(2000);
        WebElement status = driver.findElement(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']"));
        action.moveToElement(status).perform();
	    //Thread.sleep(2000);
	    status.click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[@title='Active']")).click();
	    //Thread.sleep(2000);
	    //10. Click on Save
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    //Thread.sleep(2000);
	    //11. Verify the Alert message (Complete this field) displayed for Name
	    String errorMessage = driver.findElement(By.xpath("//div[@class='container']")).getText();
	    System.out.println("Error Message : " +errorMessage);
	    System.out.println("********");
	    String errorMessage1 = driver.findElement(By.xpath("//div[@class='slds-form-element__help slds-m-left_none']")).getText();
	    System.out.println("Alert Message : " +errorMessage1);
	    System.out.println("********");
	    String errorMessage2 = driver.findElement(By.xpath("//lightning-input[@class='slds-form-element slds-form-element_stacked slds-has-error']")).getText();
		System.out.println("Alert Message : " +errorMessage2);
		if(errorMessage2.contains("Complete this field")) {
			System.out.println("Alert Message is Displayed as Complete this field");
		}
		else {
			System.out.println("Alert Message is not Displayed as Complete this field for Name");
		}
   	}
	@DataProvider(name="CreateLegalEntityWithoutManatoryFields")
	public String[][] sendData() {	
		data=new String[2][1];
		data[0][0]="Testleaf";
        data[1][0]="SalesForce";
        return data;	
    }

}
