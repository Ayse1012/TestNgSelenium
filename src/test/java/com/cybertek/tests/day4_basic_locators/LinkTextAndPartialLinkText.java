package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();//pencereyi büyüt

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger")).click();
        Thread.sleep(2000);
        driver.navigate().back();
     driver.findElement(By.linkText("Example 2")).click();
        Thread.sleep(2000);

      //  driver.close();




    }
}
