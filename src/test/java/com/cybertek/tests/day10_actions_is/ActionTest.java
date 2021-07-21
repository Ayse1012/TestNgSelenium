package com.cybertek.tests.day10_actions_is;

import com.cybertek.utilities.WebDriverFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionTest {
    //hover_mause hareketleri
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.quit();
    }
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));

        Actions action=new Actions(driver);

        action.moveToElement(img1).perform();
         //moveToElement=element e hareket et
        //perform():moveToElement i onayla
        WebElement text = driver.findElement(By.xpath("//a[text()='View profile']"));
        System.out.println("text.getText() = " + text.getText());

    }

    @Test
    public void test2() {

            driver.get("http://practice.cybertekschool.com/hovers");

            List<WebElement> img1 = driver.findElements(By.tagName("img"));
            Actions actions = new Actions(driver);

            for (int i = 1; i <=img1.size(); i++) {
                WebElement img = driver.findElement(By.xpath("(//img)["+i+"]"));//( //img[1,2,3=i] )
                actions.moveToElement(img).perform();
                WebElement text = driver.findElement(By.xpath("(//a[text()='View profile'])["+i+"]"));
                System.out.println(text.getText());
            }
    }

    @Test
    public void dragAndDrop() {
       // dragAndDrop= sürükle ve bırak-
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions action=new Actions(driver);

        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();

        WebElement kaynak = driver.findElement(By.cssSelector("#draggable"));
        WebElement hedef = driver.findElement(By.cssSelector("#droptarget"));

        action.dragAndDrop(kaynak,hedef).perform();
        String expectedText="You did great!";
        String actualText= hedef.getText();
        Assert.assertEquals(expectedText,actualText);

    }

    @Test
    public void dragAndDrop2() {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions action=new Actions(driver);

        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();

        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droptarget"));

        action.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();
        //    . elemente git(kaynak).tıkla ve kaldır.hedef elemente git  .2 sn bekle .ve bırak .uygula

        String expectedText="You did great!";
        String actualText= target.getText();
        Assert.assertEquals(expectedText,actualText);

    }
}
