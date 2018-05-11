package com.liser.dubbo.common;

import java.io.Serializable;

public abstract class AbstractResult implements Serializable {
	/* 业务是否成功 */
	protected boolean bizSuccess;
	/* 错误码 */
	protected String errorCode;
	/* 信息 */
	protected String message;
	
	public AbstractResult(){
		
	}

	public boolean isBizSuccess() {
		return bizSuccess;
	}

	public void setBizSuccess(boolean bizSuccess) {
		this.bizSuccess = bizSuccess;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
