package com.surveytest.example.domain;

import java.util.List;

public class Survey {
	private int sId;
	private String title;
	private String description;
	private List<Question> questions;
	
	private int rownum;
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
	public class Question {
		private int qId;
		private int type;
		private String qValue;
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
		public List<Item> getItems() {
			return items;
		}
		public void setItems(List<Item> items) {
			this.items = items;
		}
		
		
	}
	
	public class Item {
		private int iId;
		private String iValue;

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
	}
}





