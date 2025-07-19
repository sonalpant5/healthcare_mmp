package mmpTestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import mmpPageObjects.HomePage;
import mmpPageObjects.LoginPage;
import mmpPageObjects.PersonalDetailPage;
import mmp_Library.FrameworkLibrary;

public class TestUpdatedPersonalDetails extends FrameworkLibrary {


	@Test
	public void validatePersonalDetails() throws InterruptedException {
		
		
		LoginPage lPage = new LoginPage(driver);
		HomePage hPage = lPage.loginValidUser(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
		hPage.navigateToAModule("Profile");
		PersonalDetailPage updp = new PersonalDetailPage(driver);
		HashMap<String, String> expectedDetails = updp.expectedUpdatedPersonalDetails();
		HashMap<String, String> actualDetails = updp.actualUpdatedPersonalDetails();
		System.out.println("expectedDetails" +expectedDetails);
		System.out.println("actualDetails" +actualDetails);
		Assert.assertEquals(expectedDetails, actualDetails, "Data Does not Match");
	}
	
}
