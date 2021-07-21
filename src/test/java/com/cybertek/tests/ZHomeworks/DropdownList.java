package com.cybertek.tests.ZHomeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownList {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement=driver.findElement(By.cssSelector("#dropdown"));

        Select dropdown=new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        System.out.println("options.size() = " + options.size());
        Thread.sleep(2000);
        dropdown.selectByVisibleText("Option 1");

        String expectedOptionText="Option 1";
        String actualOptionText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOptionText,actualOptionText,"verify option 1");

        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());

        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dataYearElement=driver.findElement(By.cssSelector("#year"));
        WebElement dataMonthElement=driver.findElement(By.cssSelector("#month"));
        WebElement dataDayElement =driver.findElement(By.id("day"));

        Select year=new Select(dataYearElement);
        Select month=new Select(dataMonthElement);
        Select day=new Select(dataDayElement);

        List<WebElement> yearOptions = year.getOptions();
        System.out.println("yearOptions.size() = " + yearOptions.size());
        List<WebElement> monthOptions = month.getOptions();
        System.out.println("monthOptions.size() = " + monthOptions.size());
       List<WebElement> dayOptions = day.getOptions();
        System.out.println("dayOptions.size() = " + dayOptions.size());

        String expectedYearText="2021";
        String actualYearText =year.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedYearText,actualYearText,"verify year");

         Thread.sleep(2000);
        month.selectByVisibleText("April");
        String expectedMonthText="April";
        String actualMonthText=month.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedMonthText,actualMonthText,"verify month");

        for (WebElement dayOption : dayOptions) {
            System.out.println("dayOption.getText() = " + dayOption.getText());
        }
        Thread.sleep(2000);
        day.selectByIndex(9);
        String expectedDayText="10";
       String actualDayText=day.getFirstSelectedOption().getText();
       Assert.assertEquals(expectedDayText,actualDayText,"verify day");

        for (WebElement yearOption : yearOptions) {
            System.out.println("yearOption.getText() = " + yearOption.getText());
        }
        for (WebElement monthOption : monthOptions) {
            System.out.println("monthOption.getText() = " + monthOption.getText());
        }

    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement stateElement=driver.findElement(By.cssSelector("#state"));

        Select state=new Select(stateElement);
        List<WebElement> stateOptions = state.getOptions();
        System.out.println("stateOptions.size() = " + stateOptions.size());

        for (WebElement stateOption : stateOptions) {
            System.out.println("stateOption.getText() = " + stateOption.getText());

        }
         Thread.sleep(2000);
        state.selectByVisibleText("Arkansas");
        String expectedStateText="Arkansas";
        String actualStateText = state.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedStateText,actualStateText,"verify Arkansas");

    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
       WebElement languagesElement=driver.findElement(By.name("Languages"));
       Select languages=new Select(languagesElement);
        List<WebElement> languagesOptions = languages.getOptions();
        System.out.println("languagesOptions.size() = " + languagesOptions.size());

        for (WebElement languagesOption : languagesOptions) {
            System.out.println("languagesOption.getText() = " + languagesOption.getText());
        }
      // languagesOptions.get(1).click();
        Thread.sleep(2000);
        languages.selectByIndex(1);
        String expectedLanguagesText="JavaScript";
        String actualLanguagesText=languages.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedLanguagesText,actualLanguagesText,"verify languages" );



    }
}
