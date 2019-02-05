package ELearningFunctionalTests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELearningSubscribeUserToClassPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearningSubscribeUserToClassTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningSubscribeUserToClassPOM elearningsubscribeusertoclasspom;
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
		elearningsubscribeusertoclasspom = new ELearningSubscribeUserToClassPOM(driver); 
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
		elearningsubscribeusertoclasspom.sendUserName("admin");
		elearningsubscribeusertoclasspom.sendPassword("admin@123");
		elearningsubscribeusertoclasspom.clickLoginBtn(); 
		elearningsubscribeusertoclasspom.clickAdministrationBtn();
		elearningsubscribeusertoclasspom.clickClassesBtn();
		Thread.sleep(3000);
		elearningsubscribeusertoclasspom.clickSubscribeUsersToClassBtn();
		System.out.println("demo page should get displayed");
		Thread.sleep(10000);
		elearningsubscribeusertoclasspom.selectUsersOnPlatform();
		System.out.println("User selected");
		Thread.sleep(3000);
		elearningsubscribeusertoclasspom.arrowRightIcon();
		System.out.println("Click on arrow");
		Thread.sleep(3000);
		elearningsubscribeusertoclasspom.subscribe();
		Actual = driver.getCurrentUrl();
		Expected = "http://elearning.upskills.in/main/admin/usergroups.php";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}



