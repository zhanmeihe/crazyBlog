package com.service.TestCollect.pojo;

import java.io.Serializable;


/**
 * 点赞
 * @author zhanmeihe
 *
 */
public class Praise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -159565769548175504L;

	public Praise() {
		// TODO Auto-generated constructor stub
	}


	
	private String praiseId;
	
	private String blogId;
	
	private String userId;
	
	private String createDate;
	
	private String updateDate;
	
	private int countZan;
	
	private int Praisestatus;

	public int getPraisestatus() {
		return Praisestatus;
	}

	public void setPraisestatus(int praisestatus) {
		Praisestatus = praisestatus;
	}

	public int getCountZan() {
		return countZan;
	}

	public void setCountZan(int countZan) {
		this.countZan = countZan;
	}

	public String getPraiseId() {
		return praiseId;
	}

	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
