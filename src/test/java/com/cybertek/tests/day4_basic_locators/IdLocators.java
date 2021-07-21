package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocators {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //click the don't click button
        WebElement disappearbutton=driver.findElement(By.id("disappearing_button"));
        disappearbutton.click();

        WebElement resultMessage=driver.findElement(By.id("result"));
       String  actualMessage=resultMessage.getText();

       String expectedMessage="Now it's gone!";

       if (actualMessage.equals(expectedMessage)){
           System.out.println("Pass");
       }else {
           System.out.println("Fail");
       }
       driver.close();





    }
}
