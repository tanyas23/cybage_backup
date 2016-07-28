package com.alm.demo.sj;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class AllException extends Exception
{
	private String msg;

	public AllException() {
		super();
	}

	public AllException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
