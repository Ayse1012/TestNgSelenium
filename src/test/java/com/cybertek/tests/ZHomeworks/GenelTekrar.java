package com.cybertek.tests.ZHomeworks;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GenelTekrar {
    // 1.ödev
//    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
//    Step 2. Click on “Registration Form”
//    Step 3. Enter “wrong_dob” into date of birth input box.
//     Step 4. Verify that warning message is displayed:
//     “The date of birth is not valid”
        WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() {
    }
    @Test
    public void test1() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();
        WebElement inputBirdth = driver.findElement(By.xpath("//input[@name='birthday']"));
        inputBirdth.sendKeys("wrong_dob");
       WebElement messageText= driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));
       String expectedText= "The date of birth is not valid";
      String actualMessageText=messageText.getText();

        Assert.assertEquals(expectedText,actualMessageText,"verify message");
    }
//    Test case #2
//    Step 1. Go to “"https://practice-cybertekschool.herokuapp.com"”
//    Step 2. Click on “Registration Form”
//    Step 3. Verify that following options for
//    programming languages are displayed: c++, java,
//    JavaScript

    @Test
    public void test2() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();

        List<WebElement> checkbox = driver.findElements(By.cssSelector(".form-check.form-check-inline"));//list oluştururken bütün elemanlarda ortak olan ile lokeyt edilir
        System.out.println("checkbox.size() = " + checkbox.size());
        for (WebElement webElement : checkbox) {
            Assert.assertTrue(webElement.isDisplayed(),"verify is display");
            System.out.println("webElement.isDisplayed() = " + webElement.isDisplayed());
        }
    }
//Test case #3
//Step 1. Go to “https://practice-cybertekschool.herokuapp.com
//Step 2. Click on “Registration Form”
//Step 3. Enter only one alphabetic character into firstname input box.
//Step 4. Verify that warning message is displayed:
//“first name must be more than 2 and less than 64
//characters long”
    @Test
    public void test3() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();
        WebElement inputFirstName=driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        inputFirstName.sendKeys("a");
        WebElement messageText=driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        String actualMessageText=messageText.getText();
        String expectedText="first name must be more than 2 and less than 64 characters long";

        Assert.assertTrue(actualMessageText.contains(expectedText));

    }
//    Test case #4
//    Step 1. Go to https://practice-cybertekschool.herokuapp.com
//    Step 2. Click on “Registration Form”
//    Step 3. Enter only one alphabetic character into lastname input box.
//    Step 4. Verify that warning message is displayed:
//        “The last name must be more than 2 and less than 64 characters long”

    @Test
    public void test4() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();
        WebElement inputLastName=driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
           inputLastName.sendKeys("b");
          WebElement lastNameText= driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
          String actualLastName=lastNameText.getText();
          String expectedLastName="The last name must be more than 2 and less than 64 characters long";
          Assert.assertTrue(actualLastName.contains(expectedLastName));
    }
//    Test case #5
//    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
//    Step 2. Click on “Registration Form”
//    Step 3. Enter any valid first name.
//    Step 4. Enter any valid last name.
//    Step 5. Enter any valid user name.
//    Step 6. Enter any valid password.
//    Step 7. Enter any valid phone number.
//    Step 8. Select gender.
//    Step 9. Enter any valid date of birth.
//    Step 10. Select any department.
//    Step 11. Enter any job title.
//    Step 12. Select java as a programming language.
//    Step 13. Click Sign up.
//    Step 14. Verify that following success message is
//    displayed: “You've successfully completed registration!”
    @Test
    public void test5() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Registration Form']")).click();
        Faker fk=new Faker();
        //List<WebElement> inputs = driver.findElements(By.xpath("//input[@class='form-control']"));

        WebElement inputFirstName=driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        inputFirstName.sendKeys(fk.name().firstName());
        WebElement inputLastName=driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
        inputLastName.sendKeys(fk.name().lastName());
        WebElement inputUserName=driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
        inputUserName.sendKeys("EvangelinaNolan");
        WebElement inputEmailName=driver.findElement(By.xpath("(//input[@class='form-control'])[4]"));
        inputEmailName.sendKeys(fk.internet().emailAddress());
        WebElement inputPasswordName=driver.findElement(By.xpath("(//input[@class='form-control'])[5]"));
        inputPasswordName.sendKeys(fk.internet().password());
        WebElement inputPhoneName=driver.findElement(By.xpath("(//input[@class='form-control'])[6]"));
        inputPhoneName.sendKeys("123-457-2895");
        driver.findElement(By.xpath("//input[@name='gender'][1]")).click();
        WebElement inputBirth = driver.findElement(By.xpath("//input[@name='birthday']"));
        inputBirth.sendKeys("02/16/1984");

        WebElement selectDepartment=driver.findElement(By.xpath("(//select[@class='form-control selectpicker'])[1]"));
        Select department =new Select(selectDepartment);
        department.selectByIndex(3);
        List<WebElement> departmentOptions = department.getOptions();
        for (WebElement departmentOption : departmentOptions) {
            System.out.println("departmentOption.getText() = " + departmentOption.getText());
        }
        WebElement job_title =driver.findElement(By.xpath("(//select[@class='form-control selectpicker'])[2]"));
        Select jobTitle =new Select(job_title);
        jobTitle.selectByVisibleText("Designer");
        List<WebElement> jobTitleOptions = jobTitle.getOptions();
        for (WebElement jobTitleOption : jobTitleOptions) {
            System.out.println("jobTitleOption.getText() = " + jobTitleOption.getText());
        }
        List<WebElement> checkbox = driver.findElements(By.cssSelector(".form-check.form-check-inline"));
        for (WebElement webElement : checkbox) {
            webElement.click();

        }

        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        WebElement message = driver.findElement(By.cssSelector(".alert.alert-success>p"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println("message.getText() = " + message.getText());
        String actualMessage=message.getText();
        String expectedMessage="You've successfully completed registration!";
        Assert.assertEquals(expectedMessage,actualMessage,"verify message");

    }
//    Test case #6
//    Step 1. Go to "https://www.tempmailaddress.com/"
//    Step 2. Copy and save email as a string.
//    Step 3. Then go to “"https://practice-cybertekschool.herokuapp.com"”
//    Step 4. And click on “Sign Up For Mailing List".
//    Step 5. Enter any valid name.
//    Step 6. Enter email from the Step 2.
//    Step 7. Click Sign Up

    @Test
    public void test6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com");
        WebElement element = driver.findElement(By.cssSelector("#email"));
        String email =element.getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();

        WebElement full_name = driver.findElement(By.name("full_name"));
         full_name.sendKeys("Ayse Öztürk");
        WebElement email1 = driver.findElement(By.name("email"));
        email1.sendKeys(email);
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();


    }
}
