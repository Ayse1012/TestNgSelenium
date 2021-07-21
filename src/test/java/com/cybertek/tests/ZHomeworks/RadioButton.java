package com.cybertek.tests.ZHomeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButton {

    //isEnabled()

    //https://www.demoqa.com/ sayfasina git
    //elements e gel ve radio button'a tikla
    //Test1 --> radio buttonlarin UNSELECETED oldugunu verify et
    //Test2 --> Yes button' a tikla , cikan text i al ve textin icinde 'Yes' oldugunu verify et
    //Test3 --> Impressive e tikla , cikan text i al ve textin icinde 'Impressive' oldugunu teyit et
    //Test4 --> No button'in disable oldugunu dogrula (isEnable)

    WebDriver driver= WebDriverFactory.getDriver("chrome");
    @Test
    public void test1() {
        driver.get("https://www.demoqa.com/");
        WebElement elements=driver.findElement(By.xpath("//h5[text()='Elements']"));
        elements.click();

        WebElement radioButton=driver.findElement(By.xpath("//span[text()='Radio Button']"));
        radioButton.click();
        WebElement yesButton=driver.findElement(By.cssSelector("#yesRadio"));
        WebElement impressRadio =driver.findElement(By.cssSelector("#impressiveRadio"));
        WebElement noRadio =driver.findElement(By.cssSelector("#noRadio"));


        Assert.assertFalse(yesButton.isSelected());
        Assert.assertFalse(impressRadio.isSelected());
        Assert.assertFalse(noRadio.isSelected());
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.demoqa.com/");
        WebElement elements=driver.findElement(By.xpath("//h5[text()='Elements']"));
        elements.click();
        WebElement radioButton=driver.findElement(By.xpath("//span[text()='Radio Button']"));
        radioButton.click();
        Thread.sleep(2000);
        WebElement yesButton=driver.findElement(By.xpath("//label[text()='Yes']"));//element clıck intercepted(clık yapması engellendi),bir sonraki elementten locator etmek lazın(yes ten)
        yesButton.click();

        String actualYesText=yesButton.getText();
        System.out.println("yesBtnText.getText() = " + yesButton.getText());
        Assert.assertTrue(actualYesText.contains("Yes"));

    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://www.demoqa.com/");
        WebElement elements=driver.findElement(By.xpath("//h5[text()='Elements']"));
        elements.click();
        WebElement radioButton=driver.findElement(By.xpath("//span[text()='Radio Button']"));
        radioButton.click();
        Thread.sleep(2000);

        WebElement impressRadio =driver.findElement(By.xpath("//label[text()='Impressive']"));
        impressRadio.click();
        WebElement impressRadioText=driver.findElement(By.cssSelector(".mt-3"));
       String actualimpressRadio= impressRadioText.getText();
        Assert.assertTrue(actualimpressRadio.contains("Impressive"));

    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("https://www.demoqa.com/");
        WebElement elements=driver.findElement(By.xpath("//h5[text()='Elements']"));
        elements.click();
        WebElement radioButton=driver.findElement(By.xpath("//span[text()='Radio Button']"));
        radioButton.click();
        Thread.sleep(2000);

        WebElement noRadio=driver.findElement(By.xpath("//label[text()='No']"));
        Assert.assertTrue(noRadio.isEnabled(),"noRadio ");
    }
}
