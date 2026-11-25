package AutomationTesting;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownloadFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    WebDriver driver =new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
    String Filename="C:\\Users\\gopin\\Downloads\\download.xlsx";
    String Updatevalue = "598";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    By Toastmessager= By.xpath("//div[@class=\"Toastify__toast-body\"]/div[2]");
    
    driver.findElement(By.id("downloadButton")).click();
    
    int row=rownumber(Filename,"Apple");
    int column=Columnnumber(Filename,"price");
    Assert.assertTrue(Updatecellvalue(Filename,row,column,Updatevalue));
    
    WebElement UploadBTN= driver.findElement(By.id("fileinput"));
    UploadBTN.sendKeys("C:\\Users\\gopin\\Downloads\\download.xlsx");
    
    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(Toastmessager));
    System.out.println(driver.findElement(Toastmessager).getText());
    String Number= driver.findElement(By.xpath("//div[text()='Apple']/parent::div/parent::div/div[@id='cell-4-undefined']")).getText();
    Assert.assertEquals(Updatevalue, Number);
    
    
    
    }
	 public static int rownumber(String filename, String rowitem) throws IOException
	    {
	    	FileInputStream fis = new FileInputStream(filename);
	    	XSSFWorkbook wb = new XSSFWorkbook(fis);
	    	XSSFSheet sh= wb.getSheet("Sheet1");
	    	Iterator<Row> rows = sh.iterator();
	    	int k=1;
	    	int rowindex=-1;
	    	while (rows.hasNext())
	    	{  	Row row=rows.next();
	    		Iterator<Cell> cells = row.cellIterator();
	    		while (cells.hasNext())
	    		{
	    			Cell cell = cells.next();
	    			if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(rowitem))
	    			{
	    				rowindex= k;
	    			}
	    			
	    		}
	    		k++;
	    		
	    	}
	    	return rowindex;
	    }
	 public static int Columnnumber(String filename, String columnitem) throws IOException  
	 {
		 FileInputStream fis = new FileInputStream(filename);
	    	XSSFWorkbook wb = new XSSFWorkbook(fis);
	    	XSSFSheet sh= wb.getSheet("Sheet1");
	    	Iterator<Row> rows = sh.iterator();
	    	Row row=rows.next();
	    	Iterator<Cell> cells = row.cellIterator();
	    	int l=1;
	    	int columnindex=0;
	    	while (cells.hasNext())
	    	{   Cell cell =cells.next();
	    		if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(columnitem))
    			{
    				columnindex= l;
    			}
	    		l++;
	    	}
	    return 	columnindex;
	 }
	 
	 public static boolean Updatecellvalue(String filename, int Row, int Column, String updatevalue) throws IOException  
	 {
		 FileInputStream fis = new FileInputStream(filename);
	    	XSSFWorkbook wb = new XSSFWorkbook(fis);
	    	XSSFSheet sh= wb.getSheet("Sheet1");
	    	Row row = sh.getRow(Row-1);
	    	Cell CellField = row.getCell(Column-1);
	    	CellField.setCellValue(updatevalue);
	    	fis.close();
	    	FileOutputStream Fos = new FileOutputStream(filename);
	    	wb.write(Fos);
	    	Fos.close();
	    	wb.close();
	    	return true;
	 }
	 
	 

}
