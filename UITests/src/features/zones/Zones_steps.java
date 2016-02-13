package features.zones;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_objects.PO_ClusterView;
import page_objects.PO_ZoneMetricsPage;
import page_objects.PO_ZonesPage;
import util.CallAPI;

public class Zones_steps {
	PO_ZonesPage zonesPage = null;
	PO_ZoneMetricsPage zoneMetrics = null;
	PO_ClusterView clusterView = null;

	double average;
	double newusage;
	double newCPU;
	double newallocation;

	@Given("^I am on the ZonesPage$")
	public void I_am_on_the_ZonesPage() {
		zonesPage = new PO_ZonesPage();
		zonesPage.Goto();
	}

	@When("^I click on MetricsButton$")
	public void I_click_on_MetricsButton() {
		zoneMetrics = zonesPage.clickZoneMetrics();
	}

	@Then("^I should be displayed with the ZoneMetricsPage$")
	public void I_should_be_displayed_with_the_ZoneMetricsPage() {
		zoneMetrics.isAt();

	}

	@When("^I click on the Name of a Zone$")
	public void I_click_on_the_Name_of_a_Zone() {
		clusterView = zoneMetrics.clickSpecificZone();
	}

	@Then("^I am navigated to ClustersView of that specific zone$")
	public void I_am_navigated_to_ClustersView_of_that_specific_zone() {
		clusterView.isAt();
	}

	@When("^I call the API to enable a zone$")
	public void I_call_the_API_to_enable_a_zone() {
		CallAPI.enableSpecificZone();
	}

	@Then("^the zone should be displayed as enabled$")
	public void the_zone_should_be_displayed_as_enabled() {
		zoneMetrics.specificZoneIsEnabled();

	}

	@When("^I call the API to enable a cluster for a zone$")
	public void I_call_the_API_to_enable_a_cluster_for_a_zone() {
		CallAPI.enableClusterForAZone();
	}

	@Then("^the value of clusters should be updated$")
	public void the_value_of_clusters_should_be_updated() {
		zoneMetrics.valueOfClustersUpdated();

	}

	@Given("^I call the API to create:CPU Usage for a cluster of:\"([^\"]*)\"$")
	public void I_call_the_API_to_create_CPU_Usage_for_a_cluster_of(String arg1) {
		CallAPI.createCPUUsageOf(arg1);

	}

	@Then("^the value of CPU Usage should be sumOfAllCluserUseg divided by numberOfClusters$")
	public void the_value_of_CPU_Usage_should_be_sumOfAllCluserUseg_divided_by_numberOfClusters() {
		zoneMetrics.checkCPUUsage();
	}

	@Given("^I call the API to create:Memory Usage for a cluster of:\"([^\"]*)\"$")
	public void I_call_the_API_to_create_Memory_Usage_for_a_cluster_of(String arg1) {
		CallAPI.createMemoryUsageOf(arg1);

	}

	@Then("^the value of Memory Usage should be sumOfAllCluserUseg divided by numberOfClusters$")
	public void the_value_of_Memory_Usage_should_be_sumOfAllCluserUseg_divided_by_numberOfClusters() {
		zoneMetrics.checkMemoryUsage();

	}

	@Given("^I get the average usage of all clusters$")
	public void I_get_the_average_usage_of_all_clusters() {
		average = zoneMetrics.getAverageUsageOfClusters();

	}

	@Given("^I call the API to create: CPU Usage for a zone of:\"([^\"]*)\"$")
	public void I_call_the_API_to_create_CPU_Usage_for_a_zone_of(String arg1) {
		newusage = CallAPI.createCPUUsageOf(arg1);

	}

	@When("^I click the RefreshButton$")
	public void I_click_the_RefreshButton() {
		zoneMetrics.clickRefresh();

	}

