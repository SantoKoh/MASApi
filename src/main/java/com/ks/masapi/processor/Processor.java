package com.ks.masapi.processor;

import com.ks.masapi.model.InterestRate;
import com.ks.masapi.model.option.ArgumentOption;

/**
 * Interface for the business processor, extractData is to get the data
 *
 */
public interface Processor{
	public InterestRate extractData(ArgumentOption argumentOption) throws Exception;
	public String generateReport(InterestRate interestRate, ArgumentOption argumentOption) throws Exception;
	
}
