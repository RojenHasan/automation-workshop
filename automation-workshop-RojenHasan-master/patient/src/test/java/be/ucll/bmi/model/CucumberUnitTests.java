package be.ucll.bmi.model;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.SpringFactory;
import org.junit.runner.RunWith;

// configures the scenarios to be executed using the JUnit implementation
//from the io.cucumber library.
@RunWith(Cucumber.class)
@CucumberOptions(
        //specifies the location of our features.
        features={"src/test/resources/features"},
        //specifies the glue path
        glue={"be/ucll/bmi/model", "be/ucll/bmi/config"},
        tags="@Unit",
        plugin={"json:target/unit-test.json"},
        objectFactory=SpringFactory.class
)
public class CucumberUnitTests {
}
