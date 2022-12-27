package com.surveytest.example.domain;

public class Item {
	private int iId;
	private String iValue;
	private int qId;
	
	private int rownum;
	
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getiValue() {
		return iValue;
	}
	public void setiValue(String iValue) {
		this.iValue = iValue;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
	
}
