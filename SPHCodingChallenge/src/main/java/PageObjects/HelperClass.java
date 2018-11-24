package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HelperClass {
	
	public void waitForVisibilityOfElements(WebElement element, String message,WebDriver driver) {
		//Waits until the element specified is visible
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Returns the given message if the element cannot be found after waiting for given no of seconds
		wait.withMessage(message);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void closeAdvertisement(WebDriver driver) {
		driver.switchTo().frame(driver.findElement(By.xpath("//div[contains(@style,'overflow')]/iframe")));
		while(!(driver.findElements(By.id("celtra-object-124")).isEmpty())) {
			List<WebElement> closeButton = driver.findElements(By.id("celtra-object-235"));
			if(!closeButton.isEmpty() && !driver.findElements(By.id("celtra-object-124")).isEmpty()) {
				closeButton.get(0).click();
			}
		}
		driver.switchTo().defaultContent();
	}
	
	public boolean verifyBrokenLinks(String link) throws Exception {
		//Verifies the given url is not broken by verifying whether the url returns 200
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(40 * 1000).setCookieSpec(CookieSpecs.STANDARD).build();
		HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
		HttpGet request = new HttpGet(link);
		HttpResponse response = client.execute(request);
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode!=200) {
			System.out.println(statusCode);
		}
		return (statusCode==200);
	}

}
