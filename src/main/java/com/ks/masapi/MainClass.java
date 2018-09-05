package com.ks.masapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ks.masapi.model.InterestRate;
import com.ks.masapi.model.option.ArgumentOption;
import com.ks.masapi.processor.Processor;

public class MainClass {
	private static final Logger logger = LoggerFactory.getLogger(MainClass.class);	
	public static void main(String[] args) throws Exception{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("MASApi-context.xml");
			ArgumentOption argumentOption = new ArgumentOption();
			argumentOption.extractOptions(args);
			// base on the input report type M-Monthly Y-Yearly processor to process the report
			Processor processor = (Processor)context.getBean(argumentOption.getReportType().toString());
			InterestRate interestRate = processor.extractData(argumentOption);
			String reportOutput = processor.generateReport(interestRate, argumentOption);
			System.out.println(reportOutput);
		} catch (Exception e) {
			logger.error("error in main",e);
			throw e;
		}
	}
}
