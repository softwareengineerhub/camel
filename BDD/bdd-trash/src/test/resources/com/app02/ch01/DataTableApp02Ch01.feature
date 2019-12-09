Feature: Application Login

Scenario: Home page default login
Given User is on NetBanking landing page
When User sign up with following details
| jenny | 123password | jenny@abcd.com | Australia | 3242353 |
Then Home page is populated
And Cards are displayed
