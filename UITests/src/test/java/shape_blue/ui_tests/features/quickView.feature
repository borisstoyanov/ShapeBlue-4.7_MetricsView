Feature: Zones Metrics
  As a customer,
  I want to go to the Zones Metrics page and click on a quick view
  so that I can view all details and actions available for the zone

  Scenario Outline: QuickView displays zone details
    Given I am on the ZonesPage
    When I click on a <zone> zone quickview
    And I call db to get the <zone> details
    Then both the result should match

    Examples: 
      | zone  |
      | zone1 |
      | zone2 |
      | zone3 |
      | zone4 |

  Scenario: User is able to add VMware datacenter
    Given I am on the QuickView of the <zone> zone
    When I press the AddVWwareDatacenter button
    Then I should be able to add a datacenter to the <zone>
    
  Scenario: User is able to disable and enable a zone
    Given I am on the QuickView of the <zone> zone
    When I press the disable button
    Then the <zone> zone should be disabled
    But when I press the enable button
    Then the <zone> zone should be enabled

  Scenario: User is able to Release Dedicated Zone
    Given I am on the QuickView of the <zone> zone
    When I press the ReleaseDedicatedZone button
    Then the <zone> should be released