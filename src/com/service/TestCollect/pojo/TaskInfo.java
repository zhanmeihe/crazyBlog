package com.service.TestCollect.pojo;

import java.io.Serializable;

public class TaskInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7812724171734974842L;

	public TaskInfo() {
		// TODO Auto-generated constructor stub
	}
	
	private String id;
	
	private String taskInstruction;

	private double salaryNum;
	
	private String taskDate;
	
	private String taskAddress;
	
	private String productionNum;
	
	private String listIng;
	
	private String createTime;
	
	private String updateDate;
	
	
	/**
	 * 订单状态 
	 * 0：未被抢单  1：已被抢单，2：已完成订单，3：作废订单
	 */
	private int orderState;

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	
}
