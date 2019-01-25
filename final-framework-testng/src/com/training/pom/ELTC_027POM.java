package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELTC_027POM {
private WebDriver driver;
	
	public ELTC_027POM(WebDriver driver) {
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
	
	@FindBy(xpath="//a[@href='add_users_to_usergroup.php?id=86']//img[@title='Subscribe users to class']")
	private WebElement Subscribe_Users_To_Class; 
	
	@FindBy(xpath="//option[@value='238']")
	private WebElement SelectUsersOnPlatform; 
	
	@FindBy(xpath="//em[@class='fa fa-arrow-right']")
	private WebElement ArrowRightIcon; 
	
	@FindBy(xpath="//em[@class='fa fa-check']")
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
	
	public void clickSubscribeUsersToClassBtn() {
		this.Subscribe_Users_To_Class.click();
	}
	
	public void selectUsersOnPlatform() {
		this.SelectUsersOnPlatform.isSelected();
	}
	
	public void arrowRightIcon() {
		this.ArrowRightIcon.click();
	}
	
	public void subscribe() {
		this.Subscribe.click();
	}

}




