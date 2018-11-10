package com.service.TestCollect.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.service.TestCollect.pojo.WeiXinNumber;


/**
 * 
 * @author zhanmeihe
 *
 */
public interface WeiXinNumberDao {

	
	void create(WeiXinNumber wxn);
	
	void updatePraise(WeiXinNumber wxn);
	
	//void insert(WeiXinNumber wxn);
	
	WeiXinNumber  queryonetomeny(@Param("blogId") String blogId,@Param("userId") String userId);
	
	WeiXinNumber selectNum(@Param("blogId") String blogId);

	WeiXinNumber selectOne();

	void updateByPrimaryKey(WeiXinNumber weiXin);

	List<WeiXinNumber> selectByBiz(@Param("biz") String biz);
}
