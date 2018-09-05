package com.ks.masapi.report.impl;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ks.masapi.constants.AppConstants;
import com.ks.masapi.model.InterestRate;
import com.ks.masapi.model.Record;
import com.ks.masapi.model.option.ArgumentOption;
import com.ks.masapi.model.option.RecordTypeOption;
import com.ks.masapi.report.ReportGenerator;

public class ReportYearly implements ReportGenerator{
	
	private static final Logger logger = LoggerFactory.getLogger(ReportYearly.class);

	/**
	 * generate the yearly report, if the Record Type input option 1-11 will be display accordingly
	 *
	 */
	public String generateReport(InterestRate interestRate, ArgumentOption argumentOption) {
		StringBuffer sbf = new StringBuffer();
		ArrayList<RecordTypeOption> displayOptions = new ArrayList<RecordTypeOption>();
		ArrayList<Record> records = interestRate.getResult().getRecords();
		for (RecordTypeOption rtOption : argumentOption.getHmapRecordTypeOption()) {
			if (rtOption.isDisplayOnReport()) {
				displayOptions.add(rtOption);
			}
		}
		Date rptDate = new Date();		
		sbf.append(" Yearly report datetime   ---    " + AppConstants.dateFormatterReportDate.format(rptDate) + "\n\n");
		sbf.append(" Year");
		for (RecordTypeOption option : displayOptions) {
			sbf.append("|" + padLeft(option.getRecordTypeEnum().toString()));
		}
		sbf.append("\n");
		for (Record record : records) {
			sbf.append(" " + record.getEnd_of_year());
			String formattedString = "";
			String trend = "";
			for (RecordTypeOption option : displayOptions) {
				trend = " ";
				switch (option.getRecordTypeEnum()) {
				case prime_lending_rate:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getPrime_lending_rate() > record.getPrime_lending_rate()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getPrime_lending_rate() < record.getPrime_lending_rate()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getPrime_lending_rate());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				case banks_fixed_deposits_3m:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getBanks_fixed_deposits_3m() > record.getBanks_fixed_deposits_3m()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getBanks_fixed_deposits_3m() < record.getBanks_fixed_deposits_3m()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getBanks_fixed_deposits_3m());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				case banks_fixed_deposits_6m:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getBanks_fixed_deposits_6m() > record.getBanks_fixed_deposits_6m()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getBanks_fixed_deposits_6m() < record.getBanks_fixed_deposits_6m()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getBanks_fixed_deposits_6m());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				case banks_fixed_deposits_12m:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getBanks_fixed_deposits_12m() > record.getBanks_fixed_deposits_12m()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getBanks_fixed_deposits_12m() < record.getBanks_fixed_deposits_12m()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getBanks_fixed_deposits_12m());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				case banks_savings_deposits:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getBanks_savings_deposits() > record.getBanks_savings_deposits()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getBanks_savings_deposits() < record.getBanks_savings_deposits()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getBanks_savings_deposits());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				case fc_hire_purchase_motor_3y:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getFc_hire_purchase_motor_3y() > record.getFc_hire_purchase_motor_3y()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getFc_hire_purchase_motor_3y() < record.getFc_hire_purchase_motor_3y()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getFc_hire_purchase_motor_3y());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				case fc_housing_loans_15y:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getFc_housing_loans_15y() > record.getFc_housing_loans_15y()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getFc_housing_loans_15y() < record.getFc_housing_loans_15y()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getFc_housing_loans_15y());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				case fc_fixed_deposits_3m:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getFc_fixed_deposits_3m() > record.getFc_fixed_deposits_3m()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getFc_fixed_deposits_3m() < record.getFc_fixed_deposits_3m()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getFc_fixed_deposits_3m());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				case fc_fixed_deposits_6m:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getFc_fixed_deposits_6m() > record.getFc_fixed_deposits_6m()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getFc_fixed_deposits_6m() < record.getFc_fixed_deposits_6m()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getFc_fixed_deposits_6m());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				case fc_fixed_deposits_12m:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getFc_fixed_deposits_12m() > record.getFc_fixed_deposits_12m()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getFc_fixed_deposits_12m() < record.getFc_fixed_deposits_12m()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getFc_fixed_deposits_12m());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				case fc_savings_deposits:
					if (option.getPreviousRecord() != null) {
						if (option.getPreviousRecord().getFc_savings_deposits() > record.getFc_savings_deposits()) {
							trend = AppConstants.REPORT_TREND_DOWN;
						} else if (option.getPreviousRecord().getFc_savings_deposits() < record.getFc_savings_deposits()) {
							trend = AppConstants.REPORT_TREND_UP;
						}
					}
					formattedString = trend + " " + String.format("%5.2f", record.getFc_savings_deposits());
					sbf.append("|" + padLeft("" + formattedString));
					break;
				}
				option.setPreviousRecord(record);
			}
			sbf.append("\n");
		}
		logger.info("===Report===\n");
		logger.info(sbf.toString());
		return sbf.toString();
	}
	
	protected String padLeft(String originalString) {
		String paddedString = "                         ";
		if (originalString != null) {
			paddedString = paddedString.substring(originalString.length()) + originalString;
		}
		return paddedString;
	}
}
