package webPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Launch_Application;
import utils.Utility;

public class Home_Page extends Launch_Application{
	
	@FindBy(xpath="//a[text()='HOME']")
	WebElement Home;
	
	@FindBy(xpath="//span[text()='Visit the store']")
	WebElement visit_Store;
	
	@FindBy(xpath="//select[@class='orderby']")
	WebElement sort;
	
	@FindBy(xpath="//option[@value='date']")
	WebElement sort_Latest;
	
	@FindBy(xpath="//a[@class='next page-numbers']")
	WebElement next_Page;
	
	@FindBy(xpath="//img[@alt='bamboo hanging hoop mini planter']")
	WebElement planter;
	
	@FindBy(xpath="//a[@class='woocommerce-product-gallery__trigger']")
	WebElement zoom_Item; 
	
	@FindBy(xpath="//button[text()='Add to cart']")
	WebElement add_to_Cart;
	
	@FindBy(xpath="//button[@class='pswp__button pswp__button--arrow--right']")
	WebElement right_Arrow;
	
	@FindBy(xpath="//button[@class='pswp__button pswp__button--fs']")
	WebElement max_Image;
	
	@FindBy(xpath="//div[@class='woocommerce-message']")
	WebElement message;
	
	public Home_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void explore_HomePage() throws InterruptedException
	{
		Home.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Actions a=new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		visit_Store.click();
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		sort.click();
		Utility.sort_Item(driver,sort_Latest,sort);
	}
	
	public void select_Item() throws InterruptedException
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		next_Page.click();
		Utility.select_Planter(driver,planter,zoom_Item);
		
	}
	
	public void perform_AddtoCart() throws InterruptedException, IOException
	{
		Actions a=new Actions(driver);
		right_Arrow.click();
		Thread.sleep(1000);
		right_Arrow.click();
		Thread.sleep(1000);
		max_Image.click();
		Thread.sleep(1000);
		Utility.take_Screenshot(driver);
		a.sendKeys(Keys.ESCAPE).build().perform();
		Utility.perform_cart(driver,add_to_Cart);
	}
	
	public String getCart_Message()
	{
		return message.getText();
	}
}
