package com.service.TestCollect;

import java.io.IOException;

import javax.servlet.Filter;
 
import javax.servlet.FilterChain;
 
import javax.servlet.FilterConfig;
 
import javax.servlet.ServletException;
 
import javax.servlet.ServletRequest;
 
import javax.servlet.ServletResponse;
 
import javax.servlet.http.HttpServletRequest;
 
import javax.servlet.http.HttpServletResponse;
 
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	 
	  public void init(FilterConfig filterConfig) throws ServletException {
	 
	  }
	 
	  public void doFilter(ServletRequest request, ServletResponse response,
	 
	      FilterChain chain) throws IOException, ServletException {
	 
	    //将request强转成htt...
	 
	    HttpServletRequest req = (HttpServletRequest) request;
	 
	    //获取session
	 
	    HttpSession ss = req.getSession();
	 
	    //从session中获取user
	 
	    if(ss.getAttribute("user")==null){
	 
	      System.err.println("你还没有登录");
	 
	      req.getSession().setAttribute("msg", "请你先登录");
	 
	      //重定向到登录
	 
	      HttpServletResponse resp = (HttpServletResponse) response;
	 
	      resp.sendRedirect(req.getContextPath()+"/index.jsp"); 
	 
	    }else{
	 
	      //放行
	 
	      chain.doFilter(request, response);
	 
	    }
	 
	  }
	 
	  public void destroy() {
	 
	  }
	 
	}
