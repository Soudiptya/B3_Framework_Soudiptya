package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELearningSubscribeUsersAddCoursesPOM {

private WebDriver driver;
	
	public ELearningSubscribeUsersAddCoursesPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//a[contains(text(),'Sessions categories list')]")
	private WebElement SessionsCategoriesList; 
	
	@FindBy(xpath="//img[@title='Training sessions list']")
	private WebElement TrainingSessionsList; 
	
	@FindBy(xpath="//a[@href='add_users_to_session.php?page=session_list.php&id_session=30']//img[@title='Subscribe users to this session']")
	private WebElement SubscribeUsersToThisSession;
	
	@FindBy(id="user_to_add")
	private WebElement studentName;
	
	@FindBy(xpath="//a[contains(text(),'kumar sunil (sunkum09) SUNKUM09')]")
	private WebElement SudentNameLink;
	
	@FindBy(xpath="//button[contains(text(),'Subscribe users to this session')]")
	private WebElement SubscribeUsersToThisSessionButton;
	
	@FindBy(xpath="//a[contains(text(),'Session list')]")
	private WebElement SessionList;
	
	@FindBy(xpath="//a[@href='add_courses_to_session.php?page=session_list.php&id_session=30']//img[@title='Add courses to this session']")
	private WebElement AddCoursesToThisSession;
	
	@FindBy(xpath="//option[@title='javatpoint (5)']")
	private WebElement Course;
	
	@FindBy(xpath="//em[@class='fa fa-chevron-right']")
	private WebElement RightArrowButton;
	
	@FindBy(xpath="//button[@name='next']")
	private WebElement AddCoursesToThisSessionButton;

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
	
	public void clickSessionsCategoriesList() {
		this.SessionsCategoriesList.click(); 
	}
	
	public void clickTrainingSessionsList() {
		this.TrainingSessionsList.click(); 
	}
	
	public void clickSubscribeUsersToThisSession() {
		this.SubscribeUsersToThisSession.click(); 
	}
	
	public void sendstudentName(String studentName) {
		this.studentName.clear();
		this.studentName.sendKeys(studentName);
	}
	
	public void clickSudentNameLink() {
		this.SudentNameLink.click(); 
	}
	
	public void clickSubscribeUsersToThisSessionButton() {
		this.SubscribeUsersToThisSessionButton.click(); 
	}
	
	public void clickSessionList() {
		this.SessionList.click(); 
	}
	
	public void clickAddCoursesToThisSession() {
		this.AddCoursesToThisSession.click(); 
	}
	
	public void clickCourse() {
		this.Course.click(); 
	}
	
	public void clickRightArrowButton() {
		this.RightArrowButton.click(); 
	}
	
	public void clickAddCoursesToThisSessionButton() {
		this.AddCoursesToThisSessionButton.click(); 
	}
}
