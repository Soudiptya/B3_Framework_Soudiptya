package ELearningFunctionalTests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.ELTC_029POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_029 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_029POM eltc_029pom;
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
		eltc_029pom = new ELTC_029POM(driver); 
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
		eltc_029pom.sendUserName("admin");
		eltc_029pom.sendPassword("admin@123");
		eltc_029pom.clickLoginBtn(); 
		eltc_029pom.clickAdministrationBtn();
		eltc_029pom.clickClassesBtn();
		Thread.sleep(3000);
		eltc_029pom.clickDeleteClassBtn();
		
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Thread.sleep(3000);
		alert.accept();
		Actual = driver.getCurrentUrl();
		Expected = "http://elearning.hommelle.com/main/admin/usergroups.php";
		assertEquals(Actual, Expected);
		
		screenShot.captureScreenShot("First");
	}
}



