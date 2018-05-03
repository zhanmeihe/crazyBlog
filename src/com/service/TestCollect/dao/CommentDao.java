package com.service.TestCollect.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.service.TestCollect.pojo.Comment;

public interface CommentDao {

	
	/**
	 * 创建
	 * @param ct
	 */
	void createComments(Comment ct);
	
	/**
	 * 删除
	 * @param ct
	 */
	void deleteComments(Comment ct);
	
	//更新
	void updateComments(Comment ct);
	
	List<Comment> queryCommentAll(@Param("firstResult") int firstResult,@Param("maxRowResult") int maxRowResult);
}
