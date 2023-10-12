package webPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.Launch_Application;

public class Shop_Page extends Launch_Application{

	@FindBy(xpath="//a[text()='SHOP']")
	WebElement shop_Hover;
	
	@FindBy(xpath="//a[text()='PLANTERS']")
	WebElement planters_Hover;
	
	@FindBy(xpath="//a[text()='Fiberglass Planters']")
	WebElement fiberglass_Planters;
	
	@FindBy(xpath="//select[@class='orderby']")
	WebElement sort;
	
	@FindBy(xpath="//h2[text()='Fiberglass Designer Planter']")
	WebElement fiberglass;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	WebElement AddtoCart;
	
	@FindBy(id="pa_size")
	WebElement options_btn;
	
	@FindBy(xpath="//option[text()='Medium Height 15 Inches x Diameter 11.5 Inches']")
	WebElement medium_height;
	
	@FindBy(xpath="//div[@class='woocommerce-message']")
	WebElement message;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/div[1]/div/a")
	WebElement view_Cart;
	
	public Shop_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void explore_ShopPage() throws InterruptedException
	{
		Actions a=new Actions(driver);
		a.moveToElement(shop_Hover).perform();
		//a.moveToElement(plants_Hover).click(orchid_Plant);
		a.moveToElement(planters_Hover).click(fiberglass_Planters);
		a.perform();
		sort.click();
		Select s=new Select(sort);
		s.selectByIndex(2);
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		fiberglass.click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(1000);
		AddtoCart.click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();	
	}
	
	public void select_Product() throws InterruptedException
	{
		options_btn.click();
		medium_height.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		AddtoCart.click();
		Thread.sleep(1000);
		view_Cart.click();
		Thread.sleep(1000);
	}
}
