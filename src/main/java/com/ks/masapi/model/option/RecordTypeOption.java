package com.ks.masapi.model.option;

import com.ks.masapi.constants.AppConstants;
import com.ks.masapi.model.Record;

public class RecordTypeOption {

	public RecordTypeOption(){}
	public RecordTypeOption(AppConstants.RecordTypeEnum recordType, String description){
		this.recordType = recordType;
		this.description = description;
	}
	private AppConstants.RecordTypeEnum recordType;
	private String description;
	private boolean displayOnReport = false;
	private Record previousRecord = null;
	public AppConstants.RecordTypeEnum getRecordTypeEnum() {
		return recordType;
	}
	public void setRecordTypeEnum(AppConstants.RecordTypeEnum recordType) {
		this.recordType = recordType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDisplayOnReport() {
		return displayOnReport;
	}
	public void setDisplayOnReport(boolean displayOnReport) {
		this.displayOnReport = displayOnReport;
	}		
	public Record getPreviousRecord() {
		return previousRecord;
	}
	public void setPreviousRecord(Record previousRecord) {
		this.previousRecord = previousRecord;
	}
	@Override
	public String toString() {
		return "RecordTypeOption [recordType=" + recordType + ", description=" + description + ", displayOnReport="
				+ displayOnReport + ", previousRecord=" + previousRecord + "]";
	}
}
