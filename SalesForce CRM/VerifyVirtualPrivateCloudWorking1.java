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

public class VerifyVirtualPrivateCloudWorking1 extends BaseClass {
	String[][] data;
	@Test
	public void VerifyVirtualPrivateCloudWorking() {
		//3. Click on the sliding icon until ""Real-time Collaborative Docs"" is displayed
		//4. Click on Get Started link
		driver.findElement(By.xpath("(//span[text()='Get Started'])[2]")).click();
		//5. Navigate to the new window  and click confirm.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle=new ArrayList<String>(windowHandles);	
		driver.switchTo().window(windowHandle.get(1));
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='goAhead()']")).click();
		//6. Mousehover on Product.
		WebElement product = driver.findElement(By.xpath("//button[text()='Product']"));
		Actions action=new Actions(driver);
		action.moveToElement(product).perform();
		//7. Click on the Virtual Private Cloud.
		driver.findElement(By.xpath("//h5[text()='Virtual Private Cloud']")).click();
		//8.Scroll down to the element "How Quip VPC works"
		WebElement vpcWorks = driver.findElement(By.xpath("//h2[text()='How Quip VPC works']"));
		action.moveToElement(vpcWorks).perform();
		//9.Verify flowchart structure under How Quip VPC works
		String text = driver.findElement(By.xpath("//h2[text()='How Quip VPC works']/following-sibling::p")).getText();
		System.out.println(text);
		if(text.contains("Learn how Quip VPC")) {
			System.out.println("Flowchart structure is present under How Quip VPC works");
		}
		else {
			System.out.println("Flowchart structure is not present under How Quip VPC works");
		}

	}

}
