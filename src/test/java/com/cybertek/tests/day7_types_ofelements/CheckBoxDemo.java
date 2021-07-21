package com.cybertek.tests.day7_types_ofelements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {
    WebDriver driver= WebDriverFactory.getDriver("chrome");

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.cssSelector("input[name='checkbox1']"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("input[name='checkbox2']"));

        WebElement check1 = driver.findElement(By.xpath("//span[text()='Checkbox 1']"));
        WebElement check2 = driver.findElement(By.xpath("//span[text()='Checkbox 2']"));

        //checkbox(1-2) işaretlimi
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());//false
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());//true

        checkbox1.click();
        checkbox2.click();

        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());//true
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());//false

        System.out.println("check1.getText() = " + check1.getText());//Checkbox 1
        System.out.println("check1.getAttribute = " + check1.getAttribute("name"));//attribute yazdığımızda value yazar
        System.out.println("check2.getText() = " + check2.getText());//Checkbox 2

        Assert.assertTrue(checkbox1.isSelected(),"verify checkbox1 is selected");
        Assert.assertFalse(checkbox2.isSelected(),"verify checkbox2 is selected ");





    }
}
