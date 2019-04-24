package com.service.TestCollect.dao;

 import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.service.TestCollect.pojo.TaskInfo;
 
 

public interface TaskInfoDao {
	
	void createTask(TaskInfo info);
//	
//	List<Video> querydata(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult);
//	
//	List<Video> queryvideoType(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult,
//			@Param("videotype") String videotype);
//	
//	List<Video> querytype();
	
	List<TaskInfo> queryOrder(@Param("userId") String userId);
	
	void updateTaskInfo(TaskInfo info);
	
	List<TaskInfo> selectInfo();
	
	TaskInfo findId(@Param("id") String id);
	
//	boolean querybool(@Param("thirdId") String thirdId);
//	 
}
