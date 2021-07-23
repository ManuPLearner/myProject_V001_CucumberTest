package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class LoginSteps {
	private WebDriver driver;
	private LoginPage lp;

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) {
		lp.setUserName(username);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		System.out.println("Original title = " + driver.getTitle());
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
	}

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("Close browser")
	public void close_browser() {
		driver.quit();
	}

}
