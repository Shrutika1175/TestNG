package excelPara;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadrvnexcel {

	File file;
	FileInputStream fis;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFRow row;
	HSSFCell cell;
	int rowCount, cellCount, i,j;
	WebDriver driver;
	String fpath="C:\\Users\\DELL\\Documents\\practiceExcel\\ddtestExsauce";
	
	@BeforeTest
	public void beforetest() throws IOException {
		driver= new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
		
		file = new File(fpath);
		fis = new FileInputStream(file);
		workbook = new HSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
	}
	
	@DataProvider
	public Object[][] dp(){
		rowCount=sheet.getPhysicalNumberOfRows();
		cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data = new Object[rowCount-1][cellCount];
		
		for(i=0; i<rowCount-1; i++) {
			row=sheet.getRow(i+1);
			for(j=0; j<cellCount; j++) {
				cell= row.getCell(j);
				data[i][j]= cell.getStringCellValue();
			}
		}
		return data;
	}
	
	@Test(dataProvider="dp")
	public void validatelogin(String un, String pwd) {
	
	        driver.findElement(By.id("user-name")).sendKeys(un);
	        driver.findElement(By.id("password")).sendKeys(pwd);
	        driver.findElement(By.id("login-button")).click();
	        if(driver.getCurrentUrl().contains("inventory.html")) {
	            driver.findElement(By.id("react-burger-menu-btn")).click();
	            driver.findElement(By.linkText("Logout")).click();
	        }
	        else {
	            String ErrorMsg=driver.findElement
	                    (By.xpath("//div[@class='error-message-container error']/h3")).getText();
	            Assert.assertTrue(ErrorMsg.contains("Sorry, this user has been locked out."));
	        }
		}
	@AfterTest
    public void afterTest() throws IOException {
        workbook.close();  
        fis.close();
        driver.close();
        System.out.println("Done..");
    }
}

