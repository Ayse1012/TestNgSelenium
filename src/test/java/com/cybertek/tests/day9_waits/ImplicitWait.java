package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//her locator dan once çalışacak
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);//wait_ beklemek(kodu durdurur başka işlem yapmaz)
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        //iki tür wait var:

        //1-iplicitlywait= sadece elementleri bulmaya çalışırken bekler
        //selenyum her kodu çalıştırır iken eğer elementi bulamazsan bekle ve bulduğun an beklemeyi bırak
       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //bu wait i beforemetot a yazıyoruz ve böylece bütün testlerde çalışıyor
        //burada en az 5 sn de bulacaktır ve 15 sn beklemeyecektir
        WebElement element = driver.findElement(By.cssSelector("#finish"));
        System.out.println("element.getText() = " + element.getText());

        //2-ExplicitWait


    }
}
