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

public class CreateNewCase extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateNewCase")
	public void CreateNewCase(String sub,String desc) throws InterruptedException {
	    //3) Click on Global Actions SVG icon
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    Thread.sleep(2000);
            driver.findElement(By.xpath("//p[text()='Sales']")).click();
	    Thread.sleep(2000);
	    WebElement moredd = driver.findElement(By.xpath("//a[@class='slds-button slds-button_reset slds-context-bar__label-action']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(moredd).click(moredd).perform();
	    Thread.sleep(2000);
	    WebElement cases = driver.findElement(By.xpath("(//span[text()='Cases'])[2]"));
	    action.moveToElement(cases).click(cases).perform();
	    //Thread.sleep(2000);
	    //4) Click on New Case
	    WebElement casesdd = driver.findElement(By.xpath("(//div[@class='slds-context-bar__label-action slds-p-left--none'])[13]"));
	    action.moveToElement(casesdd).click(casesdd).perform();
	    Thread.sleep(2000);
	    WebElement newCase = driver.findElement(By.xpath("//span[text()='New Case']"));
	    action.moveToElement(newCase).click(newCase).perform();
	    Thread.sleep(2000);
	    //5) Choose Contact Name from the dropdown
	    driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[1]")).click();
	    driver.findElement(By.xpath("//span[@title='Poojaashree P V']")).click();
	    //6)  Select Case origin as email
	    driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]")).click();
	    driver.findElement(By.xpath("//span[text()='Email']")).click();
	    //7) Select status as Escalated
	    driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")).click();
	    driver.findElement(By.xpath("//span[text()='Escalated']")).click();
	    //8) Enter Subject as and description
	    driver.findElement(By.xpath("(//input[@class='slds-input'])[7]")).sendKeys(sub,Keys.ENTER);
	    driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[1]")).sendKeys(desc,Keys.ENTER);
	    //9) Click 'Save' and verify the message
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
            System.out.println(text);
            if(text.contains("was created.")) {
        	System.out.println("Case was created");
            }
            else {
        	System.out.println("Case was not created");
            }

	}
	@DataProvider(name="CreateNewCase")
	public String[][] sendData() {	
		data=new String[2][2];
		data[0][0]="Testing";
        	data[0][1]="Dummy";
        	data[1][0]="Software Testing";
        	data[1][1]="Dummy";
        	return data;	
    }

}
