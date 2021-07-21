package com.cybertek.tests.day7_types_ofelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayDemo {
    //userName i ilk once gore sonra tıkla ve userName i gör

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userInput = driver.findElement(By.id("username"));

        Assert.assertFalse(userInput.isDisplayed(),"verify is NOT DISPLAYED");
        Thread.sleep(2000);
        //userName i görmedi

        driver.findElement(By.xpath("//button[text()='Start']")).click();//start a clickledi
        Thread.sleep(5000);
        //  userInput.sendKeys("xyz123");
        System.out.println("userInput.isDisplayed() = " + userInput.isDisplayed());
        Assert.assertTrue(userInput.isDisplayed(),"verify is displayed");
        //userName i gördü

        driver.quit();

        //display metotu= userName varmı varsa true yoksa false döner






    }
}
