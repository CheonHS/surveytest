package com.surveytest.example.domain;

import java.util.List;

public class Survey {
	String title;
	String description;
	List<Question> questions;
}

class Question {
	int type;
	String value;
	List<Item> items;
}

class Item {
	String value;
}

