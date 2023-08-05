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

public class Board_Exam_Schedule1 extends BaseClass {
	String[][] data;
    @Test
	public void Board_Exam_Schedule() {
		//3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle=new ArrayList<String>(windowHandles);	
		driver.switchTo().window(windowHandle.get(1));
		//Thread.sleep(2000);
		//4. Click confirm in the redirecting page.
		driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();
		//5. Click on the Learning and select Learning on trailhead
		//6. Click on  Salesforce Certification
		//7. Navigate to Certifications window
		Shadow shadow = new Shadow(driver);
		shadow.findElementByXPath("//span[text()='Learning']").click();
		WebElement trailHead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		WebElement certification = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		Actions action=new Actions(driver);
		action.moveToElement(trailHead).click(certification).perform();
		//8. Select Salesforce Architect
		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
       // Thread.sleep(2000);
        //9. Click on LearnMore in Technical Architect Certification
        driver.findElement(By.xpath("(//a[text()='Learn More'])[3]")).click();
        //10. Navigate to Architect Review Board window
        Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windowHandle1=new ArrayList<String>(windowHandles1);	
		driver.switchTo().window(windowHandle1.get(2));
		//Thread.sleep(2000);
		//11. Verify Location and Dates for Review Board Exam Schedule for next month with only status as Planning as unique"
        String text = driver.findElement(By.xpath("(//ul[@class='blank-bullets Lh(1.5) Fz(16px) slds-container--center'])[2]")).getText();
        System.out.println(text);
        if(text.contains("Online")) {
        	System.out.println("Location for Review Board Exam Schedule is unique");
        }
        else {
        	System.out.println("Location for Review Board Exam Schedule is not unique");
        }
		

		

	}

}
