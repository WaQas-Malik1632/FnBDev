package com.fnb.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.crm.qa.base.TestBase;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class TestUtil extends TestBase {
	
	 //for testdata
/*	
	static Workbook book;
	 static Sheet sheet;
	 
	 */
	 
	//declare page load and implicit wait values and load them in base class
	 public static long PAGE_LOAD_TIMEOUT =20;
	 public static long IMPLICIT_WAIT=10;

	 
	
	public TestUtil() throws IOException {
		super();

	}
	
  //  public static String TEST_DATA_SHEET_PATH="D:/Selenium Automation/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";

    //for switching to mainpanel frame
    public void switchtoframe() {
        driver.switchTo().frame("mainpanel");
    }

 /*
    //for reading testdata
    public Object[][] getTestData(String sheetName) {

        FileInputStream file=null;
        try {
            file=new FileInputStream(TEST_DATA_SHEET_PATH);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        try {
            book=WorkbookFactory.create(file);
        }catch(InvalidFormatException e){
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }

        sheet=book.getSheet(sheetName);
        //used two dimensional object array
        Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i<sheet.getLastRowNum();i++) {
            for(int k=0;k<sheet.getRow(i+1).getLastCellNum();k++) {
                data[i][k]=sheet.getRow(i+1).getCell(k).toString();

            }
        }

        return data;
    }
    */

}

