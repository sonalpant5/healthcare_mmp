package mmpTestCases;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import mmpPageObjects_AdminPages.RecieveMessageOnAdminPage;
import mmpPageObjects_PatientPages.HomePage;
import mmpPageObjects_PatientPages.LoginPage;
import mmpPageObjects_PatientPages.PersonalDetailPage;
import mmpPageObjects_PatientPages.SendMessageToAdminPage;
import mmp_Library.FrameworkLibrary;
import mmp_utilities.RandomDataUtils;

public class TestSendMessageE2E extends FrameworkLibrary {
	
	@Test
	
	public void validateSendMessageToAdmin() throws Exception
	{
		
		LoginPage lPage = new LoginPage(driver);
		HomePage hpage = lPage.loginValidUser(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
		hpage.navigateToAModule("Profile");
		PersonalDetailPage pdp = new PersonalDetailPage(driver);
		HashMap<String, String> patientData = pdp.fetchPatientDetails();
		String patientName = patientData.get("fname");
		hpage.navigateToAModule("Messages");
		SendMessageToAdminPage smPage = new SendMessageToAdminPage(driver);
		HashMap<String, String> expectedData = smPage.ExpectedMessageDetails(RandomDataUtils.randomAlphabets(6), RandomDataUtils.randomAlphabets(8), patientName);
		
		String actualmsg = smPage.getMessageStatus();
		System.out.println("Actual message: "+actualmsg);
		
		Assert.assertTrue(actualmsg.equals("Messages Successfully sent."));
		
		hpage.navigateToAModule("Logout");
		System.out.println("Patient account Logged out successfully");
		
		
				
		//Validate Recieve Message To Admin from Patient
		
		launchApplication(prop.getProperty("admin_url"));
		hpage = lPage.loginValidUser(prop.getProperty("admin_username"), prop.getProperty("admin_password"));	 
		hpage.navigateToAModule("Messages");
		RecieveMessageOnAdminPage map = new RecieveMessageOnAdminPage(driver);

		HashMap<String, String> actualData = map.getDatafromAdminMessage(expectedData.get("reason"));
	//	String pname = expectedData.get("patient");
		Assert.assertEquals(actualData, expectedData);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[normalize-space(text())='Logout']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf((element)));
		element.click();
		
		System.out.println("Admin account Logged out successfully");
		
		}
	
	

}
