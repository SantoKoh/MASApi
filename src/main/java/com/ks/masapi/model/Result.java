package com.ks.masapi.model;

import java.util.ArrayList;

/**
 * Main Json Object, from the Resource ID, total records, limit, offset, link to list of Records
 *
 */
public class Result {

		public Result(){}
		public ArrayList<String> resource_id;
		private int limit;
		private int offset;
		private String total;
		ArrayList<Record> records = new ArrayList<Record>();
		public ArrayList<String> getResource_id() {
			return resource_id;
		}
		public void setResource_id(ArrayList<String> resource_id) {
			this.resource_id = resource_id;
		}
		public float getLimit() {
			return limit;
		}
		public void setLimit(int limit) {
			this.limit = limit;
		}
		public float getOffset() {
			return offset;
		}
		public void setOffset(int offset) {
			this.offset = offset;
		}
		public String getTotal() {
			return total;
		}
		public void setTotal(String total) {
			this.total = total;
		}
		public ArrayList<Record> getRecords() {
			return records;
		}
		public void setRecords(ArrayList<Record> records) {
			this.records = records;
		}

		@Override
		public String toString() {
			return "Result [resource_id=" + resource_id + ", limit=" + limit
					+ ", offset=" + offset + ", total=" + total + ", records="
					+ records + "]";
		}
}
