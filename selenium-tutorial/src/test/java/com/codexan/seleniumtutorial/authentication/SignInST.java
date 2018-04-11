package com.codexan.seleniumtutorial.authentication;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codexan.seleniumtutorial.pages.CreateAnAccountPage;
import com.codexan.seleniumtutorial.pages.HomePage;
import com.codexan.seleniumtutorial.pages.LoginPage;
import com.codexan.seleniumtutorial.pages.MyAccountPage;
import com.codexan.seleniumtutorial.pages.TshirtsPage;
import com.codexan.seleniumtutorial.sections.ErrorSection;

public class SignInST {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Java\\selenium-tutorial\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Before
	public void setupBeforeEachTest() {		
		driver.get("http://automationpractice.com/index.php");
	}

	@Test @Ignore
	public void testSuccessfullLoginViaCorrectCredentials() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickSignInButton();
		loginPage.enterUserNameAndPassword("farhadali922@yahoo.com", "123456789abc");
		MyAccountPage myAccountPage = loginPage.clickLoginButton();
		Assert.assertNotNull(myAccountPage.getLogoutButton());
	}

	@Test @Ignore
	public void testThatValidationErrorShownForIncorrectPassword() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickSignInButton();
		loginPage.enterUserNameAndPassword("farhadali922@yahoo.com", "123456789");
		loginPage = loginPage.clickLoginButtonThatWillFail();
		
		Assert.assertTrue(loginPage.hasErrors());
		
		ErrorSection errorSection = loginPage.getErrorSection();
		Assert.assertEquals("There is 1 error", errorSection.getErrorHeader());
		Assert.assertEquals(1, errorSection.getErrorList().size());
		Assert.assertEquals("Authentication failed.", errorSection.getErrorList().get(0));
	}

	@Test @Ignore
	public void testSignout() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickSignInButton();
		loginPage.enterUserNameAndPassword("farhadali922@yahoo.com", "123456789abc");
		MyAccountPage myAccountPage = loginPage.clickLoginButton();
		loginPage = myAccountPage.clickSignOutButton();
		String headerText = loginPage.getHeaderText();
		Assert.assertEquals("AUTHENTICATION", headerText);
	}
	
	@Ignore @Test 
	public void testCreateAnAccount() {		
		HomePage homePage = new HomePage(driver);
		CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
		LoginPage loginPage = homePage.clickSignInButton();
		loginPage.enterNewAccountEmail("farhadali+001@yahoo.com");  
		createAnAccountPage = loginPage.clickCreateAnAccountButton();
		createAnAccountPage.chooseTitle();
		createAnAccountPage.enterFirstName("Farhad");
		createAnAccountPage.enterLastName("Ali");
		createAnAccountPage.enterPassword("123456789");
		createAnAccountPage.enterDateOfBirth("1", "1", "1985");
		createAnAccountPage.enterAddressFirstname("Farhad");
		createAnAccountPage.enterAddressLastname("Ali");
		createAnAccountPage.enterAddress("test address");
		createAnAccountPage.enterCity("London");
		createAnAccountPage.selectState("Alaska");
		createAnAccountPage.enterPostalCode("12345");
		createAnAccountPage.selectCountry("United States");
		createAnAccountPage.enterMobileNumber("07489574485");
		createAnAccountPage.enterAddressAlias("My home");
		createAnAccountPage.clickRegisterButton();
	}
	
	@Test
	public void test() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickSignInButton();
		loginPage.enterUserNameAndPassword("farhadali922@yahoo.com", "123456789abc");
		MyAccountPage myAccountPage = loginPage.clickLoginButton();
		TshirtsPage tshirtsPage = myAccountPage.clickOnTshirts();
		tshirtsPage.clickTshirt();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		tshirtsPage.clickOnTheimage();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    //System.out.println("number of frames"+tshirtsPage.numberOfFrames());
		tshirtsPage.clickOnAddToCartButton();
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