package com.service.TestCollect.dao;

 import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.service.TestCollect.pojo.Video;
 

public interface VideoDao {
	
	void create(Video ve);
	
	List<Video> querydata(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult);
	
	List<Video> queryvideoType(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult,
			@Param("videotype") String videotype);
	
	List<Video> querytype();
	
	Video queryId(@Param("thirdId") String thirdId);
	
	boolean querybool(@Param("thirdId") String thirdId);
	 
}
