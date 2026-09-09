package AutomationTestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import AutomationTesting.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingpage;
    public WebDriver InitializeDriver() throws IOException
    {
    	Properties prop = new Properties();
    	FileInputStream fis = new FileInputStream("C:\\Users\\gopin\\eclipse-workspace New\\SeleniumFrameworkDesign\\src\\main\\java\\AutomationTesting\\resources\\GlobalData.properties");
    	prop.load(fis);
    	String BrowserName = System.getProperty("browser")!= null ? System.getProperty("browser"):prop.getProperty("browser");
    	
    	if (BrowserName.contains("Chrome"))
    	{	ChromeOptions options=new ChromeOptions();
    		WebDriverManager.chromedriver().setup();
    		if (BrowserName.contains("headless"))
    		{
    			options.addArguments("headless");
    			
    		}
             driver = new ChromeDriver(options);
             driver.manage().window().setSize(new Dimension(1920,1080));
             
            
    	}
    	else if (BrowserName.equalsIgnoreCase("edge"))
    	{
    		WebDriverManager.edgedriver().setup();
    		 driver = new EdgeDriver();
    	}
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    	return driver;
    	
    }
    
    public String GetScreenshot(String TestcaseName, WebDriver driver) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File Source = ts.getScreenshotAs(OutputType.FILE);
    	File file = new File(System.getProperty("user.dir")+"//Reports//"+TestcaseName+".png");
    	FileUtils.copyFile(Source, file);
    	return System.getProperty("user.dir")+"//Reports//"+TestcaseName+".png";
    }
    
    @BeforeMethod(alwaysRun=true)
    public LandingPage launchApplication() throws IOException
    {
    	driver = InitializeDriver();
    	landingpage = new LandingPage(driver);
        landingpage.Goto();
        return landingpage;
       
    }
    
    @AfterMethod(alwaysRun=true)
    public void quitapplication()
    {
    	driver.quit();
    }
    
    public List<HashMap<String, String>> GetJsonData(String FilePATH) throws IOException
    {   // Read Json to String
    	String JsonContent= FileUtils.readFileToString(new File(FilePATH),StandardCharsets.UTF_8);
    	
    	//Convert String to HashMAP
    	ObjectMapper Mapper = new ObjectMapper();
    	List<HashMap<String,String>> Data = Mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
    	return Data;
    }
    
	
    
}
