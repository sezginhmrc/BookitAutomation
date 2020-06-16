package com.bookit.step_definitions;

import com.bookit.utilities.DBUtility;
import com.bookit.utilities.Environment;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectStep_Definitions {


    @When("i run the select query to retrieve data from db")
    public void iRunTheSelectQueryToRetrieveDataFromDb() {
        DBUtility.createDBConnection(Environment.DB_HOST, Environment.DB_USERNAME, Environment.DB_PASSWORD);
    }



    @Then("i should able to see see the")
    public void iShouldAbleToSeeSeeThe() {

    }


}
