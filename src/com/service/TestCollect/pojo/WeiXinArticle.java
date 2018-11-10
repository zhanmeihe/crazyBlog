package com.service.TestCollect.pojo;

public class WeiXinArticle {
	
	private int id;
	//文章对应的公众号biz
	private String biz;
	//微信定义的一个id，每条文章唯一
	private int fieldId;
	//'文章标题
	private String title;
	//文章编码，防止文章出现emoji
	private String titleEncode;
	//文章摘要
	private String digest;
	///文章地址
	private String contentUrl;
	//阅读原文地址
	private String sourceUrl;
	//封面图片
	private String cover;
	//是否多图文
	private int isMulti;
	//是否头条
	private int isTop;
	//文章时间戳
	private int datetime;
	//文章阅读量
	private int readNum;
	//文章点赞量
	private int likeNum;

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

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleEncode() {
		return titleEncode;
	}

	public void setTitleEncode(String titleEncode) {
		this.titleEncode = titleEncode;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getIsMulti() {
		return isMulti;
	}

	public void setIsMulti(int isMulti) {
		this.isMulti = isMulti;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}

	public int getDatetime() {
		return datetime;
	}

	public void setDatetime(int datetime) {
		this.datetime = datetime;
	}

	public int getReadNum() {
		return readNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

}
