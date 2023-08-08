package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DeleteCase extends BaseClass {
	String[][] data;
	@Test
	public void DeleteCase() throws InterruptedException {
	    //3. Click on toggle menu button from the left corner
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    //4. Click view All and click Sales from App Launcher
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	    Thread.sleep(2000);
	    //5. Click on Cases tab 
	    WebElement moredd = driver.findElement(By.xpath("//a[@class='slds-button slds-button_reset slds-context-bar__label-action']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(moredd).click(moredd).perform();
	    Thread.sleep(2000);
	    WebElement cases = driver.findElement(By.xpath("(//span[text()='Cases'])[2]"));
	    action.moveToElement(cases).click(cases).perform();
	    Thread.sleep(2000);
	    //6. Click on the Dropdown icon and select Delete from the case you created by reffering "case owner alias"
	    String caseNumber = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/th")).getText();
	    System.out.println("Case Number is " +caseNumber);
	    driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[7]/span/div/a")).click();
	    driver.findElement(By.xpath("//a[@title='Delete']")).click();
	    driver.findElement(By.xpath("//button[@title='Delete']")).click();
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
            System.out.println(text);
            System.out.println("Case " + "\""+caseNumber+"\"" +  " was deleted. Undo");
            //7. Verify the case with your name is deleted or not
            if(text.equals("Case " + "\""+caseNumber+"\"" +  " was deleted. Undo")) {
        	System.out.println("Case was Deleted");
            }
            else {
        	System.out.println("Case was Not Deleted");
            }

	}

}
