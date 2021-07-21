package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

       List<WebElement> buttons= driver.findElements(By.tagName("button"));
        System.out.println("buttons.size() = " + buttons.size());//size 6

        int expectedSize=6;
        Assert.assertEquals(buttons.size(),expectedSize,"verify size is 6");
        buttons.get(1).click();

        for (WebElement button : buttons) {
            System.out.println("button.getText() = " + button.getText());

        }
        for (int i = 0; i <buttons.size(); i++) {
           buttons.get(i).click();
            Thread.sleep(2000);
        }

    }
   //list element örnek
    @Test
    public void amazon() throws InterruptedException {

        driver.get("https://www.amazon.co.uk");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#sp-cc-accept")).click();
        driver.findElement(By.xpath("(//a[text()='Best Sellers'])[1]")).click();

        List<WebElement> department = driver.findElements(By.tagName("li"));
        System.out.println("department.size() = " + department.size());
        for (WebElement element : department) {
            System.out.println("element.getText() = " + element.getText());
        }
        department.get(92).click();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons= driver.findElements(By.tagName("button"));

        WebElement buttontext=driver.findElement(By.cssSelector("#result"));//buttonlara tıklandığında altta yazan text, hepsinde sabit olan id
       // System.out.println("button1text.getText() = " + button1text.getText());

        for (int i = 0; i <buttons.size(); i++) {
            buttons.get(i).click();
            Thread.sleep(2000);
            System.out.println("buttontext.getText() = " + buttontext.getText());

        }

    }
   //önemli Not:
    @Test
    public void test3() {
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons= driver.findElements(By.tagName("buttonkgdfhlhghş"));
        System.out.println("buttons.size() = " + buttons.size());
        //Lİst element ile çalışırken mutlaka size' dan test etmek gerekir
        // çünkü locator hatalı olsa dahi test geçer size 0 dönecektir
        //size da bir beklentimiz varsa ; size yazdırıp teyit edip öyle bakmak lazım
    }
//list çalışma:
    @Test
    public void test4() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        List<WebElement> elements = driver.findElements(By.className("dropdown-item"));
        System.out.println("elements.size() = " + elements.size());//5

        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());//text vermedi
        }

        List<WebElement> h6 = driver.findElements(By.tagName("h6"));
        System.out.println("h6.size() = " + h6.size());
        for (WebElement webElement : h6) {
            System.out.println("webElement.getText() = " + webElement.getText());

        }


    }
}
