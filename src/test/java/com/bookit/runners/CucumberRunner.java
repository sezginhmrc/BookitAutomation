package com.bookit.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/bookit/step_definitions",  // step definitions path
        features = "src/test/resources/features",  // features path
        plugin = {
                "json:target/cucumber.json"
        },
     //   tags = "@create_student_3", // which test scenarios to be run
        dryRun = false ,  // used to ensure that every phase has some implemenatation
        strict = false

)
public class CucumberRunner {
}
