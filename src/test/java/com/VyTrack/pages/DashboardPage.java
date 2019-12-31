package com.VyTrack.pages;

import com.VyTrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{

    public DashboardPage(){  // Page Object model pattern comes with PAGEFACTORY
        PageFactory.initElements(Driver.get(),this);
    }

}