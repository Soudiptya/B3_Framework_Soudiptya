package ELearningFunctionalTests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.ELearningLogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearningLogoutTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningLogoutPOM elearninglogoutpom;
	private static Properties properties;
	private ScreenShot screenShot;
	String Actual, Expected;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		elearninglogoutpom = new ELearningLogoutPOM(driver); 
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
	public void validLogoutTest() throws InterruptedException {
		elearninglogoutpom.sendUserName("admin");
		elearninglogoutpom.sendPassword("admin@123");
		elearninglogoutpom.clickLoginBtn(); 
		elearninglogoutpom.clickDropdownBtn();
		Thread.sleep(3000);
		elearninglogoutpom.clickLogoutBtn();
		screenShot.captureScreenShot("First");
		Actual= driver.getCurrentUrl();
	    Expected= "http://elearning.upskills.in/index.php";
	    assertEquals(Actual,Expected);
	    System.out.println("Perfect");
	}
}
