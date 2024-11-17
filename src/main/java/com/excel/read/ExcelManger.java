package com.excel.read;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelManger {
	String value;
	public String getReadExcelData(int rowNum, int ColNum) throws Exception {
		// convert excel to stream = FIleInputStream class
		File file = new File("./src/test/resources/Login Test data.xlsx");
		FileInputStream fis = new FileInputStream(file);

		// read excel =Apache POI *****************
		// whole excel file as book >>
		Workbook workbook = WorkbookFactory.create(fis); // Create Workbook object

		Sheet sheet = workbook.getSheetAt(0); // Access first sheet (index 0)

		for (Row row : sheet) {// all row
			//System.out.println("------" + row.getRowNum());//row numb
			for (Cell cell : row) {// get cell
				//System.out.println("Column number ="+cell.getColumnIndex());
				
				if (row.getRowNum() != 0 
						&& row.getRowNum() ==rowNum 
						&& cell.getColumnIndex()==ColNum) {
					// 2nd all column ==> loop it to get each column
					// cell (row+col)= return data
					 value = cell.getStringCellValue();
					System.out.println(value);
				}
			}
		}
		
		return value;
	}//end

	public static void main(String[] args) throws Exception {
		
		//Row2_Col2==> row2=2-1=1 & clo2=2-1 =1
		//row & column count by index theory = actual number -1
		//Excel = horizontal(LT to RT) :Row & Vertical(top to down) : Column
		ExcelManger em = new ExcelManger();
		em.getReadExcelData(1,1);
	}

}
