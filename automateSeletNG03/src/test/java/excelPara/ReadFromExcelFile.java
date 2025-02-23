package excelPara;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadFromExcelFile {
	File file;
    FileInputStream fis;
    HSSFWorkbook workbook;
    HSSFSheet sheet;
    HSSFRow row;
    HSSFCell cell;
    int i,j,rowCount,cellCount;
    String fpath="C:\\Users\\DELL\\Documents\\practiceExcel\\practWB03";
    int rowcount;
    int cellcount;
    
    @BeforeTest
	public void beforeTest() throws IOException {
		file = new File(fpath);
		fis=new FileInputStream(file);
		workbook=new HSSFWorkbook(fis);
		sheet=workbook.getSheet("MyCompDetails");
	}
    
    @Test
	public void ReadFromExcel() {
		rowcount=sheet.getPhysicalNumberOfRows();
		cellcount=sheet.getRow(0).getPhysicalNumberOfCells();
		for(i=0;i<rowcount;i++) {
			row=sheet.getRow(i);
			for(j=0;j<cellcount;j++) {
				cell=row.getCell(j);
				System.out.println(cell.getStringCellValue()+"\t");
			}
			System.out.println();
		}
	}
	@AfterTest
    public void afterTest() throws IOException {
        
        workbook.close();
        fis.close();
        System.out.println("Done..");
    }

}
