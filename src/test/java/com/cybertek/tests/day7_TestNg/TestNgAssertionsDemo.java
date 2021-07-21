package com.cybertek.tests.day7_TestNg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgAssertionsDemo {
    @BeforeMethod
    public void setUp() {
        System.out.println("Open Browser");
    }

    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2() {
        Assert.assertEquals("title","title");
    }
    @Test
    public void test3() {

        String expectedTitle= "Amazon";
        String actualTitle = "Amazon.co.uk"; //    -->   //driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle),"expected title'in actual title icinde oldugunu teyit et"); //@

        Assert.assertTrue(actualTitle.startsWith(expectedTitle));
        //0>1
        Assert.assertEquals(actualTitle,expectedTitle,"verify that titles are equals");

        int expectedResult = 792;
        // int actualResult= driver.getText();

        String expectedWord= "apple";
        //  String actualWord = driver.getText() = apple contains
    }

    @Test
    public void test4() {
        //email check  @ isareti var mi teyit et
        String expectedEmail = "@";
        String actualEmail = "test@gmail.com";

        Assert.assertTrue(actualEmail.contains(expectedEmail));
        Assert.assertFalse(0>1,"0 1 den kucuk mu teyit et");

    }
    @AfterMethod
    public void tearDown() {
        System.out.println("driver.quit");
    }
}


