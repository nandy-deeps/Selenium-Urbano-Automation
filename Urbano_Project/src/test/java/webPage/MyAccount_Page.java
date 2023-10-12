package webPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Launch_Application;
import utils.Utility;

public class MyAccount_Page extends Launch_Application{
	
	@FindBy(id="menu-item-21")
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Account details']")
	WebElement accDetails;
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passWord;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement submitBtn;
	
	public MyAccount_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validate_Login()
	{
		Actions A=new Actions(driver);
		A.moveToElement(myAccount).perform();
		accDetails.click();
		Utility.account_LogIn(driver,userName,passWord,submitBtn);
	}

}
