Feature: New user registration on the utest page

    @challenge
    Scenario: Successfully register a new user on home page
        Given the user is on the utest home page
        When the user registers through join today with the data
        Then the user should see the successful registration