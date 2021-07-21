package com.cybertek.tests.day10_actions_is;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {
    //Executor=vasiyeti yerine getirme
    //selenium yerine javascript in işlem yapması

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        // driver.quit();
    }

    @Test
    public void clickWithJS() {
       // java script ile click
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        // dropdownLink.click();

        //java script ile click;
        //java script ile obje oluşturuyoruz
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",dropdownLink);

    }
    @Test
    public void typeWithJS() {
        //java script ile send keys yazma
     driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        String text="Hello World in Disable Field";

        JavascriptExecutor jse=(JavascriptExecutor) driver;//kesting yapıyoruz(dönüştürme)
        jse.executeScript("arguments[0].setAttribute('value', '"+text+"')",inputBox);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        //java script ilr ekranı aşağı yukarı hareket ettirme;
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");

        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");

        }
    }

    @Test
    public void amazon() throws InterruptedException {
        driver.get("https://wwww.amazon.com.tr/");
        WebElement turkey = driver.findElement(By.xpath("//a[text()='Turkey']"));
       // turkey.click();
        JavascriptExecutor jse=(JavascriptExecutor) driver;

//        for (int i = 0; i <23; i++) {
//            jse.executeScript("window.scrollBy(0.250)");
//
//        }


        //daha kolay bir yöntem:
        // "arguments[0].scrollIntoView(true);" =yukarıda locayt ettiğimiz elementi görene kadar aşağı in:

        jse.executeScript("arguments[0].scrollIntoView(true);",turkey);
        Thread.sleep(2000);
        turkey.click();

    }


}
