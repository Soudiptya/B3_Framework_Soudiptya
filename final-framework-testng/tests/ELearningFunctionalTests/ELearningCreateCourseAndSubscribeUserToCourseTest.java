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
import com.training.pom.ELearningCreateCourseAndSubscribeUserToCoursePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearningCreateCourseAndSubscribeUserToCourseTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningCreateCourseAndSubscribeUserToCoursePOM eLearningCreateCourseAndSubscribeUserToCoursePOM;
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
		eLearningCreateCourseAndSubscribeUserToCoursePOM = new ELearningCreateCourseAndSubscribeUserToCoursePOM(driver); 
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
		eLearningCreateCourseAndSubscribeUserToCoursePOM.sendUserName("admin");
		eLearningCreateCourseAndSubscribeUserToCoursePOM.sendPassword("admin@123");
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickLoginBtn(); 
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickAdministrationBtn();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickCreateACourse();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.sendTitle("testing");
		eLearningCreateCourseAndSubscribeUserToCoursePOM.sendCode("tes");
		Thread.sleep(3000);
		eLearningCreateCourseAndSubscribeUserToCoursePOM.deselectTeacher("Site Owner");
		eLearningCreateCourseAndSubscribeUserToCoursePOM.selectTeacher("manzoor mehad");
		System.out.println("Teacher selection completed");
		Thread.sleep(3000);
		eLearningCreateCourseAndSubscribeUserToCoursePOM.selectCategory("(PROJ) Projects");
		System.out.println("Category selection completed");
		Thread.sleep(3000);
		eLearningCreateCourseAndSubscribeUserToCoursePOM.selectLanguage("English");
		System.out.println("Language selection completed");
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickCreateACourseButton();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickAdministrationTab();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickClasses();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickAddClasses();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.sendNameTextbox("demo915");
		eLearningCreateCourseAndSubscribeUserToCoursePOM.sendDescription("demo915");
		eLearningCreateCourseAndSubscribeUserToCoursePOM.selectGroupPermission("Open");
		Thread.sleep(3000);
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickAdd();
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected = "Item added";
		assertEquals(Actual, Expected);
		
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickSubscribeUsersToClass();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickUsersOnPlatform();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickRightArrow();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickSubscribeUsersToClassButton();
		
		Actual1 = driver.findElement(By.xpath("//li[contains(text(),'Classes')]")).getText();
		Expected1 = "Classes";
		assertEquals(Actual1, Expected1);
		
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickSubscribeClassToCourses();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickCoursesOnPlatform();
		eLearningCreateCourseAndSubscribeUserToCoursePOM.clickRightArrowButton();
		
		screenShot.captureScreenShot("First");
	}
}
