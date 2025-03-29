package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	//Dataproviders
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from testdata
		
		Excelutility xlutil = new Excelutility(path);
		
		int rowCount = xlutil.getRowCount("Sheet1");
		int cellCount = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[rowCount-1][cellCount];
		
	    for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;

	}
}
