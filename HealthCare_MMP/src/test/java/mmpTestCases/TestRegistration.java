package mmpTestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import mmpPageObjects.PatientRegisStatusInAdminPage;
import mmpPageObjects.HomePage;
import mmpPageObjects.LoginPage;
import mmpPageObjects.RegistrationPage;
import mmp_Library.FrameworkLibrary;

public class TestRegistration extends FrameworkLibrary{
	
	/*
	 * This method is used to validate the registration functionality of Patient.
	 */
	@Test
	public void validateRegistration() throws Exception 
	{
		launchApplication(prop.getProperty("patient_url"));
		LoginPage lPage = new LoginPage(driver);
		RegistrationPage regPage = new RegistrationPage(driver);
		HashMap<String, String> expectedData = regPage.enterRegistrationDetails();	
		String msg = regPage.getRegistrationMessage();		
		System.out.println(msg);
		Assert.assertTrue(msg.equalsIgnoreCase("Thank you for registering with MMP. "));
	

	launchApplication(prop.getProperty("admin_url"));	
	HomePage hpage= lPage.loginValidUser(prop.getProperty("admin_username"), prop.getProperty("admin_password"));
	hpage.navigateToAModule("Users");
	PatientRegisStatusInAdminPage apr = new PatientRegisStatusInAdminPage(driver);
	String patientName = expectedData.get("fname");
	String ssn = expectedData.get("ssn");
	String status = "Rejected"; // Enter status: Rejected, Accepted, Pending as per the requirement;
	String message = apr.PatientRegistrationRequest(patientName, ssn, status );
	Assert.assertTrue(message.equalsIgnoreCase(" USER has been updated."));

	hpage.navigateToAModule("Logout");
	System.out.println("Admin account Logged out successfully");

	
	// Validate Patient Login after Registration
    launchApplication(prop.getProperty("patient_url"));
	System.out.println(expectedData.get("username"));
	System.out.println(expectedData.get("password"));
	
	
	if(status.equalsIgnoreCase("Accepted"))
	{

	hpage = lPage.loginValidUser(expectedData.get("username"), expectedData.get("password"));
	Assert.assertTrue(hpage.PatientRegistrationAccepted().contains(expectedData.get("username")));
	System.out.println("Patient account logged in successfully")	;
	Thread.sleep(2000);
	hpage.navigateToAModule("Logout");
	System.out.println("Patient account Logged out successfully");

	System.out.println("Registration Test Case Passed Successfully");
	}else
	{	
		String alertmsg = lPage.loginInValidUser(expectedData.get("username"), expectedData.get("password"));
		System.out.println("Registration is in " + status + " state, hence "+alertmsg);
		System.out.println("Not a valid user");
		Assert.assertTrue(true);
		System.out.println("Registration Test Case Passed Successfully");
		
	}
	
}
}	