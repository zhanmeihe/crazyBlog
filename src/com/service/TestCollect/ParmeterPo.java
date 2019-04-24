package com.service.TestCollect;

import java.io.Serializable;

public class ParmeterPo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6387557296559091269L;
	
	
	private int id;
	
	
	private String name;
	
	private String valueI;
	
	private String note;
	
	private int type;

	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValueI() {
		return valueI;
	}

	public void setValueI(String valueI) {
		this.valueI = valueI;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
