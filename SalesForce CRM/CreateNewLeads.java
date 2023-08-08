package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateNewLeads extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateNewLeads")
	public void CreateNewLeads(String lname,String cname) throws InterruptedException {
		//3. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//4. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//5. Click on Leads tab 
		WebElement leads = driver.findElement(By.xpath("//span[text()='Leads']"));
		driver.executeScript("arguments[0].click();", leads);
		//6. Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		//7. Select Salutation as 'Mr'
		driver.findElement(By.xpath("//button[@name='salutation']")).click();
		driver.findElement(By.xpath("//span[text()='Mr.']")).click();
		Thread.sleep(2000);
		//8. Enter the Last Name
		//driver.findElement(By.xpath("//input[@name='lastName']")).click();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lname);
		//9. Enter the CompanyName
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(cname);
		//10. click Save and Verify Leads Name
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
                if(text.equals("Lead \"Mr. Kumar\" was created.")) {
        	    System.out.println("New Lead is Created");
        	
                }
                else {
        	    System.out.println("New Lead is Not Created");
                }
        
	}
	@DataProvider(name="CreateNewLeads")
	public String[][] sendData() {	
		data=new String[2][2];
		data[0][0]="Poojaashree";
        	data[0][1]="TestLeaf";
        	data[1][0]="Sri";
        	data[1][1]="TestLeaf";
        	return data;	
    }

}
