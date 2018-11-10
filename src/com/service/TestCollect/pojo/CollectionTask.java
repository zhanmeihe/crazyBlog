package com.service.TestCollect.pojo;

public class CollectionTask {
	
	private int id;
	//文章地址
	private String contentUrl;
	//读取中标记
	private int load;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public int getLoad() {
		return load;
	}
	public void setLoad(int load) {
		this.load = load;
	}

}
