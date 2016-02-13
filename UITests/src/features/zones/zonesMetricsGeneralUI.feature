Feature: Zones Metrics General UI Features
  As a customer,
  I want to go to the Zones Metrics page
  so that I can view all related metrics to the Zones

  Scenario: MetricsButton gets us to ZoneMetricsPage
    Given I am on the ZonesPage
    When I click on MetricsButton
    Then I should be displated with the ZoneMetricsPage

  Scenario: Breadcrumb navigation displays the right location of the page
    Given I am on ZoneMetricsPage
    Then the breadcrumb should display the right location of the page

  Scenario: RefreshButton is refreshing the ZoneMetricsPage
    Given I am on ZoneMetricsPage
    And I get the value for a specific metric
    When I execute a mocked method to change a metric
    And I click RefreshButton
    Then I should be displated with the updated value of the metric

  Scenario: All metrics are displated
    Given I am on ZoneMetricsPage
    And I have the following metrics:
      | Name             |
      | State            |
      | Clusters         |
      | CPU Used         |
      | CPU Max Dev      |
      | CPU Allocated    |
      | CPU Total        |
      | Memory Allocated |
      | Memory Total     |
      | Memory Used      |
      | Memory Max Dev   |
      | QuickView        |
    Then they should be displayed

  Scenario: All metrics columns are collapseble and expandable
    Given I am on ZoneMetricsPage
    And I have the following metrics:
	  | Name             |
      | State            |
      | Clusters         |
      | CPU Used         |
      | CPU Max Dev      |
      | CPU Allocated    |
      | CPU Total        |
      | Memory Allocated |
      | Memory Total     |
      | Memory Used      |
      | Memory Max Dev   |
      | QuickView        |
    Then I collapse and expand the metric

  Scenario: All metrics columns are sortable
    Given I am on ZoneMetricsPage
    And I have the following metrics:
	  | Name             |
      | State            |
      | Clusters         |
      | CPU Used         |
      | CPU Max Dev      |
      | CPU Allocated    |
      | CPU Total        |
      | Memory Allocated |
      | Memory Total     |
      | Memory Used      |
      | Memory Max Dev   |
      | QuickView        |
    Then I sort ascending and descending 


    