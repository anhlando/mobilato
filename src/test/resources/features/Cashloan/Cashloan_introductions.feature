Feature:
  As a client who wants to apply for a loan
  I want to  read the introduction about cash loan walking online function
  So that I will have a better understanding about the product

  Scenario: go through all 4 introduction pages
    Given I am at the Welcome screen
    When I select 'Cashloan' option
    Then I will see introduction page 1
    When I tap 'Next'
    Then I will see introduction page 2
    When I tap 'Next'
    Then I will see introduction page 3
    When I tap 'Next'
    Then I will see introduction page 4

  Scenario: go through the whole 4 pages then tap 'Back' in each page
    Given I am at the Welcome screen
    When I select 'Cashloan' option
    Then I will see introduction page 1
    When I tap 'Next'
    Then I will see introduction page 2
    When I tap 'Next'
    Then I will see introduction page 3
    When I tap 'Next'
    Then I will see introduction page 4
    When I tap 'Back'
    Then I will see introduction page 3
    When I tap 'Back'
    Then I will see introduction page 2
    When I tap 'Back'
    Then I will see introduction page 1
    When I tap 'Back'
    Then I will see the Welcome screen