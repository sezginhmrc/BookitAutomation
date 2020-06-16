package com.bookit.step_definitions;

import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.DBUtility;
import com.bookit.utilities.Driver;
import com.bookit.utilities.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    /**
     * This hook will be executed only for scenarios that are annotated with @db tag
     */
    @Before("@db")
    public void dbSetup(){
        DBUtility.createDBConnection(Environment.DB_HOST, Environment.DB_USERNAME, Environment.DB_PASSWORD);
    } // to connect with dabase based on url and credentials.4n

    /**
     * This hook will be executed only for scenarios that are annotated with @db tag
     */
    @After("@db") // this tag includes test from related scenarios
                 // we labelling our scenarios to connection jdbc and destry connection after executed tests
    public void dbTearDown(){
        DBUtility.destroy();
        // to close connections with database
    }

    /**
     * This hook will be executed only for scenarios that are annotated with @ui tag
     */

    @Before("@ui")
    public void uiSetUp(){
        String browser = ConfigurationReader.getProperty("browser").toLowerCase();
        if (!browser.contains("ios") && !browser.contains("android")){
            Driver.getDriver().manage().window().maximize();
        }
     //   Driver.getDriver().manage().window().maximize(); // this doesnt work for IOS mobiles. we need to configure it.
    }
    @After
    public void tearDownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
    /**
     * This hook will be executed only for scenarios that are annotated with @ui tag
     */
    @After("@ui")
    public void uiTearDown(){
        Driver.closeDriver();
    }

}
