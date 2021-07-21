package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /*Verify Url not Changed
        -url in değişmediğini bana doğrula
        -open chrome browser
        -go to  http://practice.cybertekschool.com/forgot_password
       click on retrieve password
       //paaword tıklamadan onceki url ile tıkladıktan sonraki url in aynı sayfa olup olmadığını kontrol et
       -verify that url did not changed
         */


        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //expected = beklenen        //actual = olan

        //belenen url li kaydet password butonuna tiklamadan (save expectedURL before click on password)
        String expectedUrl = driver.getCurrentUrl();

        //click // retrive password butonuna tikla
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        retrievePassword.click();

        //olan URL tekrar al ve kaydet (save actual URL)
        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("Url'ler ayni(PASS)");
        }else{
            System.out.println("Url degismis(FAIL)");
        }


        //url al
        //password a tikla
        //tekrar url al




    }


}
