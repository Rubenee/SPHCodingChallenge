package PageObjects;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SPHHomePage {
	
	private WebDriver driver;
	HelperClass helper = new HelperClass();
	private static Log log = LogFactory.getLog(SPHHomePage.class);
	
	//Elements declaration using page factory
	@FindBy(className = "navbar-header") private static WebElement header;
	@FindBy(className = "nav-login") private static WebElement loginOption;
	@FindBy(id = "j_username") private static WebElement userNameField;
	@FindBy(id = "j_password") private static WebElement passwordField;
	@FindBy(className = "btn") private static WebElement loginButton;
	@FindBy(className = "nav-user") private static WebElement loggedinUserName;
	@FindBy(xpath = "//div[@data-vr-zone='Top Stories 0']") private static WebElement mainArticle;
	@FindBy(xpath = "//div[@data-vr-zone='Top Stories 0']//h3//a") private static WebElement mainArticleTitle;
	@FindBy(xpath = "//div[@data-vr-zone='Top Stories 0']//div[contains(@class,'file-image')]//img") 
																		private static List<WebElement> mediaImage;
	@FindBy(xpath = "//div[@data-vr-zone='Top Stories 0']//div[contains(@class,'file-video')]//img") 
																		private static List<WebElement> mediaVideo;
	
	
	public SPHHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToHomePage(String URL) {
		//Navigate to Homepage
		driver.get(URL);
		helper.waitForVisibilityOfElements(header, "HOME PAGE LOADING IS UNSUCCESSFUL", driver);
		log.info("HOME PAGE LOADED SUCCESSFULLY");
		try {
			Thread.sleep(3000);
			helper.closeAdvertisement(driver);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLogin() {
		//Click on the login
		log.info("NAVIGATING TO THE LOG IN SCREEN....");
		Actions action = new Actions(driver);
		action.moveToElement(loginOption).click().build().perform();
		helper.waitForVisibilityOfElements(userNameField, "LOGIN SCREEN NOT LOADED ON CLICKING LOGIN OPTION", driver);
		log.info("USER REDIRECTED TO THE LOGIN PAGE SUCCESSFULLY");
	}

	public void loginToWebSite(String uName, String password) {
		//Login to the website with given credentials
		log.info("LOGGING IN USER.......");
		Actions action = new Actions(driver);
		action.moveToElement(userNameField).click().sendKeys(uName).build().perform();
		action.moveToElement(passwordField).click().sendKeys(password).build().perform();
		action.moveToElement(loginButton).click().build().perform();
		helper.waitForVisibilityOfElements(header, "USER NOT REDIRECTED TO HOMEPAGE ON LOGGING IN", driver);
		log.info("USER LOGGED IN SUCCESSFULLY");
	}

	public boolean isUserLoggedIn() {
		//Verify the user is logged in successfully
		return loggedinUserName.isDisplayed();
	}

	public boolean isMainArticleDisplayed() {
		//Verify the main article is displayed
		return mainArticle.isDisplayed();
	}

	public boolean isMediaDisplayed() {
		//Verify the media is displayed in the main article
		log.info("VERIFYING THE MEDIA IS DISPLAYED AND THE MEDIA LINK IS NOT BROKEN.....");
		boolean isDisplayed = false;
		String mediaLink = "";
		if(!mediaImage.isEmpty()) {
			mediaLink = mediaImage.get(0).getAttribute("src");
			try { 
				isDisplayed = mediaImage.get(0).isDisplayed() && helper.verifyBrokenLinks(mediaLink);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(!mediaVideo.isEmpty()) {
			mediaLink = mediaVideo.get(0).getAttribute("src");
			try { 
				isDisplayed = mediaVideo.get(0).isDisplayed() && helper.verifyBrokenLinks(mediaLink);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return isDisplayed;
	}

	public SPHMainArticlePage clickMainArticle() {
		//Click on main article
		mainArticle.click();
		return new SPHMainArticlePage(driver);
	}

	public String getMainArticleTitle() {
		//Get the title of the main article
		return mainArticleTitle.getText();
	}
    
}
