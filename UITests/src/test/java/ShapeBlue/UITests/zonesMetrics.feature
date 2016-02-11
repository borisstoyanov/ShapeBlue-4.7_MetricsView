Feature: Zones Metrics
As a customer,
I want to open the signup page 
so that I can select a plan and signup


  Scenario: Pricing changes when I change number of websites
    Given I'm on the SignupPage
     When I select 3 websites
     Then basic should be: "50.07"
      And pro should be: "74.97"
      And business: "124.98"

  Scenario: Select a plan and signup
    Given I'm on the SignupPage
     When I buy SucuriAntivirusSolution
     Then I should be at the CreateAccountPage
     When I enter email:"randomemail3@email.com"
      And I enter password:"SOMEsecret1"
      And I agree with terms
      And I click CreateAccount
     Then I shoud be on the checkout page
  