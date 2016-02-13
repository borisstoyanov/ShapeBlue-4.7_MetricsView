package features.zones;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_objects.PO_ZoneMetricsPage;
import page_objects.PO_ZonesPage;
import util.CallAPI;

public class ZonesUI {
	String newValue;
	String oldValue;
	List<String> metrics;

	
	PO_ZoneMetricsPage zoneMetrics;
	PO_ZonesPage zonesPage;

	@Then("^they should be displayed$")
	public void they_should_be_displayed() {
		for (String metric : metrics) {
			System.out.println(metric);
			// Assert Metric is displayed
		}
	}

	@Then("^I should be displated with the ZoneMetricsPage$")
	public void I_should_be_displated_with_the_ZoneMetricsPage() {
		zoneMetrics = new PO_ZoneMetricsPage();
		zoneMetrics.isAt();

	}

	@Given("^I am on ZoneMetricsPage$")
	public void I_am_on_ZoneMetricsPage(){
		zonesPage = new PO_ZonesPage();
		zonesPage.Goto();
		zoneMetrics = zonesPage.clickZoneMetrics();

	}
	
	@When("^I click RefreshButton$")
	public void I_click_RefreshButton() {
		zoneMetrics.clickRefresh();

	}
	
	@Then("^the breadcrumb should display the right location of the page$")
	public void the_breadcrumb_should_display_the_right_location_of_the_page() {
		zoneMetrics.checkBreadcrumb();

	}

	@Given("^I get the value for a specific metric$")
	public void I_get_the_value_for_a_specific_metric() {
		oldValue = zoneMetrics.getSomeValue();
	}

	@When("^I execute a mocked method to change a metric$")
	public void I_execute_a_mocked_method_to_change_a_metric() {
		newValue = CallAPI.updateSomeMetric();

	}

	@Then("^I should be displated with the updated value of the metric$")
	public void I_should_be_displated_with_the_updated_value_of_the_metric() {
		zoneMetrics.valueIsDisplayed(newValue);
		zoneMetrics.valueNotDisplayed(oldValue);
	}

	@Given("^I have the following metrics:$")
	public void I_have_the_following_metrics(List<String> listOfMetrics) {
		metrics = listOfMetrics;
	}

	@Then("^I collapse and expand the metric$")
	public void I_collapse_and_expand_the_metric() {
		for (String metric : metrics) {
			zoneMetrics.collapseMetric(metric);
			zoneMetrics.verifyMetricCollapsed(metric);
			zoneMetrics.expandMetric(metric);
			zoneMetrics.verifyMetricExpanded(metric);
		}
	}

	@Then("^I sort ascending and descending$")
	public void I_sort_ascending_and_descending() {
		for (String metric : metrics) {
			zoneMetrics.sortAsc(metric);
			zoneMetrics.verifyMetricSortAsc(metric);
			zoneMetrics.sertDesc(metric);
			zoneMetrics.verifyMetricSortDesc(metric);
		}
	}
}
