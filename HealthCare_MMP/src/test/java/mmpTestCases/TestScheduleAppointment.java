package mmpTestCases;


import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import mmpPageObjects.HomePage;
import mmpPageObjects.LoginPage;
import mmpPageObjects.ScheduleAppointmentPage;
import mmp_Library.FrameworkLibrary;

 

public class TestScheduleAppointment extends FrameworkLibrary{


	@Test
	public void validateBookAppointment()
	{
		
		LoginPage lPage = new LoginPage(driver);
		HomePage hPage = lPage.loginValidUser(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
		hPage.navigateToAModule("Schedule Appointment");
		ScheduleAppointmentPage sAppointment = new ScheduleAppointmentPage(driver);
		HashMap<String,String> expectedHMap = sAppointment.bookAppointment("Alexander",365);
		HashMap<String,String> actualHMap = hPage.fetchDatafromPatientPortalTable();
		System.out.println("Actual HMap::" +actualHMap);
		System.out.println("Expected HMap::" +expectedHMap);
		Assert.assertTrue(expectedHMap.equals(actualHMap));
	}
	
}








