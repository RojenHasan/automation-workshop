package be.ucll.bmi.ui;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.SpringFactory;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features={"../patient/src/test/resources/features"},
        glue={"be/ucll/bmi/ui", "be/ucll/bmi/config"},
        //every class or scenario has @UI run it
        tags="@UI",
        plugin={"json:target/ui-test.json"},
        objectFactory=SpringFactory.class
)
public class CucumberUITests { }
