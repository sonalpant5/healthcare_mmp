package mmpPageObjects;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import mmp_utilities.DateUtils;

public class SendMessageToAdminPage {

	protected WebDriver driver;
	
	private By contactReasonTxt = By.id("subject");
	private By subjectTxt = By.id("message");
	private By sendBtn = By.xpath("//input[@value='Send']");

	
	public SendMessageToAdminPage(WebDriver driver)
	{
		this.driver = driver;
		if(!driver.getTitle().equals("Send Messages"))
		{
			throw new IllegalStateException("This is not a Send Message Page, current page is:" + driver.getCurrentUrl()); 
		}
	}
	
	public HashMap<String, String> ExpectedMessageDetails(String reason, String message, String patientName) throws Exception
	{
		HashMap<String, String> expectedData = new HashMap<String, String>();		
		driver.findElement(contactReasonTxt).sendKeys("cold, nausea - "+reason);
		expectedData.put("reason", driver.findElement(contactReasonTxt).getDomProperty("value"));
		System.out.println("Expected reason:"+driver.findElement(contactReasonTxt).getDomProperty("value"));
		
		driver.findElement(subjectTxt).sendKeys("Visit - "+message);
		expectedData.put("subject", driver.findElement(subjectTxt).getDomProperty("value"));
		System.out.println("Expected subject: "+driver.findElement(subjectTxt).getDomProperty("value"));
		
		expectedData.put("patient", patientName);
		System.out.println("Expected patient name: "+patientName);
		
		expectedData.put("Date", DateUtils.getCurrentDate());
		System.out.println("Date: "+DateUtils.getCurrentDate());
		
		driver.findElement(sendBtn).click();
		
		return expectedData;
	}
	
	public String getMessageStatus() throws Exception {
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String messagesText = alert.getText(); // Get the alert text
		alert.accept(); // Accept the alert to close it
		return messagesText;
	}
	
}
