package AutomationTesting;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationTestComponents.BaseTest;
import AutomationTestComponents.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest{

	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void Loginerror() throws IOException
	{
		// TODO Auto-generated method stub
        
        String Productname="ZARA COAT 3";
        String CountryName="india";
        landingpage.loginApplication("gopinath.k170699@gmail.com", "Gopi1223456");
        Assert.assertEquals("Incorrect email or password.", landingpage.GetErrorMessage());
        
	}
	
	@Test
	public void Producterror() throws IOException
	{
		// TODO Auto-generated method stub
        
        String Productname="ZARA COAT 3";
        String CountryName="india";
        landingpage.loginApplication("gopinath.k17061999@gmail.com", "Gopi170619");
        productCatalogue productcatalogue = new productCatalogue(driver);
        List<WebElement> products = productcatalogue.ProductList();
        productcatalogue.Addtocart(Productname);
        productcatalogue.gotoCart();
        CartPage cartpage = new CartPage(driver);
        List<WebElement> cartProducts = cartpage.CartList();
        Boolean Value= cartpage.CheckCart("ZARA COAT 33");
        Assert.assertFalse(Value);
        
        
	}

}
