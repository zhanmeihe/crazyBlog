package com.service.TestCollect.pojo;

import java.io.Serializable;


/**
 * 评论pojo类
 * @author zhanmeihe
 *
 */
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4616088766386206636L;

	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	private String commentId;
	
	private String blogId;
	
	private String userId;
	
	private String commentContent;
	
	private int zanNum;
	
	private String createDate;
	
	private String updateDate;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
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

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getZanNum() {
		return zanNum;
	}

	public void setZanNum(int zanNum) {
		this.zanNum = zanNum;
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
