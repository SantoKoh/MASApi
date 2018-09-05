package com.ks.masapi.constants;

import java.text.SimpleDateFormat;

/**
 *  Application constants
 */
public class AppConstants {
	public static String MAS_REST_URL = "https://eservices.mas.gov.sg/api/action/datastore/search.json";	

	public static String MAS_REST_PRARM_RESOURCE_ID = "?resource_id=";
	public static String MAS_REST_PRARM_LIMIT = "&limit=";
	public static String MAS_REST_PRARM_OFFSET = "&offset=";
	// MONTHLY
	public static String MAS_REST_RESOURCE_ID_MONTHLY = "5f2b18a8-0883-4769-a635-879c63d3caac";
	public static String MAS_REST_PRARM_MONTHLY_SORT_DESC = "&sort=end_of_month%20desc";
	public static String MAS_REST_PRARM_MONTHLY_SORT_ASC = "&sort=end_of_month%20asc";
	public static String MAS_REST_PRARM_MONTHLY_DATE_RANGE = "&between[end_of_month]=";
	// YEARLY
	public static String MAS_REST_RESOURCE_ID_YEARLY = "bd841397-108f-4644-8da3-38a7c159d68a";
	public static String MAS_REST_PRARM_YEARLY_SORT_DESC = "&sort=end_of_year%20desc";
	public static String MAS_REST_PRARM_YEARLY_SORT_ASC = "&sort=end_of_year%20asc";
	public static String MAS_REST_PRARM_YEARLY_DATE_RANGE = "&between[end_of_year]=";
	
	public static String ARGS_PARAM_REPORT_TYPE = "report.type=";
	public static String ARGS_PARAM_DATE_FROM = "start.date=";
	public static String ARGS_PARAM_DATE_TO = "end.date=";
	public static String ARGS_PARAM_DISPLAY_TYPE = "display.type=";
	public static String REPORT_TREND_UP = "+";
	public static String REPORT_TREND_DOWN = "-";

	public static String REPORT_TYPE_MONTHLY = "M";
	public static String REPORT_TYPE_YEARLY = "Y";
	public static int LOOP_COUNTER_BREAKER = 100;
	
	public static SimpleDateFormat dateFormatterInput = new SimpleDateFormat("MMM-yyyy");
	public static SimpleDateFormat dateFormatterAPI = new SimpleDateFormat("yyyy-MM");
	public static SimpleDateFormat dateFormatterReportDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String ERR_MSG_INVALID_OPTION_EMPTY = "Empty input options";
	public static String ERR_MSG_INVALID_OPTION_DISPLAY_RPT_COL = "Invalid input display report column";
	public static String ERR_MSG_INVALID_OPTION_REPORT_TYPE = "Missing or invalid input report type [m-monthly, y-yearly]";
	public static String ERR_MSG_INVALID_OPTION_DATE_RANGE = "Missing or invalid input date range";
	
	
	public static enum ReportTypeEnum{
		monthly_report, 
		yearly_report;
	}
	
	public static enum RecordTypeEnum{
		prime_lending_rate, 
		banks_fixed_deposits_3m, 
		banks_fixed_deposits_6m, 
		banks_fixed_deposits_12m, 
		banks_savings_deposits, 
		fc_hire_purchase_motor_3y, 
		fc_housing_loans_15y, 
		fc_fixed_deposits_3m, 
		fc_fixed_deposits_6m, 
		fc_fixed_deposits_12m, 
		fc_savings_deposits;
	}
}
