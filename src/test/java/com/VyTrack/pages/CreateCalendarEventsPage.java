package com.VyTrack.pages;

import com.VyTrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventsPage extends BasePage {

    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath="//input[@value='monday']")
    public WebElement monday;

    @FindBy(xpath="//input[@value='friday']")
    public WebElement friday;

    @FindBy(xpath="(//option[@value='weekly'])[1]")
    public WebElement weeklyOption;

    @FindBy(css = "[id^='recurrence-repeats-view1026'][name^='temp-validation-name']")
    public WebElement selectWeekly;

    @FindBy(xpath = "(//input[@placeholder= 'Choose a date'])[3]")
    public WebElement chooseADate;

    @FindBy(xpath = "//*[contains(text(), ', end by Nov 18, 2021')]")
    public WebElement byNov18;

    @FindBy(xpath = "//*[contains(text(), 'Daily every 1 day')]")
    public WebElement summaryEvery1Day;

    @FindBy(xpath = "//*[contains(text(), 'Weekly every 1 week on Monday, Friday')]")
    public WebElement weeklyEvery;

    @FindBy(xpath = "//*[contains(text(), ', end after 10 occurrences')]")
    public WebElement summary10Occurrences;

    @FindBy(xpath = "(//input[@class='recurrence-subview-control__number'])[7]")
    public WebElement accuranceInput;

    @FindBy(xpath = "//*[contains(text(), 'Daily every 1 day')]")
    public WebElement summary;

    @FindBy(css = "[name^='oro_calendar_event_form[allDay]']")
    public WebElement allDayEventButton;

    @FindBy(xpath = "(//*[contains(text(), 'Cancel')])[2]")
    public WebElement cancel;

    @FindBy(xpath = "(//*[contains(text(), 'Save')])[4]")
    public WebElement save;

    @FindBy(xpath = "//*[contains(text(), 'Save')]/../a")
    public WebElement saveDropDown;

    @FindBy(xpath = "(//*[contains(text(), 'Save and Close')])[2]")
    public WebElement saveAndClose;

    @FindBy(xpath = "//*[contains(text(), 'Save and New')]")
    public WebElement saveAndNew;

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;

    @FindBy(xpath = "(//li[contains(text(),'9:00')])[2]")
    public WebElement startTimePicker;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;

    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }


}
