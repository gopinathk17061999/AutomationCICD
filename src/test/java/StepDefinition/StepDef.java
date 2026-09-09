package StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import AutomationTestComponents.BaseTest;
import AutomationTesting.CartPage;
import AutomationTesting.LandingPage;
import AutomationTesting.checkoutPage;
import AutomationTesting.productCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef  extends BaseTest
{  public LandingPage landingpage;
   public productCatalogue productcatalogue;
   public checkoutPage checkoutpage;
   public CartPage cartpage;
   
   
   @Given("I land on Ecommerce page")
   public void I_land_on_Ecommerce_page() throws IOException 
   {
	   landingpage= launchApplication();
   }
   
   @Given ("^Logged in with username (.+) and Password (.+)$")
   public void Logged_in_with_username_and_Password(String name, String pass)
   {
	   landingpage.loginApplication(name,pass);
   }
	
   @When ("^I add product (.+) to cart$")
   public void I_add_product_to_cart(String Productname)
	{
		
		productcatalogue = new productCatalogue(driver);
        List<WebElement> products = productcatalogue.ProductList();
        productcatalogue.Addtocart(Productname);
        productcatalogue.gotoCart();
        
	}
	@And  ("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String Productname)
	{   String CountryName="india";
	    cartpage = new CartPage(driver);
	    List<WebElement> cartProducts = cartpage.CartList();
	    Boolean Value= cartpage.CheckCart(Productname);
	    cartpage.Checkout();
	    checkoutpage = new checkoutPage(driver);
	    checkoutpage.Checkoutpage1();
		checkoutpage.selectcountryindropdown(CountryName);
	}
	
	@Then ("{string} message is displayed on confirmation Page")
	public void message_is_displayed_on_confirmation_Page(String string)
	{
		String ThanksMsg= checkoutpage.ThanksMessage();
        Boolean msg= ThanksMsg.equalsIgnoreCase(string);
        driver.close();
        
	}
}
