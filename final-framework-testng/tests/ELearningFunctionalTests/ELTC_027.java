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
import com.training.pom.ELTC_027POM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_027 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_027POM eltc_027pom;
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
		eltc_027pom = new ELTC_027POM(driver); 
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
		eltc_027pom.sendUserName("admin");
		eltc_027pom.sendPassword("admin@123");
		eltc_027pom.clickLoginBtn(); 
		eltc_027pom.clickAdministrationBtn();
		eltc_027pom.clickClassesBtn();
		Thread.sleep(3000);
		eltc_027pom.clickSubscribeUsersToClassBtn();
		System.out.println("demo page should get displayed");
		Thread.sleep(10000);
		eltc_027pom.selectUsersOnPlatform();
		System.out.println("User selected");
		eltc_027pom.arrowRightIcon();
		System.out.println("Click on arrow");
		eltc_027pom.subscribe();
		Actual = driver.getCurrentUrl();
		Expected = "http://elearning.hommelle.com/main/admin/usergroups.php";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}


