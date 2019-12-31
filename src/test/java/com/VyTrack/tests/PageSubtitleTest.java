package com.VyTrack.tests;

import com.VyTrack.pages.CalendarEventsPage;
import com.VyTrack.pages.DashboardPage;
import com.VyTrack.pages.LoginPage;
import com.VyTrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    @Test
    public void verifySubtitleTest(){
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");
        loginPage.login(username, password);

        DashboardPage dashboardPage= new DashboardPage();
        String actual=dashboardPage.getPageSubTitle();
        String expected="Quick Launchpad";
        Assert.assertEquals(actual,expected, "Verify that page subtitle is Quick Launchpad");

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        String actualSubtitle=calendarEventsPage.getPageSubTitle(); // called CalendarEventsPage class from here
        String expectedSubtitle="Calendar Events";
        Assert.assertEquals(actualSubtitle,expectedSubtitle, "Verify that page subtitle is Calendar Events");


    }

}
