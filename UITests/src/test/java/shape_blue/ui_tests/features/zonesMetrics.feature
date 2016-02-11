Feature: Zones Metrics
As a customer,
I want to go to the Zones Metrics page
so that I can view all related metrics to the Zones

  Scenario: Pricing changes when I change number of websites
    Given I'm on the ZonesPage
       
  Scenario Outline: Search for regulation by partial text
    Given a user goes to consumer rights
    When they Search for <partial_query>
    Then user should be displayed with search results
    And the first regulation should be <partial_query>

  Examples:
  |partial_query|
  |Sale of|
  |Distance Selling|
  |Payment Services|