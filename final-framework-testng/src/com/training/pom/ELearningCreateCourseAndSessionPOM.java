package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ELearningCreateCourseAndSessionPOM {

private WebDriver driver;
	
	public ELearningCreateCourseAndSessionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[@title='Administration']")
	private WebElement Administration; 
	
	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement CreateACourse; 
	
	@FindBy(name="title")
	private WebElement Title; 
	
	@FindBy(name="visual_code")
	private WebElement Code; 
	
	@FindBy(id="course_teachers")
	private WebElement TeacherDeselect;
	
	@FindBy(id="course_teachers")
	private WebElement TeacherSelect;
	
	@FindBy(id="update_course_category_code")
	private WebElement CategorySelect;
	
	@FindBy(id="update_course_course_language")
	private WebElement LanguageSelect;
	
	@FindBy(xpath="//button[@id='update_course_submit']")
	private WebElement CreateACourseButton;
	
	@FindBy(xpath="//a[@title='Administration']")
	private WebElement AdministrationTab;
	
	@FindBy(xpath="//a[contains(text(),'Add a training session')]")
	private WebElement AddATrainingSession;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement SessionName;
	
	@FindBy(xpath="//button[@id='add_session_submit']")
	private WebElement NextStep;
	
	@FindBy(xpath="//option[@title='testing (TES)']")
	private WebElement CourseSelection;
	
	@FindBy(xpath="//em[@class='fa fa-chevron-right']")
	private WebElement RightArrow;
	
	@FindBy(xpath="//button[@name='next']")
	private WebElement NextStepButton;
	
	@FindBy(xpath="//input[@id='user_to_add']")
	private WebElement StudentName;
	
	@FindBy(xpath="//a[contains(text(),'kumar sunil (sunkum09) SUNKUM09')]")
	private WebElement SelectStudentName;
	
	@FindBy(xpath="//button[contains(text(),'Finish session creation')]")
	private WebElement FinishSessionCreation;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickAdministrationBtn() {
		this.Administration.click(); 
	}
	
	public void clickCreateACourse() {
		this.CreateACourse.click(); 
	}
	
	public void sendTitle(String Title) {
		this.Title.clear();
		this.Title.sendKeys(Title);
	}
	
	public void sendCode(String Code) {
		this.Code.clear();
		this.Code.sendKeys(Code);
	}
	
	public void deselectTeacher(String TeacherDeselect)
    {
     Select selectDropdown= new Select(this.TeacherDeselect);
     selectDropdown.deselectByVisibleText(TeacherDeselect);
    }
	
	public void selectTeacher(String TeacherSelect)
    {
     Select selectDropdown= new Select(this.TeacherSelect);
     selectDropdown.selectByVisibleText(TeacherSelect);
    }
	
	public void selectCategory(String CategorySelect)
    {
     Select selectDropdown= new Select(this.CategorySelect);
     selectDropdown.selectByVisibleText(CategorySelect);
    }
	
	public void selectLanguage(String LanguageSelect)
    {
     Select selectDropdown= new Select(this.LanguageSelect);
     selectDropdown.selectByVisibleText(LanguageSelect);
    }
	
	public void clickCreateACourseButton() {
		this.CreateACourseButton.click(); 
	}
	
	public void clickAdministrationTab() {
		this.AdministrationTab.click(); 
	}
	
	public void clickAddATrainingSession() {
		this.AddATrainingSession.click(); 
	}
	
	public void sendSessionName(String SessionName) {
		this.SessionName.clear();
		this.SessionName.sendKeys(SessionName);
	}
	
	public void clickNextStep() {
		this.NextStep.click(); 
	}
	
	public void clickCourseSelection() {
		this.CourseSelection.click(); 
	}
	
	public void clickRightArrow() {
		this.RightArrow.click(); 
	}
	
	public void clickNextStepButton() {
		this.NextStepButton.click(); 
	}
	
	public void sendStudentName(String StudentName) {
		this.StudentName.clear();
		this.StudentName.sendKeys(StudentName);
	}
	
	public void SelectStudentName() {
		this.SelectStudentName.click(); 
	}
	
	public void clickFinishSessionCreation() {
		this.FinishSessionCreation.click(); 
	}
}
