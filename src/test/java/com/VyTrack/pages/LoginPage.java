package com.VyTrack.pages;


import com.VyTrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        // Page Object model pattern comes with PAGEFACTORY
        PageFactory.initElements(Driver.get(), this); // call driver and this keyword
    }

    //same with driver.findElement(By.id("prependedInput")); ==> @FindBy(id="prependedInput")
    @FindBy(id="prependedInput") // id values will be changed based on web site
    public WebElement usernameInput;

    @FindBy(id="prependedInput2")
    public WebElement passwordInput;

    @FindBy(id="_submit")
    public WebElement loginBtn;

//    @FindAll({ //OR multiple locator can be given to same element
//            @FindBy(id="prependedInput"),
//            @FindBy(name="_username")
//    })
//    public WebElement username2;

//     @FindBys({ //AND if all locators matching
//            @FindBy(id="prependedInput"),
//            @FindBy(name="_username")
//    })
//    public WebElement username2;

    public void login(String usernameStr, String passwordStr){
        usernameInput.sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();
    }


}

