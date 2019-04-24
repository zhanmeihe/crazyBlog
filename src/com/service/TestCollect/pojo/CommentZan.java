package com.service.TestCollect.pojo;

import java.io.Serializable;

public class CommentZan implements Serializable {

	/**
	 * 维护评论点赞bean
	 */
	private static final long serialVersionUID = -4172448807234635120L;
	
	private String userId;
	
	private String commentId;
	
	private int status;
	
	private String createDate;
	
	private String updateDate;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getcommentId() {
		return commentId;
	}

	public void setcommentId(String commentId) {
		this.commentId = commentId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
