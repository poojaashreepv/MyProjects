package salesforce;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Customer_Service_Options extends BaseClass {
	String[][] data;
	@Test 
	public void Customer_Service_Options() throws InterruptedException {
		//3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle=new ArrayList<String>(windowHandles);	
		driver.switchTo().window(windowHandle.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();
		//4. Click on Products and MouseHover on  Service 
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		WebElement products = shadow.findElementByXPath("//span[text()='Products']");
		Actions action=new Actions(driver);
		action.moveToElement(products).click(products).perform();
	        Thread.sleep(2000);
		WebElement service = shadow.findElementByXPath("//span[text()='Service']");
		action.moveToElement(service).perform();
	        //5. Verify the tabs displayed in the page"
	        List<WebElement> serviceTabs = shadow.findElementsByXPath("//a[@class='c360-panel-linkedlist__listitem-title']");
	    	List<String> serviceTabs1=new ArrayList<String>();
		for (WebElement serviceTabsNames : serviceTabs) {
			serviceTabs1.add(serviceTabsNames.getText()); 
	    	}
		System.out.println("Tabs Displayed in the Page : ");
		System.out.println(serviceTabs1);

	}

	
}
