package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ELTC_059POM {
private WebDriver driver;
	
	public ELTC_059POM(WebDriver driver) {
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
	
	@FindBy(xpath="//a[contains(text(),'Classes')]")
	private WebElement Classes;
	
	@FindBy(xpath="//img[@title='Add classes']")
	private WebElement AddClasses;
	
	@FindBy(xpath="//input[@id='usergroup_name']")
	private WebElement NameTextbox;
	
	@FindBy(xpath="//textarea[@id='usergroup_description']")
	private WebElement Description;
	
	@FindBy(id="usergroup_visibility")
	private WebElement GroupPermissionSelect;
	
	@FindBy(xpath="//button[@id='usergroup_submit']")
	private WebElement Add;
	
	@FindBy(xpath="//a[@href='add_users_to_usergroup.php?id=60']//img[@title='Subscribe users to class']")
	private WebElement SubscribeUsersToClass;
	
	@FindBy(xpath="//option[@value='10']")
	private WebElement UsersOnPlatform;
	
	@FindBy(xpath="//em[@class='fa fa-arrow-right']")
	private WebElement RightArrow;
	
	@FindBy(xpath="//button[contains(text(),'Subscribe users to class')]")
	private WebElement SubscribeUsersToClassButton;
	
	@FindBy(xpath="//a[@href='add_users_to_usergroup.php?id=60']//img[@title='Subscribe users to class']")
	private WebElement SubscribeClassToCourses;
	
	@FindBy(xpath="//option[@value='5']")
	private WebElement CoursesOnPlatform;
	
	@FindBy(xpath="//em[@class='fa fa-arrow-right']")
	private WebElement RightArrowButton;
	
	@FindBy(xpath="//button[contains(text(),'Subscribe class to courses')]")
	private WebElement SubscribeClassToCoursesButton;

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
	
	public void clickClasses() {
		this.Classes.click(); 
	}
	
	public void clickAddClasses() {
		this.AddClasses.click(); 
	}
	
	public void sendNameTextbox(String NameTextbox) {
		this.NameTextbox.clear();
		this.NameTextbox.sendKeys(NameTextbox);
	}
	
	public void sendDescription(String Description) {
		this.Description.clear();
		this.Description.sendKeys(Description);
	}
	
	public void selectGroupPermission(String GroupPermissionSelect)
    {
     Select selectDropdown= new Select(this.GroupPermissionSelect);
     selectDropdown.selectByVisibleText(GroupPermissionSelect);
    }
	
	public void clickAdd() {
		this.Add.click(); 
	}
	
	public void clickSubscribeUsersToClass() {
		this.SubscribeUsersToClass.click(); 
	}
	
	public void clickUsersOnPlatform() {
		this.UsersOnPlatform.click(); 
	}
	
	public void clickRightArrow() {
		this.RightArrow.click(); 
	}
	
	public void clickSubscribeUsersToClassButton() {
		this.SubscribeUsersToClassButton.click(); 
	}
	
	public void clickSubscribeClassToCourses() {
		this.SubscribeClassToCourses.click(); 
	}
	
	public void clickCoursesOnPlatform() {
		this.CoursesOnPlatform.click(); 
	}
	
	public void clickRightArrowButton() {
		this.RightArrowButton.click(); 
	}
	
	public void clickSubscribeClassToCoursesButton() {
		this.SubscribeClassToCoursesButton.click(); 
	}
}

