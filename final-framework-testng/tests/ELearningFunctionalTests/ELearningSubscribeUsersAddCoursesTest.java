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
import com.training.pom.ELearningSubscribeUsersAddCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearningSubscribeUsersAddCoursesTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningSubscribeUsersAddCoursesPOM eLearningSubscribeUsersAddCoursesPOM;
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
		eLearningSubscribeUsersAddCoursesPOM = new ELearningSubscribeUsersAddCoursesPOM(driver); 
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
		eLearningSubscribeUsersAddCoursesPOM.sendUserName("admin");
		eLearningSubscribeUsersAddCoursesPOM.sendPassword("admin@123");
		eLearningSubscribeUsersAddCoursesPOM.clickLoginBtn(); 
		eLearningSubscribeUsersAddCoursesPOM.clickAdministrationBtn(); //Click on Administration tab.
		eLearningSubscribeUsersAddCoursesPOM.clickSessionsCategoriesList(); // Click on Sessions Categories List
		eLearningSubscribeUsersAddCoursesPOM.clickTrainingSessionsList();  // Click on Training Sessions List
		eLearningSubscribeUsersAddCoursesPOM.clickSubscribeUsersToThisSession(); // Click on Subscribe Users To This Session
		Thread.sleep(3000);
		eLearningSubscribeUsersAddCoursesPOM.sendstudentName("sunil"); // Enter student name in Portal users list text-box.
		eLearningSubscribeUsersAddCoursesPOM.clickSudentNameLink(); // Click on Student Name Link
		eLearningSubscribeUsersAddCoursesPOM.clickSubscribeUsersToThisSessionButton(); // Click on Subscribe Users To This Session Button
		Thread.sleep(3000);
		eLearningSubscribeUsersAddCoursesPOM.clickSessionList(); // Click on Session List
		eLearningSubscribeUsersAddCoursesPOM.clickAddCoursesToThisSession();  // Click on Add Courses To This Session.
		eLearningSubscribeUsersAddCoursesPOM.clickCourse(); // Click on Course.
		Thread.sleep(3000);
		eLearningSubscribeUsersAddCoursesPOM.clickRightArrowButton(); // Click on Right Arrow button.
		eLearningSubscribeUsersAddCoursesPOM.clickAddCoursesToThisSessionButton(); // Click on Add Courses To This Session button.
		System.out.println("Completed");
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected = "Update successful";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}
