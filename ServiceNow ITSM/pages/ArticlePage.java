package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import baseclass.BaseClass;
import io.github.sukgu.Shadow;

public class ArticlePage extends BaseClass {
	Shadow shadow = new Shadow(driver);
	public ArticlePage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public ArticlePage switchToFrame() throws IOException {//ca//fm
		try {
			WebElement frame1 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
			driver.switchTo().frame(frame1);
			reportStep("Pass", "Frame is Switched Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Frame is Not Switched Successfully" +e);
		}
		return this;
	}
	public ArticlePage clickOnCreateAnArticleButton() throws IOException {//ca //fm
		try {
			driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
			//Thread.sleep(2000);
			reportStep("Pass", "Create An Article Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Create An Article Button is Not Clicked Successfully" +e);
		}
		return this;
	}
	public ArticlePage getArticleNumberText() throws IOException {//ca //fm
		try {
			String number = driver.findElement(By.xpath("//input[@class='form-control disabled ']")).getAttribute("value");
			System.out.println("Article Number is " +number);
			reportStep("Pass", "Article Number Text is got Successfully");
		} catch (Exception e) {
		reportStep("Fail", "Article Number Text is Not got Successfully" +e);
		}
		return this;
	}
	public ArticlePage enterKnowledgeBase(String knowbase) throws IOException {//ca //fm
		try {
			driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(knowbase,Keys.ENTER);
			//Thread.sleep(2000);
			reportStep("Pass", "Knowledge Base is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Knowledge Base is Not Entered Successfully" +e);
		}
		return this;
	}
	public ArticlePage enterShortDescription(String sdesc) throws IOException {//ca
		try {
			driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(sdesc,Keys.ENTER);
			//Thread.sleep(2000);
			reportStep("Pass", "Short Description is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Short Description is Not Entered Successfully" +e);
		}
		return this;
    }
	public void clickOnSubmitButton() throws IOException {//ca //fm
		try {
			driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
			System.out.println("New Article is Created");
			reportStep("Pass", "Submit Button is Clicked Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Submit Button is Not Clicked Successfully" +e);
		}
	}
	public ArticlePage enterCategory(String categ) throws IOException {//fm
		try {
			driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(categ,Keys.ENTER);
			reportStep("Pass", "Category is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Category is Not Entered Successfully" +e);
		}
		return this;
	}
	public ArticlePage enterShortDescription1(String sdesc1) throws IOException {//fm
		try {
			driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(sdesc1,Keys.ENTER);
			//Thread.sleep(2000);
			reportStep("Pass", "Short Description is Entered Successfully");
		} catch (Exception e) {
			reportStep("Fail", "Short Description is Not Entered Successfully" +e);
		}
		return this;
	}

	

}
