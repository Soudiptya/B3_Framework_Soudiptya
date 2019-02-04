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
import com.training.pom.ELTC_060POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_060 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_060POM eltc_060pom;
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
		eltc_060pom = new ELTC_060POM(driver); 
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
		eltc_060pom.sendUserName("admin");
		eltc_060pom.sendPassword("admin@123");
		eltc_060pom.clickLoginBtn(); 
		eltc_060pom.clickAdministrationBtn(); //Click on Administration tab.
		eltc_060pom.clickAddAUser(); //Click on Add A User.
		eltc_060pom.sendFirstName("manzoor"); // Provide First Name.
		eltc_060pom.sendLastName("mehadi"); // Provide Last Name.
		System.out.println("Test case 1 passed");
		eltc_060pom.sendEmail("manzoor@gmail.com"); // Provide Email ID.
		eltc_060pom.sendPhoneNumber("9876543210"); // Provide Phone Number.
		eltc_060pom.sendLoginBox("manzoor542765"); // Provide credential in Login Text-box.
		System.out.println("Test case 2 passed");
		
		Thread.sleep(3000);
		eltc_060pom.SelectEnterPasswordButton();
		Thread.sleep(3000);
		eltc_060pom.sendValidPassword("manzoor");
		Thread.sleep(3000);
		eltc_060pom.selectProfile("Trainer");
		eltc_060pom.clickAdd();
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected = "The user has been added: manzoor mehadi";
		assertEquals(Actual, Expected);
		
		eltc_060pom.clickAdministrationTab();
		eltc_060pom.clickClasses();
		eltc_060pom.clickAddClasses();
		eltc_060pom.sendName("state32");
		eltc_060pom.sendDescription("state32");
		Thread.sleep(3000);
		eltc_060pom.selectGroupPermission("Open");
		eltc_060pom.clickAddBtn();
		System.out.println("Test case 3 passed");
		
		Actual1 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected1 = "Item added";
		assertEquals(Actual1, Expected1);
		
		eltc_060pom.clickSubscribeUsersToClass();
		eltc_060pom.clickUsersOnPlatform();
		eltc_060pom.clickRightArrow();
		eltc_060pom.clickSubscribeUsersToClassBtn();
		System.out.println("Test case 4 passed");
		
		eltc_060pom.clickSubscribeClassToCourses();
		eltc_060pom.clickCoursesOnThePlatform();
		eltc_060pom.clickRightArrowBtn();
		eltc_060pom.clickSubscribeClassToCoursesBtn();
		System.out.println("Test case 5 passed");
		
		Actual2 = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected2 = "Update successful";
		assertEquals(Actual2, Expected2);
		
		screenShot.captureScreenShot("First");
	}
}



