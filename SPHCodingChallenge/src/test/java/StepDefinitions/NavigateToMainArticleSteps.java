package StepDefinitions;

import org.junit.Assert;

import PageObjects.SPHHomePage;
import PageObjects.SPHMainArticlePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigateToMainArticleSteps extends SPHBaseTestClass {
   
	SPHHomePage homePage;
	SPHMainArticlePage mainArticlePage;
	String mainArticleTitle = "";
	
	@Given("I launch the SPH website")
	public void i_launch_the_SPH_website() {
	    homePage.navigateToHomePage(readPropertyValues("URL"));
	}

	@When("I click on the login option")
	public void i_click_on_the_login_option() {
	    homePage.clickLogin();
	}

	@When("I login to the website with the credentials")
	public void i_login_to_the_website_with_the_credentials() {
	    homePage.loginToWebSite(readPropertyValues("userName"), readPropertyValues("password"));
	}

	@Then("I should be logged into the website successfully")
	public void i_should_be_logged_into_the_website_successfully() {
	    Assert.assertTrue("THE USER IS NOT LOGGED IN SUCCESSFULLY TO THE WEBSITE",homePage.isUserLoggedIn());
	}

	@Then("I should see the main article displayed on the home page")
	public void i_should_see_the_main_article_displayed_on_the_home_page() {
	    Assert.assertTrue("THE MAIN ARTICLE IS NOT DISPLAYED IN THE HOME PAGE",homePage.isMainArticleDisplayed());
	}

	@Then("I should see the article contains a media")
	public void i_should_see_the_article_contains_a_media() {
	    Assert.assertTrue("THE MAIN ARTICLE IN THE HOME PAGE DOES NOT CONTAIN A MEDIA",homePage.isMediaDisplayed());
	}

	@When("I click on the main article")
	public void i_click_on_the_main_article() {
		mainArticleTitle = homePage.getMainArticleTitle();
		mainArticlePage = homePage.clickMainArticle();
	}

	@Then("I should be redirected to the main article page")
	public void i_should_be_redirected_to_the_main_article_page() {
	    Assert.assertTrue("USER NOT REDIRECTED TO THE MAIN ARTICLE PAGE",
	    												mainArticlePage.isMainArticlePageLoaded(mainArticleTitle));
	}

	@Then("I should see the media is displayed for the article on the mainarticle page")
	public void i_should_see_the_media_is_displayed_for_the_article_on_the_mainarticle_page() {
		Assert.assertTrue("THE ARTICLE IN THE ARTICLE PAGE DOES NOT CONTAIN A MEDIA",mainArticlePage.isMediaDisplayed());
	}
	
	@Before
	public void beforeMethod() {
		initializeDriver();
		homePage = new SPHHomePage(SPHBaseTestClass.driver);
	}

	@After
	public void afterMethod(Scenario scenario) {
		sessionCleanup(scenario);
	}
}
