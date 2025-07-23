package mmpPageObjects_PatientPages;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import mmp_utilities.DateUtils;
import mmp_utilities.RandomDataUtils;

public class RegistrationPage {
	
	protected WebDriver driver;
	//Locators
	By registerBtn = By.xpath("//input[@value ='Register']");
	By fnametxt = By.id("firstname");
	By lnametxt = By.id("lastname");
	By datetxt = By.id("datepicker");
	By licensetxt = By.id("license");
	By ssntxt = By.id("ssn");
	By statetxt = By.id("state");
	By citytxt = By.id("city");
	By addresstxt = By.id("address");
	By zipcodetxt = By.id("zipcode");
	By agetxt = By.id("age");
	By heighttxt = By.id("height");
	By weighttxt = By.id("weight");
	By pharmacytxt = By.id("pharmacy");
	By pharmacyAddresstxt = By.id("pharma_adress");
	By emailtxt = By.id("email");
	By usernametxt = By.id("username");
	By passwordtxt = By.id("password");
	By confirmpasswordtxt = By.id("confirmpassword");
	By securitydd = By.id("security");
	By answertxt = By.id("answer");
	By submit = By.xpath("//input[@value ='Save']");
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		driver.findElement(registerBtn).click();
		if(!driver.getTitle().equals("Registration"))
		{
			throw new IllegalStateException("This is not a Registration Page, This is a "+driver.getTitle()+ "Page");
		}
	}

	public HashMap<String, String> enterRegistrationDetails() throws Exception
	{
		
		HashMap<String, String> expectedData = new HashMap<String, String>();
		String pwd = RandomDataUtils.randomPassword();
		System.out.println("Password: "+pwd);
		
		
		driver.findElement(fnametxt).sendKeys(RandomDataUtils.randomAlphabets(7));
		expectedData.put("fname", driver.findElement(fnametxt).getDomProperty("value"));
		
		driver.findElement(lnametxt).sendKeys(RandomDataUtils.randomAlphabets(8));
		expectedData.put("lname", driver.findElement(lnametxt).getDomProperty("value"));
		
		driver.findElement(datetxt).sendKeys(DateUtils.getCurrentDate());
		expectedData.put("date", driver.findElement(datetxt).getDomProperty("value"));
		
		driver.findElement(licensetxt).sendKeys(RandomDataUtils.randomLicense());
		expectedData.put("license", driver.findElement(licensetxt).getDomProperty("value"));
		
		driver.findElement(ssntxt).sendKeys(RandomDataUtils.randomNumbers(9));
		expectedData.put("ssn", driver.findElement(ssntxt).getDomProperty("value"));
		
		driver.findElement(statetxt).sendKeys(RandomDataUtils.randomAlphabets(5));
		expectedData.put("state", driver.findElement(statetxt).getDomProperty("value"));
		
		driver.findElement(citytxt).sendKeys(RandomDataUtils.randomAlphabets(5));
		expectedData.put("city", driver.findElement(citytxt).getDomProperty("value"));
		
		driver.findElement(addresstxt).sendKeys(RandomDataUtils.randomAddress());
		expectedData.put("address", driver.findElement(addresstxt).getDomProperty("value"));
		
		driver.findElement(zipcodetxt).sendKeys(RandomDataUtils.randomNumbers(5));
		expectedData.put("zipcode", driver.findElement(zipcodetxt).getDomProperty("value"));
		String age=RandomDataUtils.randomNumbers(2);
		
		while(age.equals("00"))
		{
			age = RandomDataUtils.randomNumbers(2);
		}
		driver.findElement(agetxt).sendKeys(age);
		expectedData.put("age", driver.findElement(agetxt).getDomProperty("value"));
		
		driver.findElement(heighttxt).sendKeys(RandomDataUtils.randomNumbers(2));
		expectedData.put("height", driver.findElement(heighttxt).getDomProperty("value"));
		
		driver.findElement(weighttxt).sendKeys(RandomDataUtils.randomNumbers(2));
		expectedData.put("weight", driver.findElement(weighttxt).getDomProperty("value"));
			
		driver.findElement(pharmacytxt).sendKeys(RandomDataUtils.randomAlphabets(5));
		expectedData.put("pharmacy", driver.findElement(pharmacytxt).getDomProperty("value"));
		
		driver.findElement(pharmacyAddresstxt).sendKeys(RandomDataUtils.randomAddress());
		expectedData.put("pharmacy_address", driver.findElement(pharmacyAddresstxt).getDomProperty("value"));
		
		driver.findElement(emailtxt).sendKeys(RandomDataUtils.randomEmail());
		expectedData.put("email", driver.findElement(emailtxt).getDomProperty("value"));
		
		driver.findElement(usernametxt).sendKeys(RandomDataUtils.randomAlphabets(5));
		expectedData.put("username", driver.findElement(usernametxt).getDomProperty("value"));
		
		driver.findElement(passwordtxt).sendKeys(pwd);
		expectedData.put("password", driver.findElement(passwordtxt).getDomProperty("value"));
		
		driver.findElement(confirmpasswordtxt).sendKeys(pwd);
		expectedData.put("confirm_password", driver.findElement(confirmpasswordtxt).getDomProperty("value"));
		
		new Select(driver.findElement(securitydd)).selectByVisibleText("what is your pet name");
		driver.findElement(securitydd).sendKeys(RandomDataUtils.randomAlphabets(5));
		expectedData.put("security", driver.findElement(securitydd).getDomProperty("value"));
		
		driver.findElement(answertxt).sendKeys(RandomDataUtils.randomAlphabets(7));
		expectedData.put("answer", driver.findElement(answertxt).getDomProperty("value"));
		
		
		driver.findElement(submit).click();
		
		return expectedData;
	}
		public String getRegistrationMessage() throws Exception
        {
			Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            String msg = alert.getText();       
            alert.accept();
            return msg;
        }
	}

