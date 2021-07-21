package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//her locator dan once çalışacak
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);//wait_ beklemek(kodu durdurur başka işlem yapmaz)
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[text()='Start']")).click();
        WebElement usernameInput = driver.findElement(By.id("username"));
        //WebDriverWait classından obje oluşturup wait metotlarını kullanıyoruz
        WebDriverWait wait=new WebDriverWait(driver,10);
        //until= a kadar
        wait.until(ExpectedConditions.visibilityOf(usernameInput));

        usernameInput.sendKeys("Apple");

    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input "));

        WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));//burada clickleme şartına bağlı
        //belli bir şarta bağlı olarak çalışan wait türü

        inputBox.sendKeys("Apple");
    }
}