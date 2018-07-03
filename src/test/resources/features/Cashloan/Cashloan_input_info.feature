Feature:
  As a client who wants to apply for a loan
  I want to input all my info
  So that I can proceed to apply for a loan

  @test
  Scenario Outline: input invalid phone & ID
    Given I am at the 'Personal Details' screen
    When I enter phone number <invalid_phone>
    And I enter ID number <invalid_id>
    Then I will see an error message for both fields
    Examples:
      | invalid_phone  | invalid_id       |
      | 12345678911134 | 1111111112232333 |
      |                |                  |
      | abcgdf         | abcdef           |
      | 0989123456     | abcdef           |
      | abcdef         | 024030899        |

  Scenario Outline: input invalid phone | ID
    Given I am at the 'Personal Details' screen
    When I enter phone number <valid_phone>
    And I enter ID number <invalid_id>
    Then I will see an error message for ID field
    When I enter phone number <invalid_phone>
    And I enter ID number <valid_id>
    Then I will see an error message for phone field
    Examples:
      | valid_phone | valid_ID  | invalid_phone | invalid_id |
      | 0989123456  | 024030888 | abcdef        | xyzxyz     |


  Scenario Outline: input valid phone & ID no & OTP
    Given I am at the 'Personal Details' screen
    When I enter phone number <valid_phone_no>
    And I enter ID number <valid_id_no>
    And I tap 'Next'
    Then I will be navigated to 'Enter OTP' screen
    When I enter OTP <valid_otp>
    And I tap 'Submit'
    Then I will be navigated to 'Select loan' screen
    Examples:
      | valid_phone_no | valid_id_no | valid_otp |
      | 0982222222     | 024000111   | zzzzzz    |

  Scenario Outline: input valid phone & ID no & invalid OTP
    Given I am at the 'Personal Details' screen
    When I enter phone number <valid_phone_no>
    And I enter ID number <valid_id_no>
    And I tap 'Next'
    Then I will be navigated to 'Enter OTP' screen
    When I enter OTP <valid_otp>
    And I tap 'Submit'
    Then I will be navigated to 'Select loan' screen
    Examples:
      | valid_phone_no | valid_id_no | valid_otp |
      | 0982222222     | 024000111   | zzzzzz    |


