package mmp_utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import mmp_Library.FrameworkLibrary;

public class ListenerUtility implements ITestListener{
	
	private ExtentSparkReporter sparkReport; // use to setup the UI of the report.
	private ExtentReports extent;  // use to populate the common info of the report(testername, OS, environment)
	private ExtentTest test; //create testcase entries in the report and update status of the test method.
	protected Properties prop = new Properties();
	String environment = "";
	String browsertype = "";
	
	@Override
	public void onStart(ITestContext context)
	{
		String timestamp = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new Date());
		String reportName = "TestReport-" + timestamp + ".html";
		
		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/" + reportName);
		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setReportName("Functional Testing");
		sparkReport.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);  // binding spark report and extent Report
		
		try {
			new FrameworkLibrary().readPropertyFile("mmp_global.properties");
			 environment =  prop.getProperty("environment");
			 browsertype = prop.getProperty("browsertype");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
			extent.setSystemInfo("Environment", environment);
			extent.setSystemInfo("Browser Type", browsertype);
			
		System.out.println(context.getName()+ " : On start");
	}
	
	@Override
	public void onTestStart(ITestResult testResult)
	{
		test = extent.createTest(testResult.getTestClass().getName()+ " :: " + testResult.getMethod().getMethodName());
		test.log(Status.INFO, "Test Started");
		System.out.println(testResult.getName()+ " : On Test Start");
	}

	@Override
	public void onTestSuccess(ITestResult testResult)
	{
		test.log(Status.PASS, "Test Passed");
		System.out.println(testResult.getName()+ " : On Test Success");
	}
	
	@Override
	public void onTestFailure(ITestResult testResult)
	{
		test.log(Status.FAIL, testResult.getName());
		test.log(Status.FAIL, testResult.getThrowable().getMessage());
		try
		{
		String scPath = new ScreenShotUtil().captureScreen(testResult.getName());
		test.addScreenCaptureFromPath(scPath);
		}catch(Exception e)
		{
			e.getStackTrace();
		}
		System.out.println(testResult.getName()+ ": On Test Fail");
	}
	
	@Override
	public void onTestSkipped(ITestResult testResult)
	{
		test.log(Status.SKIP, "Test Skipped");
		System.out.println(testResult.getName()+ ": On Test Skip");
	}
	
	public void onFinish(ITestContext context)
	{
		if(extent != null)
		{
		extent.flush();
		}
		
		System.out.println("Extent Report flushed successfully");
	}
		
	
	
}
