package com.tyss.justdial.library;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	/**
	 * To Read the data from the cell
	 * @param excelPath
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 */
	public String getExcelData(String excelPath, String sheetName, int rowNo, int cellNo) {

		String data = "";

		try {
			//System.out.println("excelPath:" + excelPath);
			System.out.println("SheetName:" + sheetName+" "+"rowNo:" + rowNo + " " + "cellNo:" + cellNo);
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			data = sht.getRow(rowNo).getCell(cellNo).toString();
			System.out.println(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * To get the Total number of rows(data filled rows) in the sheet 
	 * @param excelPath
	 * @param sheetName
	 * @return
	 */
	public int getExcelRowCount(String excelPath, String sheetName) {

		int iRowNum = -1;
		try {
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			iRowNum = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iRowNum;
	}

	/**
	 *  To get the Number of columns from the Each row 
	 * @param excelPath
	 * @param sheetName
	 * @param rowNo
	 * @return
	 */
	public int getExcelCellCount(String excelPath, String sheetName, int rowNo) {

		int cellCount = 0;
		try {
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			cellCount = sht.getRow(rowNo).getLastCellNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellCount;
	}
}