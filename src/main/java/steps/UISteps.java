package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UISteps extends Steps {
	static private WebDriver driver = null;
	
	@Given("Eu abro o browser")
	public void openingABrowser() {
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		driver.manage().deleteAllCookies();
	}
	
	@When("Eu insiro $url e pressiono enter")
	public void entringUrl(String url) {
		driver.get(url);
	}
	
	@Then("$title é exibido")
	public void lookingForTheTitle(String title) {
		Assert.assertEquals(title, driver.getTitle());
	}
	

}
