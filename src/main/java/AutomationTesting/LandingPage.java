package AutomationTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class LandingPage extends abstractComponent{

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement usermail;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement Submit;
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement ErrorMesage;
	
	public String GetErrorMessage()

	{
		WaitForWebElementToAppear(ErrorMesage);
		return ErrorMesage.getText();
	}
	
	public void loginApplication(String email,String Pass)
	{
		usermail.sendKeys(email);
		Password.sendKeys(Pass);
		Submit.click();
	}
	public void Goto()
	{
		driver.get("https://rahulshettyacademy.com/client");
		
	}
}
