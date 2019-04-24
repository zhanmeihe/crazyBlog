package com.service.TestCollect.dao;

 import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.service.TestCollect.pojo.MyorderInfo;
import com.service.TestCollect.pojo.WorkVideo;
 
 
 

public interface WorkVideoDao {
	
	void createVideo(WorkVideo info);
//	
//	List<Video> querydata(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult);
//	
//	List<Video> queryvideoType(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult,
//			@Param("videotype") String videotype);
//	
//	List<Video> querytype();
	
	List<WorkVideo> queryOrder(@Param("userId") String userId);
	
	void updateTaskInfo(WorkVideo info);
	
	List<WorkVideo> selectInfo();
	
	WorkVideo selectOrderInfo(@Param("taskId") String taskId);
	
//	boolean querybool(@Param("thirdId") String thirdId);
//	 
}
