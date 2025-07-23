package mmpPageObjects_PatientPages;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage{
	
	protected WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		if(!driver.getTitle().equals("home"))
				{
			throw new IllegalStateException("This is not a Home Page," +
					" current page is: " + driver.getTitle());
				}
	}
	
	public void navigateToAModule(String moduleName)
	{
		driver.findElement(By.xpath("//span[normalize-space(text())='"+moduleName+"']")).click();
//		WebElement element = driver.findElement(By.xpath("//span[normalize-space(text())='"+moduleName+"']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		element.click();
	}
	
	
	/*This method helps to fetch the data from Patient Portal Table.
	 * Which will be used to compare the Actual and Expected Data.
	 * 
	 */
	
	public HashMap<String, String> fetchDatafromPatientPortalTable()
	{
		HashMap<String, String> actualHMap = new HashMap<String, String>();
		actualHMap.put("date", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText());
		actualHMap.put("time", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText());
		actualHMap.put("sym", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText());
		actualHMap.put("doctor", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText());
	//	actualHMap.put("doctor", "sjhasf");
		return actualHMap;
	}

	public String PatientRegistrationAccepted() {
		String patient_username = driver.findElement(By.xpath("//span[@class='username']")).getText();
		 return patient_username;
	}
	
//	public String PatientRegistrationRejected() throws InterruptedException {
//		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
//		String alertmsg = alert.getText();		
//	    alert.accept();
//		return alertmsg;
//	}
}
