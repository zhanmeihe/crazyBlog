package com.service.TestCollect.pojo;

import java.io.Serializable;

public class BlogInfo  implements Serializable {

	 
	private static final long serialVersionUID = -913058166544595444L;
	public BlogInfo() {
		// TODO Auto-generated constructor stub
	}
	//图片地址
	private int maxBlogId;
	public int getMaxBlogId() {
		return maxBlogId;
	}
	public void setMaxBlogId(int maxBlogId) {
		this.maxBlogId = maxBlogId;
	}
	private  String imageUrl;
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	private String blogId;
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	//blog标题
	private String title;
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	
	private String userId ;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//blog内容
	private String blogContent;
	//博客创建时间
	private String createblogDate;
	private String updateDate;
	//作者
	private String author;
	//点赞数
	private int praiseCount;
	//评论
	private String comments;
	//评论数
	private int commentsNum;
	public int getCommentsNum() {
		return commentsNum;
	}
	public void setCommentsNum(int commentsNum) {
		this.commentsNum = commentsNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public String getCreateblogDate() {
		return createblogDate;
	}
	public void setCreateblogDate(String createblogDate) {
		this.createblogDate = createblogDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
