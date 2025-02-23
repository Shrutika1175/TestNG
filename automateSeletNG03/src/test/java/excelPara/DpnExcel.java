package excelPara;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DpnExcel {

	File file;
	FileOutputStream fos;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFRow row;
	HSSFCell cell;
	String fpath="C:\\Users\\DELL\\Documents\\practiceExcel\\practWB03";
	int i=0;
	@BeforeTest

	   public void beforeTest() throws FileNotFoundException {

	       file=new File(fpath);

	       fos=new FileOutputStream(file);

	       workbook=new HSSFWorkbook();

	       sheet=workbook.createSheet("MyCompDetails");

	   }
	@Test(dataProvider="dp")
	public void addcompData(String name, String company, String location) {
		row = sheet.createRow(i);
		//
		cell=row.createCell(0);
		cell.setCellValue(name);
		cell= row.createCell(1);
		cell.setCellValue(company);
		cell= row.createCell(2);
		cell.setCellValue(location);
		i++;
	}
	@DataProvider()
	public Object[][] dp(){
		Object[][] data = new Object[5][3];
		data[0][0]="Name";
		data[0][1]="Company";
		data[0][2]="Location";
		data[1][0]="Sita";
		data[1][1]="DRC";
		data[1][2]="Pune";
		data[2][0]="Gita";
		data[2][1]="SRR";
		data[2][2]="Raipur";
		data[3][0]="Vinita";
		data[3][1]="SPP LTD";
		data[3][2]="South goa";
		data[4][0]="Karina";
		data[4][1]="GGR";
		data[4][2]="Nagpur";
		return data;
	}
    @AfterTest
    public void afterTest() throws IOException {
        workbook.write(fos);
        workbook.close();
        fos.close();
        System.out.println("Done..");
    }

}
