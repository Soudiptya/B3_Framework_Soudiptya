package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELearningAddCareerPromotionSessionPOM {

private WebDriver driver;
	
	public ELearningAddCareerPromotionSessionPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//a[contains(text(),'Careers and promotions')]")
	private WebElement CareersAndPromotions; 
	
	@FindBy(xpath="//img[@title='Careers']")
	private WebElement Careers; 
	
	@FindBy(xpath="//img[@title='Add']")
	private WebElement Add; 
	
	@FindBy(xpath="//input[@id='career_name']")
	private WebElement Name; 
	
	@FindBy(xpath="//button[@id='career_submit']")
	private WebElement AddButton; 
	
	@FindBy(xpath="//a[contains(text(),'Careers and promotions')]")
	private WebElement CareersAndPromotionsLink;
	
	@FindBy(xpath="//img[@title='Promotions']")
	private WebElement PromotionsIcon;
	
	@FindBy(xpath="//img[@title='Add']")
	private WebElement AddIcon;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement NameTextbox; 
	
	@FindBy(xpath="//button[@id='promotion_submit']")
	private WebElement AddButtonClick; 
	
	@FindBy(xpath="//img[@title='Add a training session']")
	private WebElement AddATrainingSession; 
	
	@FindBy(xpath="//input[@id='add_session_name']")
	private WebElement AddSessionName; 
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement NextStep; 
	
	@FindBy(xpath="//option[@title='Selenium Course (WL)']")
	private WebElement Course; 
	
	@FindBy(xpath="//em[@class='fa fa-chevron-right']")
	private WebElement RightArrow;
	
	@FindBy(xpath="//button[@name='next']")
	private WebElement NextStep1; 
	
	@FindBy(xpath="//input[@id='user_to_add']")
	private WebElement PortalUserName; 
	
	@FindBy(xpath="//a[contains(text(),'kumar sunil (sunkum09) SUNKUM09')]")
	private WebElement StudentNameLink; 
	
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
	
	public void clickCareersAndPromotions() {
		this.CareersAndPromotions.click(); 
	}
	
	public void clickCareers() {
		this.Careers.click(); 
	}
	
	public void clickAdd() {
		this.Add.click(); 
	}
	
	public void sendName(String Name) {
		this.Name.clear();
		this.Name.sendKeys(Name);
	}
	
	public void clickAddButton() {
		this.AddButton.click(); 
	}
	
	public void clickCareersAndPromotionsLink() {
		this.CareersAndPromotionsLink.click(); 
	}
	
	public void clickPromotionsIcon() {
		this.PromotionsIcon.click(); 
	}
	
	public void clickAddIcon() {
		this.AddIcon.click(); 
	}
	
	public void sendNameTextbox(String NameTextbox) {
		this.NameTextbox.clear();
		this.NameTextbox.sendKeys(NameTextbox);
	}
	
	public void AddButtonClick() {
		this.AddButtonClick.click(); 
	}
	
	public void clickAddATrainingSession() {
		this.AddATrainingSession.click(); 
	}
	
	public void sendAddSessionName(String AddSessionName) {
		this.AddSessionName.clear();
		this.AddSessionName.sendKeys(AddSessionName);
	}
	
	public void ClickNextStep() {
		this.NextStep.click(); 
	}
	
	public void ClickCourse() {
		this.Course.click(); 
	}
	
	public void ClickRightArrow() {
		this.RightArrow.click(); 
	}
	
	public void ClickNextStep1() {
		this.NextStep1.click(); 
	}
	
	public void sendPortalUserName(String PortalUserName) {
		this.PortalUserName.clear();
		this.PortalUserName.sendKeys(PortalUserName);
	}
	
	public void ClickStudentNameLink() {
		this.StudentNameLink.click(); 
	}
	
	public void ClickFinishSessionCreation() {
		this.FinishSessionCreation.click(); 
	}
}
