package com.ks.masapi.model;

/**
 * Main Json Object, from the status and Result Object
 *
 */
public class InterestRate {
	public InterestRate() {
	}

	private boolean success;
	Result ResultObject;

	public boolean getSuccess() {
		return success;
	}

	public Result getResult() {
		return ResultObject;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setResult(Result resultObject) {
		this.ResultObject = resultObject;
	}

	@Override
	public String toString() {
		return "InterestRate [success=" + success + ", ResultObject="
				+ ResultObject + "]";
	}
}
