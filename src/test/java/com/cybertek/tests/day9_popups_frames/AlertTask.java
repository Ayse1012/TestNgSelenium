package com.cybertek.tests.day9_popups_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTask {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
          driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[3]")).click();

        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("hello Ayse");
        alert.accept();

        WebElement alertText=driver.findElement(By.cssSelector("#result"));
        String actualText=alertText.getText();
        String expectedText="You entered: hello Ayse";

        Assert.assertEquals(expectedText,actualText);



    }
}
