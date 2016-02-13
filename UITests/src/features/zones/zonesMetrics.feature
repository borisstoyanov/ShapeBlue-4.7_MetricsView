Feature: Zones Metrics
  As a customer,
  I want to go to the Zones Metrics page
  so that I can be sure all metrics are showing correct values

  Scenario: Clicking on a zone name will navigate the user to ClusterView of the specific zone
    Given I am on the ZoneMetricsPage
    When I click on the Name of a Zone
    Then I am navigated to ClustersView of that specific zone

  Scenario: Enabling a zone changes the state
    Given I am on the ZoneMetricsPage
    When I call the API to enable a zone
    Then the zone should be displayed as enabled

  Scenario: Enabling a cluster for a zone updates the clusters
    Given I am on the ZoneMetricsPage
    When I call the API to enable a cluster for a zone
    Then the value of clusters should be updated

  Scenario Outline: <used> Used is displaying right percentage
    Given I am on the ZoneMetricsPage
    And I call the API to create:<used> Usage for a cluster of:"50"
    Then the value of <used> Usage should be sumOfAllCluserUseg divided by numberOfClusters

    Examples: 
      | used   |
      | CPU    |
      | Memory |

  Scenario Outline: <deviation> Useage Deviation
    Given I am on the ZoneMetricsPage
    And I get the average usage of all clusters
    And I call the API to create: <deviation> Usage for a zone of:"200"
    When I click the RefreshButton
    Then the <deviation> Deviation should be CurrentZoneUsage minus AvarageZonesUsage

    Examples: 
      | deviation |
      | CPU       |
      | Memory    |

  Scenario Outline: <allocation> displays correct data
    Given I am on the ZoneMetricsPage
    And I call API to set:<allocation> for a cluster of:"200"
    When I click the RefreshButton
    Then the <allocation> should be sumOfAllocation devided by numberOfClusters

    Examples: 
      | allocation       |
      | CPU Allocated    |
      | Memory Allocated |

  Scenario Outline: <total> Total displays correct data
    Given I am on the ZoneMetricsPage
    When I call the API to set:<total> Total Allocation for a zone
    And I click the RefreshButton
    Then the value of <total> Total Allocation should be updated

    Examples: 
      | total  |
      | CPU    |
      | Memory |

  Scenario Outline: <metric> metric is displayed with amber color when near the limit
    Given I am on the ZoneMetricsPage
    When I call an API to change the <metric> near exceeding the limit
    And I click the RefreshButton
    Then I should see the new <metric> value displayed in amber

  Scenario Outline: <metric> metric is displayed with amber color when exceeds the limit
    Given I am on the ZoneMetricsPage
    When I call an API to change the <metric> to exceed the limit
    And I click the RefreshButton
    Then I should see the new <metric> value displayed in red

    Examples: 
      | metric           |
      | CPU Allocated    |
      | Memory Allocated |
      
  Scenario: Changing the threshold near the current value should display the metric in amber
    Given I am on the ZoneMetricsPage
	And I get the value of a metric:
	When I update the threshold to be slightly above the metric value 
	Then the metric should be displayed in amber
	
  Scenario: Changing the threshold below the current value should display the metric in red
    Given I am on the ZoneMetricsPage
	And I get the value of a metric:
	When I update the threshold to be below the metric value 
	Then the metric should be displayed in red
  
