package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {

//             Test case 1
//        Go to Ebay //"" a gıt
//        enter search term // araapplmea yaptır
//        click on search button // search button a tıkla
//        print number of results //sonucların sayısını yazdır
//

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        Thread.sleep(2000);
        WebElement input=driver.findElement(By.xpath("//input[@name='_nkw']"));//class bir tane gördüğü halde neden calişmadı çünkü class içinde boşluk olmamalı
       // WebElement input=driver.findElement(By.className(""))
        WebElement searchButton=driver.findElement(By.id("gh-btn"));
        input.sendKeys("apple");
        searchButton.click();
       WebElement result =driver.findElement(By.xpath("(//span[@class='BOLD'])[17]"));


       System.out.println("result.getText() = " + result.getText());


    }
}
