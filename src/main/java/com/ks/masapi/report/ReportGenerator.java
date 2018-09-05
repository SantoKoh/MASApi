package com.ks.masapi.report;

import com.ks.masapi.model.InterestRate;
import com.ks.masapi.model.option.ArgumentOption;

/**
 * Interface for the different generation of report, Data Object InterestRate is passed in as param, Argument are setting object
 *
 */
public interface ReportGenerator {
	public String generateReport(InterestRate interestRate, ArgumentOption argumentOption);

}
