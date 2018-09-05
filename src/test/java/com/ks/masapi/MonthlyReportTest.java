package com.ks.masapi;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class MonthlyReportTest {

	private static final Logger logger = LogManager.getLogger( MonthlyReportTest.class );
	
	/**
	 * Testing valid case for Jan to Aug 2018, display 1,3,9
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMonthlyRpt01Test()throws Exception{
		String args[] = "report.type=M start.date=Jan-2018 end.date=Aug-2018 display.type=1,3,9".split(" ");
		MainClass.main(args);
        assertEquals("","");		
    }
	
	/**
	 * Testing valid case for Jan to Dec 2017, display 2,3,4,6,7,8
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMonthlyRpt02Test()throws Exception{
		String args[] = "report.type=M start.date=Jan-2017 end.date=Sep-2017 display.type=2-4,6,7-8".split(" ");
		MainClass.main(args);
        assertEquals("","");		
    }
	
	/**
	 * Testing valid case for Jan to Sep 2017, display 5,11
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMonthlyRpt03Test()throws Exception{
		String args[] = "report.type=Y start.date=Jan-2000 end.date=DEC-2017 display.type=11,5".split(" ");
		MainClass.main(args);
        assertEquals("","");		
    }
	
	
	
}
