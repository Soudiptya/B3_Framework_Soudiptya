package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELearningLogoutPOM {
private WebDriver driver;
	
	public ELearningLogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement dropdownBtn; 

	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement logoutBtn; 
	
	
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
		System.out.println("Hello manzoor mehadi and welcome");
	}
	
	public void clickDropdownBtn() {
		this.dropdownBtn.click(); 
	}
	
	public void clickLogoutBtn() {
		this.logoutBtn.click(); 
	}

	
}
