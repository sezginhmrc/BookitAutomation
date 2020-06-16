package com.bookit.units;

import com.bookit.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestSingletonDriver {

    @Test
    public void testSingleton(){

        WebDriver driver = Driver.getDriver();
        WebDriver driver1 = Driver.getDriver();

        System.out.println(driver==driver1);
    }
}
