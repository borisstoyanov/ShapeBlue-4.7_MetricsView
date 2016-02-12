Feature: Zones Metrics
  As a customer,
  I want to go to the Zones Metrics page
  so that I can view all related metrics to the Zones

  Scenario: MetricsButton gets us to ZoneMetricsPage
    Given I am on the ZonesPage
    When I click on MetricsButton
    Then I should be displated with the ZoneMetricsPage

  Scenario: Breadcrumb navigation displays the right location of the page
    Given I am on the ZonesPage
    Then the breadcrumb should display the right location of the page

  Scenario: RefreshButton is refreshing the ZoneMetricsPage
    Given I am on the ZoneMetricsPage
    And I get the value for a specific metric
    When I execute a mocked method to change a metric
    And I click the RefreshButton
    Then I should be displated with the updated value of the metric

  Scenario Outline: All metrics are displated
    Given I am on the ZoneMetricsPage
    Then they should be displayed with the metric: <metric>

  Scenario Outline: All metrics columns are collapseble and expandable
    Given I am on the ZoneMetricsPage
    And I collapse the <metric> column
    Then I should not be able to see the <metric> metrics
    But when I expand the <metric> column
    Then I should be able to see the <metric> metrics
  
  Scenario Outline: All metrics columns are sortable
    Given I am on the ZoneMetricsPage
    And I sort the <metric> column ascending
    Then I should see the <metric> metrics displayed ascending 
    But when I sort the <metric> column descending 
    Then I should see the <metric> metrics displayed descending  

    Examples: 
      | metric           |
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
