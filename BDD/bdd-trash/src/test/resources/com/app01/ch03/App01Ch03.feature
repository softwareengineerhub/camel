Feature: Application Login

@my
Scenario: Home page default login
Given User is on NetBanking landing page
When User login into application with username and password
Then Home page is populated
And Cards are displayed

@my2
Scenario: MyHome2 page default login2
Given User2 is on NetBanking landing page2
When User login into application with username and password2
Then Home2 page is populated2
And Cards are displayed2
