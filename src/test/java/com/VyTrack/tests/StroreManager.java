package com.VyTrack.tests;

import com.VyTrack.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StroreManager {
    WebDriver driver;
    @BeforeMethod
    public void connection(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/");
        driver.manage().window().maximize();
//        driver.findElement(By.name("_username")).sendKeys("storemanager85");
//        driver.findElement(By.name("_password")).sendKeys("UserUser123");
//        driver.findElement(By.xpath("//button")).click();
//
//        WebElement calendarActivities=driver.findElement(By.xpath("(//*[.='Calendar Events'])[3]"));
//        JavascriptExecutor jse= (JavascriptExecutor)driver;
//        jse.executeScript("arguments[0].click();",calendarActivities);

    }

    @Test
    public void test1(){
        Boolean options= driver.findElement(By.xpath("(//*[contains(text(),'Options')])[2]")).isDisplayed();
        Assert.assertTrue(options);
    }

    @Test
    public void test2(){
        String actualValue= driver.findElement(By.cssSelector("input[type='number']")).getAttribute("value");
        String expectedValue="1";
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test
    public void test3(){
        String actualValue= driver.findElement(By.xpath("//button[contains(text(),'25')]")).getText();
        String expectedValue="25";
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test
    public void test4(){
        String numberOfEvents= driver.findElement(By.xpath("//label[@class='dib'][3]")).getText();
        String[] expectedNumberOfEvents= numberOfEvents.split(" ");
        System.out.println(expectedNumberOfEvents.toString());

        Integer expectedNumberOfEvent = Integer.valueOf(expectedNumberOfEvents[2]);
        List<WebElement> listTable=driver.findElements(By.cssSelector("tbody > tr"));
        Integer actualNumberOfEvent=Integer.valueOf(listTable.size());
        Assert.assertEquals(expectedNumberOfEvent,actualNumberOfEvent);
    }

    @Test
    public void test5(){
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        WebElement clickButton= driver.findElement(By.xpath("//div/button/input"));
        jse.executeScript("arguments[0].click();",clickButton);// buraya tikladi.

        List<WebElement> list=  driver.findElements(By.xpath("//input[@tabindex='-1']"));
        for (WebElement value : list) {
            Assert.assertTrue(value.isSelected());
        }
    }

    @Test
    public void test6() {
        Actions actions = new Actions(driver);
//        WebDriverWait wait=new WebDriverWait(driver,10);
//        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[14]")));
        WebElement element=driver.findElement(By.xpath("//tbody/tr[14]"));
        WebElement rows=driver.findElement(By.xpath("//tbody/tr[14]/td[3]"));

        actions.moveToElement(element).clickAndHold().pause(2000).moveToElement(rows).click().build().perform();

        String actualTitle=driver.findElement(By.xpath("(//*[.='Testers Meeting'])[2]")).getText();
        String expectedTitle="Testers Meeting";
        Assert.assertEquals(actualTitle,expectedTitle);

        String actualDescription=driver.findElement(By.xpath("//p")).getText();
        String expectedDescription="This is a a weekly testers meeting";
        Assert.assertEquals(actualDescription,expectedDescription);

        String actualStartTime=driver.findElement(By.xpath("//*[contains(text(),'9:30')]")).getText();
        String expectedStartTime="Nov 27, 2019, 9:30 PM";
        Assert.assertEquals(actualStartTime,expectedStartTime);

    }



    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
