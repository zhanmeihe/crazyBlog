package com.service.TestCollect.pojo;

import java.io.Serializable;

public class Video implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1692878949515022983L;
	private int id;
	private String name;// 节目名称
	private String url;// 节目播放地址
	private String description;// 简介
	private String area;// 地区
	private String publishDate;// 发布时间
	private String appName;// app名称
	private String videoPath;// 视频流地址
	private String imageUrl;// 图片地址
	private String progType;// 节目类型
	private String progid;// 节目ID
	private String actor;// 演员
	private String director;// 导演
	private String sysDate;
	private String timeLength;
	public String getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(String timeLength) {
		this.timeLength = timeLength;
	}

	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSysDate() {
		return sysDate;
	}

	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getProgType() {
		return progType;
	}

	public void setProgType(String progType) {
		this.progType = progType;
	}

	public String getProgid() {
		return progid;
	}

	public void setProgid(String progid) {
		this.progid = progid;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPlayCount() {
		return playCount;
	}

	public void setPlayCount(String playCount) {
		this.playCount = playCount;
	}

	private String appId;
	private String playCount;// 点击数

}