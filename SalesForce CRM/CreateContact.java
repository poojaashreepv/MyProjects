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

public class CreateContact extends BaseClass {
	String[][] data;
	@Test(dataProvider="CreateContact")
	public void CreateContact(String fname,String lname,String email,String aname) throws InterruptedException {
	    //3) Click on Global Actions SVG icon
	    driver.findElement(By.xpath("//a[contains(@class,'globalCreateTrigger slds-button')]")).click();
	    //4) After clicking Global Actions SVG icon, Click 'New Contact'.
	    WebElement newContact = driver.findElement(By.xpath("//span[text()='New Contact']"));
	    Actions action=new Actions(driver);
	    action.moveToElement(newContact).click(newContact).perform();
	    Thread.sleep(2000);
	    //5) Pick Salutation as 'Mr.'
	    driver.findElement(By.xpath("//div[contains(@class,'salutation compoundTLRadius')]")).click();		
	    WebElement salutationMr = driver.findElement(By.xpath("//a[@title='Mr.']"));
	    action.moveToElement(salutationMr).click(salutationMr).perform();
	    Thread.sleep(2000);
	    //6) Enter First Name 
	    driver.findElement(By.xpath("//span[text()='First Name']")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(fname,Keys.ENTER);
	    Thread.sleep(2000);
	    String firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']")).getAttribute("value");
	    System.out.println("First Name is " +firstName);
	    //7) Enter Last Name 
	    driver.findElement(By.xpath("//span[text()='Last Name']")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(lname,Keys.ENTER);
	    Thread.sleep(2000);
	    String lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']")).getAttribute("value");
	    System.out.println("Last Name is " +lastName);
	    String contactName = firstName+" "+lastName;
	    System.out.println("Contact Name is " +contactName);
	    //8) Enter email 
	    driver.findElement(By.xpath("(//span[text()='Email'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(email,Keys.ENTER);
	    //Thread.sleep(2000);
	    //9) Create a New Account for Account Name
	    driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).click();
            Thread.sleep(2000);
	    WebElement newAccount = driver.findElement(By.xpath("//span[@title='New Account']"));
	    action.moveToElement(newAccount).click(newAccount).perform();
	    Thread.sleep(2000);
	    //10) Enter account name as 'Credits' and save
	    driver.findElement(By.xpath("(//input[@class=' input'])[4]")).sendKeys(aname,Keys.ENTER);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
	    Thread.sleep(3000);
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
            System.out.println(text);
            Thread.sleep(3000);
	    //11) Click and save
	    WebElement save = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
	    driver.executeScript("arguments[0].click();", save);
	    String text1 = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
            System.out.println(text1);
	    //12) Verify contact using Unique name and print the name
            if(text1.contains(contactName)) {
        	System.out.println("Contact is Created and Verified by Unique name");
            }
            else {
        	System.out.println("Contact is Not Created");
            }
        
        }
	@DataProvider(name="CreateContact")
	public String[][] sendData() {	
		data=new String[2][4];
		data[0][0]="Poojaashree";
        	data[0][1]="P V";
        	data[0][2]="poojaashree@test.com";
        	data[0][3]="Credits";
        	data[1][0]="Raghavi";
        	data[1][1]="R";
        	data[1][2]="raghavi@test.com";
        	data[1][3]="Credits";
		return data;
		
    }

}
