package com.service.TestCollect.dao;

 import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.service.TestCollect.pojo.BlogInfo;

 

public interface BlogInfoDao {
	
	void create(BlogInfo info);
//	
//	List<Video> querydata(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult);
//	
//	List<Video> queryvideoType(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult,
//			@Param("videotype") String videotype);
//	
	boolean ifExist(@Param("blogId")String blogId);
	
	List<BlogInfo> indexquery(@Param("firstResult") int firstResult, @Param("maxResults") int maxResult);
	
	List<BlogInfo> selectallData(@Param("userId") String userId,@Param("nextPage") int nextPage);
	
	List<BlogInfo> searchList(@Param("queryString") String queryString,@Param("firstResult") int firstResult, @Param("maxResults") int maxResult);
	
	BlogInfo querymaxid();
	
	BlogInfo queryId(@Param("blogId") String blogId );
	
	//void intsertBlog(BlogInfo info);
	
	void updateUserInfo(BlogInfo info);
	
	BlogInfo MaxId();
	
//	boolean querybool(@Param("thirdId") String thirdId);
//	 
}
