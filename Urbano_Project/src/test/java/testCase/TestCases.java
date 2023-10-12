package testCase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testBase.Launch_Application;
import webPage.AboutUs_Page;
import webPage.Cart_Page;
import webPage.Checkout_Page;
import webPage.ContactUs_Page;
import webPage.Dashboard_Page;
import webPage.Home_Page;
import webPage.Logout_Page;
import webPage.MyAccount_Page;
import webPage.Search_Product;
import webPage.Shop_Page;

public class TestCases extends Launch_Application{
	
	MyAccount_Page myAccount_page;
	Dashboard_Page dashBoard_page;
	Home_Page home_page;
	AboutUs_Page aboutUs_page;
	ContactUs_Page contactUs_page;
	Shop_Page shop_page;
	Search_Product search_product;
	Cart_Page cart_page;
	Checkout_Page checkout_page;
	Logout_Page logout_page;
	
	public TestCases()
	{
		super();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		launchApp();
		myAccount_page=new MyAccount_Page();
		dashBoard_page=new Dashboard_Page();
		aboutUs_page=new AboutUs_Page();
		contactUs_page=new ContactUs_Page();
		home_page=new Home_Page();
		shop_page=new Shop_Page();
		search_product=new Search_Product();
        cart_page=new Cart_Page();
        checkout_page=new Checkout_Page();
        logout_page=new Logout_Page();
  
	}
	
	@Test(priority=0)
	public void perform_Login()
	{
		SoftAssert softassert=new SoftAssert();
		myAccount_page.validate_Login();
		softassert.assertAll();
	}
	
	@Test(priority=1)
	public void edit_Accountpage()
	{
		SoftAssert softassert=new SoftAssert();
		myAccount_page.validate_Login();
		dashBoard_page.edit_Accountdetails();
		AssertJUnit.assertEquals(dashBoard_page.getSuccess_Message(),"Account details changed successfully.","Account Details Should be Changed");
		System.out.println(dashBoard_page.getSuccess_Message());
		softassert.assertAll();
	}
	
	@Test(priority=2)
	public void urbano_AboutUs() throws InterruptedException
	{
		SoftAssert softassert=new SoftAssert();
		aboutUs_page.explore_Aboutus();
		aboutUs_page.whatsapp_Medialink();
		aboutUs_page.facebook_Medialink();
		aboutUs_page.instagram_Medialink();
		softassert.assertAll();
	}
	
	@Test(priority=3)
	public void urabano_ContactUs() throws InterruptedException, AWTException
	{
		SoftAssert softassert=new SoftAssert();
		contactUs_page.explore_ContactUs();
		AssertJUnit.assertEquals(contactUs_page.getCongrats_Message(),"Thanks for contacting us! We will be in touch with you shortly.","Message should match");
		System.out.println(contactUs_page.getCongrats_Message());
		contactUs_page.map_View();
		softassert.assertAll();
	}
	
	@Test(priority=4)
	public void urbano_Homepage() throws InterruptedException, IOException
	{
		SoftAssert softassert=new SoftAssert();
		myAccount_page.validate_Login();
		home_page.explore_HomePage();
		home_page.select_Item();
		home_page.perform_AddtoCart();
		AssertJUnit.assertEquals(home_page.getCart_Message(),"View cart\n"+ "“Bamboo hanging hoop mini planter” has been added to your cart.","Message should match");
		System.out.println(home_page.getCart_Message());
		softassert.assertAll();
	}
	
	@Test(priority=5)
	public void urbano_ShopPage() throws InterruptedException
	{
		SoftAssert softassert=new SoftAssert();
		myAccount_page.validate_Login();
		shop_page.explore_ShopPage();
		shop_page.select_Product();
		softassert.assertAll();
	}
	
	@Test(priority=6)
	public void urbano_Searchproduct() throws InterruptedException
	{
		myAccount_page.validate_Login();
		SoftAssert softassert=new SoftAssert();
		search_product.search_Plants();
		search_product.OutofStock_product();
		System.out.println(search_product.getCommentText());
		softassert.assertAll();
	}
	
	@Test(priority=7)
	public void urbano_Cartpage() throws InterruptedException
	{
		myAccount_page.validate_Login();
		SoftAssert softassert=new SoftAssert();
		cart_page.explore_Cartpage();
		softassert.assertAll();
	}
	
	@Test(priority=8)
	public void urbano_Checkoutpage() throws InterruptedException
	{
		myAccount_page.validate_Login();
		SoftAssert softassert=new SoftAssert();
		checkout_page.explore_Checkoutpage();
		System.out.println(checkout_page.getOrderPlaced_Message());
		softassert.assertAll();
	}
	
	@Test(priority=9)
	public void urbano_Logoutpage() throws InterruptedException, IOException
	{
		myAccount_page.validate_Login();
		SoftAssert softassert=new SoftAssert();
		logout_page.Order_page();
		softassert.assertAll();
	}
	
	
}
