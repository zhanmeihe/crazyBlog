package com.service.TestCollect.dao;

 import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.service.TestCollect.pojo.MyorderInfo;
 
 
 

public interface MyorderInfoDao {
	
	void createTask(MyorderInfo info);
//	
//	List<Video> querydata(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult);
//	
//	List<Video> queryvideoType(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult,
//			@Param("videotype") String videotype);
//	
//	List<Video> querytype();
	
	List<MyorderInfo> queryOrder(@Param("userId") String userId);
	
	void updateTaskInfo(MyorderInfo info);
	
	List<MyorderInfo> selectInfo();
	
	MyorderInfo selectOrderInfo(@Param("taskId") String taskId);
	
//	boolean querybool(@Param("thirdId") String thirdId);
//	 
}
