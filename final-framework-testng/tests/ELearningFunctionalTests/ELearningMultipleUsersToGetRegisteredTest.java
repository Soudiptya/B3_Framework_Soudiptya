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

import com.training.dataproviders.MultipleUsersToGetRegisteredDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ELearningMultipleUsersToGetRegisteredPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
 * Author                : Soudiptya Kumar Basu
 * Test Case ID          : ELTC_087
 * Test Case Description : TO verify whether application allows multiple users to get registered as Student.
 * PreCondition          : 1. User should have launched the application 
 */

public class ELearningMultipleUsersToGetRegisteredTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningMultipleUsersToGetRegisteredPOM eLearningMultipleUsersToGetRegisteredPOM;
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
		eLearningMultipleUsersToGetRegisteredPOM = new ELearningMultipleUsersToGetRegisteredPOM(driver); 
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
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = MultipleUsersToGetRegisteredDataProviders.class)
	public void ELearningMultipleUsersToGetRegisteredDBTest(String FirstName, String LastName, String Email, String UserNameTextbox, String PasswordTextbox, String ConfirmPasswordTextbox, String PhoneNumber, String LanguageSelect) throws InterruptedException {
		eLearningMultipleUsersToGetRegisteredPOM.clickSignUp();
		eLearningMultipleUsersToGetRegisteredPOM.sendFirstName(FirstName);
		eLearningMultipleUsersToGetRegisteredPOM.sendLastName(LastName);
		eLearningMultipleUsersToGetRegisteredPOM.sendEmail(Email);
		eLearningMultipleUsersToGetRegisteredPOM.sendUserNameTextbox(UserNameTextbox);
		eLearningMultipleUsersToGetRegisteredPOM.sendPasswordTextbox(PasswordTextbox);
		eLearningMultipleUsersToGetRegisteredPOM.sendConfirmPasswordTextbox(ConfirmPasswordTextbox);
		eLearningMultipleUsersToGetRegisteredPOM.sendPhoneNumber(PhoneNumber);
		eLearningMultipleUsersToGetRegisteredPOM.selectLanguageSelect(LanguageSelect);
		Thread.sleep(3000);
		eLearningMultipleUsersToGetRegisteredPOM.selectProfile();
		eLearningMultipleUsersToGetRegisteredPOM.clickRegister();
		System.out.println("Registration completed");
		
		Actual = driver.findElement(By.xpath("//p[contains(text(),'An email has been sent to help you remember your l')]")).getText();
		Expected = "An email has been sent to help you remember your login and password.";
		assertEquals(Actual, Expected);
		
		screenShot.captureScreenShot("First");
	}
}
