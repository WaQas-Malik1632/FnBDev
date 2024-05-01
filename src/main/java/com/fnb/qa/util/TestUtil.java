package com.fnb.qa.util;
import java.io.IOException;
import com.fnb.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	
	//declare page load and implicit wait values and load them in base class
	 public static long PAGE_LOAD_TIMEOUT =20;
	 public static long IMPLICIT_WAIT=10;

	 
	public TestUtil() throws IOException
	{
		super();
	}
	
    //for switching to mainpanel frame
    public void switchtoframe() {
        driver.switchTo().frame("mainpanel");
    }
}

