package com.cybertek.tests.day7_types_ofelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElements {
    //enable=etkinleştirme
    WebDriver driver= WebDriverFactory.getDriver("chrome");

    @Test
    public void test1() {

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenBtn=driver.findElement(By.cssSelector("#green"));
        //green butonu etkinmi;
        System.out.println("greenButton.isEnabled() = " + greenBtn.isEnabled());

        //green buton etkin değil;
        Assert.assertFalse(greenBtn.isEnabled(),"verify green button is not enable");

        WebElement greenBtnText = driver.findElement(By.xpath("//label[text()='Green']"));
        String expectedText ="Green";
        String actualText = greenBtnText.getText();
         //text ler eşit;
        Assert.assertEquals(actualText,expectedText,"verify that texts are equals");

        greenBtnText.click();//burda hata almamız lazımdı fakat vermedi

        //driver.quit();

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://www.demoqa.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        driver.findElement(By.xpath("//span[text()='Radio Button']")).click();

        WebElement yesRadio = driver.findElement(By.xpath("//label[text()='Yes']"));
        yesRadio.click();
        String actualText = yesRadio.getText();
        Assert.assertTrue(actualText.contains("Yes"));


       // driver.quit();


    }
}
