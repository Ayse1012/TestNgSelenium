package com.cybertek.tests.day9_popups_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    //bir şeye tıkladığımızda bazen farklı bir pencerede açar
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        Thread.sleep(2000);
        driver= WebDriverFactory.getDriver("chrome");
        //driver.quit();
    }
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Title before click = " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Title after click= " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        String currentWindow =driver.getWindowHandle();//her pencerenın kendine özel numarası vardır

        Set<String> windowHandles = driver.getWindowHandles();// birden fazla pencereyi(numarayı) set olarak kaydediyoruz

        //javada set konusu:
        // set'ler de birinci özellik  dublicate(aynı elemandan iki adet) kabul etmezler
        //ikinci özellik ise sıralama yapmazlar
        //örn; elma ,armut portakal
        // armut ,elma portakal

        for (String handle : windowHandles) {
            if (!handle.equals(windowHandles)){
                driver.switchTo().window(handle);
                System.out.println("driver.findElement(By.tagName(h3)).getText() = " + driver.findElement(By.tagName("h3")).getText());
            }

        }
        System.out.println("driver.getTitle() = " + driver.getTitle());


    }
}
