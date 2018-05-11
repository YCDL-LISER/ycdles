package com.liser.dubbo.common;

import java.io.Serializable;

public abstract class AbstractParam implements Serializable {
	/*用户id*/
	protected String userId;
	/*用户登录id*/
	protected String loginId;

	public AbstractParam() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
