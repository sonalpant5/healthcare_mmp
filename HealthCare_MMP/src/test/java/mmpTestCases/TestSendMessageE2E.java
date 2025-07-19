package mmpTestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import mmpPageObjects.HomePage;
import mmpPageObjects.LoginPage;
import mmpPageObjects.MessageRecieveOnAdminPage;
import mmpPageObjects.PersonalDetailPage;
import mmpPageObjects.SendMessageToAdminPage;
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
		MessageRecieveOnAdminPage map = new MessageRecieveOnAdminPage(driver);

		HashMap<String, String> actualData = map.getDatafromAdminMessage(expectedData.get("reason"));
	//	String pname = expectedData.get("patient");
		Assert.assertEquals(actualData, expectedData);
		Thread.sleep(2000);
		hpage.navigateToAModule("Logout");
		
		System.out.println("Admin account Logged out successfully");
		
		}
	
	

}
