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
import com.training.pom.ELTC_058POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_058 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_058POM eltc_058pom;
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
		eltc_058pom = new ELTC_058POM(driver); 
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
		eltc_058pom.sendUserName("admin");
		eltc_058pom.sendPassword("admin@123");
		eltc_058pom.clickLoginBtn(); 
		eltc_058pom.clickAdministrationBtn();
		eltc_058pom.clickCreateACourse();
		eltc_058pom.sendTitle("testing");
		eltc_058pom.sendCode("tes");
		Thread.sleep(3000);
		eltc_058pom.deselectTeacher("Site Owner");
		eltc_058pom.selectTeacher("manzoor mehad");
		System.out.println("Teacher selection completed");
		Thread.sleep(3000);
		eltc_058pom.selectCategory("(PROJ) Projects");
		System.out.println("Category selection completed");
		Thread.sleep(3000);
		eltc_058pom.selectLanguage("English");
		System.out.println("Language selection completed");
		eltc_058pom.clickCreateACourseButton();
		eltc_058pom.clickAdministrationTab();
		eltc_058pom.clickAddATrainingSession();
		eltc_058pom.sendSessionName("english training session");
		eltc_058pom.clickNextStep();
		eltc_058pom.clickCourseSelection();
		eltc_058pom.clickRightArrow();
		eltc_058pom.clickNextStepButton();
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected = "Update successful";
		assertEquals(Actual, Expected);
		
		eltc_058pom.sendStudentName("sunil");
		eltc_058pom.SelectStudentName();
		eltc_058pom.clickFinishSessionCreation();
		
		Actual1 = driver.findElement(By.xpath("//li[contains(text(),'Session')]")).getText();
		Expected1 = "Session";
		assertEquals(Actual1, Expected1);
		
		screenShot.captureScreenShot("First");
	}
}

