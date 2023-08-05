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

public class Create_New_Chart1 extends BaseClass {
	String[][] data;
    @Test(dataProvider="CreateNewChart")
	public void Create_New_Chart(String cname) {
		//3. Click on menu button from the Left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click view All and click Service Console from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement serviceConsole = driver.findElement(By.xpath("//p[text()='Service Console']"));
		Actions action=new Actions(driver);
		action.moveToElement(serviceConsole).click(serviceConsole).perform();
	    //Thread.sleep(2000);
	    //5. Click on the drop down and select Refunds
	    WebElement navigationMenudd = driver.findElement(By.xpath("//div[@class='slds-context-bar__icon-action']"));
	    action.moveToElement(navigationMenudd).click(navigationMenudd).perform();
	    WebElement refunds = driver.findElement(By.xpath("//span[text()='Refunds']"));
	    action.moveToElement(refunds).click(refunds).perform();
	    //Thread.sleep(2000);
	    //6.Click on drop down near Recently viewed and change into 'All'.
	    WebElement dd = driver.findElement(By.xpath("(//button[@role='button'])[2]"));
	    action.moveToElement(dd).click(dd).perform();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[@role='option'])[1]")).click();
	    //7. Click on Chart icon under New Button
	    WebElement chart = driver.findElement(By.xpath("//button[@title='Show charts']"));
	    action.moveToElement(chart).click(chart).perform();
	    //Thread.sleep(2000);
	    //8. Click New Chart
	    driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-utility-settings slds-button__icon slds-icon_container forceIcon']")).click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@title='New Chart']")).click();
	    //9. Give Chart Name and Select Chart Type
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(cname,Keys.ENTER);
	    driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[@title='Vertical Bar Chart'])[2]")).click();
	    //10. Select Aggregate Type as Average and Aggregate Field as Amount
	    driver.findElement(By.xpath("(//a[@class='select'])[3]")).click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@title='Average']")).click();
	    driver.findElement(By.xpath("(//a[@class='select'])[4]")).click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@title='Amount']")).click();
	    //11. Select Grouping Field as Account and click Save
	    driver.findElement(By.xpath("(//a[@class='select'])[5]")).click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@title='Account']")).click();
	    //Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@title='Save']")).click();
	    //Thread.sleep(2000);
	    //12. Click on settings icon and change the Chart Type
	    driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-utility-settings slds-button__icon slds-icon_container forceIcon']")).click();
	    driver.findElement(By.xpath("//a[text()='Donut Chart']")).click();
		
	}
    
    @DataProvider(name="CreatNewChart")
	public String[][] sendData() {	
		data=new String[2][1];
		
        data[0][0]="Automation Testing";
        data[1][0]="Software Testing";
	    return data;
		
    }

}
