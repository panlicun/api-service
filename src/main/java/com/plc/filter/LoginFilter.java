package com.plc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;

import com.plc.model.User;

@Order(1)//数越小，越提前执行
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
//		HttpServletRequest request = (HttpServletRequest) srequest;
//		HttpServletResponse response = (HttpServletResponse) sresponse;
//		String path = request.getRequestURI();	
//		System.out.println("this is MyFilter,url :" + path);
//		if (path.indexOf("/admin/html/login.html") > -1) {
//			filterChain.doFilter(srequest, sresponse);
//			return;
//		}
//		User user = (User) request.getSession().getAttribute("user");
//		if (null == user) {
//			response.sendRedirect("/admin/html/login.html");
//		} else {
//			filterChain.doFilter(srequest, sresponse);
//		}
		filterChain.doFilter(srequest, sresponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
