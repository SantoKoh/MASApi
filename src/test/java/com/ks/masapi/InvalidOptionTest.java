package com.ks.masapi;

import static org.testng.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.ks.masapi.MainClass;
import com.ks.masapi.constants.AppConstants;

public class InvalidOptionTest {
private static final Logger logger = LogManager.getLogger( InvalidOptionTest.class );
	
	/**
	 * Test invalid input, args is empty
	 * 
	 * @throws Exception
	 */
	@Test
	public void testErrorInput01Test()throws Exception{				
        boolean thrown = false;
        try {        	
    		String args[] = null;
    		MainClass.main(args);            
        } catch (Exception e) {
        	thrown = AppConstants.ERR_MSG_INVALID_OPTION_EMPTY.equals(e.getMessage());
        }
        assertEquals(true, thrown);
    }
	
	/**
	 *  Test invalid input for report type - empty
	 *  
	 * @throws Exception
	 */
	@Test
	public void testErrorInput02Test()throws Exception{				
        boolean thrown = false;
        try {        	
    		String args[] = " start.date=Jul-2017 end.date=Mar-2017 display.type=2".split(" ");
    		MainClass.main(args);            
        } catch (Exception e) {
        	thrown = AppConstants.ERR_MSG_INVALID_OPTION_REPORT_TYPE.equals(e.getMessage());
        }
        assertEquals(true, thrown);
    }
	
	/**
	 *  Test invalid input for report type 'X' valid one is Yy Mm
	 *  
	 * @throws Exception
	 */
	@Test
	public void testErrorInput03Test()throws Exception{				
        boolean thrown = false;
        try {        	
    		String args[] = "report.type=x start.date=Jul-2017 end.date=Mar-2017 display.type=3".split(" ");
    		MainClass.main(args);            
        } catch (Exception e) {
        	thrown = AppConstants.ERR_MSG_INVALID_OPTION_REPORT_TYPE.equals(e.getMessage());
        }
        assertEquals(true, thrown);
    }
	
	/**
	 *  Test invalid input 'aaa-2017' for start.date  MMM-yyyy
	 *  
	 * @throws Exception
	 */
	@Test
	public void testErrorInput04Test()throws Exception{				
        boolean thrown = false;
        try {        	
    		String args[] = "report.type=m start.date=aaa-2017 end.date=Mar-2017 display.type=3".split(" ");
    		MainClass.main(args);            
        } catch (Exception e) {
        	thrown = AppConstants.ERR_MSG_INVALID_OPTION_DATE_RANGE.equals(e.getMessage());
        }
        assertEquals(true, thrown);
    }
	
	/**
	 *  Test invalid input 'JUL-18' for end.date  MMM-yyyy
	 *  
	 * @throws Exception
	 */
	@Test
	public void testErrorInput05Test()throws Exception{				
        boolean thrown = false;
        try {        	
    		String args[] = "report.type=Y start.date=JUL-2017 end.date=Mar-18 display.type=3".split(" ");
    		MainClass.main(args);            
        } catch (Exception e) {
        	thrown = AppConstants.ERR_MSG_INVALID_OPTION_DATE_RANGE.equals(e.getMessage());
        }
        assertEquals(true, thrown);
    }

	/**
	 *  Test invalid input start.date is earlier than end.date
	 *  
	 * @throws Exception
	 */
	@Test
	public void testErrorInput06Test()throws Exception{				
        boolean thrown = false;
        try {        	
    		String args[] = "report.type=M start.date=Jul-2017 end.date=Mar-2017 display.type=2".split(" ");
    		MainClass.main(args);            
        } catch (Exception e) {
        	thrown = AppConstants.ERR_MSG_INVALID_OPTION_DATE_RANGE.equals(e.getMessage());
          thrown = true;
        }
        assertEquals(true, thrown);
    }
	
	/**
	 * Test invalid input, the display record option must be a valid number, it supports range 1-4 with comma separator 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testErrorInput07Test()throws Exception{				
        boolean thrown = false;
        try {        	
    		String args[] = "report.type=M start.date=Jan-2017 end.date=Sep-2017 display.type=X,1,E".split(" ");
    		MainClass.main(args);           
        } catch (Exception e) {
        	thrown = AppConstants.ERR_MSG_INVALID_OPTION_DISPLAY_RPT_COL.equals(e.getMessage());
        }
        assertEquals(true, thrown);
    }
	
	/**
	 *  Test invalid input for display type (1-11), input is 12
	 *  
	 * @throws Exception
	 */
	@Test
	public void testErrorInput08Test()throws Exception{				
        boolean thrown = false;
        try {        	
    		String args[] = "report.type=M start.date=Jul-2017 end.date=Mar-2017 display.type=12".split(" ");
    		MainClass.main(args);            
        } catch (Exception e) {
        	thrown = AppConstants.ERR_MSG_INVALID_OPTION_DISPLAY_RPT_COL.equals(e.getMessage());
        }
        assertEquals(true, thrown);
    }
	
	/**
	 *  Test invalid input for display type (1-11), input is 0
	 *  
	 * @throws Exception
	 */
	@Test
	public void testErrorInput09Test()throws Exception{				
        boolean thrown = false;
        try {        	
    		String args[] = "report.type=M  start.date=Jul-2017 end.date=Mar-2017 display.type=0".split(" ");
    		MainClass.main(args);            
        } catch (Exception e) {
        	thrown = AppConstants.ERR_MSG_INVALID_OPTION_DISPLAY_RPT_COL.equals(e.getMessage());
        }
        assertEquals(true, thrown);
    }
	

	
}
