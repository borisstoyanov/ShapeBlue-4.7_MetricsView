Feature: Zones Metrics General UI Features
  As a customer,
  I want to go to the Zones Metrics page
  so that I can view all related metrics to the Zones

  Scenario: All metrics are displated 
  	Given the follwing metrics:
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
    Then they should be displayed


  