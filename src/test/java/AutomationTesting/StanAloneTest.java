package AutomationTesting;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AutomationTestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StanAloneTest extends BaseTest{
	String Productname="ZARA COAT 3";
	@Test(dataProvider= "getdata1",groups = {"Purchase"})
	public void StandAlone(HashMap<String,String> input) throws IOException
	{
		// TODO Auto-generated method stub
        
        
        String CountryName="india";
        landingpage.loginApplication(input.get("email"),input.get("Pass"));
        productCatalogue productcatalogue = new productCatalogue(driver);
        List<WebElement> products = productcatalogue.ProductList();
        productcatalogue.Addtocart(input.get("productname"));
        productcatalogue.gotoCart();
        CartPage cartpage = new CartPage(driver);
        List<WebElement> cartProducts = cartpage.CartList();
        Boolean Value= cartpage.CheckCart(input.get("productname"));
        Assert.assertTrue(Value);
        cartpage.Checkout();
        checkoutPage checkoutpage = new checkoutPage(driver);
        checkoutpage.Checkoutpage1();
        checkoutpage.selectcountryindropdown(CountryName);
        String ThanksMsg= checkoutpage.ThanksMessage();
        Boolean msg= ThanksMsg.equalsIgnoreCase("Thankyou for the order.");
        Assert.assertTrue(msg);
        
	}
	@Test(dependsOnMethods= {"StandAlone"})
	public void orderValidation()
	{
		landingpage.loginApplication("gopinath.k170699@gmail.com", "Gopi123456");
		OrderPage orderpage =landingpage.orderCart();
		orderpage.orderList();
		orderpage.orderCart(Productname);
	}
	
	public void Takescreenshot(String Testcasename ) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("C://Users//gopin//eclipse-workspace New//SeleniumFrameworkDesign//Reports"+Testcasename+".png");
		FileUtils.copyFile(source, dest);
	}
	@DataProvider
	public Object[][] getdata1() throws IOException
	{   /*HashMap<String,String> Map = new HashMap<String,String>();
	    Map.put("email", "gopinath.k170699@gmail.com");
	    Map.put("Pass", "Gopi123456");
	    Map.put("productname", "ZARA COAT 3");
	    
	    HashMap<String,String> Map1 = new HashMap<String,String>();
	    Map1.put("email", "gopinath.k17061999@gmail.com");
	    Map1.put("Pass", "Gopi170619");
	    Map1.put("productname", "ADIDAS ORIGINAL");*/
		List<HashMap<String, String>> data= GetJsonData("C:\\Users\\gopin\\eclipse-workspace New\\SeleniumFrameworkDesign\\src\\test\\java\\AutomationTestingData\\TestData.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
