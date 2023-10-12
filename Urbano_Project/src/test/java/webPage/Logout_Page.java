package webPage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Launch_Application;
import utils.Utility;

public class Logout_Page extends Launch_Application{
	
	@FindBy(xpath="//a[text()='MY ACCOUNT']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Orders']")
	WebElement ordersTab;
	
	@FindBy(xpath="//a[text()='View']")
	WebElement view_Btn;
	
	@FindBy(xpath="//*[@id=\"post-549\"]/div/div/nav/ul/li[6]/a")
	WebElement Logout;
	
	public Logout_Page()
	{
		PageFactory.initElements(driver, this);
	}

	public void Order_page() throws InterruptedException, IOException
	{
		Actions A=new Actions(driver);
		A.moveToElement(myAccount).click(ordersTab).perform();
		Thread.sleep(1000);
		view_Btn.click();
		Utility.orders_Screenshot(driver);
		Thread.sleep(500);
		Logout.click();
	}
}
