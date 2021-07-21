package com.cybertek.tests.day7_types_ofelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    //Bazen gettext ile alamadığımız text i getAttribute ile alabiliriz
    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement redButton=driver.findElement(By.cssSelector("#red"));
        redButton.click()
        ;
          //red butonun işaretli olduğunu doğrulama(işaretli işe true dur raporda göstermez.değil ise falsdur gösterir)
        Assert.assertTrue(redButton.isSelected(),"verify is selected ");

        System.out.println("redButton.getAttribute() = " + redButton.getAttribute("type"));//red butonda Attribut ü typr olan locetor in velue süini yazdırır
        System.out.println("redButton.getAttribute() = " + redButton.getAttribute("id"));
        System.out.println("redButton.getAttribute() = " + redButton.getAttribute("name"));



    }
}
