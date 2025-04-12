package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider1

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		
		String path = ".\\testData\\Qafox_LoginData.xlsx"; // taking xl file from test data

		ExcelUtility xlutil = new ExcelUtility(path); // creating an object of XLutility

		int totalrows = xlutil.getRowCount("sheet1");
		int totalcols = xlutil.getCellCount("sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols]; // Created for two dimension array which can store the
																	// value.

		for (int i = 1; i <= totalrows; i++) // 1 //Read the data from xl storing in two dimensional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is row and j is column
			{
				logindata[i-1][j] = xlutil.getCellData("sheet1", i, j); // 1,0
			}
		}
		return logindata; // returning two dimension array

	}

	// If we want more number of data provider we can keep
	// DataProvider1

	// DataProvider2

	// DataProvider3

}
