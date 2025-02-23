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
import org.testng.annotations.Test;

public class firstExcel {

	File file;
	FileOutputStream fos;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFRow row;
	HSSFCell cell;
	String fpath="C:\\Users\\DELL\\Documents\\practiceExcel\\practWB01";
	
	@BeforeTest

	   public void beforeTest() throws FileNotFoundException {

	       file=new File(fpath);

	       fos=new FileOutputStream(file);

	       workbook=new HSSFWorkbook();

	       sheet=workbook.createSheet("My Sheet");

	   }

	   @Test

	   public void WriteInCell() {

	       row=sheet.createRow(0);//first row creation

	       cell=row.createCell(0);//First cell creation

	       cell.setCellValue("My cell");    

	   }

	@AfterTest

	public void afterTest() throws IOException {

	    workbook.write(fos);

	    workbook.close();

	    fos.close();

	    System.out.println("Done..");

	}
}
