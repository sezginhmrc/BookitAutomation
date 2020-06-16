Feature: Back-End testing
  Background: Given im connected with the database

    @DB_1
    Scenario: I want to test the database of bookit application
      When i run the select query to retrieve data from db
      Then i should able to see see the
