package utils;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import testBase.Launch_Application;

public class Utility extends Launch_Application{
	
	public static void account_LogIn(WebDriver driver,WebElement username,WebElement password,WebElement loginbtn)
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,300)");
		username.sendKeys(prop.getProperty("email"));
		password.sendKeys(prop.getProperty("password"));
		loginbtn.click();
		
	}
	
	public static void whatsapp_Mediapage(WebDriver driver)
	{
		String parentWindowHandle=driver.getWindowHandle();
		Set<String> windowHandles=driver.getWindowHandles();
		//switch to the pop-up window
		for(String handle:windowHandles)
		{
			if(!handle.equals(parentWindowHandle))
			{
				driver.switchTo().window(handle);
				driver.close();
				
			}
			
		}
		driver.switchTo().window(parentWindowHandle);

	}
	
	public static void sort_Item(WebDriver driver,WebElement sort_Latest,WebElement sort) throws InterruptedException {
		//Using select class
		Select s=new Select(sort);
		/*List<WebElement> latest=s.getOptions();
		for(WebElement o:latest)
		{
			System.out.println(o.getText());
		}*/
		s.selectByIndex(2);
		Thread.sleep(2000);
	}
	
	public static void select_Planter(WebDriver driver,WebElement Planter,WebElement zoom_Item) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		Planter.click();
		Thread.sleep(1000);
		zoom_Item.click();
		Thread.sleep(1000);
	}
	
	public static void take_Screenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot S=(TakesScreenshot)driver;
		File source=S.getScreenshotAs(OutputType.FILE);
		File destination=new File("D:/planters.png");
		//File destination=new File("D:/planters"+Instant.now()+".png");
		org.apache.commons.io.FileUtils.copyFile(source, destination);
	}
	
	public static void perform_cart(WebDriver driver,WebElement add_to_Cart)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", add_to_Cart);
		add_to_Cart.click();
	}
	
	public static void orders_Screenshot(WebDriver driver) throws IOException
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		TakesScreenshot S=(TakesScreenshot)driver;
		File source=S.getScreenshotAs(OutputType.FILE);
		File destination=new File("D:/orders.png");
		//File destination=new File("D:/planters"+Instant.now()+".png");
		org.apache.commons.io.FileUtils.copyFile(source, destination);
	}
	

}