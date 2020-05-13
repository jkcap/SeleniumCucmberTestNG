package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public class fileReader1 {

	public String[][] filereadxls(String sheetBook,String WorkBook) {
		String[][] xData = null;
		File file = new File(System.getProperty("user.dir") +"/InputData/"+sheetBook+".xls");
		try {
			FileInputStream fi = new FileInputStream(file);
			HSSFWorkbook workbook = null;
			try {
				workbook = new HSSFWorkbook(fi);
			} catch (IOException e) {
				e.printStackTrace();
			}
			HSSFSheet sheet = workbook.getSheet(WorkBook);
			int rowCount = sheet.getLastRowNum() + 1;
			int cellCount = sheet.getRow(0).getLastCellNum();
			xData = new String[rowCount][cellCount];
			DataFormatter df = new DataFormatter();
			int r = 0;
			for (int i = 0; i <= rowCount; i++) {
				Row row = sheet.getRow(i);

				if (row != null) {
					for (int j = 0; j < cellCount; j++) {
						Cell cell = sheet.getRow(i).getCell(j);
						String valueAsString = df.formatCellValue(cell);
						// System.out.print((valueAsString) + "\t\t\t");
						xData[r][j] = valueAsString;
						//System.out.print(valueAsString + "\t\t\t");
						// System.out.print(row.getCell(j) != null ?
						// row.getCell(j).getStringCellValue() + "\t" : "\t\t");
					}
					System.out.println();
					r++;
				}

			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// return xData;

		return xData;

	}

}