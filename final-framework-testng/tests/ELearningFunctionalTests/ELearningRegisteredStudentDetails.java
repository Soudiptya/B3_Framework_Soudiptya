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

import com.training.generics.ScreenShot;
import com.training.pom.ELearningRegisteredStudentDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
 * Author                : Soudiptya Kumar Basu
 * Test Case ID          : ELTC_089
 * Test Case Description : TO verify whether registered student details get stored in database.
 * PreCondition          : 1. User should have launched the application 
 */

public class ELearningRegisteredStudentDetails {
	private WebDriver driver;
	private String baseUrl;
	private ELearningRegisteredStudentDetailsPOM eLearningRegisteredStudentDetailsPOM;
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
		eLearningRegisteredStudentDetailsPOM = new ELearningRegisteredStudentDetailsPOM(driver); 
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
	@Test
	public void validRegisteredStudentDetailsTest() throws InterruptedException {
		eLearningRegisteredStudentDetailsPOM.sendUserName("admin");
		eLearningRegisteredStudentDetailsPOM.sendPassword("admin@123");
		eLearningRegisteredStudentDetailsPOM.clickLoginBtn(); 
		eLearningRegisteredStudentDetailsPOM.clickDropdown();
		eLearningRegisteredStudentDetailsPOM.clickLogout();
		eLearningRegisteredStudentDetailsPOM.clickSignUp();
		eLearningRegisteredStudentDetailsPOM.sendFirstName("sunil");
		eLearningRegisteredStudentDetailsPOM.sendLastName("nagaraj");
		eLearningRegisteredStudentDetailsPOM.sendEmail("sunil@gmail.com");
		eLearningRegisteredStudentDetailsPOM.sendUserNameTextbox("65gvfd");
		eLearningRegisteredStudentDetailsPOM.sendPasswordTextbox("sunil");
		eLearningRegisteredStudentDetailsPOM.sendConfirmPasswordTextbox("sunil");
		eLearningRegisteredStudentDetailsPOM.sendPhoneNumber("9876543210");
		eLearningRegisteredStudentDetailsPOM.selectLanguageSelect("English");
		Thread.sleep(3000);
		eLearningRegisteredStudentDetailsPOM.selectProfile();
		eLearningRegisteredStudentDetailsPOM.clickRegister();
		System.out.println("Registration completed");
		
		Actual = driver.findElement(By.xpath("//p[contains(text(),'An email has been sent to help you remember your l')]")).getText();
		Expected = "An email has been sent to help you remember your login and password.";
		assertEquals(Actual, Expected);
		
		screenShot.captureScreenShot("First");
	}
}

