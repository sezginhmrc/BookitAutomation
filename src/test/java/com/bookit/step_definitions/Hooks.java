package com.bookit.step_definitions;

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
    @After("@db")
    public void dbTearDown(){
        DBUtility.destroy();
        // to close connections with database
    }

    /**
     * This hook will be executed only for scenarios that are annotated with @ui tag
     */

    @Before("@ui")
    public void uiSetUp(){
        Driver.getDriver().manage().window().maximize();
    }

    /**
     * This hook will be executed only for scenarios that are annotated with @ui tag
     */
    @After("@ui")
    public void uiTearDown(){
        Driver.closeDriver();
    }

}