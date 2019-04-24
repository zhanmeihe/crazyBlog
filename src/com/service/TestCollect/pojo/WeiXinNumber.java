package com.service.TestCollect.pojo;

public class WeiXinNumber {
	
	private int id;
	
	//公众号唯一标识biz
	private String biz;
	//公众号头像地址
	private String headimage;
	//公众号名称
	private String name;
	//记录采集时间的时间戳
	private long collect;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBiz() {
		return biz;
	}

	public void setBiz(String biz) {
		this.biz = biz;
	}

	public String getHeadimage() {
		return headimage;
	}

	public void setHeadimage(String headimage) {
		this.headimage = headimage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCollect() {
		return collect;
	}

	public void setCollect(long collect) {
		this.collect = collect;
	}
	

}
