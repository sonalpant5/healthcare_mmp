package mmpTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class launchPage {
	public WebDriver driver;

	@BeforeClass
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));	
		getUrl("http://85.209.95.122/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			
	}
	
	public void getUrl(String path)
	{
		driver.get(path);
	}
	
		
	@SuppressWarnings("deprecation")
	@AfterClass
	public void tearDown() throws Exception
	{
		driver.quit();
		Runtime.getRuntime().exec("taskkill /F /IM chromeDriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
	}

}
