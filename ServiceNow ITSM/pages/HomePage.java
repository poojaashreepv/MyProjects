package pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import baseclass.BaseClass;
import io.github.sukgu.Shadow;

public class HomePage extends BaseClass {
	Shadow shadow = new Shadow(driver);
	public HomePage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public HomePage clickOnAll() throws IOException {
		try {
			shadow.setImplicitWait(20);
			shadow.findElementByXPath("//div[text()='All']").click();
			shadow.setImplicitWait(10);
			reportStep("Pass", "All is Entered Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "All is Not Entered Successfully" +e);
		}
		return this;
	}
	public HomePage searchOnKey(String searchKey) throws IOException {
		try {
			shadow.findElementByXPath("//input[@id='filter']").sendKeys("Incidents",Keys.ENTER);
			reportStep("Pass", "Incident is Searched Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "Incident is Not Searched Successfully" +e);
		}
		return this;
	}
	public IncidentPage clickOnIncident() throws IOException {
		try {
			shadow.findElementByXPath("//span[text()='Incidents']").click();
			reportStep("Pass", "Incident is Clicked Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "Incident is Not Clicked Successfully" +e);
		}
		return new IncidentPage(driver,node);
	}
        public HomePage searchOnKey1(String searchKey1) throws IOException {
    	        try {
			shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service catalog",Keys.ENTER);
			reportStep("Pass", "Service Catalog is Searched Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "Service Catalog is Not Searched Successfully" +e);
		}
		return this;
    }
    public ServiceCatalogPage clickOnServiceCatalog() throws IOException {
    	        try {
			shadow.findElementByXPath("//span[text()='Service Catalog']").click();
			reportStep("Pass", "Service Catalog is Clicked Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "Service Catalog is Not Clicked Successfully" +e);
		}
    	        return new ServiceCatalogPage(driver,node);
    }
    public HomePage searchOnKey2(String searchKey2) throws IOException {
    	        try {
			shadow.findElementByXPath("//input[@id='filter']").sendKeys("Proposal",Keys.ENTER);
			reportStep("Pass", "Proposal is Searched Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "Proposal is Not Searched Successfully" +e);
		}
		return this;
    }
    public ProposalPage clickOnProposal() throws IOException {
    	        try {
			shadow.findElementByXPath("//span[text()='My Proposals']").click();
			reportStep("Pass", "Proposal is Clicked Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "Proposal is Not Clicked Successfully" +e);
		}
    	        return new ProposalPage(driver,node);
    }
    public HomePage searchOnKey3(String searchKey3) throws IOException {
    	        try {
			shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers",Keys.ENTER);
			reportStep("Pass", "Caller is Searched Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "Caller is Not Searched Successfully" +e);
		}
		return this;
		
    }
    public CallerPage clickOnCaller() throws IOException {
    	        try {
			shadow.findElementByXPath("//span[text()='Callers']").click();
			reportStep("Pass", "Caller is Clicked Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "Caller is Not Clicked Successfully" +e);
		}
    	        return new CallerPage(driver,node);
    } 
    public HomePage searchOnKey4(String searchKey4) throws IOException {
    	        try {
			shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge",Keys.ENTER);
			reportStep("Pass", "Knowledge is Searched Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "Knowledge is Not Searched Successfully" +e);
		}
		return this;
	}
    public ArticlePage clickOnKnowledge() throws IOException {
    	        try {
			shadow.findElementByXPath("//span[text()='Knowledge']").click();
			reportStep("Pass", "Knowledge is Clicked Successfully");
		} 
                catch (Exception e) {
			reportStep("Fail", "Knowledge is Not Clicked Successfully" +e);
		}
    	        return new ArticlePage(driver,node);
    }
}
