package page_objects;

public class PO_ZonesPage {

	public void Goto() {
		// Navigates the user to ZonesPage
		
	}

	public PO_ZoneMetricsPage clickZoneMetrics() {
		// Navigates the user to ZonesMetricsPage
		return new PO_ZoneMetricsPage();
	}

}
