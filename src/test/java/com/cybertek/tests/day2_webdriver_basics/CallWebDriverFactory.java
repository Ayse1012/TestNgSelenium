package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) {
       // WebDriverManager' artık ihtiyaç yok aşağıda weDriverFactory class ından çağırmış olduk

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("title = " + title);
        driver.close();

    }
}
