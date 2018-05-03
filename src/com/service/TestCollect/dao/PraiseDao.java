package com.service.TestCollect.dao;
import org.apache.ibatis.annotations.Param;
import com.service.TestCollect.pojo.Praise;


/**
 * 
 * @author zhanmeihe
 *
 */
public interface PraiseDao {

	
	void createZan(Praise pe);
	
	void updatePraise(Praise pe);
	
	Praise  queryonetomeny(@Param("blogId") String blogId,@Param("userId") String userId);
	
	Praise selectNum(@Param("String blogId") String blogId);
}
