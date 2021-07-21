package com.cybertek.tests.day7_TestNg;

import org.testng.annotations.*;

public class BeforeAfterClassName {

    @Test
    public void test1(){
        System.out.println("first test case");

    }
    @BeforeMethod //her bir metotdan önce çalıştır
    public void setup(){
        System.out.println("WebDriver, opening Browser");
    }
    @Ignore//bu test case i çalıştırmak istemiyorsak bu şekilde kapatıyoruz
    @Test // ( // ile de kapatılabilir )
    public void test2() {
        System.out.println("test case 2");
    }

    @Test
    public void test3() {
        System.out.println("test case 3");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("close driver");
    }
    @BeforeClass// 1 defa classdan önce çalışır
    public void setupClass(){
        System.out.println("------------Before Class");
        System.out.println(" classtan önce bir defa çalışır");
    }
    @AfterClass// bir defa class dan sonra çalışır
    public void tearDownClass(){
        System.out.println("---After Class---");
        System.out.println("1 defa çalışır ,ileride buraya rapor ekleyeceğiz");
    }



}
