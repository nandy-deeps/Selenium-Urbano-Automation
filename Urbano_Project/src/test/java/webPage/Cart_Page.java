package webPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.Launch_Application;

public class Cart_Page extends Launch_Application{

	@FindBy(id="ast-site-header-cart")
	WebElement cart_Menu;
	
	@FindBy(xpath="//a[text()='View cart']")
	WebElement view_cart;
	
	@FindBy(xpath="//a[@aria-label='Remove this item'][1]")
	WebElement remove;
	
	@FindBy(xpath="//a[text()='Undo?']")
	WebElement undo;
	
	@FindBy(xpath="//input[@class='input-text qty text']")
	WebElement quantity;
	
	@FindBy(xpath="//button[@name='update_cart']")
	WebElement update_Cartbtn;
	
	@FindBy(xpath="//a[text()='Calculate shipping']")
	WebElement calculate_Shipping;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement text_Field;
	
	@FindBy(id="select2-calc_shipping_state-container")
	WebElement State;
	
	@FindBy(id="calc_shipping_city")
	WebElement City;
	
	@FindBy(id="calc_shipping_postcode")
	WebElement Postalcode;
	
	@FindBy(xpath="//button[text()='Update']")
	WebElement Update_Btn;
	
	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void explore_Cartpage() throws InterruptedException
	{
//		cart_Menu.click();
		Actions A=new Actions(driver);
		Thread.sleep(1000);
		A.moveToElement(cart_Menu).click(view_cart).perform();
		remove.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		undo.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		quantity.clear();
		quantity.sendKeys("1");
		Thread.sleep(1000);
		update_Cartbtn.click();
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		/*calculate_Shipping.click();
		State.click();
		text_Field.sendKeys(Keys.SHIFT,"Tamil Nadu");
		text_Field.sendKeys(Keys.ENTER);
		//Select s=new Select(text_Field);
		//s.selectByIndex(1);
		City.sendKeys("Chennai");
		Thread.sleep(1000);
		Postalcode.sendKeys("600013");
		Thread.sleep(1000);
		Update_Btn.click();*/
	}
}
