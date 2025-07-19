package mmpPageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientRegisStatusInAdminPage {

	/* 
	 * login admin
navigate to 'Users' link
select pending from dropdown
search you registered ssn and click on name
change the status to Accepted in drop down
click on submit
validate the alert message " USER has been updated."  
accept the alert.

validate the name in the accepted list
	 */
	protected WebDriver driver;
	//Locators 
	By status = By.id("search");
	By request_status = By.id("sapproval");
	By submit = By.xpath("//input[@value='Submit']");
	
	public PatientRegisStatusInAdminPage(WebDriver driver)
	{
		this.driver = driver;
		if (!driver.getTitle().equals("Schedule Appointments")) {
			throw new IllegalStateException("This is not Schedule Appointments Page," +
					" current page is: " + driver.getCurrentUrl());
		}
	}

	public String PatientRegistrationRequest(String patientName, String ssn, String process_status) throws InterruptedException
	{
			
		Select sel = new Select(driver.findElement(status));
		sel.selectByVisibleText("Pending");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[normalize-space(text())='"+ssn+"']/preceding-sibling::td/a")).click();
		sel = new Select(driver.findElement(request_status));
		sel.selectByVisibleText(process_status);
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement submitform = driver.findElement(submit);
		wait.until(ExpectedConditions.visibilityOf(submitform));
		submitform.click();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.accept();	
		System.out.println(message);
		return message;
	}
	
	

}
