package com.liser.common.dubbo;

import com.liser.dubbo.common.AbstractParam;

public class BusinessParam extends AbstractParam {
	private static final long serialVersionUID = -1399053508719020960L;
	private String systemKey;
	private String serviceKey;
	private Object input;

	public String getSystemKey() {
		return systemKey;
	}

	public void setSystemKey(String systemKey) {
		this.systemKey = systemKey;
	}

	public String getServiceKey() {
		return serviceKey;
	}

	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}
	
	public Object getInput() {
		return input;
	}

	public void setInput(Object input) {
		this.input = input;
	}

}
