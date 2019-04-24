package com.service.TestCollect.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UserInfofileVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7418482633548763858L;

	public UserInfofileVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 接收的图片二进制文件
	 */
	private List<MultipartFile> headPic;
	
	/**
	 * 身份证照片
	 */
	private List<String> CheckIdcardPicUrl;

	public List<MultipartFile> getHeadPic() {
		return headPic;
	}

	public void setHeadPic(List<MultipartFile> headPic) {
		this.headPic = headPic;
	}

	public List<String> getCheckIdcardPicUrl() {
		return CheckIdcardPicUrl;
	}

	public void setCheckIdcardPicUrl(List<String> checkIdcardPicUrl) {
		CheckIdcardPicUrl = checkIdcardPicUrl;
	}
	
	 

}
