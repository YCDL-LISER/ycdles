package com.liser.common.dubbo;

import com.liser.dubbo.common.AbstractResult;

public class BusinessResult extends AbstractResult {
	private static final long serialVersionUID = -5113389120452534231L;
	public static final String INVALID_PARAM_ERROR = "-1";
	public static final String INVALID_SIGNATURE_ERROR = "-2";
	public static final String INVALID_BUSINESS_ERROR = "-3";
	private String jsonData;
	
	public BusinessResult(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
		this.bizSuccess = false;
	}
	
	public BusinessResult(String jsonData) {
		this.jsonData = jsonData;
		this.bizSuccess = true;
	}
	
	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
}
