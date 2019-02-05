package ELearningFunctionalTests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELearningClassCreationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ELearningClassCreation {
	private WebDriver driver;
	private String baseUrl;
	private ELearningClassCreationPOM elearningclasscreationpom;
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
		elearningclasscreationpom = new ELearningClassCreationPOM(driver); 
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
		elearningclasscreationpom.sendUserName("admin");
		elearningclasscreationpom.sendPassword("admin@123");
		elearningclasscreationpom.clickLoginBtn(); 
		elearningclasscreationpom.clickAdministrationBtn();
		elearningclasscreationpom.clickClassesBtn();
		elearningclasscreationpom.clickAddClassesBtn();
		elearningclasscreationpom.sendName("demo109");
		elearningclasscreationpom.sendDescription("demo109");
		Thread.sleep(3000);
		elearningclasscreationpom.selectGroupPermission("Open");
		elearningclasscreationpom.clickAddBtn();
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected = "Item added";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}


