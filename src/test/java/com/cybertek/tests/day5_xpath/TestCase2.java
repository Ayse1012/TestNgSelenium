package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase2 {
    public static void main(String[] args) {
        //        Test case 2
//        Go to Ebay //
//        search 'Selenium' //arat
//        click on search button
//        verify title contains Selenium //tıtleın ıcınde 'Selenıum' yazdıgını dogrula

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        WebElement inputSelenium=driver.findElement(By.id("gh-ac"));
        WebElement searchButton=driver.findElement(By.id("gh-btn"));
        inputSelenium.sendKeys("selenium");
        searchButton.click();
        String title=driver.getTitle();

        if (title.contains("selenium")){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
        driver.quit();




    }
}
