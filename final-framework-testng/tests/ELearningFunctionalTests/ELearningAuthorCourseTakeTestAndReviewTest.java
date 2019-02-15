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
import com.training.pom.ELearningAuthorCourseTakeTestAndReviewPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
 * Author                : Soudiptya Kumar Basu
 * Test Case ID          : ELTC_090
 * Test Case Description : To verify whether application allows teacher to author a test for a course, student to take the test & teacher to review & send the response.
 * PreCondition          : 1. User should have launched the application 
 */

public class ELearningAuthorCourseTakeTestAndReviewTest {
	
private WebDriver driver;
private String baseUrl;
private ELearningAuthorCourseTakeTestAndReviewPOM eLearningAuthorCourseTakeTestAndReviewPOM;
private static Properties properties;
private ScreenShot screenShot;
String Actual;
String Actual1;
String Actual2;
String Expected;
String Expected1;
String Expected2;

@BeforeClass
public static void setUpBeforeClass() throws IOException {
	properties = new Properties();
	FileInputStream inStream = new FileInputStream("./resources/others.properties");
	properties.load(inStream);
}

@BeforeMethod
public void setUp() throws Exception {
	driver = DriverFactory.getDriver(DriverNames.CHROME);
	eLearningAuthorCourseTakeTestAndReviewPOM = new ELearningAuthorCourseTakeTestAndReviewPOM(driver); 
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
public void validELearningAuthorCourseTakeTestAndReviewTest() throws InterruptedException {
	eLearningAuthorCourseTakeTestAndReviewPOM.sendUserName("admin");
	eLearningAuthorCourseTakeTestAndReviewPOM.sendPassword("admin@123");
	eLearningAuthorCourseTakeTestAndReviewPOM.clickLoginBtn(); 
	System.out.println("Login successful");
	eLearningAuthorCourseTakeTestAndReviewPOM.clickHomepage();
	eLearningAuthorCourseTakeTestAndReviewPOM.clickCourseCatalog();
	eLearningAuthorCourseTakeTestAndReviewPOM.clickCourseImage();
	eLearningAuthorCourseTakeTestAndReviewPOM.clickTests();
	eLearningAuthorCourseTakeTestAndReviewPOM.clickNewTest();
	System.out.println("Test will be created");
	eLearningAuthorCourseTakeTestAndReviewPOM.sendTestName("online quiz");
	eLearningAuthorCourseTakeTestAndReviewPOM.clickAdvancedSettings();
	Thread.sleep(3000);
	eLearningAuthorCourseTakeTestAndReviewPOM.sendContextTextbox("quiz"); // Iframe criteria.
	eLearningAuthorCourseTakeTestAndReviewPOM.clickFeedback();
	Thread.sleep(3000);
	eLearningAuthorCourseTakeTestAndReviewPOM.clickEnableStartTime();
	eLearningAuthorCourseTakeTestAndReviewPOM.clickStartTime();
	Thread.sleep(3000);
	eLearningAuthorCourseTakeTestAndReviewPOM.ChooseStartDate();
	eLearningAuthorCourseTakeTestAndReviewPOM.clickDone();
	eLearningAuthorCourseTakeTestAndReviewPOM.sendPassPercentage("50");
	eLearningAuthorCourseTakeTestAndReviewPOM.clickProceedToQuestions();
	System.out.println("Test criteria specified");
	
	Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	Expected = "Exercise added";
	assertEquals(Actual, Expected);
	
	eLearningAuthorCourseTakeTestAndReviewPOM.clickMutipleChoice();
	System.out.println("Question pattern selected");
	eLearningAuthorCourseTakeTestAndReviewPOM.sendQuestionTextbox("which is your country?");
	eLearningAuthorCourseTakeTestAndReviewPOM.sendAnswer1Textbox("India"); // Iframe criteria.
	eLearningAuthorCourseTakeTestAndReviewPOM.sendAnswer2Textbox("Pakistan"); // Iframe criteria.
	eLearningAuthorCourseTakeTestAndReviewPOM.sendAnswer3Textbox("Bangladesh"); // Iframe criteria.
	eLearningAuthorCourseTakeTestAndReviewPOM.sendAnswer4Textbox("Nepal"); // Iframe criteria.
	System.out.println("Question and answer options created");
	//eLearningAuthorCourseTakeTestAndReviewPOM.clickFirstOption();
	eLearningAuthorCourseTakeTestAndReviewPOM.clickAddThisQuestion();
	System.out.println("Question added");
	Thread.sleep(5000);
	/*Actual1 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	Expected1 = "Item added";
	assertEquals(Actual1, Expected1);
	
	eLearningAuthorCourseTakeTestAndReviewPOM.clickMutipleChoice2();
	System.out.println("For selection of 2nd question");
	eLearningAuthorCourseTakeTestAndReviewPOM.sendQuestionTextbox2("what is your favourite vehicle?");
	eLearningAuthorCourseTakeTestAndReviewPOM.sendAnswer5Textbox("Pulsar"); // Iframe criteria.
	eLearningAuthorCourseTakeTestAndReviewPOM.sendAnswer6Textbox("TVS"); // Iframe criteria.
	eLearningAuthorCourseTakeTestAndReviewPOM.sendAnswer7Textbox("Royal Enfield"); // Iframe criteria.
	eLearningAuthorCourseTakeTestAndReviewPOM.sendAnswer8Textbox("Enticer"); // Iframe criteria.
	System.out.println("2nd Question and answer options created");*/
	screenShot.captureScreenShot("First"); 
}
}

