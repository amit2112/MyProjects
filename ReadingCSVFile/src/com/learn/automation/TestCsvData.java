package com.learn.automation;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.pageobject.BasePage;
import com.automation.pageobject.LoginPage;

import au.com.bytecode.opencsv.CSVReader;

@Listeners(com.learn.utilities.Utility.class)
public class TestCsvData extends Browser {

	@Test
	public void csvDataRead() throws IOException {
		driver.get(baseUrl);
		Actions so = new Actions(driver);

		@SuppressWarnings("resource")
		CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
		String[] csvCell;
		

		// while loop will be executed till the last line In CSV.

		while ((csvCell = reader.readNext()) != null) {
			String user = csvCell[0];
			String pass = csvCell[1];
			String exp = csvCell[2];
			String exp_so = csvCell[3];

			  // logging in 
			  LoginPage lp = new LoginPage(driver);
			  lp.login(user, pass);
			  
			  // Asserting 
			  BasePage bp = new BasePage(driver); 
			  String  act = driver.getTitle(); 
			  bp.assertByTitle(exp, act);
			  
			  
			  // Signing Out 
			  bp.signOut(so);
			  driver.switchTo().frame("ad-uas-consumer-logout-1"); 
			  act = driver.getTitle(); 
			  driver.navigate().back();
			  bp.assertByTitle(exp_so, act);

		}
	}
}
