package webPage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Launch_Application;

public class ContactUs_Page extends Launch_Application{

	@FindBy(id="menu-item-455")
	WebElement contactUs_link;
	
	@FindBy(xpath="//div[@class='elementor-image']")
	WebElement contact_widget;
	
	@FindBy(xpath="//h3[text()='Send Us a Message']")
	WebElement send_Message;
	
	@FindBy(id="wpforms-6-field_0")
	WebElement name_Field;
	
	@FindBy(id="wpforms-6-field_1")
	WebElement email_Field;
	
	@FindBy(id="wpforms-6-field_4")
	WebElement subject_Field;
	
	@FindBy(id="wpforms-6-field_2")
	WebElement message_Field;
	
	@FindBy(id="wpforms-submit-6")
	WebElement submit_Button;
	
	@FindBy(id="wpforms-confirmation-6")
	WebElement congrats_Message;
	
	@FindBy(xpath="//*[@id=\"post-12\"]/div/div/div/div/section[3]/div/div/div/div/div")
	WebElement mapImage;
	
	@FindBy(xpath="//*[@id=\"mapDiv\"]/div/div/div[4]/div/div/div/div/a")
	WebElement mode;
	
	public ContactUs_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void explore_ContactUs()
	{
		contactUs_link.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", contact_widget);
		js.executeScript("arguments[0].scrollIntoView();", send_Message);
		name_Field.sendKeys("Testing");
		email_Field.sendKeys("abc@gmail.com");
		subject_Field.sendKeys("Plants & Planters");
		message_Field.sendKeys("Good Collections!..Keep Going...!!!");
		submit_Button.click();
		
	}
	
	public String getCongrats_Message()
	{
		return congrats_Message.getText();
		
	}
	
	public void map_View() throws InterruptedException, AWTException
	{
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		mapImage.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_SHIFT);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ADD);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SHIFT); 
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_SHIFT);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SHIFT); 
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		Thread.sleep(1000);
	}

}