	@Then("^the CPU Deviation should be CurrentZoneUsage minus AvarageZonesUsage$")
	public void the_CPU_Deviation_should_be_CurrentZoneUsage_minus_AvarageZonesUsage() {
		Assert.assertTrue(zoneMetrics.getDisplayedDeviation() == newusage - average);

	}

	@Given("^I call the API to create: Memory Usage for a zone of:\"([^\"]*)\"$")
	public void I_call_the_API_to_create_Memory_Usage_for_a_zone_of(String arg1) {
		newusage = CallAPI.createMemoryUsageOf(arg1);

	}

	@Then("^the Memory Deviation should be CurrentZoneUsage minus AvarageZonesUsage$")
	public void the_Memory_Deviation_should_be_CurrentZoneUsage_minus_AvarageZonesUsage() {
		Assert.assertTrue(zoneMetrics.getDisplayedDeviation() == newusage - average);

	}

	@Given("^I call API to set:CPU Allocated for a cluster of:\"([^\"]*)\"$")
	public void I_call_API_to_set_CPU_Allocated_for_a_cluster_of(String arg1) {
		CallAPI.setCPUAllocated(arg1);

	}

	@Then("^the CPU Allocated should be sumOfAllocation devided by numberOfClusters$")
	public void the_CPU_Allocated_should_be_sumOfAllocation_devided_by_numberOfClusters() {
		//Assert that displayed average equals the average

	}

	@Given("^I call API to set:Memory Allocated for a cluster of:\"([^\"]*)\"$")
	public void I_call_API_to_set_Memory_Allocated_for_a_cluster_of(String arg1) {
		CallAPI.setMemoryAllocated(arg1);

	}

	@Then("^the Memory Allocated should be sumOfAllocation devided by numberOfClusters$")
	public void the_Memory_Allocated_should_be_sumOfAllocation_devided_by_numberOfClusters() {
		//Assert that displayed average equals the average

	}

	@When("^I call the API to set:CPU Total Allocation for a zone$")
	public void I_call_the_API_to_set_CPU_Total_Allocation_for_a_zone() {
		newallocation = CallAPI.setTotalAllocation();

	}

	@Then("^the value of CPU Total Allocation should be updated$")
	public void the_value_of_CPU_Total_Allocation_should_be_updated() {
		Assert.assertTrue(newallocation == zoneMetrics.getDisplayedAllocation());
	}

	@Then("^the value of Memory Total Allocation should be updated$")
	public void the_value_of_Memory_Total_Allocation_should_be_updated() {
		newallocation = CallAPI.setTotalAllocation();

	}

	@When("^I call the API to set:Memory Total Allocation for a zone$")
	public void I_call_the_API_to_set_Memory_Total_Allocation_for_a_zone(){
		newallocation = CallAPI.setTotalAllocation();
	}

	@Given("^I am on the ZoneMetricsPage$")
	public void I_am_on_the_ZoneMetricsPage(){
		zonesPage = new PO_ZonesPage();
		zonesPage.Goto();
		zoneMetrics = zonesPage.clickZoneMetrics();

	}

	@When("^I call an API to change the CPU Allocated to exceed the limit$")
	public void I_call_an_API_to_change_the_CPU_Allocated_to_exceed_the_limit(){
		CallAPI.setCPUAllocatedToExceedLimit();

	}

	@Then("^I should see the new CPU Allocated value displayed in red$")
	public void I_should_see_the_new_CPU_Allocated_value_displayed_in_red(){
		zoneMetrics.checkCPUAllocatedIsRed();

	}

	@When("^I call an API to change the Memory Allocated to exceed the limit$")
	public void I_call_an_API_to_change_the_Memory_Allocated_to_exceed_the_limit(){
		CallAPI.setMemoryAllocatedToExceedLimit();

	}

	@Then("^I should see the new Memory Allocated value displayed in red$")
	public void I_should_see_the_new_Memory_Allocated_value_displayed_in_red(){
		zoneMetrics.checkMemoryAllocatedIsRed();


	}
}
