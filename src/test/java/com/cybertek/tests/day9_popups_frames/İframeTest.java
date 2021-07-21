package com.cybertek.tests.day9_popups_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class İframeTest {
    //frame=çerçeve

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        Thread.sleep(2000);
        driver= WebDriverFactory.getDriver("chrome");
        //driver.quit();
    }



    @Test
    public void test1() {
        driver.get("https://www.demoqa.com/");
        driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[3]")).click();
        WebElement frames = driver.findElement(By.xpath("//span[text()='Frames']"));

         //sayfayı aşağı kaydırmak için java script kullanırız
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",frames);

        //not:iframe ve farklı html bir  arada bulunur

        WebElement frame1 =driver.findElement(By.id("frame1"));

        //1. yol id veya name ile
        driver.switchTo().frame("frame1");
        System.out.println("driver.findElement.getText() = " + driver.findElement(By.id("sampleHeading")).getText());

        //içinde bulunduğu html yapısından çıkıp bi ütteki perent classa geçer
        //driver.switchTo().parentFrame();

//        //2.yol
//        driver.switchTo().frame("frame1");//frame gitmek için locetor ederiz ve elementin ismini gireriz
//        System.out.println("driver.findElement.getText() = " + driver.findElement(By.id("sampleHeading")).getText());
//        //içinde bulunduğu html(iframe) den çıkıp en baştaki yapıya geçer
//        driver.switchTo().defaultContent();//en üste çıkar
//
//          //sayfadaki ikinci html aralığındaki text
//        WebDriver frame2 = driver.switchTo().frame("frame2");
//        System.out.println("driver.findElement.getText() = " + driver.findElement(By.id("sampleHeading")).getText());



    }


    @Test
    public void test2() {

//        HTML
//        FRAME-TOP   --> apartman
//                -left   ->daire
//                -middle ->daire
//                -rigth  ->daire
//        FRAME-BUTTON __->yan bina
//        HTLM
//
        driver.get("http://practice.cybertekschool.com/nested_frames");

       // driver.findElement(By.id("content")).getText();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println("driver.findElement.getText() = " + driver.findElement(By.id("content")).getText());
           //right frame  içindeki texti al
        //ilk olarak perent e gitmek zorundayız
        driver.switchTo().parentFrame();
          //right frame e gideriz
        driver.switchTo().frame("frame-right");
        //text i locator ederiz
        System.out.println("driver.findElement(By.tagName = " + driver.findElement(By.tagName("body")).getText());
         //öden2: button frame text al
        //ilk olarak en üstte gitmeliyiz--HTML top
        driver.switchTo().defaultContent();
           //button frame e gideriz
        driver.switchTo().frame("frame-bottom");
        System.out.println("driver.findElement(By.tagName.getText() = " + driver.findElement(By.tagName("body")).getText());

    }
}
