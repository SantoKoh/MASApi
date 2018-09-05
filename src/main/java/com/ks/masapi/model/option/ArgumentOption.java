package com.ks.masapi.model.option;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ks.masapi.constants.AppConstants;
import com.ks.masapi.exception.AppException;

public class ArgumentOption extends AppConstants {
	private static final Logger logger = LoggerFactory.getLogger(ArgumentOption.class);

	public ArgumentOption() {
	}
	private ReportTypeEnum reportType = null;
	private Date startDate = null;
	private Date endDate = null;
	
	private ArrayList<RecordTypeOption> hmapRecordTypeOption = new ArrayList<RecordTypeOption>();

	public ReportTypeEnum getReportType() {
		return reportType;
	}

	public void setReportType(ReportTypeEnum reportType) {
		this.reportType = reportType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ArrayList<RecordTypeOption> getHmapRecordTypeOption() {
		return hmapRecordTypeOption;
	}

	public void setHmapRecordTypeOption(ArrayList<RecordTypeOption> hmapRecordTypeOption) {
		this.hmapRecordTypeOption = hmapRecordTypeOption;
	}

	public void extractOptions(String[] args) throws Exception {
		ArrayList<Integer> listDisplayTypeNumbers = new ArrayList<Integer>();
		try {
			initRecordType();// reset all the display report option
			if (args != null && args.length > 0) {
				for (String argItem : args) {
					logger.info("argItem=" + argItem);
					if (argItem.startsWith(AppConstants.ARGS_PARAM_REPORT_TYPE)) {
						String[] items = argItem.split("=");
						if (items.length == 2) {
							String strReportType = items[1];
							if(strReportType != null && strReportType.equalsIgnoreCase(REPORT_TYPE_MONTHLY)){
								reportType = ReportTypeEnum.monthly_report;
							}else if(strReportType != null && strReportType.equalsIgnoreCase(REPORT_TYPE_YEARLY)){
								reportType = ReportTypeEnum.yearly_report;
							}
						}
					} else if (argItem.startsWith(AppConstants.ARGS_PARAM_DATE_FROM)) {
						try {
							String[] items = argItem.split("=");
							if (items.length == 2) {
								String strDate = items[1];
								startDate = dateFormatterInput.parse(strDate);
							}
						} catch (Exception e) {
							throw new AppException(ERR_MSG_INVALID_OPTION_DATE_RANGE);
						}
					} else if (argItem.startsWith(AppConstants.ARGS_PARAM_DATE_TO)) {
						try {
							String[] items = argItem.split("=");
							if (items.length == 2) {
								String strDate = items[1];
								endDate = dateFormatterInput.parse(strDate);
							}
						} catch (Exception e) {
							throw new AppException(ERR_MSG_INVALID_OPTION_DATE_RANGE);
						}
					} else if (argItem.startsWith(AppConstants.ARGS_PARAM_DISPLAY_TYPE)) {
						try {
							String[] items = argItem.split("=");
							if (items.length == 2) {
								String[] displayItems = items[1].split(",");
								for (String item : displayItems) {
									if (item.contains("-")) {
										// 1-3
										String[] emdNoRange = item.split("-");
										int intStart = Integer.parseInt(emdNoRange[0]);
										int intEnd = Integer.parseInt(emdNoRange[1]);
										for (int val = intStart; val <= intEnd; val++) {
											if (listDisplayTypeNumbers.contains(val)) {
												throw new AppException(ERR_MSG_INVALID_OPTION_DISPLAY_RPT_COL);
											}
											if (val <= 0 || val > hmapRecordTypeOption.size()) {
												throw new AppException(ERR_MSG_INVALID_OPTION_DISPLAY_RPT_COL);
											}
											listDisplayTypeNumbers.add(val);
										}
									} else {
										int val = Integer.parseInt(item);
										if (listDisplayTypeNumbers.contains(val)) {
											throw new AppException(ERR_MSG_INVALID_OPTION_DISPLAY_RPT_COL);
										}
										if (val <= 0 || val > hmapRecordTypeOption.size()) {
											throw new AppException(ERR_MSG_INVALID_OPTION_DISPLAY_RPT_COL);
										}
										listDisplayTypeNumbers.add(val);
									}
								}
							}
						} catch (Exception e) {
							logger.error(ERR_MSG_INVALID_OPTION_DISPLAY_RPT_COL, e);
							throw new AppException(ERR_MSG_INVALID_OPTION_DISPLAY_RPT_COL);
						}
					}
				}
			}else{
				System.out.println(helpInformation());
				throw new AppException(ERR_MSG_INVALID_OPTION_EMPTY);
			}
			if(reportType == null){
				throw new AppException(ERR_MSG_INVALID_OPTION_REPORT_TYPE);
			}
			if (startDate == null || endDate == null || startDate.after(endDate)) {
				throw new AppException(ERR_MSG_INVALID_OPTION_DATE_RANGE);
			}
			logger.info("startDate=" + dateFormatterAPI.format(startDate));
			logger.info("endDate=" + dateFormatterAPI.format(endDate));
			logger.info("listDisplayTypeNumbers=" + listDisplayTypeNumbers);
			// Empty input, will set all
			if (listDisplayTypeNumbers.isEmpty()) {
				for (int intDisplayIndex : listDisplayTypeNumbers) {
					hmapRecordTypeOption.get(intDisplayIndex - 1).setDisplayOnReport(true);
				}
			} else {
				for (int intDisplayIndex : listDisplayTypeNumbers) {
					hmapRecordTypeOption.get(intDisplayIndex - 1).setDisplayOnReport(true);
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Reset the map that contains all the display banks,fc rates
	 * 
	 */
	protected void initRecordType() {
		// description is stored in case need to reflect it in the reports *future
		hmapRecordTypeOption = new ArrayList<RecordTypeOption>();
		hmapRecordTypeOption
				.add(new RecordTypeOption(AppConstants.RecordTypeEnum.prime_lending_rate, "Prime Lending Rate"));
		hmapRecordTypeOption.add(new RecordTypeOption(AppConstants.RecordTypeEnum.banks_fixed_deposits_3m,
				"Banks Fixed Deposits 3 Months"));
		hmapRecordTypeOption.add(new RecordTypeOption(AppConstants.RecordTypeEnum.banks_fixed_deposits_6m,
				"Banks Fixed Deposits 6 Months"));
		hmapRecordTypeOption.add(new RecordTypeOption(AppConstants.RecordTypeEnum.banks_fixed_deposits_12m,
				"Banks Fixed Deposits 12 Months"));
		hmapRecordTypeOption.add(
				new RecordTypeOption(AppConstants.RecordTypeEnum.banks_savings_deposits, "Banks Savings Deposits"));
		hmapRecordTypeOption.add(new RecordTypeOption(AppConstants.RecordTypeEnum.fc_hire_purchase_motor_3y,
				"Finance Companies Loans - Hire Purchase of New Vehicles For 3 Years"));
		hmapRecordTypeOption.add(new RecordTypeOption(AppConstants.RecordTypeEnum.fc_housing_loans_15y,
				"Finance Companies Housing Loans For 15 Years"));
		hmapRecordTypeOption.add(new RecordTypeOption(AppConstants.RecordTypeEnum.fc_fixed_deposits_3m,
				"Finance Companies Fixed Deposits 3 Months"));
		hmapRecordTypeOption.add(new RecordTypeOption(AppConstants.RecordTypeEnum.fc_fixed_deposits_6m,
				"Finance Companies Fixed Deposits 6 Months"));
		hmapRecordTypeOption.add(new RecordTypeOption(AppConstants.RecordTypeEnum.fc_fixed_deposits_12m,
				"Finance Companies Fixed Deposits 12 Months"));
		hmapRecordTypeOption.add(new RecordTypeOption(AppConstants.RecordTypeEnum.fc_savings_deposits,
				"Finance Companies Savings Deposits"));
	}
	
	protected String helpInformation(){
		StringBuffer sbf = new StringBuffer();
		sbf.append("\nHelp\n\n");
		sbf.append("Arguments input eg. \n");
		sbf.append("i)		report.type=M [M=monthly, m=monthly, Y=yearly, y=yearly]\n");
		sbf.append("ii)		start.date=Jan-2018 [MMM-yyyy]  \n");
		sbf.append("iii)		end.date=Aug-2018 [MMM-yyyy]\n");
		sbf.append("iv)		isplay.type=1,3-4,9 [1-11 only, support range input '-' with comma separator ]\n");
		sbf.append("example java -jar target/MASApi-1.0-SNAPSHOT.jar report.type=M start.date=Jan-2018 end.date=Aug-2018 display.type=1,3-4,9\n");
		sbf.append("-----------\n");
		sbf.append("[display.type list]\n");
		sbf.append("-----------\n");
		sbf.append("1	prime_lending_rate			Prime Lending Rate\n");
		sbf.append("2	banks_fixed_deposits_3m	Banks 		Fixed Deposits 3 Months\n");
		sbf.append("3	banks_fixed_deposits_6m	Banks 		Fixed Deposits 6 Months\n");
		sbf.append("4	banks_fixed_deposits_12m		Banks Fixed Deposits 12 Months\n");
		sbf.append("5	banks_savings_deposits			Banks Savings Deposits\n");
		sbf.append("6	fc_hire_purchase_motor_3y		Finance Companies Loans - Hire Purchase of New Vehicles For 3 Years\n");
		sbf.append("7	fc_housing_loans_15y			Finance Companies Housing Loans For 15 Years\n");
		sbf.append("8	fc_fixed_deposits_3m			Finance Companies Fixed Deposits 3 Months\n");
		sbf.append("9	fc_fixed_deposits_6m			Finance Companies Fixed Deposits 6 Months\n");
		sbf.append("10	fc_fixed_deposits_12m			Finance Companies Fixed Deposits 12 Months\n");
		sbf.append("11	fc_savings_deposits			Finance Companies Savings Deposits\n");
		return sbf.toString();
	}
	
}
