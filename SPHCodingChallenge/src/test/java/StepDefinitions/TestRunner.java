package StepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin   = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber-report.json"},
		features = {"src/test/resources/Features/"},
		glue	 = {"StepDefinitions"},
		tags	 = {"@LaunchArticle"}
		)

public class TestRunner {

}
