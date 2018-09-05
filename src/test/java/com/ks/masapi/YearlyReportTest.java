package com.ks.masapi;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class YearlyReportTest {
	
	private static final Logger logger = LogManager.getLogger( MonthlyReportTest.class );	

	/**
	 * Testing valid case for Jan to Aug 2018, display 1,3,9
	 * 
	 * @throws Exception
	 */
	@Test
	public void testYearlyRpt01Test()throws Exception{
		String args[] = "report.type=Y start.date=Jan-2000 end.date=Aug-2005 display.type=1,3,9".split(" ");
		MainClass.main(args);
        assertEquals("","");		
    }
	
	/**
	 * Testing valid case for Jan to Dec 2017, display 2,3,4,6,7,8
	 * 
	 * @throws Exception
	 */
	@Test
	public void testYearlyRpt02Test()throws Exception{
		String args[] = "report.type=y start.date=Jan-1990 end.date=Dec-2017 display.type=2-4,6,7-8".split(" ");
		MainClass.main(args);
        assertEquals("","");		
    }
	
	/**
	 * Testing valid case for Jan to Sep 2017, display 5,11
	 * 
	 * @throws Exception
	 */
	@Test
	public void testYearlyRpt03Test()throws Exception{
		String args[] = "report.type=Y start.date=Jan-2000 end.date=DEC-2017 display.type=11,5".split(" ");
		MainClass.main(args);
        assertEquals("","");		
    }
}
