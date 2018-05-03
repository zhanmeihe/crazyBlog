package com.service.TestCollect.dao;

 import org.apache.ibatis.annotations.Param;

import com.service.TestCollect.pojo.MyorderInfo;
import com.service.TestCollect.pojo.UserInfo;
 

public interface UserInfoDao {
	
	void create(UserInfo info);
//	
//	List<Video> querydata(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult);
//	
//	List<Video> queryvideoType(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult,
//			@Param("videotype") String videotype);
//	
//	List<Video> querytype();
	
	UserInfo queryId(@Param("openId") String openId ,@Param("userId") String userId);
	
	void updateUserInfo(UserInfo info);
	
	UserInfo MaxId();
	
//	boolean querybool(@Param("thirdId") String thirdId);
//	 
}
