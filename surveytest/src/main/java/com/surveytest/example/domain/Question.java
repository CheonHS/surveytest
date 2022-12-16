package com.surveytest.example.domain;

import java.util.List;

public class Question {
	private int qId;
	private int type;
	private String qValue;
	private int sId;
	private List<Item> items;
	
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getqValue() {
		return qValue;
	}
	public void setqValue(String qValue) {
		this.qValue = qValue;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}	
}
