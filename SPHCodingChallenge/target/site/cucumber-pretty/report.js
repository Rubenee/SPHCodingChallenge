$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/NavigateToMainArticle.feature");
formatter.feature({
  "name": "Navigate to the main article page on website",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@NavigateToMainArticleWebPage"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I launch the SPH website",
  "keyword": "Given "
});
formatter.match({
  "location": "NavigateToMainArticleSteps.i_launch_the_SPH_website()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Launch the main article",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@NavigateToMainArticleWebPage"
    },
    {
      "name": "@LaunchArticle"
    }
  ]
});
formatter.step({
  "name": "I should see the main article displayed on the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "NavigateToMainArticleSteps.i_should_see_the_main_article_displayed_on_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the article contains a media",
  "keyword": "And "
});
formatter.match({
  "location": "NavigateToMainArticleSteps.i_should_see_the_article_contains_a_media()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the main article",
  "keyword": "When "
});
formatter.match({
  "location": "NavigateToMainArticleSteps.i_click_on_the_main_article()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be redirected to the main article page",
  "keyword": "Then "
});
formatter.match({
  "location": "NavigateToMainArticleSteps.i_should_be_redirected_to_the_main_article_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the media is displayed for the article on the mainarticle page",
  "keyword": "And "
});
formatter.match({
  "location": "NavigateToMainArticleSteps.i_should_see_the_media_is_displayed_for_the_article_on_the_mainarticle_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});