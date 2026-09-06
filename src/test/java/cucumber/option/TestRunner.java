package cucumber.option;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", plugin="json:target/jsonReports/cucumber-report.json" ,glue ={"stepDefinations", "cucumber.option"})
//, tags= "@DeletePlace"
public class TestRunner {

}
//mvn test verify '-Dcucumber.filter.tags=@AddPlace'