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

public class EditWorkType1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="EditWorkType")
	public void EditWorkType(String fstime,String fetime) {
		//3) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4) Click on View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//5) Click on Work Types
		WebElement workTypes = driver.findElement(By.xpath("//p[text()='Work Types']"));
		Actions action=new Actions(driver);
		action.moveToElement(workTypes).click(workTypes).perform();
	    //Thread.sleep(2000);
	    //6) Click on the Arrow button at the end of the first result
	    WebElement workTypeOptiondd = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[5]/span/div/a"));
	    action.moveToElement(workTypeOptiondd).click(workTypeOptiondd).perform();
	    //Thread.sleep(2000);
	    //7) Click on Edit
	    driver.findElement(By.xpath("//a[@title='Edit']")).click();
	    //8) Enter Time Frame Start as '9'
	    driver.findElement(By.xpath("//span[text()='Timeframe Start']")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys(fstime,Keys.ENTER);
	    //9) Enter Time Frame End as '18'
	    driver.findElement(By.xpath("//span[text()='Timeframe End']")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(fetime,Keys.ENTER);
	    //10) Click on Save
	    driver.findElement(By.xpath("//button[@title='Save']")).click();
	    //Thread.sleep(2000);
	    //11) Verify the success message
	    driver.findElement(By.xpath("(//a[@data-refid='recordId'])[1]")).click();
	    String timeFrameStart = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow '])[10]")).getText();
	    System.out.println("TimeFrame Start : " +timeFrameStart);
	    String timeFrameEnd = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow '])[12]")).getText();
	    System.out.println("TimeFrame End : " +timeFrameEnd);
	    if(timeFrameStart.contains(fstime) && timeFrameEnd.contains(fetime)) {
	    	System.out.println("The Work type is Edited Successfully");
	    }
	    else {
	    	System.out.println("The Work type is not Edited Successfully");
	    }
	    
	}
	@DataProvider(name="EditWorkType")
	public String[][] sendData() {	
		data=new String[1][2];
		data[0][0]="9";
		data[0][1]="18";
		return data;

    }

}
