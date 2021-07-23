#Trail project
Feature: To test login functionality.

#@SmokeTest
#Scenario: Check login is successful with valid credentials
#
#Given User is on login page
#When User enters username and password
#And Clicks on Login button
#Then User is navigated to Home Page

#Scenario Outline: Check login is successful with valid credentials
#
#Given User is on login page
#When User enters <username> and <password>
#And Clicks on Login button
#Then User is navigated to Home Page
#
#Examples:
#| username | password |
#| manu | 123 |
#| navya | 321 |


Scenario: Successful login with valid credentials

Given User Launch Chrome browser
When User opens URL "http://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User clicks on Logout link
Then Page Title should be "Your store. Login"
And Close browser

@SmokeTest
Scenario Outline: Login data driven
Given User Launch Chrome browser
When User opens URL "http://admin-demo.nopcommerce.com/login"
And User enters Email as "<username>" and Password as "<password>"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User clicks on Logout link
Then Page Title should be "Your store. Login"

Examples:
| username | password |
| admin@yourstore.com | admin |
#| manu | 321 |
