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

public class AdministratorCertifications extends BaseClass {
    
	    String[][] data;
	    @Test
            public void AdministratorCertification() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle=new ArrayList<String>(windowHandles);	
		driver.switchTo().window(windowHandle.get(1));
		//Thread.sleep(2000);
		//4. Click on confirm in redirecting page and navigate to  Create and publish custom-branded mobile apps.
		driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();
		//5. Click on the Learning and select Learning on trailhead  
		//6. Click on  Salesforce Certification
		Shadow shadow = new Shadow(driver);
		shadow.findElementByXPath("//span[text()='Learning']").click();
		WebElement trailHead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		WebElement certification = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		Actions action=new Actions(driver);
		action.moveToElement(trailHead).click(certification).perform();
		//7. Click on SalesForce Administrator
		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[1]")).click();
		WebElement administrator = driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)[1]"));
		action.moveToElement(administrator).perform();
		administrator.click();
		//8. Verify the Certifications available for Administrator
		System.out.println("Certifications available for Administrator Certification:");
		System.out.println("");
		List<WebElement> administratorCerti = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for(WebElement certi : administratorCerti) {
			String certification1 = certi.getText();
			System.out.println(certification1);
		}
		
		

	}

}
