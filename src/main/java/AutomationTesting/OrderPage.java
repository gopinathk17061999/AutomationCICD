package AutomationTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class OrderPage extends abstractComponent {

	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> OrderProductsList;
	
	@FindBy(xpath="//tr/td[2]")
	WebElement OrderProducts;
	
	By CartProductswait = By.xpath("//div[contains(@class, 'cartSection')]/h3");
	
	public List<WebElement> orderList()
	{
		WaitForWebElementToAppear(OrderProducts);
		return OrderProductsList;
		
	}
	
	public Boolean orderCart(String Productname)
	{
		Boolean value= OrderProductsList.stream().anyMatch(orderproduct->
        orderproduct.getText().equalsIgnoreCase(Productname));
		 return value;
		
	}
	
	
	
	
	}
