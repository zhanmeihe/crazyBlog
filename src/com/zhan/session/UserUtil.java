package com.zhan.session;

import com.service.TestCollect.pojo.BlogUser;
import com.zhan.ex.UnisException;

 

 

public class UserUtil {

	public static void setUser(BlogUser User) {
		SessionWrapper.put(SecurityConstant.OPERATOR, User);
	}

	public static BlogUser getUser() {
		Object obj = SessionWrapper.get(SecurityConstant.OPERATOR);
		if (obj instanceof BlogUser) {
			return (BlogUser) obj;
		} else {
			return null;
			//throw new UnisException("用户未登录");
		}
	}

	public static void deleteUser() {
		Object obj = SessionWrapper.get(SecurityConstant.OPERATOR);
		if (obj instanceof BlogUser) {
			SessionWrapper.remove(SecurityConstant.OPERATOR);
		}
	}

	public static String getUserId() {
		Object obj = SessionWrapper.get(SecurityConstant.OPERATOR);
		if (obj instanceof BlogUser) {
			return ((BlogUser) obj).getUserId();
		} else {
			throw new UnisException("用户未登录");
		}
	}

	public static void checkUser() {
		Object obj = SessionWrapper.get(SecurityConstant.OPERATOR);
		if (obj instanceof BlogUser) {
		} else {
			throw new UnisException("用户未登录");
		}
	}

}
