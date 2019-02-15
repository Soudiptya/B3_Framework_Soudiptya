package ELearningFunctionalTests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.InvalidCredentialValidationDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ELearningInvalidCredentialValidationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
 * Author                : Soudiptya Kumar Basu
 * Test Case ID          : ELTC_088
 * Test Case Description : TO verify whether application displays error message upon entering invalid credentials in student registration page.
 * PreCondition          : 1. User should have launched the application 
 */

public class ELearningInvalidCredentialValidationTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningInvalidCredentialValidationPOM eLearningInvalidCredentialValidationPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	String Actual;
	String Expected;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eLearningInvalidCredentialValidationPOM = new ELearningInvalidCredentialValidationPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = InvalidCredentialValidationDataProviders.class)
	public void ELearningInvalidCredentialValidationDBTest(String FirstName, String LastName, String Email, String UserNameTextbox, String PasswordTextbox, String ConfirmPasswordTextbox, String PhoneNumber, String LanguageSelect) throws InterruptedException {
		eLearningInvalidCredentialValidationPOM.clickSignUp();
		eLearningInvalidCredentialValidationPOM.sendFirstName(FirstName);
		eLearningInvalidCredentialValidationPOM.sendLastName(LastName);
		eLearningInvalidCredentialValidationPOM.sendEmail(Email);
		eLearningInvalidCredentialValidationPOM.sendUserNameTextbox(UserNameTextbox);
		eLearningInvalidCredentialValidationPOM.sendPasswordTextbox(PasswordTextbox);
		eLearningInvalidCredentialValidationPOM.sendConfirmPasswordTextbox(ConfirmPasswordTextbox);
		eLearningInvalidCredentialValidationPOM.sendPhoneNumber(PhoneNumber);
		eLearningInvalidCredentialValidationPOM.selectLanguageSelect(LanguageSelect);
		Thread.sleep(3000);
		eLearningInvalidCredentialValidationPOM.selectProfile();
		eLearningInvalidCredentialValidationPOM.clickRegister();
		System.out.println("Error messege should get displayed");
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();
		Expected = "The email address is not complete or contains some invalid characters";
		assertEquals(Actual, Expected);
		
		screenShot.captureScreenShot("First");
	}
}
