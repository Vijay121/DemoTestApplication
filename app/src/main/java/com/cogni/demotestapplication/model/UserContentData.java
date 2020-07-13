package com.cogni.demotestapplication.model;

import java.util.List;

public class UserContentData {
	private String title;
	private List<RowsItem> rows;

	public String getTitle(){
		return title;
	}

	public List<RowsItem> getRows(){
		return rows;
	}
}