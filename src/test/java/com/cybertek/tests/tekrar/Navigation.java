package com.cybertek.tests.tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
    public static class NavigationDemo1 {
        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            String myUrl= "https://www.google.com";

            driver.get(myUrl);
            Thread.sleep(3000);
            driver.get("https://www.youtube.com");
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().forward();
            driver.navigate().refresh();
            Thread.sleep(2000);
            driver.get("https://www.youtube.com/channel/UCZNZj3mkdCGJfCoKyl4bSYQ");
            driver.navigate().back();
            driver.get("https://www.youtube.com/watch?v=kgDPyfuCTJk");


        }
    }
}
