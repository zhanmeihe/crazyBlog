package com.service.TestCollect.pojo;

import java.io.Serializable;

public class MyorderInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7766617285965656428L;

	public MyorderInfo() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	
	private String userId;
	
	private String taskId;
	
	private String taskInstruction;

	private double salaryNum;
	
	private String taskDate;
	
	private String taskAddress;
	
	private String productionNum;
	
	private String listIng;
	
	private String createTime;
	
	private String updateDate;
	
	/**
	 * 任务完成状态 0：未完成 1：已完成 2：进行中  3：作废
	 */
	private int state;

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

	public String getTaskInstruction() {
		return taskInstruction;
	}

	public void setTaskInstruction(String taskInstruction) {
		this.taskInstruction = taskInstruction;
	}

	public double getSalaryNum() {
		return salaryNum;
	}

	public void setSalaryNum(double salaryNum) {
		this.salaryNum = salaryNum;
	}

	public String getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public String getTaskAddress() {
		return taskAddress;
	}

	public void setTaskAddress(String taskAddress) {
		this.taskAddress = taskAddress;
	}

	public String getProductionNum() {
		return productionNum;
	}

	public void setProductionNum(String productionNum) {
		this.productionNum = productionNum;
	}

	public String getListIng() {
		return listIng;
	}

	public void setListIng(String listIng) {
		this.listIng = listIng;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
