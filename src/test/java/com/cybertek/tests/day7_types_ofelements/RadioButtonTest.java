package com.cybertek.tests.day7_types_ofelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    //radio button=


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locator radio Buttons

        WebElement blueButton=driver.findElement(By.cssSelector("#blue"));
        WebElement redButton=driver.findElement(By.cssSelector("#red"));

        System.out.println("blueButton.isSelected() = " + blueButton.isSelected());
        System.out.println("redButton.isSelected() = " + redButton.isSelected());

//        Assert.assertTrue(blueButton.isSelected(),"mavi butonun seçili olduğunu teyit et");
//        Assert.assertFalse(redButton.isSelected(),"kırmizi butonun seçili OLMADIĞINI teyit et");

        Assert.assertTrue(blueButton.isSelected(),"verify that blue button is selected");
        Assert.assertFalse(redButton.isSelected(),"verify that red button is UNSELECTED");

        redButton.click();

        Assert.assertTrue(redButton.isSelected(),"red butonun tıklı olduğunu teyit et");
        Assert.assertFalse(blueButton.isSelected(),"blue butonun tıklı olmadığını teyit et");
        Thread.sleep(2000);
        driver.quit();

    }
}
