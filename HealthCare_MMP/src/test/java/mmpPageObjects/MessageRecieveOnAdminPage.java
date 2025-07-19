package mmpPageObjects;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageRecieveOnAdminPage {
	
	protected WebDriver driver;
	public MessageRecieveOnAdminPage(WebDriver driver)
	{
		this.driver = driver;
		if(!driver.getTitle().equals("Messages"))
		{
			throw new IllegalStateException("This is not an Admin Message Page. This is  "+ driver.getTitle()+ "page");
		}
		
	}

	public HashMap<String, String> getDatafromAdminMessage(String reason)
	{
		HashMap<String, String> actualData = new HashMap<String, String>();
		
		System.out.println("Retrieve data where reason is : "+reason);
		try {
		    String actualReason =driver.findElement(By.xpath("//b[text()='"+reason+"']")).getText();
		  
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//b[text()='"+reason+"']"))));
			  System.out.println("AR:  "+actualReason);
		if(reason.equals(actualReason))
		{
			actualData.put("reason", reason);
			System.out.println("Actual reason: "+ reason);
			
			actualData.put("patient", driver.findElement(By.xpath("//b[text()='"+reason+"']/parent::td/preceding-sibling::td/b")).getText());
			System.out.println("Actual patient name : "+ driver.findElement(By.xpath("//b[text()='"+reason+"']/parent::td/preceding-sibling::td/b")).getText());

			actualData.put("subject", driver.findElement(By.xpath("//b[text()='"+reason+"']/ancestor::tr/following-sibling::tr/td[2]")).getText());
			System.out.println("Actual subject: "+driver.findElement(By.xpath("//b[text()='"+reason+"']/ancestor::tr/following-sibling::tr/td[2]")).getText());
		        
			WebElement element = driver.findElement(By.xpath("//b[text()='"+reason+"']/parent::td/following-sibling::td/b"));
		            // Scroll the element into view
		     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		           
		     actualData.put("Date", element.getText());
		   
		//	actualData.put("Date", driver.findElement(By.xpath("//b[text()='"+reason+"']/parent::td/following-sibling::td/b")).getText());
			System.out.println("Date: "+ driver.findElement(By.xpath("//b[text()='"+reason+"']/parent::td/following-sibling::td/b")).getText());
		
		} else
		{System.out.println("Reason not Found");}
		
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		return actualData;
		
	}
}
