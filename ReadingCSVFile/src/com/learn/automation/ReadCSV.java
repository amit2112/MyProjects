package com.learn.automation;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCSV {
	
	public Object[][] main( String[] args) throws Exception{        
	    File excel = new File(args[0]);
	    FileInputStream fis = new FileInputStream(excel);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet ws = wb.getSheet(args[1]);

	    int rowNum = ws.getLastRowNum() + 1;
	    int colNum = ws.getRow(0).getLastCellNum();
	    String[][] data = new String[rowNum][colNum];

	    for (int i = 0 ; i < rowNum ; i++) {
	        XSSFRow row = ws.getRow(i);
	            for (int j = 0 ; j < colNum ; j++) {
	                XSSFCell cell = row.getCell(j);
	                String value = cellToString(cell);
	                data[i][j] = value ;
	                //System.out.println("the value is " + value);
	            }
	        }
	    System.out.println("Row nuber "+rowNum);
	    return data;
	    }
	
	public static String cellToString(XSSFCell cell) {  
	    int type;
	    Object result;
	    type = cell.getCellType();

	    switch (type) {

	        case 0: // numeric value in Excel
	            result = cell.getNumericCellValue();
	            break;
	        case 1: // String Value in Excel 
	            result = cell.getStringCellValue();
	            break;
	        default:  
	            throw new RuntimeException("There is no support for this type of cell");                        
	    }

	    return result.toString();
	}
	
}
