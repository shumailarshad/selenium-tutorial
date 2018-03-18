package com.codexan.seleniumtutorial.authentication;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codexan.seleniumtutorial.pages.HomePage;
import com.codexan.seleniumtutorial.pages.LoginPage;
import com.codexan.seleniumtutorial.pages.MyAccountPage;

/*


*/

public class SignInST {

	private static WebDriver driver;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium\\New folder\\Lib\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Before
	public void setupBeforeEachTest() {
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void testSuccessfullLoginViaCorrectCredentials() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickSignInButton();
		loginPage.enterUserNameAndPassword("farhadali922@yahoo.com", "123456789abc");
		MyAccountPage myAccountPage = loginPage.clickLoginButton();
		Assert.assertNotNull(myAccountPage.getLogoutButton());
	}
	
	@Test
	public void testThatValidationErrorShownForIncorrectPassword() { 
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickSignInButton();
		loginPage.enterUserNameAndPassword("farhadali922@yahoo.com", "123456789");
		loginPage = loginPage.clickLoginButtonThatWillFail();	
		Assert.assertEquals("There is 1 error", loginPage.getErrorHeader());
		List<WebElement> allErrors = loginPage.getErrorList();
		Assert.assertEquals(1, allErrors.size());
		Assert.assertEquals("Authentication failed.", allErrors.get(0).getText());		
	}	

	@Test
	public void testSignout() {		
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickSignInButton();
		loginPage.enterUserNameAndPassword("farhadali922@yahoo.com", "123456789abc");
		MyAccountPage myAccountPage = loginPage.clickLoginButton();
		loginPage = myAccountPage.clickSignOutButton();
		String headerText = loginPage.getHeaderText();
		Assert.assertEquals("AUTHENTICATION", headerText);
	}

	@After
	public void cleanupAfterEachTest() {
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void cleanup() {
		driver.quit();
	}

}
