package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * Author                : Soudiptya Kumar Basu
 * Test Case ID          : ELTC_090
 * Test Case Description : To verify whether application allows teacher to author a test for a course, student to take the test & teacher to review & send the response.
 * PreCondition          : 1. User should have launched the application 
 */

public class ELearningAuthorCourseTakeTestAndReviewPOM {

private WebDriver driver;
	
	public ELearningAuthorCourseTakeTestAndReviewPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	@FindBy(id="password")
	private WebElement password;
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	@FindBy(xpath="//a[@title='Homepage']")
	private WebElement Homepage; 
	
	public void clickHomepage() {
		this.Homepage.click(); 
	}
	
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement CourseCatalog; 
	
	public void clickCourseCatalog() {
		this.CourseCatalog.click(); 
	}
	
	@FindBy(xpath="//a[@title='1er']//img[@class='img-responsive']")
	private WebElement CourseImage; 
	
	public void clickCourseImage() {
		this.CourseImage.click(); 
	}
	
	@FindBy(xpath="//img[@id='toolimage_1340']")
	private WebElement Tests; 
	
	public void clickTests() {
		this.Tests.click(); 
	}
	
	@FindBy(xpath="//img[@title='Create a new test']")
	private WebElement NewTest; 
	
	public void clickNewTest() {
		this.NewTest.click(); 
	}
	
	@FindBy(xpath="//input[@name='exerciseTitle']")
	private WebElement TestName; 
	
	public void sendTestName(String TestName) {
		this.TestName.clear();
		this.TestName.sendKeys(TestName);
	}
	
	@FindBy(xpath="//button[@id='advanced_params']")
	private WebElement AdvancedSettings; 
	
