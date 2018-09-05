package com.ks.masapi.processor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ks.masapi.connector.RestClientConnector;
import com.ks.masapi.model.InterestRate;
import com.ks.masapi.model.option.ArgumentOption;
import com.ks.masapi.processor.Processor;
import com.ks.masapi.report.ReportGenerator;

@Component
public abstract class ProcessorImpl implements Processor {
	
	@Autowired
	protected RestClientConnector restClient;
	
	protected ReportGenerator reportGenerator;
	
	public RestClientConnector getRestClient() {
		return restClient;
	}

	public void setRestClient(RestClientConnector restClient) {
		this.restClient = restClient;
	}

	public ReportGenerator getReportGenerator() {
		return reportGenerator;
	}

	public void setReportGenerator(ReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}
	
	public abstract InterestRate extractData(ArgumentOption argumentOption) throws Exception;
	
	public String generateReport(InterestRate interestRate, ArgumentOption argumentOption) throws Exception{
		return reportGenerator.generateReport(interestRate, argumentOption);
	}
	
}
