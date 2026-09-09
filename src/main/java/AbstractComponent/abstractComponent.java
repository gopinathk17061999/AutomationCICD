package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationTesting.OrderPage;

public class abstractComponent {
WebDriver driver;
	public abstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement ProductsCart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement OrdersCart;
	
	public void WaitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void WaitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void gotoCart() 
	{
		 ProductsCart.click();
	}
	
	public OrderPage orderCart() 
	{   OrderPage orderpage = new OrderPage(driver);
		OrdersCart.click();
		return orderpage;
	}

}
