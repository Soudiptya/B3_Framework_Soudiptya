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
import com.training.pom.ELearningSubscribeClassToCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearningSubscribeClassToCoursesTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningSubscribeClassToCoursesPOM elearningsubscribeclasstocoursespom;
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
		elearningsubscribeclasstocoursespom = new ELearningSubscribeClassToCoursesPOM(driver); 
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
		elearningsubscribeclasstocoursespom.sendUserName("admin");
		elearningsubscribeclasstocoursespom.sendPassword("admin@123");
		elearningsubscribeclasstocoursespom.clickLoginBtn(); 
		elearningsubscribeclasstocoursespom.clickAdministrationBtn();
		elearningsubscribeclasstocoursespom.clickClassesBtn();
		Thread.sleep(3000);
		elearningsubscribeclasstocoursespom.subscribe_Class_To_Courses();
		System.out.println("Subscribe class to courses page should get displayed");
		Thread.sleep(10000);
		elearningsubscribeclasstocoursespom.selectCouresesOnPlatform();
		System.out.println("Course selected");
		elearningsubscribeclasstocoursespom.arrowRightIcon();
		System.out.println("Click on arrow");
		elearningsubscribeclasstocoursespom.subscribe();
		Thread.sleep(3000);
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected = "Update successful";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}





