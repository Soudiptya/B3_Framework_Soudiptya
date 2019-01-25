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

import com.training.pom.ELTC_030POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_030 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_030POM eltc_030pom;
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
		eltc_030pom = new ELTC_030POM(driver); 
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
		eltc_030pom.sendUserName("admin");
		eltc_030pom.sendPassword("admin@123");
		eltc_030pom.clickLoginBtn(); 
		eltc_030pom.clickDropdownBtn();
		Thread.sleep(3000);
		eltc_030pom.clickLogoutBtn();
		screenShot.captureScreenShot("First");
		Actual= driver.getCurrentUrl();
	    Expected= "http://elearning.hommelle.com/index.php";
	    assertEquals(Actual,Expected);
	    System.out.println("Perfect");
	}
}








