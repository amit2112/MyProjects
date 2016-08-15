package com.learn.testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Guru99Test1 {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.demo.guru99.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGuru99Test1() throws Exception {
    driver.get(baseUrl + "/V4/index.php");
    driver.findElement(By.name("uid")).clear();
    driver.findElement(By.name("uid")).sendKeys("mngr26417");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("tyqUmas");
    driver.findElement(By.name("btnLogin")).click();
    
    String s1 =  driver.findElement(By.cssSelector(".heading3 > td")).getText();
    System.out.println(s1);
    AssertJUnit.assertTrue("Element is found", s1.contains("Manger Id : mngr26417"));
  }

  @AfterMethod
public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }
}
