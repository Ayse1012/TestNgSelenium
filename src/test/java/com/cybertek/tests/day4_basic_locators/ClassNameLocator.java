package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameLocator {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

         WebElement homeBtn = driver.findElement(By.className("nav-link"));
        System.out.println("homeBtn.getText() = " + homeBtn.getText());
        homeBtn.click();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println("driver.findElement(By.className(\"h3\")).getText() = " + driver.findElement(By.className("h3")).getText());

        //class name locator ederken arada boşluk olursa çalışmaz
        //className("h3 he")//araya nokta koyabiliriz.
        driver.close();
    }
}
