package com.learn.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Browser {
		protected static WebDriver driver = new FirefoxDriver();
		protected static String baseUrl; 
		protected static String CSV_PATH;
		
		@BeforeSuite
		public static void setup(){
			CSV_PATH = "/home/amit/BrowserAndUrl.csv";
			baseUrl = "https://www.linkedin.com/";
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		public static WebDriver getDriver(){
			if(null == driver){
				driver = new FirefoxDriver();
			}
			return driver;
		}
		
		@AfterSuite
		public static void tearDown(){
			driver.quit();
		}
}
