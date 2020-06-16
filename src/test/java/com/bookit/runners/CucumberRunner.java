package com.bookit.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // where we create connection between junit and Cucumber
@CucumberOptions(
        glue = "com/bookit/step_definitions",  // step definitions path
        features = "src/test/resources/features",  // features path
        plugin = {
                "json:target/cucumber.json"
        },
     //   tags = "@DB_1",   // which test scenarios to be run
        dryRun = false ,  // We use it to ensure that every phase has some implementation, auto-genereated by cucumber.
        strict = false

)
public class CucumberRunner {
}
