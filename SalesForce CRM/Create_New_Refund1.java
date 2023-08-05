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

public class Create_New_Refund1 extends BaseClass {
	String[][] data;
    @Test(dataProvider="CreateNewRefund")
	public void Create_New_Refund(String amount) {
		//3. Click on menu button from the Left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click view All and click Service Console from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement serviceConsole = driver.findElement(By.xpath("//p[text()='Service Console']"));
		Actions action=new Actions(driver);
		action.moveToElement(serviceConsole).click(serviceConsole).perform();
	    //Thread.sleep(2000);
	    //5. Click on the drop down and select Refunds
	    driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
	    driver.findElement(By.xpath("//span[text()='Refunds']")).click();
	    //Thread.sleep(2000);
	    //6. Click on New
	    WebElement newButton = driver.findElement(By.xpath("//a[@title='New']"));
	    action.moveToElement(newButton).click(newButton).perform();
	    //Thread.sleep(2000);
	    //7. Select Account name
	    driver.findElement(By.xpath("(//input[@role='combobox'])[1]")).click();
	    WebElement contact = driver.findElement(By.xpath("//div[@title='Poojaashree']"));
	    action.moveToElement(contact).click(contact).perform();
	    //Thread.sleep(2000);
	    //8. Select Status as Canceled
	    driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
	    WebElement status = driver.findElement(By.xpath("//a[@title='Canceled']"));
	    action.moveToElement(status).click(status).perform();
	    //Thread.sleep(2000);
	    //9. Give Amount and select Referenced in Type
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(amount,Keys.ENTER);
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
	    //Thread.sleep(2000);
	    WebElement type = driver.findElement(By.xpath("//a[@title='Referenced']"));
	    action.moveToElement(type).click(type).perform();
	    //Thread.sleep(2000);
	    //10. Select Processing Mode as External
	    driver.findElement(By.xpath("(//a[@class='select'])[3]")).click();
	    WebElement processingMode = driver.findElement(By.xpath("//a[@title='External']"));
	    action.moveToElement(processingMode).click(processingMode).perform();
	    //Thread.sleep(2000);
	    //11. Click Save
	    driver.findElement(By.xpath("//button[@title='Save']")).click();
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(text);
        //Thread.sleep(2000);
	    String refundNumber = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]")).getText();
	    System.out.println("Redfund Number is " +refundNumber);
	    if(refundNumber.contains("R-0000000")) {
	    	System.out.println("Refund " +refundNumber+ " was created");
	    }
	    else {
	    	System.out.println("Refund " +refundNumber+ " was not created");
	    }
	    

	}
    @DataProvider(name="CreateNewRefund")
	public String[][] sendData() {	
		data=new String[2][1];
		
        data[0][0]="50000";
        data[1][0]="75000";
	    return data;
		
    }

}
