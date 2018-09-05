package com.ks.masapi.processor.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ks.masapi.constants.AppConstants;
import com.ks.masapi.model.InterestRate;
import com.ks.masapi.model.option.ArgumentOption;

@Component
public class ProcessorYearlyImpl extends ProcessorImpl{
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessorYearlyImpl.class);
	
	public ProcessorYearlyImpl(){
		
	}
	
	/**
	 * Process will extract yearly report data the input parameters i) report type ii) start date, iii) end date, iv) display report type option 1-11
	 * As the REST API will only return limit of 100 records, 
	 * it will loop using offset and append the rest of the list into the main InterestRate Object
	 * 
	 * @param ArgumentOption
	 * @throws Exception
	 */
	public InterestRate extractData(ArgumentOption argumentOption) throws Exception{
		int intOffSet = 0;
		int totals = 0;
		int limits = 100;
		int counter = 1;
		InterestRate interestRate = null;
		try {	
			String dateRange = AppConstants.MAS_REST_PRARM_YEARLY_DATE_RANGE 
					+ AppConstants.dateFormatterAPI.format(argumentOption.getStartDate()) + "," 
					+ AppConstants.dateFormatterAPI.format(argumentOption.getEndDate());
			String urlInput = AppConstants.MAS_REST_URL 
					+ AppConstants.MAS_REST_PRARM_RESOURCE_ID + AppConstants.MAS_REST_RESOURCE_ID_YEARLY 
					+ AppConstants.MAS_REST_PRARM_LIMIT + limits + dateRange 
					+ AppConstants.MAS_REST_PRARM_YEARLY_SORT_ASC;
			interestRate = restClient.connect(urlInput);
			if (interestRate != null){
				if (interestRate.getResult().getTotal() != null){
					totals = Integer.valueOf(interestRate.getResult().getTotal());
					intOffSet = interestRate.getResult().getRecords().size();
					while (totals - intOffSet > 0){
						// repeat the loops for more than the limit records
						logger.info("Output from counter " + counter +" intOffSet=" + intOffSet + "\n");
						urlInput = AppConstants.MAS_REST_URL 
								+ AppConstants.MAS_REST_PRARM_RESOURCE_ID + AppConstants.MAS_REST_RESOURCE_ID_YEARLY  
								+ AppConstants.MAS_REST_PRARM_LIMIT + limits + dateRange 
								+ AppConstants.MAS_REST_PRARM_OFFSET + intOffSet 
								+ AppConstants.MAS_REST_PRARM_YEARLY_SORT_ASC;
						logger.info("urlInput=" + urlInput + ".... \n");
						InterestRate interestRateTemp = restClient.connect(urlInput);
						intOffSet = intOffSet + interestRateTemp.getResult().getRecords().size();
						counter ++;
						interestRate.getResult().getRecords().addAll(interestRateTemp.getResult().getRecords());
						logger.info("interestRate.totals=" + interestRate.getResult().getRecords().size() + "interestRateTemp.totals=" + interestRateTemp.getResult().getRecords().size() + ".... \n");
						// prevent endless loop from happening, the total records doesn't exceed 100 times
						if (counter > AppConstants.LOOP_COUNTER_BREAKER){							
							break;
						}
					}
				}
				//reportGenerator.generateReport(interestRate, argumentOption);
			}
			logger.info("Final total records =" + interestRate.getResult().getRecords().size() +  "\n" + interestRate.toString() + "\n");	
		} catch (Exception e) {			
			throw e;
		}
		return interestRate;
	}
	

}
