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
import com.training.pom.ELTC_028POM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_028 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_028POM eltc_028pom;
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
		eltc_028pom = new ELTC_028POM(driver); 
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
		eltc_028pom.sendUserName("admin");
		eltc_028pom.sendPassword("admin@123");
		eltc_028pom.clickLoginBtn(); 
		eltc_028pom.clickAdministrationBtn();
		eltc_028pom.clickClassesBtn();
		Thread.sleep(3000);
		eltc_028pom.subscribe_Class_To_Courses();
		System.out.println("Subscribe class to courses page should get displayed");
		Thread.sleep(10000);
		eltc_028pom.selectCouresesOnPlatform();
		System.out.println("Course selected");
		eltc_028pom.arrowRightIcon();
		System.out.println("Click on arrow");
		eltc_028pom.subscribe();
		Thread.sleep(3000);
		//Actual = driver.getCurrentUrl();
		//Expected = "http://elearning.hommelle.com/main/admin/usergroups.php";
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected = "Update successful";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("First");
	}
}




