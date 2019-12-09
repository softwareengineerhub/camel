Feature: Application Login

#Important!!!! Background is only for this feature file

Background:
Given validate the browser 
When Browser is triggered
Then check if browser is started

  @my
  Scenario Outline: Home page default login
    Given User is on NetBanking landing page
    When User login into application with "<Name>" and "<Pass>" and "<Mail>" and "<Country>" and "<Key>"
    Then Home page is populated
    And Cards are displayed

    Examples: 
      | Name  | Pass        | Mail           | Country   | Key     |
      | jenny | 123password | jenny@abcd.com | Australia | 3242353 |
      | jenn2 | 12password2 | jenn2@abcd.com | Australi2 | 4242353 |
      | jenn3 | 12password3 | jenn3@abcd.com | Australi3 | 5242353 |
      | jenn4 | 12password4 | jenn4@abcd.com | Australi4 | 6242353 |
