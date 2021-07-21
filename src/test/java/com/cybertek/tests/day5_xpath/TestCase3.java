package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase3 {
    public static void main(String[] args) throws InterruptedException {

        //      Test case 3
//        Go to wikipedia.org (Links to an external site.)
//        enter search term `selenium webdriver`
//        click on search button
//        click on search result `Selenium (software)`//tıkla
//        verify url ends with `Selenium_(software)' //url'ın 'Selenium_(software)' oldugunu dogrula


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        WebElement inputSearch=driver.findElement(By.id("searchInput"));
        WebElement searchButton=driver.findElement(By.id("searchButton"));
        inputSearch.sendKeys("selenium webdriver");
        Thread.sleep(2000);
        searchButton.click();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        // WebElement software=driver.findElement(By.linkText("wiki/Selenium_(software)"));
       WebElement software=driver.findElement(By.partialLinkText("(software)"));
       Thread.sleep(2000);
        System.out.println("software.getText() = " + software.getText());
        software.click();
        String expectedCurrentUrl=driver.getCurrentUrl();

        System.out.println(expectedCurrentUrl);

         if (expectedCurrentUrl.endsWith("Selenium_(software)")){
             System.out.println("pass");
         }else {
             System.out.println("Fail");
         }

         //not=sayfa hatalı, bu tür hatalar olabilir


    }
}
