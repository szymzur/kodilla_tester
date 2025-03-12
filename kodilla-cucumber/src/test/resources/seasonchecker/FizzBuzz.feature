Feature: FizzBuzz
  As a developer
  I want to verify the FizzBuzz functionality
  So that I can ensure the method returns the correct text based on the given number

  Scenario Outline: Check FizzBuzz functionality
    Given the number is <number>
    When I call the FizzBuzz method
    Then the result should be "<expected>"

    Examples:
      | number | expected  |
      | 3      | Fizz      |
      | 5      | Buzz      |
      | 15     | FizzBuzz  |
      | 7      | None      |
