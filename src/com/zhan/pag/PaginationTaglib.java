package com.zhan.pag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.apache.commons.lang.StringUtils;

public class PaginationTaglib extends javax.servlet.jsp.tagext.TagSupport {
	private static final long serialVersionUID = 1L;
	private String url = "";
	
	@Override
	public int doEndTag() throws JspException {
		Pagination<?> pagination = (Pagination<?>)pageContext.getRequest().getAttribute("pagination");
		if(pagination.getTotalPages() <=1)
			return super.doEndTag();
		
		StringBuffer sb = new StringBuffer();
		
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		String qs = request.getQueryString();
		if(StringUtils.isEmpty(qs)) {
			qs = "";
		}
		
		String[] params =  qs.split("&");
		String newParams = "";
		for(int i = 0; i < params.length; i++) {
			String param = params[i];
			if(param.startsWith("page=")) {
				continue;
			}
			if(i != 0) {
				newParams += ("&" + param); 
			} else {
				newParams = param;
			}
		}
		
		String newUrl=url;
		// String newUrl = "";
		// if(url.endsWith("?")) {
		// newUrl = url + newParams;
		// } else if(url.contains("?")) {
		// newUrl = url + "&" + newParams;
		// } else {
		// newUrl = url + "?" + newParams;
		// }
		
		if(pagination != null) {
			sb.append("<nav><ul class=\"pagination pagination-sm\">");
			
			//前一页
			sb.append("<li>");
			if(pagination.getCurrentPage() > 1) {
				sb.append("<a href=\"" + appendParam(newUrl, "page", (pagination.getCurrentPage() - 1)+"") + "\"><span aria-hidden=\"true\">&laquo;</span></a>");
			} else {
				sb.append("<a href=\"#\"<span aria-hidden=\"true\">&laquo;</span></a>");
			}
			sb.append("</li>");
			
			
			for(int i = 0; i < pagination.getTotalPages(); i++) {
				String tmp = appendParam(newUrl, "page", i + "");
				if(i == pagination.getCurrentPage()) {
					sb.append("<li class=\"active\"><a href=\"" +  tmp + "\">" + (i+1) +" </a></li>");
				} else {
					sb.append("<li><a href=\"" + tmp +"\">" + (i+1) +" </a></li>");
				}
			}
			
			sb.append("<li>");
			if(pagination.getCurrentPage() == pagination.getTotalPages()) {
				sb.append("<a href=\"#\"><span aria-hidden=\"true\">&raquo;</span>");
			} else {
				sb.append("<a href=\""+ appendParam(newUrl, "page", (pagination.getCurrentPage() + 1)+"")  +"\"><span aria-hidden=\"true\">&raquo;</span>");
			}
			sb.append("</li>");

			sb.append("</ul></nav>");
		}
		try {
			pageContext.getOut().write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
	
	private String appendParam(String url, String param, String value) {
		if(url.endsWith("?")) {
			return url  + param +  "=" + value;
		} else if(url.contains("?")) {
			return url + "&" + param + "=" + value;
		} else {
			return url + "?" + param + "=" + value;
		}
	}
	
}
