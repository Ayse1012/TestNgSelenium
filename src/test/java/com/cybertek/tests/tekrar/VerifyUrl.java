package com.cybertek.tests.tekrar;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrl {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com.tr");
        WebElement cerez=driver.findElement(By.id("sp-cc-accept"));
        cerez.click();
        Thread.sleep(2000);
        WebElement moda =driver.findElement(By.id("nav_cs_3"));
        moda.click();
        Thread.sleep(2000);

        WebElement kadın =driver.findElement(By.className("nav-a-content"));
        kadın.click();

        WebElement abc=driver.findElement(By.partialLinkText("Print at home"));
        abc.click();
        Thread.sleep(4000);
        driver.navigate().refresh();
        driver.navigate().back();








    }
}
