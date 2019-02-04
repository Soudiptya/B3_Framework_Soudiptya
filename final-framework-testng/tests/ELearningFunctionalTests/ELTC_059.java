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
import com.training.pom.ELTC_059POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_059 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_059POM eltc_059pom;
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
		eltc_059pom = new ELTC_059POM(driver); 
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
		eltc_059pom.sendUserName("admin");
		eltc_059pom.sendPassword("admin@123");
		eltc_059pom.clickLoginBtn(); 
		eltc_059pom.clickAdministrationBtn();
		eltc_059pom.clickCreateACourse();
		eltc_059pom.sendTitle("testing");
		eltc_059pom.sendCode("tes");
		Thread.sleep(3000);
		eltc_059pom.deselectTeacher("Site Owner");
		eltc_059pom.selectTeacher("manzoor mehad");
		System.out.println("Teacher selection completed");
		Thread.sleep(3000);
		eltc_059pom.selectCategory("(PROJ) Projects");
		System.out.println("Category selection completed");
		Thread.sleep(3000);
		eltc_059pom.selectLanguage("English");
		System.out.println("Language selection completed");
		eltc_059pom.clickCreateACourseButton();
		eltc_059pom.clickAdministrationTab();
		eltc_059pom.clickClasses();
		eltc_059pom.clickAddClasses();
		eltc_059pom.sendNameTextbox("demo907");
		eltc_059pom.sendDescription("demo907");
		eltc_059pom.selectGroupPermission("Open");
		Thread.sleep(3000);
		eltc_059pom.clickAdd();
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected = "Item added";
		assertEquals(Actual, Expected);
		
		eltc_059pom.clickSubscribeUsersToClass();
		eltc_059pom.clickUsersOnPlatform();
		eltc_059pom.clickRightArrow();
		eltc_059pom.clickSubscribeUsersToClassButton();
		
		Actual1 = driver.findElement(By.xpath("//li[contains(text(),'Classes')]")).getText();
		Expected1 = "Classes";
		assertEquals(Actual1, Expected1);
		
		eltc_059pom.clickSubscribeClassToCourses();
		eltc_059pom.clickCoursesOnPlatform();
		eltc_059pom.clickRightArrowButton();
		
		screenShot.captureScreenShot("First");
	}
}
