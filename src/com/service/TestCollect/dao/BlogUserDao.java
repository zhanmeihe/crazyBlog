package com.service.TestCollect.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.service.TestCollect.pojo.BlogUser;

public interface BlogUserDao {
	
	List <BlogUser> queryUserBlogData(@Param("userId") String userId);
	BlogUser queryUserName(@Param("userName") String userNmae);
	BlogUser queryUserNamePassword(@Param("userName") String userNmae,@Param("password") String password);
	
	BlogUser queryUser(@Param("userId") String userId);

}
