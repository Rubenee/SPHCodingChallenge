package PageObjects;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SPHMainArticlePage {

	private WebDriver driver;
	HelperClass helper = new HelperClass();
	private static Log log = LogFactory.getLog(SPHMainArticlePage.class);
	
	@FindBy(xpath = "//h1[contains(@class,'node-title')]") private static WebElement mainArticlePageTitle;
	@FindBy(xpath = "//div[contains(@class,'file-image')]//figure//img") private static List<WebElement> mediaImage;
	
	public SPHMainArticlePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isMainArticlePageLoaded(String articleTitle) {
		//Verify the mainArticle  page is loaded
		String titleDisplayed = mainArticlePageTitle.getText();
		return mainArticlePageTitle.isDisplayed() && titleDisplayed.equals(articleTitle) ;
	}

	public boolean isMediaDisplayed() {
		// Verify the media is displayed in teh main article page
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
		}
		return isDisplayed;
	}

}
