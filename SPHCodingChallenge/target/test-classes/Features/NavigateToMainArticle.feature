@NavigateToMainArticleWebPage
Feature: Navigate to the main article page on website

Background:
Given I launch the SPH website
 
  #====================================================================================
  #		             Scenario 1 - Log into the web site 
  #====================================================================================
  @LoginToWebsite
  Scenario: Log into the website
  When I click on the login option
  And I login to the website with the credentials
  Then I should be logged into the website successfully
  
  #====================================================================================
  #		             Scenario 2 - Launch the main article
  #====================================================================================
  @LaunchArticle
  Scenario: Launch the main article
#  When I click on the login option
#  And I login to the website with the credentials
  Then I should see the main article displayed on the home page
  And I should see the article contains a media
  When I click on the main article
  Then I should be redirected to the main article page
  And I should see the media is displayed for the article on the mainarticle page
  
  
  