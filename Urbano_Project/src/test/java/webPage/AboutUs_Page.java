package webPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Launch_Application;
import utils.Utility;

public class AboutUs_Page extends Launch_Application{

	@FindBy(xpath="//a[text()='ABOUT US']")
	WebElement aboutUs_Btn;

	@FindBy(xpath="//h3[text()='Pranab Debnath']")
	WebElement ceo_Picture;
	
	@FindBy(xpath="//*[@id=\"page\"]/b/div/div/div/div/div/section/div/div/div[2]/div/div/div/div/div/span[1]/a")
	WebElement whatsapp_Icon;
	
	@FindBy(xpath="//*[@id=\"page\"]/b/div/div/div/div/div/section/div/div/div[2]/div/div/div/div/div/span[2]/a")
	WebElement faceBook_Icon;
	
	@FindBy(xpath="//div[@aria-label='Close']")
	WebElement cancel;
	
	@FindBy(xpath="//*[@id=\"page\"]/b/div/div/div/div/div/section/div/div/div[2]/div/div/div/div/div/span[3]/a")
	WebElement instagram_Icon;
	
	public AboutUs_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void explore_Aboutus() throws InterruptedException
	{
		aboutUs_Btn.click();
		//js.executeScript("window.scrollBy(0,900)");
		Actions a=new Actions(driver);
		//scrolling down using scroll bar
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		//scroll down to the element 
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ceo_Picture);
		//scrolling up using scroll bar
		a.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		//scrolling down to the bottom of the web page 
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void whatsapp_Medialink() throws InterruptedException
	{
		Thread.sleep(3000);
		whatsapp_Icon.click();
		Thread.sleep(5000);
		Utility.whatsapp_Mediapage(driver);
	}
	public void facebook_Medialink() throws InterruptedException
	{
		Actions a=new Actions(driver);
		a.moveToElement(faceBook_Icon).click();
		a.perform();
		cancel.click();
		//Thread.sleep(5000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		driver.navigate().back();
	}
	public void instagram_Medialink() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		instagram_Icon.click();
		Actions a=new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		driver.navigate().back();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	
	
}
