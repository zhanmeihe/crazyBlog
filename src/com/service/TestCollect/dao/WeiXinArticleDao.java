package com.service.TestCollect.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.service.TestCollect.pojo.WeiXinArticle;


/**
 * 
 * @author zhanmeihe
 *
 */
public interface WeiXinArticleDao {

	
	void create(WeiXinArticle wxa);
	
	void updatePraise(WeiXinArticle wxa);
	
	WeiXinArticle  queryonetomeny(@Param("blogId") String blogId,@Param("userId") String userId);
	
	WeiXinArticle selectNum(@Param("blogId") String blogId);

	List<WeiXinArticle> selectByContentUrl(@Param("content_url")String content_url);

	WeiXinArticle selectByBizAndSn(@Param("biz")String biz, @Param("sn")String sn);

	void updateByPrimaryKey(WeiXinArticle post);
}
