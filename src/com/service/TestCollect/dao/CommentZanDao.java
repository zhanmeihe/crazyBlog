package com.service.TestCollect.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.service.TestCollect.pojo.CommentZan;

public interface CommentZanDao {
	
	//int getCountZanT(@Param("userId") String userId,@Param("commentId") String commentId);
	
	int queryCommentNum(@Param("commentId") String commentId);
	
	CommentZan selectCommentData(@Param("userId") String userId,@Param("commentId") String commentId);
	
	List<CommentZan> selectData();
	
	void createCommentZan(CommentZan co);
	
	void updateCommentZan(CommentZan cz);

}
