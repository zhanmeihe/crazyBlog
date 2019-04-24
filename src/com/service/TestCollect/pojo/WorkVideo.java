package com.service.TestCollect.pojo;

import java.io.Serializable;

public class WorkVideo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6532137187557169787L;

	public WorkVideo() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	
	private String userId;
	
	private String taskId;
	
	private String fileUrl;

	private String createDate;
	
	private String updatetime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}
