package com.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learn.automation.Browser;

@SuppressWarnings("unused")
public class LoginPage extends Browser {
   
    @FindBy(id="login-email")  //used id locator here because its best in performance, you can use other locators as well
    @CacheLookup
        private WebElement emailAddress;
   
    @FindBy(id="login-password")
    @CacheLookup
        private WebElement password;
   
    @FindBy(name="submit")
    @CacheLookup
        private WebElement signInButton;
   
    public WebElement emailAddress(){
        return emailAddress;
    }
   
    public WebElement password(){
        return password;
    }
   
    public WebElement signInButton(){
        return signInButton;
    }
   
    public LoginPage(WebDriver driver){  //create a constructor to invoke the page factory to initialize/load all the webelements present in page class
        PageFactory.initElements(driver, this); //here 'this' is the keyword to invoke the same class members
    }
   
    public void login(String user, String pass){
        emailAddress.sendKeys(user);
        password.sendKeys(pass);
        signInButton.click();
    }

}
