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

public class DeleteAccount1 extends BaseClass {
	String[][] data;
	@Test(dataProvider="DeleteAccount")
	public void DeleteAccount(String aname) {
		//3. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Thread.sleep(2000);
		//4. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//Thread.sleep(2000);
		//5. Click on Accounts tab  
		WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		Actions action=new Actions(driver);
		action.moveToElement(accounts).click(accounts).perform();
	    //Thread.sleep(2000);
	    //6. Search the account 'Your Name'
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
	    WebElement search = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
	    search.sendKeys("Poojaashree",Keys.ENTER);
	    //Thread.sleep(2000);
	    //7. Click on  the Dropdown icon and Select Delete
	    WebElement optiondd = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[1]/td[6]/span/div/a/span"));
	    action.moveToElement(optiondd).perform();
        optiondd.click();
        //Thread.sleep(2000);
        WebElement delete = driver.findElement(By.xpath("//a[@title='Delete']"));
        action.moveToElement(delete).perform();
        //Thread.sleep(2000);
        delete.click();
        //Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@title='Delete']")).click();
        String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(text);
        //8. Verify Whether account is Deleted using account Name
        driver.findElement(By.xpath("(//input[@type='search'])[2]")).clear();
	    search.sendKeys(aname,Keys.ENTER);
	    String text2 = driver.findElement(By.xpath("//div[@class='emptyContent slds-is-absolute']")).getText();
	    if(text2.equals("No items to display.")) {
	    	System.out.println("Account is Deleted");
	    	
	    }
	    else {
	    	System.out.println("Account is Not Deleted");
	    }
        
        
	}
	@DataProvider(name="DeleteAccount")
	public String[][] sendData() {	
		data=new String[2][1];	
        data[0][0]="Poojaashree";
        data[1][0]="Sri";
	    return data;
		
    }

}
