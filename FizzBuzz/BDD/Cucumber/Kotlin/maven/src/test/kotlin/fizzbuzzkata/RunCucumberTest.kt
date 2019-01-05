package fizzbuzzkata

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(plugin = arrayOf("pretty"))
class RunCucumberTest {}
