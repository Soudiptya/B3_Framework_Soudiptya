package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ELearningCreateUserAndSubscribeUserToClassPOM {

private WebDriver driver;
	
	public ELearningCreateUserAndSubscribeUserToClassPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//a[contains(text(),'Add a user')]")
	private WebElement AddAUser; 
	
	@FindBy(xpath="//input[@id='firstname']")
	private WebElement FirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement LastName;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement Email;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement PhoneNumber;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement LoginBox;
	
	@FindBy(xpath="//fieldset//div[9]//div[1]//div[2]//label[1]")
	private WebElement EnterPasswordButton;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement ValidPassword;
	
	@FindBy(id="status_select")
	private WebElement statusSelect;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement Add;
	
	@FindBy(xpath="//a[@title='Administration']")
	private WebElement AdministrationTab;
	
	@FindBy(xpath="//a[contains(text(),'Classes')]")
	private WebElement Classes;
	
	@FindBy(xpath="//img[@title='Add classes']")
	private WebElement AddClasses;
	
	@FindBy(xpath="//input[@id='usergroup_name']")
	private WebElement Name;
	
	@FindBy(xpath="//textarea[@id='usergroup_description']")
	private WebElement Description;
	
	@FindBy(id="usergroup_visibility")
	private WebElement GroupPermissionSelect;
	
	@FindBy(xpath="//button[@id='usergroup_submit']")
	private WebElement AddBtn;
	
	@FindBy(xpath="//a[@href='add_users_to_usergroup.php?id=82']//img[@title='Subscribe users to class']")
	private WebElement SubscribeUsersToClass;
	
	@FindBy(xpath="//option[@value='55']")
	private WebElement UsersOnPlatform;
	
	@FindBy(xpath="//em[@class='fa fa-arrow-right']")
	private WebElement RightArrow;
	
	@FindBy(xpath="//button[contains(text(),'Subscribe users to class')]")
	private WebElement SubscribeUsersToClassBtn;
	
	@FindBy(xpath="//a[@href='add_users_to_usergroup.php?id=82']//img[@title='Subscribe users to class']")
	private WebElement SubscribeClassToCourses;
	
	@FindBy(xpath="//option[@value='9']")
	private WebElement CoursesOnThePlatform;
	
	@FindBy(xpath="//em[@class='fa fa-arrow-right']")
	private WebElement RightArrowBtn;
	
	@FindBy(xpath="//button[contains(text(),'Subscribe class to courses')]")
	private WebElement SubscribeClassToCoursesBtn;

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
	
	public void clickAddAUser() {
		this.AddAUser.click(); 
	}
	
	public void sendFirstName(String FirstName) {
		this.FirstName.clear();
		this.FirstName.sendKeys(FirstName);
	}
	
	public void sendLastName(String LastName) {
		this.LastName.clear();
		this.LastName.sendKeys(LastName);
	}
	
	public void sendEmail(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
	}
	
	public void sendPhoneNumber(String PhoneNumber) {
		this.PhoneNumber.clear();
		this.PhoneNumber.sendKeys(PhoneNumber);
	}
	
	public void sendLoginBox(String LoginBox) {
		this.LoginBox.clear();
		this.LoginBox.sendKeys(LoginBox);
	}
	
	public void SelectEnterPasswordButton() {
		this.EnterPasswordButton.isSelected();
	}
	
	public void sendValidPassword(String ValidPassword) {
		this.ValidPassword.clear(); 
		this.ValidPassword.sendKeys(ValidPassword); 
	}
	
    public void selectGroupPermission(String GroupPermissionSelect)
    {
     Select selectDropdown= new Select(this.GroupPermissionSelect);
     selectDropdown.selectByVisibleText(GroupPermissionSelect);
    }
     
	public void clickAdd() {
		this.Add.click(); 
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
	
	public void sendName(String Name) {
		this.Name.clear();
		this.Name.sendKeys(Name);
	}
	
	public void sendDescription(String Description) {
		this.Description.clear();
		this.Description.sendKeys(Description);
	}
	
	public void selectProfile(String statusSelect)
    {
     Select selectDropdown= new Select(this.statusSelect);
     selectDropdown.selectByVisibleText(statusSelect);
    }
	
	public void clickAddBtn() {
		this.AddBtn.click(); 
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
	
	public void clickSubscribeUsersToClassBtn() {
		this.SubscribeUsersToClassBtn.click(); 
	}
	
	public void clickSubscribeClassToCourses() {
		this.SubscribeClassToCourses.click(); 
	}
	
	public void clickCoursesOnThePlatform() {
		this.CoursesOnThePlatform.click(); 
	}
	
	public void clickRightArrowBtn() {
		this.RightArrowBtn.click(); 
	}
	
	public void clickSubscribeClassToCoursesBtn() {
		this.SubscribeClassToCoursesBtn.click(); 
	}
}

