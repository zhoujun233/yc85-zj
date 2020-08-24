package com.zj.C85S3Blog.util;

public class Result {
	
	private int i;
	private String msg;
	private Object data;
	
	
	public Result(int i, String msg) {
		super();
		this.i = i;
		this.msg = msg;
	}
	
	
	public Result( String msg) {
		this.i = 0;
		this.msg = msg;
	}
	
	public Result(int i, String msg, Object data) {
		super();
		this.i = i;
		this.msg = msg;
		this.data = data;
	}
	
	
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	

}
