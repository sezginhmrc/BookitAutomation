package com.bookit.pages;

import com.bookit.utilities.BrowserUtilities;
import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {


    @FindBy(linkText = "my")
    protected WebElement my ;

    @FindBy(linkText = "self")
    protected WebElement self ;
    @FindBy(css = ".navbar-brand > div")
    protected WebElement navBarToggle;


    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
    protected Actions actions = new Actions(Driver.getDriver());

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void goToSelfPage(){
        // set the navbartoggle for android it is little bit diff.
        BrowserUtilities.waitForPageToLoad(15);
        String browser = ConfigurationReader.getProperty("browser").toLowerCase();
        if (!browser.contains("ios") && !browser.contains("android")){
            Driver.getDriver().manage().window().maximize();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("my")));
            wait.until(ExpectedConditions.elementToBeClickable(my)).click();
            BrowserUtilities.wait(5);
            self.click();
            //   actions.moveToElement(my).pause(2000).click(self).build().perform();

        }  else
            navBarToggle.click();
            self.click();
    }
}
