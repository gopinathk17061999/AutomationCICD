package AutomationTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class productCatalogue extends abstractComponent {

	WebDriver driver;
	public productCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> Products;
	By ProductsBy = By.cssSelector(".mb-3");
	By cartButton = By.cssSelector(".card-body button:last-of-type");
	By PopUp = By.xpath("//div[@aria-label='Product Added To Cart']");
	public List<WebElement> ProductList()
	{
		WaitForElementToAppear(ProductsBy);
		return Products;
		
	}
	
	public WebElement GetProductByName(String Productname)
	{
		 WebElement prod = Products.stream().filter(product->
	        product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
		 return prod;
		
	}
	
	public void Addtocart(String Productname)
	{
		WebElement prod = GetProductByName(Productname);
		 prod.findElement(cartButton).click();
		 WaitForElementToAppear(PopUp);
		
	}
	
	
	
	}
