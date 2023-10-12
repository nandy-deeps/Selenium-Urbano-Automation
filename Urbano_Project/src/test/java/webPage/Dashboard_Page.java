package webPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Launch_Application;

public class Dashboard_Page extends Launch_Application{
	
	@FindBy(id="account_first_name")
	WebElement firstName;

	@FindBy(id="account_last_name")
	WebElement lastName;
	
	@FindBy(id="account_display_name")
	WebElement displayName;
	
	@FindBy(xpath="//button[text()='Save changes']")
	WebElement saveBtn;
	
	@FindBy(xpath="//*[@id=\"post-549\"]/div/div/div/div/div")
	WebElement successful_Msg;
	
	@FindBy(xpath="//*[@id=\"post-549\"]/div/div/nav/ul/li[5]/a")
	WebElement click_Accountdetails;
	
	public Dashboard_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void edit_Accountdetails()
	{
		firstName.clear();
		firstName.sendKeys("Testing");
		lastName.clear();
		lastName.sendKeys("Automate");
		displayName.clear();
		displayName.sendKeys("Testing Automate");
		saveBtn.click();
	}
	
	public String getSuccess_Message()
	{
		return successful_Msg.getText();
		
	}
	
}
