package ELearningFunctionalTests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELearningLogin;
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

public class ELearningLoginTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningLogin elearninglogin;
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
		elearninglogin = new ELearningLogin(driver); 
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
		elearninglogin.sendUserName("admin");
		elearninglogin.sendPassword("admin@123");
		elearninglogin.clickLoginBtn(); 
		elearninglogin.clickAdministrationBtn();
		elearninglogin.clickClassesBtn();
		elearninglogin.clickAddClassesBtn();
		elearninglogin.sendName("demo");
		elearninglogin.sendDescription("demo");
		Thread.sleep(3000);
		elearninglogin.selectGroupPermissions("Open");
		elearninglogin.clickAddBtn();
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected = "Item added";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}

