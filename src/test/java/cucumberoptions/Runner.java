package cucumberoptions;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepDefinitions", "AppHooks"},
		monochrome = true,
		plugin = {"pretty","json:target/jsonReports/cucumber-report.json",
 				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt",
				"html:target/HtmlReports/report.html","junit:target/JUnitReports/report.xml"
				 },

		tags = ""

			)
public class Runner {

	
}