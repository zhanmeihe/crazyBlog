package com.service.TestCollect.pojo;

import java.io.Serializable;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2456113726319248157L;

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	
	private int personNum;
	
	public int getPersonNum() {
		return personNum;
	}

	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}

	private String createtime;
	
	private String updateDate;
	
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	private  String userId;
	
	private String introducer;
	
	private String address;
	
	private String openid;
	
	private String bankCard;
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getBankCard() {
		return bankCard;
	}

 

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroducer() {
		return introducer;
	}

	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 性别 1：男  0：女
	 */
	private String sex;
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setIdcardNum(String idcardNum) {
		this.idcardNum = idcardNum;
	}

	public void setYearNum(String yearNum) {
		this.yearNum = yearNum;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public void setPicImage(String picImage) {
		this.picImage = picImage;
	}

	/**
	 * 手机号
	 */
	private String phoneNum;
	
	/**
	 * 身份证号
	 */
	private String idcardNum;

	/**
	 * 工作年限
	 */
	private String yearNum;
	
	/**
	 * 工作种类
	 */
	private  String workType;
	
	 
	
	/**
	 * 头像图片
	 */
	private String picImage;
	
//	/**
//	 * 接收的图片二进制文件
//	 */
//	private List<MultipartFile> headPic;
//	
//	/**
//	 * 身份证照片
//	 */
//	private List<String> CheckIdcardPicUrl;
//	
//	 
//
//	public List<String> getCheckIdcardPicUrl() {
//		return CheckIdcardPicUrl;
//	}
//
//	public void setCheckIdcardPicUrl(List<String> checkIdcardPicUrl) {
//		CheckIdcardPicUrl = checkIdcardPicUrl;
//	}

	private String checkIdcardPicUrl;
	
	public String getCheckIdcardPicUrl() {
		return checkIdcardPicUrl;
	}

	public void setCheckIdcardPicUrl(String checkIdcardPicUrl) {
		this.checkIdcardPicUrl = checkIdcardPicUrl;
	}

	public String getUserName() {
		return userName;
	}

	 
 

	public String getPhoneNum() {
		return phoneNum;
	}

	 
	public String getIdcardNum() {
		return idcardNum;
	}

	 
	public String getYearNum() {
		return yearNum;
	}

	 
	 
	public String getWorkType() {
		return workType;
	}
 

	public String getPicImage() {
		return picImage;
	}

	 

//	public List<MultipartFile> getHeadPic() {
//		return headPic;
//	}
//
//	public void setHeadPic(List<MultipartFile> headPic) {
//		this.headPic = headPic;
//	}

	 

}
