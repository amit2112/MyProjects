package com.learn.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.learn.automation.Browser;

public class Utility extends TestListenerAdapter {

	// Take screen shot only for failed test case
	@Override
	public void onTestFailure(ITestResult tr) {
		ScreenShot();
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// ScreenShot();
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		//ScreenShot();
	}

	private static void ScreenShot() {
		try {

			WebDriver driver1= Browser.getDriver();
			
			File scrFile = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
			
			// Now you can do whatever you need to do with it, for example copy somewhere
			FileUtils.copyFile(scrFile, new File("/home/amit/workspace/ReadingCSVFile/test-output/ScreenShot/screenshot.png"));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
