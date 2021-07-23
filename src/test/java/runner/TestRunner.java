package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "stepDefinitions" }, monochrome = true, plugin = {
		"pretty", "html:target/HTMLReports/reports.html", "json:target/JSONReports/report.json",
		"junit:target/JunitReports/reports.xml" }, tags = "@SmokeTest", dryRun = false)
// plugin = {"pretty", "html:target/HTMLReports/reports.html"}, plugin = {"pretty", "json:target/JSONReports/report.json"},  plugin = {"pretty", "junit:target/JunitReports/reports.xml"}
public class TestRunner {

}