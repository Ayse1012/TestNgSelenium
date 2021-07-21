package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getUrlAndTitle {
    public static void main(String[] args) throws InterruptedException {
         //title= başlık
        //getTitle=girilen sayfanın başlığını yazdırır

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.co.uk/");
        System.out.println("Title = " + driver.getTitle());

        //get Title ile sekme üzerinde bulunan başlığı alıyoruz
         driver.get("http://practice.cybertekschool.com");
        //System.out.println("Title() = " + driver.getTitle());
         String title =driver.getTitle();
         System.out.println("Title cybertek :"+title);

        //get current url(geçerli web adresini alma)
        String currentUal=driver.getCurrentUrl();
        System.out.println("currentUal :"+currentUal);

        //get page source(sayfanın gtml yapısını nerir
        String pageSource = driver.getPageSource();
        System.out.println("page Source :"+pageSource);
        Thread.sleep(2000);

        driver.close();


    }
}
