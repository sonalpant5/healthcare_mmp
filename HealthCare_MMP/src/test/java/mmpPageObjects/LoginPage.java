package mmpPageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{

	protected WebDriver driver;

	private By unametxtbox = By.id("username");
	private By pwdtxtbox = By.id("password");
	private By signinbtn = By.xpath("//input[@value='Sign In']");

	public LoginPage(WebDriver driver){
		this.driver = driver;
		if (!driver.getTitle().equals("Login")) {
			throw new IllegalStateException("This is not a Login Page," +
					" current page is: " + driver.getTitle());
		}
	}

	public HomePage loginValidUser(String userName, String password) {
		driver.findElement(unametxtbox).sendKeys(userName);
		driver.findElement(pwdtxtbox).sendKeys(password);
		driver.findElement(signinbtn).click();
		return new HomePage(driver);
	}

	  public String loginInValidUser(String userName, String password) throws InterruptedException {
			driver.findElement(unametxtbox).sendKeys(userName);
			driver.findElement(pwdtxtbox).sendKeys(password);
			driver.findElement(signinbtn).click();
		    Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String alertmsg = alert.getText();		
		    alert.accept();
			return alertmsg;
		  
	}


}
