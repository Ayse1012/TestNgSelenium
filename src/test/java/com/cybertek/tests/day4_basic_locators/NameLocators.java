package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocators {
    //name locator birden fazla olabilir,dikkat etmeliyiz
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        Faker fk=new Faker();

        WebElement full_name=driver.findElement(By.name("full_name"));
        full_name.sendKeys(fk.name().fullName());
        Thread.sleep(2000);
        WebElement email =driver.findElement(By.name("email"));
        email.sendKeys(fk.internet().emailAddress());

        WebElement wooden_spoon=driver.findElement(By.name("wooden_spoon"));
        wooden_spoon.click();
        driver.quit();




    }
}
