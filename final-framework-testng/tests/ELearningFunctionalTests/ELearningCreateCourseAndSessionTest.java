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
import com.training.pom.ELearningCreateCourseAndSessionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearningCreateCourseAndSessionTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningCreateCourseAndSessionPOM eLearningCreateCourseAndSessionPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	String Actual;
	String Actual1;
	String Expected;
	String Expected1;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eLearningCreateCourseAndSessionPOM = new ELearningCreateCourseAndSessionPOM(driver); 
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
	public void validLoginTest() throws InterruptedException {
		eLearningCreateCourseAndSessionPOM.sendUserName("admin");
		eLearningCreateCourseAndSessionPOM.sendPassword("admin@123");
		eLearningCreateCourseAndSessionPOM.clickLoginBtn(); 
		eLearningCreateCourseAndSessionPOM.clickAdministrationBtn();
		eLearningCreateCourseAndSessionPOM.clickCreateACourse();
		eLearningCreateCourseAndSessionPOM.sendTitle("testing");
		eLearningCreateCourseAndSessionPOM.sendCode("tes");
		Thread.sleep(3000);
		eLearningCreateCourseAndSessionPOM.deselectTeacher("Site Owner");
		eLearningCreateCourseAndSessionPOM.selectTeacher("manzoor mehad");
		System.out.println("Teacher selection completed");
		Thread.sleep(3000);
		eLearningCreateCourseAndSessionPOM.selectCategory("(PROJ) Projects");
		System.out.println("Category selection completed");
		Thread.sleep(3000);
		eLearningCreateCourseAndSessionPOM.selectLanguage("English");
		System.out.println("Language selection completed");
		eLearningCreateCourseAndSessionPOM.clickCreateACourseButton();
		eLearningCreateCourseAndSessionPOM.clickAdministrationTab();
		eLearningCreateCourseAndSessionPOM.clickAddATrainingSession();
		eLearningCreateCourseAndSessionPOM.sendSessionName("geography training session");
		eLearningCreateCourseAndSessionPOM.clickNextStep();
		eLearningCreateCourseAndSessionPOM.clickCourseSelection();
		eLearningCreateCourseAndSessionPOM.clickRightArrow();
		eLearningCreateCourseAndSessionPOM.clickNextStepButton();
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected = "Update successful";
		assertEquals(Actual, Expected);
		
		eLearningCreateCourseAndSessionPOM.sendStudentName("sunil");
		eLearningCreateCourseAndSessionPOM.SelectStudentName();
		eLearningCreateCourseAndSessionPOM.clickFinishSessionCreation();
		
		Actual1 = driver.findElement(By.xpath("//li[contains(text(),'Session')]")).getText();
		Expected1 = "Session";
		assertEquals(Actual1, Expected1);
		
		screenShot.captureScreenShot("First");
	}
}
