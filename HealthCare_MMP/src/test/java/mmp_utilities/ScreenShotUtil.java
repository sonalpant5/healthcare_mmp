package mmp_utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import mmp_Library.FrameworkLibrary;

public class ScreenShotUtil extends FrameworkLibrary {
	
	
	public String captureScreen(String testname)
	{
		String timestamp = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new Date());
		
		TakesScreenshot tc = (TakesScreenshot) driver;
		File srcFile = tc.getScreenshotAs(OutputType.FILE);
		
		String targetpath = System.getProperty("user.dir")+ "/screenshots/" +testname+ "_"+timestamp+ ".png" ;
		File targetFile = new File(targetpath);
		
		try {
		    FileUtils.copyFile(srcFile, targetFile);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return targetpath;
				
	}

}
