package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelData {
	
	public static String[][] readData2(String filename) throws IOException {
        XSSFWorkbook book = new XSSFWorkbook("./exceldatas/"+filename+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		int rowCount = sheet.getLastRowNum();
		System.out.println("Number Of Rows : " +rowCount);
		int cellCount = row.getLastCellNum();
		System.out.println("Number Of Columns : " +rowCount);
		
		String[][] data =new String[rowCount][cellCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String allDatas = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=allDatas; 
			}
		}

		book.close();
		return data;
	}

}
