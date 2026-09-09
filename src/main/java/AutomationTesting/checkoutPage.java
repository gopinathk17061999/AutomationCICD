package AutomationTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class checkoutPage extends abstractComponent {

	WebDriver driver;
	public checkoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement selectcountry;
	@FindBy(xpath="(//button[contains(@class, 'ta-item')])[2]")
	WebElement Countryoptionele;
	@FindBy(css=".action__submit")
	WebElement Submit;
	@FindBy(css=".hero-primary")
	WebElement finalval;
	
	By Countrycheckbox = By.xpath("//input[@placeholder='Select Country']");
	By Countryoption = By.xpath("(//button[contains(@class, 'ta-item')])[2]");
	public void Checkoutpage1()
	{
		WaitForElementToAppear(Countrycheckbox);
		
		
	}
	
	public void selectcountryindropdown(String country)
	{
		Actions a =new Actions(driver);
        a.sendKeys(selectcountry, country).build().perform();
        WaitForElementToAppear(Countryoption);
        Countryoptionele.click();
        Submit.click();
        
	}
	
	public String ThanksMessage()
	{
		String thanks= finalval.getText();
        return thanks;
	}
	
	
	
	
	}
