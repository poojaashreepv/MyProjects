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

public class CreateCaseWithoutMandatoryFields1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateCaseWithoutMandatoryFields")
	public void CreateCaseWithoutMandatoryFields(String sub,String desc) {
		//3. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//Thread.sleep(2000);
		//5. Click on Cases tab 
		WebElement moredd = driver.findElement(By.xpath("//a[@class='slds-button slds-button_reset slds-context-bar__label-action']"));
		Actions action=new Actions(driver);
		action.moveToElement(moredd).click(moredd).perform();
	    //Thread.sleep(2000);
	    WebElement cases = driver.findElement(By.xpath("(//span[text()='Cases'])[2]"));
	    action.moveToElement(cases).click(cases).perform();
	    //Thread.sleep(2000);
	    //6) Click on New button
	    driver.findElement(By.xpath("//div[text()='New']")).click();
	    //7) Choose Contact Name from DropDown
	    driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[1]")).click();
	    driver.findElement(By.xpath("//span[@title='Poojaashree P V']")).click();
	    //8) Select status as None
	    driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")).click();
	    driver.findElement(By.xpath("//span[text()='--None--']")).click();
	    //9) Enter Subject and description 
	    driver.findElement(By.xpath("(//input[@class='slds-input'])[7]")).sendKeys(sub,Keys.ENTER);
	    driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[1]")).sendKeys(desc,Keys.ENTER);
	    //10) Click 'Save'
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    //11)Get the text of Error message Displayed and Verify the message
	    String text = driver.findElement(By.xpath("//div[@class='container']")).getText();
	    System.out.println(text);
	    String text2 = driver.findElement(By.xpath("//lightning-combobox[@class='slds-form-element slds-form-element_stacked slds-has-error']")).getText();
	    System.out.println(text2);
	    String text3 = driver.findElement(By.xpath("//lightning-combobox[@class='slds-form-element_stacked slds-form-element slds-has-error']")).getText();
	    System.out.println(text3);
	    if((text.contains("Status")) && (text.contains("Case Origin"))) {
	    	System.out.println("Complete this field message is displayed for Status and Case Origin");
	    }
	    else {
	    	System.out.println("Complete this field message is Not displayed for Status and Case Origin");
	    }
	}
	 @DataProvider(name="CreateCaseWithoutMandatoryFields")
		public String[][] sendData() {	
			data=new String[2][2];
			
	        data[0][0]="Testing";
	        data[0][1]="Automation Testing";
	        data[1][0]="Testing";
	        data[1][1]="Software Testing";
		    return data;
			
	    }

}
