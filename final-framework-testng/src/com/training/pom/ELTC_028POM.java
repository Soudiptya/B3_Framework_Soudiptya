package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_028POM {
private WebDriver driver;
	
	public ELTC_028POM(WebDriver driver) {
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
	
	@FindBy(xpath="//a[@href='add_courses_to_usergroup.php?id=88']//img[@title='Subscribe class to courses']")
	private WebElement Subscribe_Class_To_Courses; 
	
	@FindBy(xpath="//option[@value='293']")
	private WebElement SelectCouresesOnPlatform; 
	
	@FindBy(xpath="//em[@class='fa fa-arrow-right']")
	private WebElement ArrowRightIcon; 
	
	@FindBy(xpath="//button[contains(text(),'Subscribe class to courses')]")
	private WebElement Subscribe; 

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
	
	public void subscribe_Class_To_Courses() {
		this.Subscribe_Class_To_Courses.click(); 
	}
	
	public void selectCouresesOnPlatform() {
		this.SelectCouresesOnPlatform.click(); 
	}
	
	public void arrowRightIcon() {
		this.ArrowRightIcon.click();
	}
	
	public void subscribe() {
		this.Subscribe.click();
	}
}





