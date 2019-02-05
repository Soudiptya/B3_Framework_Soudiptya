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
import com.training.pom.ELearningAddCareerPromotionSessionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearningAddCareerPromotionSessionTest {
	private WebDriver driver;
	private String baseUrl;
	private ELearningAddCareerPromotionSessionPOM eLearningAddCareerPromotionSessionPOM;
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
		eLearningAddCareerPromotionSessionPOM = new ELearningAddCareerPromotionSessionPOM(driver); 
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
		eLearningAddCareerPromotionSessionPOM.sendUserName("admin");
		eLearningAddCareerPromotionSessionPOM.sendPassword("admin@123");
		eLearningAddCareerPromotionSessionPOM.clickLoginBtn(); 
		eLearningAddCareerPromotionSessionPOM.clickAdministrationBtn(); //Click on Administration tab.
		eLearningAddCareerPromotionSessionPOM.clickCareersAndPromotions(); //Click on Careers And Promotions.
		eLearningAddCareerPromotionSessionPOM.clickCareers(); //Click on Careers
		eLearningAddCareerPromotionSessionPOM.clickAdd();  //Click on Add
		Thread.sleep(3000);
		eLearningAddCareerPromotionSessionPOM.sendName("QA"); // Enter valid credentials in Name text-box.
		eLearningAddCareerPromotionSessionPOM.clickAddButton(); //Click on Add button.
		System.out.println("Add1 completed");
		
		Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected = "Item added";
		assertEquals(Actual, Expected);
		
		eLearningAddCareerPromotionSessionPOM.clickCareersAndPromotionsLink(); //Click on Careers And Promotions Link.
		eLearningAddCareerPromotionSessionPOM.clickPromotionsIcon(); //Click on Promotions Icon.
		eLearningAddCareerPromotionSessionPOM.clickAddIcon(); //Click on Add Icon.
		eLearningAddCareerPromotionSessionPOM.sendNameTextbox("QA for Tester"); // Enter valid credentials in Name text-box.
		eLearningAddCareerPromotionSessionPOM.AddButtonClick(); //Click on Add
		System.out.println("Add2 completed");
		
		Actual1 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected1 = "Item added";
		assertEquals(Actual1, Expected1);
		
		eLearningAddCareerPromotionSessionPOM.clickAddATrainingSession(); //Click on Add a Training Session Icon.
		eLearningAddCareerPromotionSessionPOM.sendAddSessionName("new openings"); //Enter valid credentials in Session name text-box.
		eLearningAddCareerPromotionSessionPOM.ClickNextStep(); //Click on Next Step button.
		eLearningAddCareerPromotionSessionPOM.ClickCourse();
		eLearningAddCareerPromotionSessionPOM.ClickRightArrow();
		eLearningAddCareerPromotionSessionPOM.ClickNextStep1();
		eLearningAddCareerPromotionSessionPOM.sendPortalUserName("sunil");
		eLearningAddCareerPromotionSessionPOM.ClickStudentNameLink();
		eLearningAddCareerPromotionSessionPOM.ClickFinishSessionCreation();
		System.out.println("Add3 completed");
		
		Actual2 = driver.findElement(By.xpath("//li[contains(text(),'Session')]")).getText();
		Expected2 = "Session";
		assertEquals(Actual2, Expected2);
		screenShot.captureScreenShot("First");
	}
}

