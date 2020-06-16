package com.bookit.units;

import com.bookit.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AppleTests {


    public static void main(String[] args) {

        /*
        * TC #03: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to all of the headers one by one
a. Mac, iPad, iPhone, Watch, TV, Music, Support
4. Print out how many links on each page with the titles of the pages
5. Loop through all
6 Print out how many link is missing text TOTAL
7. Print out how many link has text TOTAL
8. Print out how many total link TOTAL*/



       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.apple.com");









    }

}
