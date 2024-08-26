package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature", glue= {"StepDefinition"},
				monochrome = true,
				
				//report
				plugin = {"pretty", "html:target/report/report.html"},
				
				//combining reports
				//plugin = {"pretty", "json:target/report/report.json","junit:target/report/report.xml"},
				
				//Pick and run TC using tags
				tags="@TC_01"

)
public class Runner {

}
