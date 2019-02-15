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
import com.training.pom.ELearningCreateCourseCommentAndReportGenerationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
 * Author                : Soudiptya Kumar Basu
 * Test Case ID          : ELTC_086
 * Test Case Description : To verify whether application allows teacher to create course with project, student to comment on the task & admin to generate the report.
 * PreCondition          : 1. User should have launched the application 
 *                         2. User should have logged in as teacher and present in Home page
 */

public class ELearningCreateCourseCommentAndReportGenerationTest {
  
  private WebDriver driver;
	private String baseUrl;
	private ELearningCreateCourseCommentAndReportGenerationPOM eLearningCreateCourseCommentAndReportGenerationPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	String Actual;
	String Actual1;
	String Actual2;
	String Actual3;
	String Actual4;
	String Actual5;
	String Actual6;
	String Expected;
	String Expected1;
	String Expected2;
	String Expected3;
	String Expected4;
	String Expected5;
	String Expected6;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eLearningCreateCourseCommentAndReportGenerationPOM = new ELearningCreateCourseCommentAndReportGenerationPOM(driver); 
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
	@Test (priority=0)
	public void validELearningCreateCourseCommentAndReportGenerationTest() throws InterruptedException {
		eLearningCreateCourseCommentAndReportGenerationPOM.sendUserName("admin");
		eLearningCreateCourseCommentAndReportGenerationPOM.sendPassword("admin@123");
		eLearningCreateCourseCommentAndReportGenerationPOM.clickLoginBtn(); 
		eLearningCreateCourseCommentAndReportGenerationPOM.clickHomepage();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickCreateACourse();
		eLearningCreateCourseCommentAndReportGenerationPOM.sendCourseName("selenium");
		eLearningCreateCourseCommentAndReportGenerationPOM.clickAdvancedSettings();
		Thread.sleep(3000);
		eLearningCreateCourseCommentAndReportGenerationPOM.selectCategory("(PROJ) Projects");
		eLearningCreateCourseCommentAndReportGenerationPOM.sendCourseCode("8975rfce");
		eLearningCreateCourseCommentAndReportGenerationPOM.selectLanguage("English");
		eLearningCreateCourseCommentAndReportGenerationPOM.clickCreateThisCourse();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickAddAnIntroduction();
		Thread.sleep(3000);
		eLearningCreateCourseCommentAndReportGenerationPOM.sendContextTextbox("this is a selenium course");
		eLearningCreateCourseCommentAndReportGenerationPOM.clickSaveIntroText();
		
		Actual = driver.findElement(By.xpath("//div[contains(text(),'Intro was updated')]")).getText();
		Expected = "Intro was updated";
		assertEquals(Actual, Expected);
		
		eLearningCreateCourseCommentAndReportGenerationPOM.clickHomepage1();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickCourseCatalog();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickCourseImage();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickCourseDescription();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickDescription();
		eLearningCreateCourseCommentAndReportGenerationPOM.sendTitle("selenium course for beginners");
		eLearningCreateCourseCommentAndReportGenerationPOM.sendContextTextbox1("selenium course for beginners");
		eLearningCreateCourseCommentAndReportGenerationPOM.clickSave();
		
		Actual1 = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected1 = "The description has been updated";
		assertEquals(Actual1, Expected1);
		
		eLearningCreateCourseCommentAndReportGenerationPOM.clickObjectives();
		eLearningCreateCourseCommentAndReportGenerationPOM.sendObjectiveTitle("selenium course for beginners");
		eLearningCreateCourseCommentAndReportGenerationPOM.sendContextTextbox2("selenium course for beginners");
		eLearningCreateCourseCommentAndReportGenerationPOM.clickSaveObjective();
		
		Actual2 = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected2 = "The description has been updated";
		assertEquals(Actual2, Expected2);
		
		eLearningCreateCourseCommentAndReportGenerationPOM.clickTopics();
		eLearningCreateCourseCommentAndReportGenerationPOM.sendTopicsTitle("selenium course for beginners");
		eLearningCreateCourseCommentAndReportGenerationPOM.sendContextTextbox3("selenium course for beginners");
		eLearningCreateCourseCommentAndReportGenerationPOM.clickSaveTopics();
		
		Actual3 = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Expected3 = "The description has been updated";
		assertEquals(Actual3, Expected3);
		
		eLearningCreateCourseCommentAndReportGenerationPOM.clickHomepage2();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickCourseCatalog2();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickCourseImage2();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickProjects();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickCreateNewProject();
		eLearningCreateCourseCommentAndReportGenerationPOM.sendProjectTitle("E Learning");
		eLearningCreateCourseCommentAndReportGenerationPOM.sendProjectSubTitle("E Learning Project");
		eLearningCreateCourseCommentAndReportGenerationPOM.clickSaveBlog();
		
		Actual4 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected4 = "The project has been added.";
		assertEquals(Actual4, Expected4);
		
		eLearningCreateCourseCommentAndReportGenerationPOM.clickProjectLink();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickNewTask();
		eLearningCreateCourseCommentAndReportGenerationPOM.sendPostTitle("design");
		eLearningCreateCourseCommentAndReportGenerationPOM.clickSaveButton();
		
		Actual5 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected5 = "The article has been added.";
		assertEquals(Actual5, Expected5);
		
		eLearningCreateCourseCommentAndReportGenerationPOM.clickRolesManagement();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickAddANewRole();
		eLearningCreateCourseCommentAndReportGenerationPOM.sendTaskTitle("developer");
		eLearningCreateCourseCommentAndReportGenerationPOM.clickSaveBtn();
		
		Actual6 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Expected6 = "The task has been created";
		assertEquals(Actual6, Expected6);
		
		eLearningCreateCourseCommentAndReportGenerationPOM.clickAssignRoles();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickValidate();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickUsersManagement();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickCheckbox();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickRegister();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickDropdown();
		eLearningCreateCourseCommentAndReportGenerationPOM.clickLogout();
		screenShot.captureScreenShot("First");
		
		
	}
}

