package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\Vijesh V R\\eclipse-workspace\\BDD\\src\\main\\resources\\features\\apitest.feature",
    glue = {"stepDefinitions"},
//    tags = "@tag",
    dryRun = false,
    plugin = {"pretty", "html:target/cucumber-reports"}
)


public class MyTestRunner {

}
