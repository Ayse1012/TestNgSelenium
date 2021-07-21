package com.cybertek.tests.ZHomeworks;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox2 {
    public static void main(String[] args) throws InterruptedException {
        //go to https://www.demoqa.com/text-box
        //kutuları doldur ve submiti click le

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.demoqa.com/text-box");

        WebElement fulName =driver.findElement(By.id("userName"));
        Faker fk=new Faker();
        fulName.sendKeys(fk.name().fullName());
        Thread.sleep(2000);

        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys(fk.internet().emailAddress());
        Thread.sleep(2000);

        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(fk.address().fullAddress());
        Thread.sleep(2000);

        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(fk.address().streetAddress());
        Thread.sleep(2000);

         WebElement submitButton =driver.findElement(By.xpath("//button[@id='submit']"));
         submitButton.click();
        Thread.sleep(2000);



    }

}
