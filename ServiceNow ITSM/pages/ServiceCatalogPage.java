package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import baseclass.BaseClass;
import io.github.sukgu.Shadow;

public class ServiceCatalogPage extends BaseClass {
	Shadow shadow = new Shadow(driver);
	public String orderPlacedMsg;
	public String orderStatus;
	public ServiceCatalogPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public ServiceCatalogPage switchToFrame() throws IOException {//om//do
		try {
			WebElement frame1 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
			driver.switchTo().frame(frame1);
			reportStep("Pass", "Frame is Switched Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Frame is Not Switched Successfully" +e);
		}
		return this;
	}
	public ServiceCatalogPage clickOnMobiles() throws IOException {//om //do
		try {
			driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
			//Thread.sleep(2000);
			reportStep("Pass", "Mobiles is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Mobiles is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ServiceCatalogPage clickOnIphone13() throws IOException {//om //do
		 try {
			shadow.findElementByXPath("//h2[text()='Apple iPhone 13']").click();
			reportStep("Pass", "IPhone13 is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "IPhone13 is Not Clicked Successfully" +e);
		}
		 return this;
	}
	public ServiceCatalogPage clickOnNoforReplacement() throws IOException {//om //do
		try {
			driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
			reportStep("Pass", "Replacement No Option is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Replacement No Option is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ServiceCatalogPage clickUnlimitedMonthlyAllowance() throws IOException {//om //do
		try {
			WebElement monthlyAllowance = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
			Select allowancedd=new Select(monthlyAllowance);
			allowancedd.selectByVisibleText("Unlimited [add $4.00]");
			reportStep("Pass", "Unlimited Monthly Allowance is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Unlimited Monthly Allowance is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ServiceCatalogPage clickOnPinkColor() throws IOException {//om //do
		try {
			driver.findElement(By.xpath("//label[text()='Pink']")).click();
			reportStep("Pass", "Pink Color is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Pink Color is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ServiceCatalogPage clickOn128GB() throws IOException {//om //do
		try {
			driver.findElement(By.xpath("//label[text()='128 GB']")).click();
			reportStep("Pass", "128GB is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "128GB is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ServiceCatalogPage clickOnOrderNow() throws IOException {//om //do
		try {
			driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
			reportStep("Pass", "Order Now is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Order Now is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ServiceCatalogPage getOrderPlacedMsgText() throws IOException {//om //do
		try {
			String orderPlacedMsg = driver.findElement(By.xpath("//div[@class='notification notification-success']//span")).getText();
			System.out.println("Order Palced Message : " +orderPlacedMsg);
			reportStep("Pass", "Order Placed Message Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Order Placed Message Text is Not got Successfully" +e);
		}
		return this;
	}
	public ServiceCatalogPage verifyOrderPlaced() throws IOException {//om
        try {
			if(orderPlacedMsg.contains("has been submitted")) {
			System.out.println("Order is Placed");
			}
			else {
				System.out.println("Order is not placed");
			}
			reportStep("Pass", "Order Placed is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Order Placed is Not Verified Successfully" +e);
		}
        return this;
	}
	public void getTextRequestNumber() throws IOException {//om
		try {
			String requestNumber = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
			System.out.println("Request Number is " +requestNumber);
			reportStep("Pass", "Request Number Text is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Request Number Text is Not got Successfully" +e);

		}
        
	}
	public ServiceCatalogPage getTextRequestNumber1() throws IOException {//do
		try {
			String requestNumber = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
			System.out.println("Request Number is " +requestNumber);
			reportStep("Pass", "Request Number Text is got Successfully");

		} catch (Exception e) {
			reportStep("Fail", "Request Number Text is Not got Successfully" +e);

		}
        return this;
	}
	public ServiceCatalogPage clickOnDisplayedReqestNumber() throws IOException {//do
		 try {
			driver.findElement(By.xpath("//a[@id='requesturl']")).click();
			reportStep("Pass", "Displayed Request Number is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Displayed Request Number is Not Clicked Successfully" +e);
		}
		 return this;
	}
	public ServiceCatalogPage clickOnDeleteButton() throws IOException {//do
		try {
			driver.findElement(By.xpath("(//button[text()='Delete'])[2]")).click();
			reportStep("Pass", "Delete Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Delete Button is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ServiceCatalogPage clickOnDeleteConfirmation() throws IOException {//do
		try {
			driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();
			reportStep("Pass", "Delete Confirmation Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Delete Confirmation Button is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ServiceCatalogPage getOrderStatus() throws IOException {//do
		try {
			orderStatus = driver.findElement(By.xpath("//div[@class='notification notification-warning']")).getText();
			System.out.println("Order Status is " +orderStatus);
			reportStep("Pass", "Order Status is got Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Order Status is Not got Successfully" +e);
		}
		return this;
	}
	public void verifyOrderDeleted() throws IOException {//do
		try {
			if(orderStatus.contains("Empty")) {
				System.out.println("Order is Deleted");
			}
			else {
				System.out.println("Order is Not Deleted");
			}
			reportStep("Pass", "Delete Order is Verified Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Delete Order is Not Verified Successfully" +e);
		}
	}

}
