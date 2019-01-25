package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELearningLogin {
	private WebDriver driver;
	
	public ELearningLogin(WebDriver driver) {
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
	
	@FindBy(xpath="//a[contains(text(),'Classes')]")
	private WebElement Classes; 
	
	@FindBy(xpath="//img[@title='Add classes']")
	private WebElement Add_Classes; 
	
	@FindBy(xpath="//input[@id='usergroup_name']")
	private WebElement Name; 
	
	@FindBy(xpath="//textarea[@id='usergroup_description']")
	private WebElement Description; 
	
	//@FindBy(xpath="//div[@class='dropdown-menu open']")
	//private WebElement Group_Permissions; 
	
	@FindBy(xpath="//span[@class='filter-option pull-left'][1]")
    private WebElement Group_Permissions; 
	
	//@FindBy(xpath="//button[@title='Open']")
    //private WebElement Group_Permissions; 
	
	@FindBy(xpath="//button[@id='usergroup_submit']")
	private WebElement Add; 

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
	
	public void clickClassesBtn() {
		this.Classes.click(); 
	}
	
	public void clickAddClassesBtn() {
		this.Add_Classes.click(); 
	}
	
	public void sendName(String Name) {
		this.Name.clear();
		this.Name.sendKeys(Name);
	}
	
	public void sendDescription(String Description) {
		this.Description.clear();
		this.Description.sendKeys(Description);
	}
	
	public void selectGroupPermissions(String Group_Permissions) {
		this.Group_Permissions.getAttribute("value");	
		System.out.println("Basu");
	}
	
	public void clickAddBtn() {
		this.Add.click(); 
	}
}


