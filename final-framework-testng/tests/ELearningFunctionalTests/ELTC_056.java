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
import com.training.pom.ELTC_056POM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_056 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_056POM eltc_056pom;
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
		eltc_056pom = new ELTC_056POM(driver); 
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
		eltc_056pom.sendUserName("admin");
		eltc_056pom.sendPassword("admin@123");
		eltc_056pom.clickLoginBtn(); 
		eltc_056pom.clickAdministrationBtn(); //Click on Administration tab.
		eltc_056pom.clickSessionsCategoriesList(); // Click on Sessions Categories List
		eltc_056pom.clickTrainingSessionsList();  // Click on Training Sessions List
		eltc_056pom.clickSubscribeUsersToThisSession(); // Click on Subscribe Users To This Session
		Thread.sleep(3000);
		eltc_056pom.sendstudentName("sunil"); // Enter student name in Portal users list text-box.
		eltc_056pom.clickSudentNameLink(); // Click on Student Name Link
		eltc_056pom.clickSubscribeUsersToThisSessionButton(); // Click on Subscribe Users To This Session Button
		Thread.sleep(3000);
		eltc_056pom.clickSessionList(); // Click on Session List
		eltc_056pom.clickAddCoursesToThisSession();  // Click on Add Courses To This Session.
		eltc_056pom.clickCourse(); // Click on Course.
		Thread.sleep(3000);
		eltc_056pom.clickRightArrowButton(); // Click on Right Arrow button.
		eltc_056pom.clickAddCoursesToThisSessionButton(); // Click on Add Courses To This Session button.
		System.out.println("ELTC_056 completed");
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected = "Update successful";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}


