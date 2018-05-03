package file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.service.TestCollect.pojo.BlogUser;
import com.zhan.utils.MD5Utils;

/**
 * 拦截器请求{只拦截登录后才能查看的页面}
 * 
 * @author zhanmeihe
 * 
 */
public class SpringLoginInterceptor implements HandlerInterceptor {

	/**
	 * @author zhanmeihe preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
	 *         SpringMVC中的Interceptor拦截器是链式的，可以同时存在
	 *         多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行
	 *         ，而且所有的Interceptor中的preHandle方法都会在
	 *         Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的
	 *         ，这种中断方式是令preHandle的返 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AllInterceptor...............................");
		HttpSession session = request.getSession(true);
		BlogUser user = (BlogUser) session.getAttribute("user");
		// 如果已经登录，放行
		if (user != null) {
			return true;
		}

		else {

			// {获取完整项目名称} request.getContextPath()
			String bacl = "/sign_login?backUrl="
					+ MD5Utils.getBASE64(request.getRequestURI())
					+ "&sone="
					+ System.currentTimeMillis()
					+ "&Rasdcode="
					+ MD5Utils.getBASE64(String.valueOf(System
							.currentTimeMillis())) + "&Ecoding="
					+ request.getCharacterEncoding();
			response.sendRedirect(request.getContextPath() + bacl);

			return false;
		}

	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println(arg3 + "afterCompletion"
				+ "---------------------------");

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.err.println("postHandle-------------------------------");

	}
}
