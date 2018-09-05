package com.ks.masapi.model;

/**
 *  Json Object, from the records of each month/year rates
 *
 */
public class Record {
	public Record(){			
	}
	private String end_of_year;
	private String end_of_month;
	private float prime_lending_rate;
	private float banks_fixed_deposits_3m;
	private float banks_fixed_deposits_6m;
	private float banks_fixed_deposits_12m;
	private float banks_savings_deposits;
	private float fc_hire_purchase_motor_3y;
	private float fc_housing_loans_15y;
	private float fc_fixed_deposits_3m;
	private float fc_fixed_deposits_6m;
	private float fc_fixed_deposits_12m;
	private float fc_savings_deposits;
	private long timestamp;	
	public String getEnd_of_year() {
		return end_of_year;
	}
	public void setEnd_of_year(String end_of_year) {
		this.end_of_year = end_of_year;
	}
	public String getEnd_of_month() {
		return end_of_month;
	}
	public void setEnd_of_month(String end_of_month) {
		this.end_of_month = end_of_month;
	}
	public float getPrime_lending_rate() {
		return prime_lending_rate;
	}
	public void setPrime_lending_rate(float prime_lending_rate) {
		this.prime_lending_rate = prime_lending_rate;
	}
	public float getBanks_fixed_deposits_3m() {
		return banks_fixed_deposits_3m;
	}
	public void setBanks_fixed_deposits_3m(float banks_fixed_deposits_3m) {
		this.banks_fixed_deposits_3m = banks_fixed_deposits_3m;
	}
	public float getBanks_fixed_deposits_6m() {
		return banks_fixed_deposits_6m;
	}
	public void setBanks_fixed_deposits_6m(float banks_fixed_deposits_6m) {
		this.banks_fixed_deposits_6m = banks_fixed_deposits_6m;
	}
	public float getBanks_fixed_deposits_12m() {
		return banks_fixed_deposits_12m;
	}
	public void setBanks_fixed_deposits_12m(float banks_fixed_deposits_12m) {
		this.banks_fixed_deposits_12m = banks_fixed_deposits_12m;
	}
	public float getBanks_savings_deposits() {
		return banks_savings_deposits;
	}
	public void setBanks_savings_deposits(float banks_savings_deposits) {
		this.banks_savings_deposits = banks_savings_deposits;
	}
	public float getFc_hire_purchase_motor_3y() {
		return fc_hire_purchase_motor_3y;
	}
	public void setFc_hire_purchase_motor_3y(float fc_hire_purchase_motor_3y) {
		this.fc_hire_purchase_motor_3y = fc_hire_purchase_motor_3y;
	}
	public float getFc_housing_loans_15y() {
		return fc_housing_loans_15y;
	}
	public void setFc_housing_loans_15y(float fc_housing_loans_15y) {
		this.fc_housing_loans_15y = fc_housing_loans_15y;
	}
	public float getFc_fixed_deposits_3m() {
		return fc_fixed_deposits_3m;
	}
	public void setFc_fixed_deposits_3m(float fc_fixed_deposits_3m) {
		this.fc_fixed_deposits_3m = fc_fixed_deposits_3m;
	}
	public float getFc_fixed_deposits_6m() {
		return fc_fixed_deposits_6m;
	}
	public void setFc_fixed_deposits_6m(float fc_fixed_deposits_6m) {
		this.fc_fixed_deposits_6m = fc_fixed_deposits_6m;
	}
	public float getFc_fixed_deposits_12m() {
		return fc_fixed_deposits_12m;
	}
	public void setFc_fixed_deposits_12m(float fc_fixed_deposits_12m) {
		this.fc_fixed_deposits_12m = fc_fixed_deposits_12m;
	}
	public float getFc_savings_deposits() {
		return fc_savings_deposits;
	}
	public void setFc_savings_deposits(float fc_savings_deposits) {
		this.fc_savings_deposits = fc_savings_deposits;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Record [end_of_year=" + end_of_year + ", end_of_month=" + end_of_month + ", prime_lending_rate="
				+ prime_lending_rate + ", banks_fixed_deposits_3m=" + banks_fixed_deposits_3m
				+ ", banks_fixed_deposits_6m=" + banks_fixed_deposits_6m + ", banks_fixed_deposits_12m="
				+ banks_fixed_deposits_12m + ", banks_savings_deposits=" + banks_savings_deposits
				+ ", fc_hire_purchase_motor_3y=" + fc_hire_purchase_motor_3y + ", fc_housing_loans_15y="
				+ fc_housing_loans_15y + ", fc_fixed_deposits_3m=" + fc_fixed_deposits_3m + ", fc_fixed_deposits_6m="
				+ fc_fixed_deposits_6m + ", fc_fixed_deposits_12m=" + fc_fixed_deposits_12m + ", fc_savings_deposits="
				+ fc_savings_deposits + ", timestamp=" + timestamp + "]";
	}
}
