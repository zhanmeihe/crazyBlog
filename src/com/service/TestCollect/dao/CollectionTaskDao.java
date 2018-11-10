package com.service.TestCollect.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.service.TestCollect.pojo.CollectionTask;
import com.zhan.utils.TmpList;


/**
 * 
 * @author zhanmeihe
 *
 */
public interface CollectionTaskDao {

	
	void create(CollectionTask cl);
	
	void deleteByLoad(@Param("load") int load);
	
	CollectionTask selectRandomOne();
	
	CollectionTask  queryonetomeny(@Param("blogId") String blogId,@Param("userId") String userId);
	
	CollectionTask selectNum(@Param("blogId") String blogId);

	void updateByContentUrl(CollectionTask cl);

	List<CollectionTask> selectMany(@Param("i")int i);

	void updateByPrimaryKey(CollectionTask queue);

	void deleteBySn(@Param("sn")String sn);

	 

	
}