	public void clickAdvancedSettings() {
		this.AdvancedSettings.click(); 
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, exerciseDescription']")
	private WebElement ContextTextbox;
	
	@FindBy(id="cke_1_contents")
	private WebElement EditableTextbox;
		
	public void sendContextTextbox(String EditableTextbox) {
		driver.switchTo().frame(ContextTextbox);
		this.EditableTextbox = driver.switchTo().activeElement();
		this.EditableTextbox.sendKeys(EditableTextbox);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//label[contains(text(),'At end of test')]")
	private WebElement Feedback; 
	
	public void clickFeedback() {
		this.Feedback.isSelected(); 
	}
	
	@FindBy(xpath="//label[contains(text(),'Enable start time')]")
	private WebElement EnableStartTime; 
	
	public void clickEnableStartTime() {
		this.EnableStartTime.click();
	}
	
	@FindBy(xpath="//div[@id='start_date_div']//img[@title='Select date']")
	private WebElement StartTime; 
	
	public void clickStartTime() {
		this.StartTime.click();
	}
	
	@FindBy(xpath="//a[contains(text(),'14')]")
	private WebElement ChooseStartDate; 
	
	public void ChooseStartDate() {
		this.ChooseStartDate.click();
	}
	
	@FindBy(xpath="//button[contains(text(),'Done')]")
	private WebElement Done; 
	
	public void clickDone() {
		this.Done.click();
	}
	
	@FindBy(xpath="//input[@id='pass_percentage']")
	private WebElement PassPercentage; 
	
	public void sendPassPercentage(String PassPercentage) {
		this.PassPercentage.clear();
		this.PassPercentage.sendKeys(PassPercentage);
	}
	
	@FindBy(xpath="//button[@id='exercise_admin_submitExercise']")
	private WebElement ProceedToQuestions; 
	
	public void clickProceedToQuestions() {
		this.ProceedToQuestions.click();
	}
	
	@FindBy(xpath="//img[@title='Multiple choice']")
	private WebElement MutipleChoice; 
	
	public void clickMutipleChoice() {
		this.MutipleChoice.click();
	}
	
	@FindBy(xpath="//input[@name='questionName']")
	private WebElement QuestionTextbox; 
	
	public void sendQuestionTextbox(String QuestionTextbox) {
		this.QuestionTextbox.clear();
		this.QuestionTextbox.sendKeys(QuestionTextbox);
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[1]']")
	private WebElement Answer1Textbox;
	
	@FindBy(id="cke_2_contents")
	private WebElement Editable1Textbox;
		
	public void sendAnswer1Textbox(String Editable1Textbox) {
		driver.switchTo().frame(Answer1Textbox);
		this.Editable1Textbox = driver.switchTo().activeElement();
		this.Editable1Textbox.sendKeys(Editable1Textbox);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[2]']")
	private WebElement Answer2Textbox;
	
	@FindBy(id="cke_4_contents")
	private WebElement Editable2Textbox;
		
	public void sendAnswer2Textbox(String Editable2Textbox) {
		driver.switchTo().frame(Answer2Textbox);
		this.Editable2Textbox = driver.switchTo().activeElement();
		this.Editable2Textbox.sendKeys(Editable2Textbox);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[3]']")
	private WebElement Answer3Textbox;
	
	@FindBy(id="cke_6_contents")
	private WebElement Editable3Textbox;
		
	public void sendAnswer3Textbox(String Editable3Textbox) {
		driver.switchTo().frame(Answer3Textbox);
		this.Editable3Textbox = driver.switchTo().activeElement();
		this.Editable3Textbox.sendKeys(Editable3Textbox);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[4]']")
	private WebElement Answer4Textbox;
	
	@FindBy(id="cke_8_contents")
	private WebElement Editable4Textbox;
		
	public void sendAnswer4Textbox(String Editable4Textbox) {
		driver.switchTo().frame(Answer4Textbox);
		this.Editable4Textbox = driver.switchTo().activeElement();
		this.Editable4Textbox.sendKeys(Editable4Textbox);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//input[@id='qf_5934f7']")
	private WebElement FirstOption; 
	
	public void clickFirstOption() {
		this.FirstOption.isSelected(); 
	}
	
	@FindBy(xpath="//button[@id='submit-question']")
	private WebElement AddThisQuestion; 
	
	public void clickAddThisQuestion() {
		this.AddThisQuestion.isSelected(); 
	}
	
	@FindBy(xpath="//img[@src='http://elearning.upskills.in/main/img/icons/64/mcua.png' and @title='Multiple choice']")
	private WebElement MutipleChoice2; 
	
	public void clickMutipleChoice2() {
		this.MutipleChoice2.click();
	}
	
	@FindBy(xpath="//input[@name='questionName']")
	private WebElement QuestionTextbox2; 
	
	public void sendQuestionTextbox2(String QuestionTextbox2) {
		this.QuestionTextbox2.clear();
		this.QuestionTextbox2.sendKeys(QuestionTextbox2);
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[1]']")
	private WebElement Answer5Textbox;
	
	@FindBy(id="cke_2_contents")
	private WebElement Editable5Textbox;
		
	public void sendAnswer5Textbox(String Editable5Textbox) {
		driver.switchTo().frame(Answer5Textbox);
		this.Editable5Textbox = driver.switchTo().activeElement();
		this.Editable5Textbox.sendKeys(Editable5Textbox);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[2]']")
	private WebElement Answer6Textbox;
	
	@FindBy(id="cke_4_contents")
	private WebElement Editable6Textbox;
		
	public void sendAnswer6Textbox(String Editable6Textbox) {
		driver.switchTo().frame(Answer6Textbox);
		this.Editable6Textbox = driver.switchTo().activeElement();
		this.Editable6Textbox.sendKeys(Editable6Textbox);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[3]']")
	private WebElement Answer7Textbox;
	
	@FindBy(id="cke_6_contents")
	private WebElement Editable7Textbox;
		
	public void sendAnswer7Textbox(String Editable7Textbox) {
		driver.switchTo().frame(Answer7Textbox);
		this.Editable7Textbox = driver.switchTo().activeElement();
		this.Editable7Textbox.sendKeys(Editable7Textbox);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[4]']")
	private WebElement Answer8Textbox;
	
	@FindBy(id="cke_8_contents")
	private WebElement Editable8Textbox;
		
	public void sendAnswer8Textbox(String Editable8Textbox) {
		driver.switchTo().frame(Answer8Textbox);
		this.Editable8Textbox = driver.switchTo().activeElement();
		this.Editable8Textbox.sendKeys(Editable8Textbox);
		driver.switchTo().defaultContent();
	}
	
	
}
