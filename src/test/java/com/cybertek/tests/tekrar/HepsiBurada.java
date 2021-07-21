package com.cybertek.tests.tekrar;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HepsiBurada {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com/");

        WebElement aramaInbox=driver.findElement(By.className("desktopOldAutosuggestTheme-input"));


//        aramaInbox.sendKeys("koltuk takımı");
//        Thread.sleep(2000);
//        System.out.println("aramaInbox.getText() = " + aramaInbox.getText());
//        WebElement clearbutton= driver.findElement(By.xpath("//i[@class='Icon-close SearchBoxOld-closeIcon']"));
//        clearbutton.click();
//        Thread.sleep(2000);
//        aramaInbox.sendKeys("koltuk takımı");
        WebElement searchBtn=driver.findElement(By.className("SearchBoxOld-buttonContainer"));
//        searchBtn.click();
//        Thread.sleep(2000);
//        WebElement caddeYıldızKltkTakımı=driver.findElement(By.xpath("//span[text()='Cadde Yıldız Belita Silver Salon Takımı']"));
//        caddeYıldızKltkTakımı.click();
//
//        WebElement sepet=driver.findElement(By.xpath("//button[@*='addToCart']"));
//        sepet.click();
//
//        driver.navigate().back();
//
//        Thread.sleep(2000);

        aramaInbox.sendKeys("dermo kozmetik");
        searchBtn.click();


         WebElement bioderma=driver.findElement(By.xpath("(//div[@data-test-id='carousel-grid-item'])[14]")); //bulamadı
         bioderma.click();
         WebElement biodermaSepet=driver.findElement(By.className("button big with-icon"));
         biodermaSepet.click();

         WebElement alışverişeDevamet=driver.findElement(By.xpath("//button[text()='Alışverişe devam et']"));
         alışverişeDevamet.click();







    }
}
