package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.learn.automation.Browser;

public class BasePage extends Browser{
   
    @FindBy(xpath="//img[@class='img-defer nav-profile-photo']")
    @CacheLookup
        private WebElement profileImg;
   
    @FindBy(xpath="//a[contains(text(),'Sign Out')]")
    @CacheLookup
        private WebElement signOutButton;
   
    @FindBy(xpath="//div[@class='alert error']")
        private WebElement errMsg;
    
   
    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
   
    public void signOut(Actions so){
        so.moveToElement(profileImg).perform();
        so.moveToElement(signOutButton).click().perform();
    }
   
    public String errMsg(){
        return errMsg.getText();
    }
   
    //common methods, these methods you can also write in separate assertion class depends on your choice
    public void assertByMsg(String exp, String act){
        Assert.assertEquals(exp, act);
        Reporter.log("Exp msg '"+exp+"'  matched with act msg '"+act+"'.", true); //here true is used to print the message in console as well
    }
    public void assertByTitle(String exp, String act){
        Assert.assertEquals(exp, act);
        Reporter.log("Exp title '"+exp+"' matched with act title '"+act+"'.", true);
    }
}
