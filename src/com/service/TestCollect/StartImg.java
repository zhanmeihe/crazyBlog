package com.service.TestCollect;

import java.io.Serializable;

public class StartImg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9081539143715620447L;
	
	
	private int id;
	
	private String startImgUrl;
	
	private int skip;
	
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartImgUrl() {
		return startImgUrl;
	}

	public void setStartImgUrl(String startImgUrl) {
		this.startImgUrl = startImgUrl;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	

}
