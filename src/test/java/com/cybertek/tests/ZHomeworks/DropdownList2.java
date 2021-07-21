package com.cybertek.tests.ZHomeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownList2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com");
        List<WebElement> gifCards = driver.findElements(By.cssSelector("#nav-xshop>a"));
        System.out.println("gifCards.size() = " + gifCards.size());
        Thread.sleep(2000);
        gifCards.get(2).click();
        Thread.sleep(2000);
      driver.findElement(By.xpath("(//a[@class='nav-a'])[2]")).click();
      driver.findElement(By.xpath("//a[text()='Any Department']")).click();

        List<WebElement> zg_browseRoot = driver.findElements(By.id("zg_browseRoot"));
        System.out.println("zg_browseRoot.size() = " + zg_browseRoot.size());

        for (WebElement webElement : zg_browseRoot) {
            System.out.println("webElement.getText() = " + webElement.getText());

        }

        WebElement anyDepartment=driver.findElement(By.xpath("//span[@class='zg_selected']"));







    }
}
