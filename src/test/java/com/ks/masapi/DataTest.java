package com.ks.masapi;


import static org.testng.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.ks.masapi.model.InterestRate;
import com.ks.masapi.model.option.ArgumentOption;
import com.ks.masapi.processor.Processor;
import com.ks.masapi.util.JsonHelper;

public class DataTest {
	ApplicationContext context = new ClassPathXmlApplicationContext("MASApi-context.xml");
	private static final Logger logger = LogManager.getLogger( DataTest.class );
	public String readDataFromResourceTestFile(String path) throws Exception {
		String text = new String(Files.readAllBytes(Paths.get(getClass().getResource(path).toURI())),"UTF-8");
		return text;
	}
	
	/**
	 * Testing valid case for Monthly report Jan to Aug 2018, display report column 1,3,9
	 * , validating base on a single line of the test resource folder /report/testData01.txt 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testData01Test()throws Exception{
		logger.debug("Executing testData01Test");
		String args[] = "report.type=M start.date=Jan-2018 end.date=Aug-2018 display.type=1,3,9".split(" ");
		ArgumentOption argumentOption = new ArgumentOption();
		argumentOption.extractOptions(args);
		// base on the input report type M-Monthly Y-Yearly processor to process the report
		Processor processor = (Processor)context.getBean(argumentOption.getReportType().toString());
		InterestRate interestRate = processor.extractData(argumentOption);
		String reportOutput = processor.generateReport(interestRate, argumentOption);
		System.out.println(reportOutput);
		
    	String path = "/report/testData01.txt";    	
    	String payload = readDataFromResourceTestFile(path);
		assertEquals(true, reportOutput.contains(payload));		
    }
	
	/**
	 * Testing valid case for Yearly report Jan 1990 to Dec 2017, display report column  2,3,4,6,7,8
	 * , validating base on a single line of the test resource folder /report/testData01.txt 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testData02Test()throws Exception{
		logger.debug("Executing testData02Test");
		String args[] = "report.type=y start.date=Jan-1990 end.date=Dec-2017 display.type=2-4,6,7-8".split(" ");
		ArgumentOption argumentOption = new ArgumentOption();
		argumentOption.extractOptions(args);
		// base on the input report type M-Monthly Y-Yearly processor to process the report
		Processor processor = (Processor)context.getBean(argumentOption.getReportType().toString());
		InterestRate interestRate = processor.extractData(argumentOption);
		String reportOutput = processor.generateReport(interestRate, argumentOption);
		System.out.println(reportOutput);
		
    	String path = "/report/testData02.txt";    	
    	String payload = readDataFromResourceTestFile(path);
		assertEquals(true, reportOutput.contains(payload));			
    }
	
	/**
	 * Can check the json content due to the timestamp value, using total count to validate
	 * , test resource folder /report/testData03.txt
	 * 
	 * @throws Exception
	 */
	@Test
	public void testData03Test()throws Exception{
		logger.debug("Executing testData03Test");
		String args[] = "report.type=M start.date=Jan-2018 end.date=Jul-2018 display.type=1-11".split(" ");
		ArgumentOption argumentOption = new ArgumentOption();
		argumentOption.extractOptions(args);
		// base on the input report type M-Monthly Y-Yearly processor to process the report
		Processor processor = (Processor)context.getBean(argumentOption.getReportType().toString());
		InterestRate interestRate = processor.extractData(argumentOption);

    	String path = "/report/testData03.txt";    	
    	String payload = readDataFromResourceTestFile(path);
    	JsonHelper jsonHelper = new JsonHelper();
    	InterestRate interestRateFromFile = jsonHelper.convert(payload);
    	//System.out.println("***2=" + interestRateFromFile.toString());
		assertEquals(true, interestRate.getResult().getRecords().size() == interestRateFromFile.getResult().getRecords().size());
    }
	
}
