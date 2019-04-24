package com.zhan.utils;

import java.io.IOException;  
import javax.annotation.Resource;
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.springframework.web.servlet.HandlerInterceptor;  
import org.springframework.web.servlet.ModelAndView;  





import com.service.TestCollect.dao.BlogUserDao;
import com.service.TestCollect.pojo.BlogUser;

public class AuthorizedInterceptor implements HandlerInterceptor {  
	
	@Resource
	private BlogUserDao blogUserDao;
	  
    /**  @author zmh
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，  
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。  
     */   
	
    public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, Object arg2, Exception arg3)  
            throws Exception {  
    }  
  
     /**  
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之  
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操  
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，  
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor  
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。  
     */    
    public void postHandle(HttpServletRequest request, HttpServletResponse response,Object handler, ModelAndView modelAndView) throws Exception {  
    }  
  
     /**  
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在  
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在  
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返  
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。  
     */    
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {  
        String uri = request.getRequestURI();  
        //登陆请求不拦截  
        /*if(uri.indexOf("checkUser.do") != -1){ 
            return true; 
        }*/  
         
      //设置不拦截的对象  
        String[] noFilters = new String[] {"u","login","supplier","innerChart"};  //对登录本身的页面以及业务不拦截  
        boolean beFilter = true;   
        for (String s : noFilters) {    
            if (uri.indexOf(s) != -1) {    
                beFilter = false;    
                break;    
            }    
        }  
          
   if (beFilter==true) {//除了不拦截的对象以外  
        String path = request.getContextPath();  
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  
    /* 
    注意：每次重新启动浏览器会重新启动一个sessionId和Cookie，之前设置的session会因为sessionId的变化而取不到,所以会出现用户明明已经登录，但是重开浏览器又需要登录. 
        流程： 
        1、用户选择记住密码：取出cookie中的用户名和密码查询,如果此用户已不存在，则清除cookie中的值，如果存在则判断用户是否重新登录,如果未重新登录则将cookie中用户信息设置到session中,如果用户重新登录了则判断登录用户是否与cookie中用户一致，一致则将cookie中用户信息设置到session中,不一致则将当前登录用户的信息设置到session中。 
                将用户信息放入session中是为了(通过cookie中的用户名密码可以得到用户信息): 
                    1、重开浏览器的时候如果已经登录的用户可以直接进入 
                    2、防止用户直接将执行方法的连接拷贝进地址栏，而方法中又需要在session中取用户信息的错误 
        2、用户未选记住密码：判断session中是否存在用户信息，如果存在，则true，如果不存在则返回登录页面 
    */  
            Cookie cokLoginName = CookieTool.getCookieByName(request, "loginName");  
            Cookie cokLoginPwd = CookieTool.getCookieByName(request, "loginPwd");  
            //如果前面的人登录勾选了记住密码,cookie中存在上一个人的信息  
            if (cokLoginName != null && cokLoginPwd != null && cokLoginName.getValue() != "" && cokLoginPwd.getValue() != "") {  
                String loginName = cokLoginName.getValue();  
                String loginPwd = cokLoginPwd.getValue();  
                  
                // 检查到客户端保存了用户的密码，进行该账户的验证  
               
                BlogUser users = blogUserDao.queryUserNamePassword(loginName, loginPwd);  
                  
                //如果此人已经被管理员删除  
                if (users == null) {  
                    CookieTool.addCookie(response, "loginName", null, 0); // 清除Cookie  
                    CookieTool.addCookie(response, "loginPwd", null, 0); // 清除Cookie  
                    try {  
                        response.sendRedirect(basePath + "self/logOn.do");  
                        return false;  
                    } catch (IOException e) {  
                        e.printStackTrace();  
                    }  
                    request.getSession().setAttribute("errorInfo", "请登录！");  
                }  
                //如果存在此人  
                else {  
                	BlogUser utcUsers = (BlogUser)request.getSession().getAttribute("utcUsers");  
                    if (utcUsers==null) {//如果未登录而直接拷贝地址栏进入页面  
                        request.getSession().setAttribute("utcUsers", users);  
                    }else {//用户登录后  
                        if (utcUsers.getUserName().equals(users.getUserName())) {//如果当前登录人与cookie中信息一致  
                            request.getSession().setAttribute("utcUsers", users);  
                        }else {//如果当前登录人与cookie中信息不一致  
                            request.getSession().setAttribute("utcUsers", utcUsers);  
                        }  
                    }  
                }  
            }  
            //如果cookie中没有内容，即未勾选记住密码，或者是退出后清除了cookie  
            else{  
            	BlogUser u = (BlogUser)request.getSession().getAttribute("utcUsers");  
                if (u==null) {//如果未登录  
                    response.sendRedirect(basePath + "self/logOn.do");  
                     return false;  
                }else {//如果已经登录  
                    //执行下一步  
                }  
            }  
              
            /******退出的时候记得清除cookie中的内容,如果用户已经登录********/  
          
   }  
        return true;  
    }  
  
}  

