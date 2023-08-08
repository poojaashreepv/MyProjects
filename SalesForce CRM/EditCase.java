package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EditCase extends BaseClass {
	String[][] data;
	@Test 
	public void Editcase() throws InterruptedException {
		//3. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//Thread.sleep(2000);
		//5. Click on Cases tab visible or select from more.
		WebElement moredd = driver.findElement(By.xpath("//a[@class='slds-button slds-button_reset slds-context-bar__label-action']"));
		Actions action=new Actions(driver);
		action.moveToElement(moredd).click(moredd).perform();
	        Thread.sleep(2000);
	        WebElement cases = driver.findElement(By.xpath("(//span[text()='Cases'])[2]"));
	    	action.moveToElement(cases).click(cases).perform();
	    	Thread.sleep(2000);
	    	//6. Click on the Dropdown icon and select Edit from the case you created by reffering "case owner alias"
	    	driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[7]/span/div/a")).click();
	    	driver.findElement(By.xpath("//a[@title='Edit']")).click();
	    	//7. Update Status as Working
	    	driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")).click();
	    	WebElement working = driver.findElement(By.xpath("//span[text()='Working']"));
	    	driver.executeScript("arguments[0].click();", working);
	    	//8. Update Priority to low
	    	driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]")).click();
	    	driver.findElement(By.xpath("//span[text()='Low']")).click();
	    	//9. Update Case Origin as Phone
	    	WebElement caseOrigin = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[4]"));
	    	driver.executeScript("arguments[0].click();", caseOrigin);
	    	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	    	//10. Update SLA violation to No
	    	WebElement slaViolation = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[8]"));
	    	driver.executeScript("arguments[0].click();", slaViolation);
	    	driver.findElement(By.xpath("//span[text()='No']")).click();
	    	//11. Click on Save and Verify Status as Working
	    	driver.findElement(By.xpath("//button[text()='Save']")).click();
	    	String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        	System.out.println(text);
        	Thread.sleep(2000);
        	String text2 = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[4]/span")).getText();
        	System.out.println("Status is " +text2);
        	if(text2.contains("Working")) {
        	   System.out.println("Status is Edited as Working");
        	}
        	else {
        		System.out.println("Status is Not Edited as Working");
        	}
	
	}

}
