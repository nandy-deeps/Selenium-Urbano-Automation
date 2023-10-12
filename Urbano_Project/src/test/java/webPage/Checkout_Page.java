package webPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Launch_Application;

public class Checkout_Page extends Launch_Application{

	@FindBy(id="ast-site-header-cart")
	WebElement cart_Menu;	
	
	@FindBy(xpath="//a[@class='checkout-button button alt wc-forward']")
	WebElement checkout_btn;
	
	@FindBy(id="billing_address_1")
	WebElement Address;
	
	@FindBy(id="billing_city")
	WebElement City;
	
	@FindBy(id="select2-billing_state-container")
	WebElement State;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement text_Field;
	
	@FindBy(id="billing_postcode")
	WebElement postalcode;
	
	@FindBy(id="billing_phone")
	WebElement phone;
	
	@FindBy(xpath="//*[@id=\"payment_method_cod\"]")
	WebElement cashOn_radio;
	
	@FindBy(id="terms")
	WebElement radio;
	
	@FindBy(id="place_order")
	WebElement place_order;
	
	@FindBy(xpath="//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")
	WebElement Orderplaced_Message;
	
	public Checkout_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void explore_Checkoutpage() throws InterruptedException
	{
		cart_Menu.click();
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		checkout_btn.click();
		Actions a=new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Address.clear();
		Address.sendKeys("No.523, Anna Nagar");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		City.clear();
		City.sendKeys("Chennai");
		Thread.sleep(500);
		State.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		text_Field.clear();
		text_Field.sendKeys(Keys.SHIFT,"Tamil Nadu");
		text_Field.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		postalcode.clear();
		postalcode.sendKeys("600013");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		phone.clear();
		phone.sendKeys("9876543210");
		Thread.sleep(1000);
		cashOn_radio.click();
		Thread.sleep(1000);
		//a.moveToElement(cashOn_radio).click().perform();
		radio.click();
		Thread.sleep(1000);
		place_order.click();
		Thread.sleep(500);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(500);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	public String getOrderPlaced_Message()
	{
		return Orderplaced_Message.getText();
	}
	
}
