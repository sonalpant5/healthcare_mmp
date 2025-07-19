package mmp_Library;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FrameworkLibrary {
	protected WebDriver driver;
	protected Properties prop = new Properties();

	@BeforeClass
	public void setUp() throws Exception
	{
		readPropertyFile("mmp_global.properties");
		
		switch (prop.getProperty("browsertype").toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		default:
			throw new IllegalArgumentException("Unsupported browser: "+prop.getProperty("browsertype"));
		}
		
		switch(prop.getProperty("environment").toLowerCase()){
		
		case "qa":
			readPropertyFile("mmp_qa.properties");
			break;
			
		case "dev":
			readPropertyFile("mmp_dev.properties");
			break;
			
		default:
			throw new IllegalArgumentException("Unsupported environment: "+prop.getProperty("browsertype"));
		}
		
			launchApplication(prop.getProperty("patient_url"));
		
		}

	
	public void readPropertyFile(String filename) throws Exception
	{
		String filepath = System.getProperty("user.dir") +"/config/" + filename;
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		//System.out.println("Properties file loaded successfully: " + filepath);
	}
	
	public void launchApplication(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
	}
	@SuppressWarnings("deprecation")
	@AfterClass
	public void tearDown() throws Exception
	{
		driver.close();
		Runtime.getRuntime().exec("taskkill /F /IM chromeDriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
	}
}
