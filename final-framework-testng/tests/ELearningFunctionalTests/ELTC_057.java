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
import com.training.pom.ELTC_057POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_057 {
	private WebDriver driver;
	private String baseUrl;
	private ELTC_057POM eltc_057pom;
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
		eltc_057pom = new ELTC_057POM(driver); 
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
		eltc_057pom.sendUserName("admin");
		eltc_057pom.sendPassword("admin@123");
		eltc_057pom.clickLoginBtn(); 
		eltc_057pom.clickAdministrationBtn(); //Click on Administration tab.
		eltc_057pom.clickCareersAndPromotions(); //Click on Careers And Promotions.
		eltc_057pom.clickCareers(); //Click on Careers
		eltc_057pom.clickAdd();  //Click on Add
		Thread.sleep(3000);
		eltc_057pom.sendName("QA"); // Enter valid credentials in Name text-box.
		eltc_057pom.clickAddButton(); //Click on Add button.
		System.out.println("Add1 completed");
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected = "Item added";
		assertEquals(Actual, Expected);
		
		eltc_057pom.clickCareersAndPromotionsLink(); //Click on Careers And Promotions Link.
		eltc_057pom.clickPromotionsIcon(); //Click on Promotions Icon.
		eltc_057pom.clickAddIcon(); //Click on Add Icon.
		eltc_057pom.sendNameTextbox("QA for Tester"); // Enter valid credentials in Name text-box.
		eltc_057pom.AddButtonClick(); //Click on Add
		System.out.println("Add2 completed");
		
		Actual1 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected1 = "Item added";
		assertEquals(Actual1, Expected1);
		
		eltc_057pom.clickAddATrainingSession(); //Click on Add a Training Session Icon.
		eltc_057pom.sendAddSessionName("new country"); //Enter valid credentials in Session name text-box.
		eltc_057pom.ClickNextStep(); //Click on Next Step button.
		eltc_057pom.ClickCourse();
		eltc_057pom.ClickRightArrow();
		eltc_057pom.ClickNextStep1();
		eltc_057pom.sendPortalUserName("sunil");
		eltc_057pom.ClickStudentNameLink();
		eltc_057pom.ClickFinishSessionCreation();
		System.out.println("Add3 completed");
		
		Actual2 = driver.findElement(By.xpath("//li[contains(text(),'Session')]")).getText();
		Expected2 = "Session";
		assertEquals(Actual2, Expected2);
		screenShot.captureScreenShot("First");
	}
}



