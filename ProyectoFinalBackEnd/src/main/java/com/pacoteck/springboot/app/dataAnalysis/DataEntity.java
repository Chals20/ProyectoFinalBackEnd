package com.pacoteck.springboot.app.dataAnalysis;

public class DataEntity {

	private String name;
	
	private int count;
	
	private String type;
	
	public DataEntity() {}

	public DataEntity(String name, int count, String type) {
		this.name = name;
		this.count = count;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
