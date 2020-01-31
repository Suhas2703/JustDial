package com.tyss.justdial.library;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	/**
	 * @author Shobhan
	 * @description To Read the data from the cell
	 * @param excelPath
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 */
	public String getExcelData(String excelPath, String sheetName, int rowNo, int cellNo) {

		String data = "";

		try {
			// System.out.println("excelPath:" + excelPath);
			System.out.println("SheetName:" + sheetName + " " + "rowNo:" + rowNo + " " + "cellNo:" + cellNo);
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			data = sht.getRow(rowNo).getCell(cellNo).toString();
//			sht.getRow(rowNo).getLastCellNum();
			// System.out.println(data);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * @author Shobhan
	 * @description To get the Total number of rows(data filled rows) in the sheet
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
	 * @author Shobhan
	 * @description To get the Number of columns from the Each row
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

	public void getAllTheExcelData(String excelPath, String sheetName) {
		ExcelLibrary excelLibrary = new ExcelLibrary();
		int row = excelLibrary.getExcelRowCount(excelPath, sheetName);
		int column = excelLibrary.getExcelCellCount(excelPath, sheetName, row);
		System.out.println(row);
		System.out.println(column);

		for (int i = 0; i <= row; i++) {

			for (int j = 0; j < column; j++) {
				System.out.println(excelLibrary.getExcelData(excelPath, sheetName, i, j));
			}

		}
	}
}