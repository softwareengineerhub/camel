Feature: Application Login

Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "jack" and "1234"
Then Home page is populated
And Cards are displayed

Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with "piter" and "5678"
Then Home page is populated
And Cards are displayed
