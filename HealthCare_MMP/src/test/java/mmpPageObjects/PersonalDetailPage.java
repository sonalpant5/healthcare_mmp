package mmpPageObjects;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import mmp_utilities.RandomDataUtils;

public class PersonalDetailPage {

	protected WebDriver driver;
	public PersonalDetailPage(WebDriver driver){
		this.driver = driver;
		if (!driver.getTitle().equals("profile")) {
			throw new IllegalStateException("This is not Profile Page," +
					" current page is: " + driver.getCurrentUrl());
		}
}
	
	public HashMap<String, String> expectedUpdatedPersonalDetails() throws InterruptedException
	{
		
		HashMap<String, String> expectedData = new HashMap<String, String>();

		
		driver.findElement(By.id("Ebtn")).click();
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.id("fname")).sendKeys("ria"+RandomDataUtils.randomAlphabets(4));
		expectedData.put("fname", driver.findElement(By.id("fname")).getDomProperty("value"));
		
		driver.findElement(By.id("lname")).clear();
		driver.findElement(By.id("lname")).sendKeys(RandomDataUtils.randomAlphabets(6));
		expectedData.put("lname", driver.findElement(By.id("lname")).getDomProperty("value"));
		
		driver.findElement(By.id("licn")).clear();
		driver.findElement(By.id("licn")).sendKeys(RandomDataUtils.randomLicense());;
		expectedData.put("licn", driver.findElement(By.id("licn")).getDomProperty("value"));
		
		driver.findElement(By.id("ssn")).clear();
		driver.findElement(By.id("ssn")).sendKeys(RandomDataUtils.randomSSN());
		expectedData.put("ssn", driver.findElement(By.id("ssn")).getDomProperty("value"));
		
		driver.findElement(By.id("addr")).clear();
		driver.findElement(By.id("addr")).sendKeys(RandomDataUtils.randomAddress());
		expectedData.put("addr", driver.findElement(By.id("addr")).getDomProperty("value"));
		
		driver.findElement(By.id("age")).clear();
		driver.findElement(By.id("age")).sendKeys(RandomDataUtils.randomNumbers(2));
		expectedData.put("age", driver.findElement(By.id("age")).getDomProperty("value"));
		
		driver.findElement(By.id("weight")).clear();
		driver.findElement(By.id("weight")).sendKeys(RandomDataUtils.randomNumbers(2));
		expectedData.put("weight", driver.findElement(By.id("weight")).getDomProperty("value"));
		
		driver.findElement(By.id("height")).clear();
		driver.findElement(By.id("height")).sendKeys(RandomDataUtils.randomNumbers(2));
		expectedData.put("height", driver.findElement(By.id("height")).getDomProperty("value"));
		
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(RandomDataUtils.randomAlphabets(6));
		expectedData.put("city", driver.findElement(By.id("city")).getDomProperty("value"));
		
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys(RandomDataUtils.randomAlphabets(7));
		expectedData.put("state", driver.findElement(By.id("state")).getDomProperty("value"));
		
		driver.findElement(By.id("zip")).clear();
		driver.findElement(By.id("zip")).sendKeys(RandomDataUtils.randomNumbers(5));
		expectedData.put("zip", driver.findElement(By.id("zip")).getDomProperty("value"));
		driver.findElement(By.id("Sbtn")).submit();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		return expectedData;
	}
	
	public HashMap<String, String> fetchPatientDetails()
	{
		HashMap<String, String> patientData = new HashMap<String, String>();

		
		patientData.put("fname", driver.findElement(By.id("fname")).getDomProperty("value"));
		patientData.put("lname", driver.findElement(By.id("lname")).getDomProperty("value"));
		patientData.put("licn", driver.findElement(By.id("licn")).getDomProperty("value"));
		patientData.put("ssn", driver.findElement(By.id("ssn")).getDomProperty("value"));
		patientData.put("addr", driver.findElement(By.id("addr")).getDomProperty("value"));		
		patientData.put("age", driver.findElement(By.id("age")).getDomProperty("value"));	
		patientData.put("weight", driver.findElement(By.id("weight")).getDomProperty("value"));		
		patientData.put("height", driver.findElement(By.id("height")).getDomProperty("value"));			
		patientData.put("city", driver.findElement(By.id("city")).getDomProperty("value"));				
		patientData.put("state", driver.findElement(By.id("state")).getDomProperty("value"));		
		patientData.put("zip", driver.findElement(By.id("zip")).getDomProperty("value"));;
		
		return patientData;
	}
	
	public  HashMap<String, String> actualUpdatedPersonalDetails()
	{
		HashMap<String, String> actualData = new HashMap<String, String>();
		
		actualData.put("fname", driver.findElement(By.id("fname")).getDomProperty("value"));		
		actualData.put("lname", driver.findElement(By.id("lname")).getDomProperty("value"));
		actualData.put("licn", driver.findElement(By.id("licn")).getDomProperty("value"));
		actualData.put("ssn", driver.findElement(By.id("ssn")).getDomProperty("value"));
		actualData.put("addr", driver.findElement(By.id("addr")).getDomProperty("value"));
		actualData.put("age", driver.findElement(By.id("age")).getDomProperty("value"));
		actualData.put("weight", driver.findElement(By.id("weight")).getDomProperty("value"));
		actualData.put("height", driver.findElement(By.id("height")).getDomProperty("value"));
		actualData.put("city", driver.findElement(By.id("city")).getDomProperty("value"));
		actualData.put("state", driver.findElement(By.id("state")).getDomProperty("value"));
		actualData.put("zip", driver.findElement(By.id("zip")).getDomProperty("value"));
		
		return actualData;
	}
	
}
