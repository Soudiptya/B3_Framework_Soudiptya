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
import com.training.pom.ELearningCreateUserAndSubscribeUserToClassPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearningCreateUserAndSubscribeUserToClassTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningCreateUserAndSubscribeUserToClassPOM eLearningCreateUserAndSubscribeUserToClassPOM;
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
		eLearningCreateUserAndSubscribeUserToClassPOM = new ELearningCreateUserAndSubscribeUserToClassPOM(driver); 
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
		eLearningCreateUserAndSubscribeUserToClassPOM.sendUserName("admin");
		eLearningCreateUserAndSubscribeUserToClassPOM.sendPassword("admin@123");
		eLearningCreateUserAndSubscribeUserToClassPOM.clickLoginBtn(); 
		eLearningCreateUserAndSubscribeUserToClassPOM.clickAdministrationBtn(); //Click on Administration tab.
		eLearningCreateUserAndSubscribeUserToClassPOM.clickAddAUser(); //Click on Add A User.
		eLearningCreateUserAndSubscribeUserToClassPOM.sendFirstName("manzoor"); // Provide First Name.
		eLearningCreateUserAndSubscribeUserToClassPOM.sendLastName("mehadi"); // Provide Last Name.
		System.out.println("Test case 1 passed");
		eLearningCreateUserAndSubscribeUserToClassPOM.sendEmail("manzoor@gmail.com"); // Provide Email ID.
		eLearningCreateUserAndSubscribeUserToClassPOM.sendPhoneNumber("9876543210"); // Provide Phone Number.
		eLearningCreateUserAndSubscribeUserToClassPOM.sendLoginBox("manzoor254321"); // Provide credential in Login Text-box.
		System.out.println("Test case 2 passed");
		
		Thread.sleep(3000);
		eLearningCreateUserAndSubscribeUserToClassPOM.SelectEnterPasswordButton();
		Thread.sleep(3000);
		eLearningCreateUserAndSubscribeUserToClassPOM.sendValidPassword("manzoor");
		Thread.sleep(3000);
		eLearningCreateUserAndSubscribeUserToClassPOM.selectProfile("Trainer");
		eLearningCreateUserAndSubscribeUserToClassPOM.clickAdd();
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected = "The user has been added: manzoor mehadi";
		assertEquals(Actual, Expected);
		
		eLearningCreateUserAndSubscribeUserToClassPOM.clickAdministrationTab();
		eLearningCreateUserAndSubscribeUserToClassPOM.clickClasses();
		eLearningCreateUserAndSubscribeUserToClassPOM.clickAddClasses();
		eLearningCreateUserAndSubscribeUserToClassPOM.sendName("state93");
		eLearningCreateUserAndSubscribeUserToClassPOM.sendDescription("state93");
		Thread.sleep(3000);
		eLearningCreateUserAndSubscribeUserToClassPOM.selectGroupPermission("Open");
		eLearningCreateUserAndSubscribeUserToClassPOM.clickAddBtn();
		System.out.println("Test case 3 passed");
		
		Actual1 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected1 = "Item added";
		assertEquals(Actual1, Expected1);
		
		eLearningCreateUserAndSubscribeUserToClassPOM.clickSubscribeUsersToClass();
		eLearningCreateUserAndSubscribeUserToClassPOM.clickUsersOnPlatform();
		eLearningCreateUserAndSubscribeUserToClassPOM.clickRightArrow();
		eLearningCreateUserAndSubscribeUserToClassPOM.clickSubscribeUsersToClassBtn();
		System.out.println("Test case 4 passed");
		
		eLearningCreateUserAndSubscribeUserToClassPOM.clickSubscribeClassToCourses();
		eLearningCreateUserAndSubscribeUserToClassPOM.clickCoursesOnThePlatform();
		eLearningCreateUserAndSubscribeUserToClassPOM.clickRightArrowBtn();
		eLearningCreateUserAndSubscribeUserToClassPOM.clickSubscribeClassToCoursesBtn();
		System.out.println("Test case 5 passed");
		
		Actual2 = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected2 = "Update successful";
		assertEquals(Actual2, Expected2);
		
		screenShot.captureScreenShot("First");
	}
}
