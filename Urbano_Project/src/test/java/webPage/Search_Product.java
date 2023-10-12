package webPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Launch_Application;

public class Search_Product extends Launch_Application{
	
	@FindBy(xpath="//a[text()='HOME']")
	WebElement Home;
	
	@FindBy(id="woocommerce-product-search-field-1")
	WebElement search_product;
	
	@FindBy(xpath="//*[@id=\"page\"]/div[2]/div/div/div/div/section/div/div/div[3]/div/div/div/div/form/button")
	WebElement search_Btn;
	
	@FindBy(xpath="//a[@aria-label='Read more about “Wild Coriander Plant”']")
	WebElement outOfstock;
	
	@FindBy(xpath="//img[@alt='Moringa Oleifera Tree']")
	WebElement moringa_Plant;
	
	@FindBy(id="tab-title-reviews")
	WebElement review_Tab;
	
	@FindBy(xpath="//a[text()='4']")
	WebElement star_Rating;
	
	@FindBy(id="comment")
	WebElement review_Textbox;
	
	@FindBy(id="author")
	WebElement name_Field;
	
	@FindBy(id="email")
	WebElement email_Field;
	
	@FindBy(id="submit")
	WebElement submit_Btn;
	
	@FindBy(xpath="//div[@class='comment-text']")
	WebElement comment_Box;
	
	public Search_Product()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void search_Plants()
	{
		Home.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", search_product);
		search_product.click();
		search_product.sendKeys(Keys.SHIFT,"medicinal");
		search_Btn.click();
	}
	
	public void OutofStock_product() throws InterruptedException
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		outOfstock.click();
		//moringa_Plant.click(;
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		review_Tab.click();
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		star_Rating.click();
		review_Textbox.sendKeys(Keys.SHIFT,"please notify once this product is available on the store!@Urbano page");
		name_Field.sendKeys(Keys.SHIFT,"testing2013");
		email_Field.sendKeys("testing2013@gmail.com");
		submit_Btn.click();
		Thread.sleep(1000);
	}
	//listing categories
	//listing minimum prices
	
	public String getCommentText()
	{
		return comment_Box.getText();
	}
}
