package AutomationTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class CartPage extends abstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class, 'cartSection')]/h3")
	List<WebElement> CartProducts;
	@FindBy(css=".totalRow button")
	WebElement CheckoutBtn;
	By CartProductswait = By.xpath("//div[contains(@class, 'cartSection')]/h3");
	
	public List<WebElement> CartList()
	{
		WaitForElementToAppear(CartProductswait);
		return CartProducts;
		
	}
	
	public Boolean CheckCart(String Productname)
	{
		Boolean value= CartProducts.stream().anyMatch(cartproduct->
        cartproduct.getText().equalsIgnoreCase(Productname));
		 return value;
		
	}
	
	public void Checkout()
	{
		CheckoutBtn.click();
		
	}
	
	
	
	}
