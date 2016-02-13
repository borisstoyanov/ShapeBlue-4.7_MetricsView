Feature: Zones Metrics
  As a customer,
  I want to go to the Zones Metrics page
  so that I can be sure all metrics are showing correct values

  Scenario: MetricsButton gets us to ZoneMetricsPage
    Given I am on the ZonesPage
    When I click on MetricsButton
    Then I should be displated with the ZoneMetricsPage

  Scenario Outline: All metrics columns are sortable
    Given I am on the ZoneMetricsPage
    When I call an API to change the <metric>
    And I click the RefreshButton
    Then I should see the new <metric> value displayed

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
