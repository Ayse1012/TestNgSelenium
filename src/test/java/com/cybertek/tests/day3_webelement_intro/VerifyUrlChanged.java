package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {
    public static void main(String[] args) throws InterruptedException {
        /*open browser
        -go to http://practice.cybertekschool.com/forgot_password
        -enter any email(herhangibir email gir)
        -click on retrieve password
        -verify that url changet to http://practice.cybertekschool.com/email_sent
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedCurrentUrl = driver.getCurrentUrl();

        //By Name 'e gore elementi Locate etme
        WebElement emailInputBox =driver.findElement(By.name("email"));

        Faker fk =new Faker();
       // String emaıl=fk.internet().emailAddress();

        //sendKeys ile yazi gonder
        emailInputBox.sendKeys(fk.internet().emailAddress());//(emaıl);
        Thread.sleep(2000);

        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        retrievePassword.click();

        String actualUrl = driver.getCurrentUrl();

        if (expectedCurrentUrl.equals(actualUrl)) {
            System.out.println("Fail");
        }else {
            System.out.println( "Pass");
        }
        driver.close();







    }
}
