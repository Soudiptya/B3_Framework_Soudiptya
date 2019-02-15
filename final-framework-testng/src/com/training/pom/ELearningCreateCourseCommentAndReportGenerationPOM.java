package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*
 * Author                : Soudiptya Kumar Basu
 * Test Case ID          : ELTC_086
 * Test Case Description : To verify whether application allows teacher to create course with project, student to comment on the task & admin to generate the report.
 * PreCondition          : 1. User should have launched the application 
 *                         2. User should have logged in as teacher and present in Home page
 */

public class ELearningCreateCourseCommentAndReportGenerationPOM {

private WebDriver driver;
	
	public ELearningCreateCourseCommentAndReportGenerationPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement CreateACourse; 
	
	public void clickCreateACourse() {
		this.CreateACourse.click(); 
	}
	
	@FindBy(xpath="//input[@id='title']")
	private WebElement CourseName;
	
	public void sendCourseName(String CourseName) {
		this.CourseName.clear();
		this.CourseName.sendKeys(CourseName);
	}
	
	@FindBy(xpath="//button[@id='advanced_params']")
	private WebElement AdvancedSettings; 
	
	public void clickAdvancedSettings() {
		this.AdvancedSettings.click(); 
	}
	
	@FindBy(id="add_course_category_code")
	private WebElement CategorySelect;
	
	public void selectCategory(String CategorySelect)
    {
     Select selectDropdown= new Select(this.CategorySelect);
     selectDropdown.selectByVisibleText(CategorySelect);
    }
	
	@FindBy(xpath="//input[@id='add_course_wanted_code']")
	private WebElement CourseCode;
	
	public void sendCourseCode(String CourseCode) {
		this.CourseCode.clear();
		this.CourseCode.sendKeys(CourseCode);
	}
	
	@FindBy(id="add_course_course_language")
	private WebElement LanguageSelect;
	
	public void selectLanguage(String LanguageSelect)
    {
     Select selectDropdown= new Select(this.LanguageSelect);
     selectDropdown.selectByVisibleText(LanguageSelect);
    }
	
	@FindBy(xpath="//button[@id='add_course_submit']")
	private WebElement CreateThisCourse; 
	
	public void clickCreateThisCourse() {
		this.CreateThisCourse.click(); 
	}
	
	@FindBy(xpath="//div[@class='btn-group pull-right']//em[@class='fa fa-file-text']")
	private WebElement AddAnIntroduction; 
	
