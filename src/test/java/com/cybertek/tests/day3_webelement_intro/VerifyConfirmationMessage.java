package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        /*task
        -open the chrome browser
       - go to http://practice.cybertekschool.com/forgot_password
        -enter on retrieve password
        -click on retrieve password
        --verify that confirmation message 'Your e-mail's has been sent!
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get(" http://practice.cybertekschool.com/forgot_password");

        WebElement mail =driver.findElement(By.name("email"));
        Faker fk=new Faker();
        mail.sendKeys(fk.internet().emailAddress());

        WebElement retrievePass = driver.findElement(By.id("form_submit"));
        retrievePass.click();

         WebElement conformationMassage= driver.findElement(By.name("confirmation_message"));
        String actualConfMessage= conformationMassage.getText();//get.Attribüt
        System.out.println(actualConfMessage);
        String confMessage="Your e-mail's been sent!";
        Thread.sleep(1000);

        if (actualConfMessage.equals(confMessage)){
            System.out.println("Fial");
        }else {
            System.out.println("Pass");
        }
        driver.close();




    }
}
