package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static void main(String[] args) {
        //webdriverFactory
        // static bir metotot yaz ve string parametre kabul etsi
        // kabul ettiği string parametre göre browzer setup etsin
        //return type bize webdriver olsun

    }
     public static WebDriver getDriver(String browser){
       WebDriver driver = null;
       //Chrome,cHrome

       switch (browser.toLowerCase()){
           case "chrome":
               WebDriverManager.chromedriver().setup();
               driver =new ChromeDriver();
               break;
           case "firefox":
               WebDriverManager.firefoxdriver().setup();
               driver=new FirefoxDriver();
               break;
           case "explorer":
               WebDriverManager.edgedriver().setup();
               driver=new EdgeDriver();
               break;
       }
        return driver;
    }
}
