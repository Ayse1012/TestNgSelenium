package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    //TagNameler=input,button,div,form,body...
    //tag name kullanacaksak ya bir tane olamlı, yada ilk inde kullanılmalı
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.findElement(By.tagName("input")).sendKeys("Ali can");
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("alican@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.tagName("button")).click();

        driver.close();

    }
}
