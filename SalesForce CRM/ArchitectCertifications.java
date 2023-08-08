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

public class ArchitectCertifications extends BaseClass {
	    String[][] data;
	    @Test
	    public void ArchitectCertifications() throws InterruptedException {
		//3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		//4.Click confirm in the redirecting page.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle=new ArrayList<String>(windowHandles);	
		driver.switchTo().window(windowHandle.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();
		//5. Click on the Learning and select Learning on trailhead
		//6. Click on  Salesforce Certification
		Shadow shadow = new Shadow(driver);
		shadow.findElementByXPath("//span[text()='Learning']").click();
		WebElement trailHead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		WebElement certification = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		Actions action=new Actions(driver);
		action.moveToElement(trailHead).click(certification).perform();
		//7.Select Salesforce Architect.
		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
                Thread.sleep(2000);
                //8. Verify the Page title after selecting Architect
                String titleOfPage = driver.getTitle();
                System.out.println("Title Of The Page is " +titleOfPage);
                //9. Verify the Certifications listed for Architect"
                System.out.println("List Of Certifications Of Architect");
                List<WebElement> archiCerti = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
                for(WebElement Certification : archiCerti) {
			String certifications = Certification.getText();
			System.out.println(certifications);
		}
        
		

	}

}