	public void clickAddAnIntroduction() {
		this.AddAnIntroduction.click(); 
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, intro_content']")
	private WebElement ContextTextbox;
	
	@FindBy(id="cke_1_contents")
	private WebElement EditableTextbox;
		
	public void sendContextTextbox(String EditableTextbox) {
		driver.switchTo().frame(ContextTextbox);
		this.EditableTextbox = driver.switchTo().activeElement();
		this.EditableTextbox.sendKeys(EditableTextbox);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//button[@id='introduction_text_intro_cmdUpdate']")
	private WebElement SaveIntroText; 
	
	public void clickSaveIntroText() {
		this.SaveIntroText.click(); 
	}
	
	@FindBy(xpath="//a[@title='Homepage']")
	private WebElement Homepage1; 
	
	public void clickHomepage1() {
		this.Homepage1.click(); 
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
	
	@FindBy(xpath="//img[@id='toolimage_1335']")
	private WebElement CourseDescription; 
	
	public void clickCourseDescription() {
		this.CourseDescription.click(); 
	}
	
	@FindBy(xpath="//img[@title='Description']")
	private WebElement Description; 
	
	public void clickDescription() {
		this.Description.click(); 
	}
	
	@FindBy(xpath="//input[@id='course_description_title']")
	private WebElement Title; 
	
	public void sendTitle(String Title) {
		this.Title.clear();
		this.Title.sendKeys(Title);
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, contentDescription']")
	private WebElement ContextTextbox1;
	
	@FindBy(id="cke_1_contents")
	private WebElement EditableTextbox1;
		
	public void sendContextTextbox1(String EditableTextbox1) {
		driver.switchTo().frame(ContextTextbox1);
		this.EditableTextbox1 = driver.switchTo().activeElement();
		this.EditableTextbox1.sendKeys(EditableTextbox1);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//button[@id='course_description_submit']")
	private WebElement Save; 
	
	public void clickSave() {
		this.Save.click(); 
	}
	
	@FindBy(xpath="//img[@title='Objectives']")
	private WebElement Objectives; 
	
	public void clickObjectives() {
		this.Objectives.click(); 
	}
	
	@FindBy(xpath="//input[@id='course_description_title']")
	private WebElement ObjectiveTitle; 
	
	public void sendObjectiveTitle(String ObjectiveTitle) {
		this.ObjectiveTitle.clear();
		this.ObjectiveTitle.sendKeys(ObjectiveTitle);
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, contentDescription']")
	private WebElement ContextTextbox2;
	
	@FindBy(id="cke_1_contents")
	private WebElement EditableTextbox2;
		
	public void sendContextTextbox2(String EditableTextbox2) {
		driver.switchTo().frame(ContextTextbox2);
		this.EditableTextbox2 = driver.switchTo().activeElement();
		this.EditableTextbox2.sendKeys(EditableTextbox2);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//button[@id='course_description_submit']")
	private WebElement SaveObjective; 
	
	public void clickSaveObjective() {
		this.SaveObjective.click(); 
	}
	
	@FindBy(xpath="//img[@title='Topics']")
	private WebElement Topics; 
	
	public void clickTopics() {
		this.Topics.click(); 
	}
	
	@FindBy(xpath="//input[@id='course_description_title']")
	private WebElement TopicsTitle; 
	
	public void sendTopicsTitle(String TopicsTitle) {
		this.TopicsTitle.clear();
		this.TopicsTitle.sendKeys(TopicsTitle);
	}
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, contentDescription']")
	private WebElement ContextTextbox3;
	
	@FindBy(id="cke_1_contents")
	private WebElement EditableTextbox3;
		
	public void sendContextTextbox3(String EditableTextbox3) {
		driver.switchTo().frame(ContextTextbox3);
		this.EditableTextbox3 = driver.switchTo().activeElement();
		this.EditableTextbox3.sendKeys(EditableTextbox3);
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath="//button[@id='course_description_submit']")
	private WebElement SaveTopics; 
	
	public void clickSaveTopics() {
		this.SaveTopics.click(); 
	}
	
	@FindBy(xpath="//a[@title='Homepage']")
	private WebElement Homepage2; 
	
	public void clickHomepage2() {
		this.Homepage2.click(); 
	}
	
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement CourseCatalog2; 
	
	public void clickCourseCatalog2() {
		this.CourseCatalog2.click(); 
	}
	
	@FindBy(xpath="//a[@title='1er']//img[@class='img-responsive']")
	private WebElement CourseImage2; 
	
	public void clickCourseImage2() {
		this.CourseImage2.click(); 
	}
	
	@FindBy(xpath="//img[@id='toolimage_1355']")
	private WebElement Projects; 
	
	public void clickProjects() {
		this.Projects.click(); 
	}
	
	@FindBy(xpath="//img[@title='Create a new project']")
	private WebElement CreateNewProject; 
	
	public void clickCreateNewProject() {
		this.CreateNewProject.click(); 
	}
	
	@FindBy(xpath="//input[@id='add_blog_blog_name']")
	private WebElement ProjectTitle; 
	
	public void sendProjectTitle(String ProjectTitle) {
		this.ProjectTitle.clear();
		this.ProjectTitle.sendKeys(ProjectTitle);
	}
	
	@FindBy(xpath="//textarea[@id='add_blog_blog_subtitle']")
	private WebElement ProjectSubTitle; 
	
	public void sendProjectSubTitle(String ProjectSubTitle) {
		this.ProjectSubTitle.clear();
		this.ProjectSubTitle.sendKeys(ProjectSubTitle);
	}
	
	@FindBy(xpath="//button[@id='add_blog_submit']")
	private WebElement SaveBlog; 
	
	public void clickSaveBlog() {
		this.SaveBlog.click(); 
	}
	
	@FindBy(xpath="//a[contains(text(),'abcd')]")
	private WebElement ProjectLink; 
	
	public void clickProjectLink() {
		this.ProjectLink.click(); 
	}
	
	@FindBy(xpath="//img[@title='New task']")
	private WebElement NewTask; 
	
	public void clickNewTask() {
		this.NewTask.click(); 
	}
	
	@FindBy(xpath="//input[@id='add_post_title']")
	private WebElement PostTitle; 
	
	public void sendPostTitle(String PostTitle) {
		this.PostTitle.clear();
		this.PostTitle.sendKeys(PostTitle);
	}
	
	@FindBy(xpath="//button[@id='add_post_save']")
	private WebElement SaveButton; 
	
	public void clickSaveButton() {
		this.SaveButton.click(); 
	}
	
	@FindBy(xpath="//img[@title='Roles management']")
	private WebElement RolesManagement; 
	
	public void clickRolesManagement() {
		this.RolesManagement.click(); 
	}
	
	@FindBy(xpath="//img[@title='Add a new role']")
	private WebElement AddANewRole; 
	
	public void clickAddANewRole() {
		this.AddANewRole.click(); 
	}
	
	@FindBy(xpath="//input[@name='task_name']")
	private WebElement TaskTitle; 
	
	public void sendTaskTitle(String TaskTitle) {
		this.TaskTitle.clear();
		this.TaskTitle.sendKeys(TaskTitle);
	}
	
	@FindBy(xpath="//button[@name='Submit']")
	private WebElement SaveBtn; 
	
	public void clickSaveBtn() {
		this.SaveBtn.click(); 
	}
	
	@FindBy(xpath="//img[@title='Assign roles']")
	private WebElement AssignRoles; 
	
	public void clickAssignRoles() {
		this.AssignRoles.click(); 
	}
	
	@FindBy(xpath="//button[@id='assign_task_submit']")
	private WebElement Validate; 
	
	public void clickValidate() {
		this.Validate.click(); 
	}
	
	@FindBy(xpath="//img[@title='Users management']")
	private WebElement UsersManagement; 
	
	public void clickUsersManagement() {
		this.UsersManagement.click(); 
	}
	
	@FindBy(xpath="//input[@value='92']")
	private WebElement Checkbox; 
	
	public void clickCheckbox() {
		this.Checkbox.click(); 
	}
	
	@FindBy(xpath="//a[contains(@class,'btn btn-primary')]")
	private WebElement Register; 
	
	public void clickRegister() {
		this.Register.click(); 
	}
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement Dropdown; 
	
	public void clickDropdown() {
		this.Dropdown.click(); 
	}
	
	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement Logout; 
	
	public void clickLogout() {
		this.Logout.click(); 
	}
	
}


	
	
	
	
	
	
	
	
	
	



