package com.cybertek.tests.ZHomeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForLoop_click {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //xpath ile kardeş class ları for içinde dönebiliriz
        for (int i = 1; i <=6; i++) {

            WebElement btn=driver.findElement(By.xpath("//button["+i+"]"));
            btn.click();
            Thread.sleep(2000);
            

        }





    }
}
