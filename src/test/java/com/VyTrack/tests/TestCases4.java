package com.VyTrack.tests;

import com.VyTrack.pages.CalendarEventsPage;
import com.VyTrack.pages.CreateCalendarEventsPage;
import com.VyTrack.pages.DashboardPage;
import com.VyTrack.pages.LoginPage;
import com.VyTrack.utilities.BrowserUtils;
import com.VyTrack.utilities.ConfigurationReader;
import com.VyTrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class TestCases4 extends TestBase{

    @Test
    public void test1(){
        extentLogger= report.createTest("View Edit Delete Buttons");

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(4);
        WebElement testersMeeting= Driver.get().findElement(By.xpath("//td[contains(text(), 'Testers Meeting')]"));
        WebElement threeDots=Driver.get().findElement(By.xpath("(//td[.='Testers Meeting']/..//a)[1]"));
        new Actions(Driver.get()).moveToElement(testersMeeting).clickAndHold().moveToElement(threeDots).pause(400).clickAndHold().build().perform();
        WebElement delete=Driver.get().findElement(By.xpath("//a[@href='/calendar/event/update/277']/../../li[3]"));
        BrowserUtils.waitFor(3);
        WebElement view= Driver.get().findElement(By.xpath("//a[@title='View'][@href='/calendar/event/view/277']"));
        WebElement edit=Driver.get().findElement(By.xpath("//a[@title='Edit'][@href='/calendar/event/update/277']"));

        extentLogger.info("Verify that View is Available");
        Assert.assertTrue(view.isDisplayed(), "Verify that View is Available");
        extentLogger.pass("PASS: Verify that View is Available");

        extentLogger.info("Verify that Edit is Available");
        Assert.assertTrue(edit.isDisplayed(), "Verify that Edit is Available");
        extentLogger.pass("PASS: Verify that Edit is Available");

        extentLogger.info("Verify that Delete is Available");
        Assert.assertTrue(delete.isDisplayed(), "Verify that Delete is Available");
        extentLogger.pass("PASS: Verify that Delete is Available");
    }

    @Test
    public void test2(){
        extentLogger=report.createTest("Grid Settings");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);

        WebElement gridSettings=Driver.get().findElement(By.cssSelector("[title='Grid Settings']"));
        gridSettings.click();
        BrowserUtils.waitFor(1);

        List<WebElement> selectAllOptions=Driver.get().findElements(By.xpath("//input[@data-role='renderable']"));
        for (WebElement selectAllOption : selectAllOptions) {
            if(selectAllOption== selectAllOptions.get(0)){
                continue;
            } else{
                selectAllOption.click();
                BrowserUtils.waitFor(1);
                extentLogger.info("Verify that Settings options are unselected.");
                Assert.assertFalse(selectAllOption.isSelected());
                extentLogger.pass("PASS: Options are unselected");
            }
        }
        BrowserUtils.waitFor(2 );
        WebElement titleOptions=Driver.get().findElement(By.xpath("(//input[@data-role='renderable'])[1]"));
        extentLogger.info("Verify that Title is selected");
        Assert.assertTrue(titleOptions.isSelected());
        extentLogger.pass("PASS: Title is selected");
    }

    @Test
    public void test3(){
        extentLogger= report.createTest("Save Menu");

        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        extentLogger.info("Click on create Calendar Event Button");
        calendarEventsPage.createCalendarEvent.click();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        extentLogger.info("Expand Save and Close Menu:");
        createCalendarEventsPage.saveDropDown.click();
        BrowserUtils.waitFor(5);

        extentLogger.info("Verify that Save and Close Button is available");
        Assert.assertTrue(createCalendarEventsPage.saveAndClose.isDisplayed(), "Verify that Save and Close Button is available");
        BrowserUtils.waitFor(2);
        extentLogger.pass("PASS: Verify that Save and Close Button is available");
        extentLogger.info("Verify that Save and New Button is available");
        Assert.assertTrue(createCalendarEventsPage.saveAndNew.isDisplayed(),"Verify that Save and New Button is available");
        BrowserUtils.waitFor(1);
        extentLogger.pass("PASS: Verify that Save and New Button is available");
        extentLogger.info("Verify that Save Button is available");
        Assert.assertTrue(createCalendarEventsPage.save.isDisplayed(), "Verify that Save Button is available");
        extentLogger.pass("PASS: Verify that Save Button is available");
    }

    @Test
    public void test4(){
        extentLogger= report.createTest("All Calendar Events Button");

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on create Calendar Events");
        new CalendarEventsPage().createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on Cancel Button");
        createCalendarEventsPage.cancel.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Verify that All Calendar Events Page Subtitle is displayed");
        Assert.assertTrue(new CalendarEventsPage().pageSubTitle.isDisplayed(), "Verify that All Calendar Events Page Subtitle is displayed");
        extentLogger.pass("PASS: Verify that All Calendar Events Page Subtitle is displayed");
    }

    @Test
    public void test5(){
        extentLogger= report.createTest("Ends And Start Time Difference");

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        extentLogger.info("Click on create Calendar Events");
        new CalendarEventsPage().createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        extentLogger.info("Get the values of start time and end time values");
        String startTime=createCalendarEventsPage.startTime.getAttribute("value");
        String endTime=createCalendarEventsPage.endTime.getAttribute("value");
        extentLogger.pass("PASS: Get the values End Time And Start Time Values");

        String[]startTime1=startTime.split(":");
        String[]endTime1=endTime.split(":");
        int actualDifference= Integer.valueOf(endTime1[0])-Integer.valueOf(startTime1[0]);
        extentLogger.info("Verify that difference between end time and start time is exactly 1 hour");
        Assert.assertEquals(actualDifference, 1);
        extentLogger.pass("PASS: Verify that difference between end time and start time is exactly 1 hour");
    }

    @Test
    public void test6(){
        extentLogger= report.createTest("Ends Time is 10:00 PM");

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);
        extentLogger.info("Click on create Calendar Events");
        new CalendarEventsPage().createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        extentLogger.info("Select start time as 09:00");
        createCalendarEventsPage.startTime.click();
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", createCalendarEventsPage.startTimePicker);
        Driver.get().findElement(By.xpath("//*[contains(text(),'Start')]")).click();
        BrowserUtils.waitFor(2);
        extentLogger.info("Verify that end time is equals to 10:00 PM");
        Assert.assertEquals(createCalendarEventsPage.endTime.getAttribute("value"), "10:00 PM", "Verify that end time is equals to 10:00 PM");
        extentLogger.pass("PASS: Verify that end time is equals to 10:00 PM");
    }

    @Test
    public void test7(){
        extentLogger=report.createTest("All Day Events");
        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);
        extentLogger.info("Click on create Calendar Events");
        new CalendarEventsPage().createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        extentLogger.info("Click on All day Event button");
        createCalendarEventsPage.allDayEventButton.click();
        extentLogger.info("Verify that start time is displayed");
        Assert.assertTrue(createCalendarEventsPage.startTime.isDisplayed(), "Verify that start time is displayed");
        extentLogger.pass("PASS: Verify that start time is displayed");
        extentLogger.info("Verify that end time is displayed");
        Assert.assertTrue(createCalendarEventsPage.endTime.isDisplayed(), "Verify that start time is displayed");
        extentLogger.pass("PASS: Verify that end time is displayed");
        extentLogger.info("Verify that All day events button is selected");
        Assert.assertTrue(createCalendarEventsPage.allDayEventButton.isSelected(), "Verify that All day events button is selected");
        extentLogger.pass("PASS: Verify that All day events button is selected");
        BrowserUtils.waitFor(2);
        extentLogger.info("Verify that start time is not displayed");
        Assert.assertFalse(createCalendarEventsPage.startTime.isDisplayed(), "Verify that start time is not displayed");
        extentLogger.pass("PASS: Verify that start time is not displayed");
        extentLogger.info("Verify that end time is not displayed");
        Assert.assertFalse(createCalendarEventsPage.endTime.isDisplayed(), "Verify that end time is not displayed");
        extentLogger.pass("Verify that end time is not displayed");
    }

    @Test
    public void test8(){
        extentLogger=report.createTest("Repeat Checkbox");
        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);
        extentLogger.info("Click on create Calendar Events");
        new CalendarEventsPage().createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Verify that checkbox is selected");
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        extentLogger.pass("PASS: Verify that checkbox is selected");
        createCalendarEventsPage.repeatOptionsList();
        String actualSelectedItem= createCalendarEventsPage.repeatOptionsList().getFirstSelectedOption().getText();
        extentLogger.info("Verify that Daily is selected");
        Assert.assertEquals(actualSelectedItem, "Daily");
        extentLogger.pass("PASS: Verify that Daily is selected");

        List<WebElement> actualWeeklyOption= createCalendarEventsPage.repeatOptionsList().getOptions();

        extentLogger.info("Verify that Weekly is selected");
        Assert.assertEquals(actualWeeklyOption.get(1).getText(), "Weekly");
        extentLogger.pass("PASS: Verify that Weekly is selected");
        extentLogger.info("Verify that Monthly is selected");
        Assert.assertEquals(actualWeeklyOption.get(2).getText(), "Monthly");
        extentLogger.pass("PASS: Verify that Monthly is selected");
        extentLogger.info("Verify that Yearly is selected");
        Assert.assertEquals(actualWeeklyOption.get(3).getText(), "Yearly");
        extentLogger.pass("PASS: Verify that Yearly is selected");
    }

    @Test
    public void test9(){
        extentLogger=report.createTest("Summary: Daily every 1 day");
        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);
        extentLogger.info("Click on create Calendar Events");
        new CalendarEventsPage().createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Verify that repeat checkbox is selected");
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected(), "Verify that repeat checkbox is selected");
        extentLogger.pass("PASS: Verify that repeat checkbox is selected");
        extentLogger.info("Verify that repeat everyday radio button is selected");
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify that repeat everyday radio button is selected");
        extentLogger.pass("PASS: Verify that repeat everyday radio button is selected");
        extentLogger.info("Verify that never radio button is selected");
        Assert.assertTrue(createCalendarEventsPage.never.isSelected(), "Verify that never radio button is selected");
        extentLogger.pass("PASS: Verify that never radio button is selected");
        extentLogger.info("Verify that Daily every 1 day displayed");
        Assert.assertEquals(createCalendarEventsPage.summary.getText(),"Daily every 1 day", "Verify that Daily every 1 day displayed");
        extentLogger.pass("PASS: Verify that Daily every 1 day displayed");
    }

    @Test
    public void test10(){
        extentLogger=report.createTest("Summary: After 10 occurrences");
        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);
        extentLogger.info("Click on create Calendar Events");
        new CalendarEventsPage().createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        extentLogger.info("Select repeat checkbox");
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Select After 10 occurrunces as an ends option");
        createCalendarEventsPage.after.click();
        new Actions(Driver.get()).moveToElement(createCalendarEventsPage.accuranceInput).release().build().perform();
        createCalendarEventsPage.accuranceInput.sendKeys("10"+Keys.ENTER);
        extentLogger.info("Verify that Summary: Daily every 1 day, endafter 10 occurrences is displayed");
        Assert.assertEquals(createCalendarEventsPage.summaryEvery1Day.getText(),"Daily every 1 day");
        Assert.assertEquals(createCalendarEventsPage.summary10Occurrences.getText(),", end after 10 occurrences");
        extentLogger.pass("PASS: Verify that Summary: Daily every 1 day, endafter 10 occurrences is displayed");
    }

    @Test
    public void test11(){
        extentLogger=report.createTest("Summary: Daily every 1 day, end by Nov 18, 2021");
        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);
        extentLogger.info("Click on create Calendar Events");
        new CalendarEventsPage().createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        extentLogger.info("Select repeat checkbox");
        createCalendarEventsPage.repeat.click();
        extentLogger.info("Select By Nov 18, 2021 as an ends option");
        createCalendarEventsPage.by.click();
        extentLogger.info("Verify that Summary: Daily every 1 day, end by Nov 18, 2021  is displayed");
        createCalendarEventsPage.chooseADate.sendKeys("Nov 18, 2021"+ Keys.ENTER);
        Assert.assertEquals(createCalendarEventsPage.summaryEvery1Day.getText(),"Daily every 1 day");
        Assert.assertEquals(createCalendarEventsPage.byNov18.getText(),", end by Nov 18, 2021");
        extentLogger.pass("PASS: Verify that Summary: Daily every 1 day, end by Nov 18, 2021  is displayed");
    }

    @Test
    public void test12(){
        extentLogger=report.createTest("Summary: Weekly every 1 week onMonday, Friday");
        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(6);
        extentLogger.info("Click on create Calendar Events");
        new CalendarEventsPage().createCalendarEvent.click();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Select repeat checkbox");
        createCalendarEventsPage.repeat.click();
        List<WebElement> repeatsOptions=createCalendarEventsPage.repeatOptionsList().getOptions();
        repeatsOptions.get(1).click();

        BrowserUtils.waitFor(3);
        createCalendarEventsPage.monday.click();
        createCalendarEventsPage.friday.click();
        extentLogger.info("Verify that monday is selected");
        Assert.assertTrue(createCalendarEventsPage.monday.isSelected(), "Verify that monday is selected");
        extentLogger.pass("PASS: Verify that monday is selected");
        extentLogger.info("Verify that friday is selected");
        Assert.assertTrue(createCalendarEventsPage.friday.isSelected(), "Verify that friday is selected");
        extentLogger.pass("PASS: Verify that friday is selected");
        extentLogger.info("Verify that Summary: Weekly every 1 week on Monday, Friday");
        Assert.assertEquals(createCalendarEventsPage.weeklyEvery.getText(),"Weekly every 1 week on Monday, Friday");
        extentLogger.pass("PASS: Verify that  Summary: Weekly every 1 week on Monday, Friday");
    }

    @BeforeMethod
    public void loginCredentials(){
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.get("storemanager_username");
        String password=ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);
        new DashboardPage().navigateToModule("Activities", "Calendar Events");
    }
}

