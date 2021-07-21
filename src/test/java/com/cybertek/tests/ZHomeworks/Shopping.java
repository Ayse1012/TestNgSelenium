package com.cybertek.tests.ZHomeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shopping {
    public static void main(String[] args) throws InterruptedException {
        /*
        -go to address http://automationpractice.com/index.php
        -search arama yerıne "apple" yaz
        -arama butonununa tıkla
        -aramadan sonra URL ın degıstıgını verıfy et
                 */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://automationpractice.com/index.php");

        String expectedUrl= driver.getCurrentUrl();

        WebElement search =driver.findElement(By.id("search_query_top"));
        search.sendKeys("apple");
        Thread.sleep(3000);

        WebElement button =driver.findElement(By.name("submit_search"));
        button.click();

        String actualUrl=driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fial");


        }
        driver.close();

    }
}
