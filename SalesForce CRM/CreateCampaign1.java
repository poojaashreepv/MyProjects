package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateCampaign1 extends BaseClass{
	String[][] data;
    @Test(dataProvider="CreateCampaign")
	public void CreateCampaign(String cname) {
		//3. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Thread.sleep(2000);
		//4. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("(//p[@class='slds-truncate'])[8]")).click();
		//Thread.sleep(2000);
		//5. Click on Campaigns tab 
		WebElement campaigns = driver.findElement(By.xpath("//span[text()='Campaigns']"));
		Actions action=new Actions(driver);
		action.moveToElement(campaigns).click(campaigns).perform();
	    //Thread.sleep(2000);
	    //6. Click on New button
	    driver.findElement(By.xpath("//div[text()='New']")).click();
	    //7. Enter Campaign name ,Get the text and Store it 
	    driver.findElement(By.xpath("(//input[@class=' input'])[1]")).sendKeys(cname);
	    String text = driver.findElement(By.xpath("(//input[@class=' input'])[1]")).getText();
	    //Thread.sleep(2000);
	    //8. Choose Start date as Tomorrow
	    driver.findElement(By.xpath("(//a[@class='datePicker-openIcon display'])[1]")).click();
	    driver.findElement(By.xpath("(//span[@class='slds-day weekday DESKTOP uiDayInMonthCell--default'])[6]")).click();
	    //Thread.sleep(2000);
	    //9. End date as Tomorrow+1
	    driver.findElement(By.xpath("(//a[@class='datePicker-openIcon display'])[2]")).click();
	    driver.findElement(By.xpath("(//span[@class='slds-day weekday DESKTOP uiDayInMonthCell--default'])[7]")).click();
	    //10. click Save and Verify the newly created Campaign  
	    driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	    String text1 = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(text1);
        //Thread.sleep(2000);
        if(text.contains(cname)) {
        	System.out.println("Campaign was Created");
        }
        else {
        	System.out.println("Campaign was Not Created");
        }

	}
    @DataProvider(name="CreateCampaign")
	public String[][] sendData() {	
		data=new String[2][1];
		
        data[0][0]="Bootcamp";
        data[1][0]="Selenium Bootcamp";
	    return data;
		
    }

}
