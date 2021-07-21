package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssLocator {
    public static void main(String[] args) throws InterruptedException {
        //Css=element bulmada kullanılır
        //locating element with ıd= css ıd=#(ıd,value)
        //css de index çalışmaz

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.cssSelector("#disappearing_button")).click();

        //2. yol button#disappearing_button (tagname#value)

        //Locating Element with className
        //. --> class name i temsil eder
        //.(classnameValue) ile locate edebiliriz.
        // .btn.btn-primary (class name bosluk ile calismaz iken css ile bosluk olan yere
        // nokta koyarak locate ederiz.

        driver.findElement(By.className("btn btn-primary")).click(); // calismaz
        driver.findElement(By.cssSelector(".btn.btn-primary")).click(); // bu sekilde calisir.

        //2. yol tagName.value
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();// calisir

        //Locating Element with Attribute&Value
        //xpath //button[@onclick='button4()']     Css  -->button[onclick='button4()']
        driver.findElement(By.cssSelector("button[onclick='button4()']")); //CSS
        driver.findElement(By.xpath("//button[@onclick='button4()'")); //xpath

        //2.yol
        driver.findElement(By.cssSelector("[onclick='button5()']")); //tagname olmadan da formul calisir.

        //Locating with Starts With
        //xpath //h3[starts-with(@class,'h3')]   --> h3[class^='h3']
        // ^ bu isaret css de starts with yerine gecer
        // ^ --> MacBook da shift 6
        // ^ --> windows da shift 3
        driver.findElement(By.cssSelector("h3[class^='h3']"));

        //Locating with ends With
        //xpath //h3[ends-with(@class,'h3')]   --> h3[class^='h3']
        // $ bu isaret css de ends with yerine gecer
        //ends with css ile chrome da çalışır(xpach ile chromda çalışmaz)
        WebElement btn5=driver.findElement(By.cssSelector("button[onclick$='5()']"));

        //    button[onclick*='5'] ---> contains işareti *
        driver.findElement(By.cssSelector(" button[onclick*='5']"));

    }
}
