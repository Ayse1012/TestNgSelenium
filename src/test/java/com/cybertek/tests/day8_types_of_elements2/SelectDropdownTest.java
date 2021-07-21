package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("hello Ayse");
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        System.out.println("by Ayse");
        Thread.sleep(2000);
       // driver.quit();

    }
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        // 1-Select classını kullanmak için selec tag name olan elementi locate ediyoruz
       WebElement dropdownElement= driver.findElement(By.cssSelector("#state"));

       // 2_Select classini oluşturuyoruz.
        Select stateDropdown=new Select(dropdownElement);
        List<WebElement> options= stateDropdown.getOptions();//getoptions(): dropdown daki listeyi list'e çeviriyor
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            
            System.out.println("option.getText() = " + option.getText());
            
        }
        
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement= driver.findElement(By.id("state"));

        Select states =new Select(dropdownElement);

        //birinci seçenek ""select a State" olacak buru doğrula
        //getFirstSelectedOption()= seçili olan ilk elementi verir
        String expectedOption="Select a State";

        String actualOption= states.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"verify title");

        //1-visible text ile seçme

        Thread.sleep(2000);
        states.selectByVisibleText("Hawaii");//dropdown list de hawaii yi seçme

        expectedOption="Hawaii";
       actualOption=states.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify title");

        //2-Index ile seçme
        Thread.sleep(2000);
        states.selectByIndex(48);
        expectedOption="Washington";
        actualOption=states.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify title");

        //3-By value= değere göre yazdırma
        Thread.sleep(2000);
        states.selectByValue("TX");
        expectedOption="Texas";
        actualOption=states.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify title");

    }
}
