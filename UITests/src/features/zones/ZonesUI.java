package features.zones;

import java.util.Iterator;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ZonesUI {
	List<String> metrics;

	@Given("^the follwing metrics:$")
	public void the_follwing_metrics(List<String> listOfMetrics){
		metrics = listOfMetrics;
	}

	@Then("^they should be displayed$")
	public void they_should_be_displayed(){
		Iterator<String> itr = metrics.iterator();
		while(itr.hasNext()) {
		    // Assert the metric is displayed
		}
	}
}
