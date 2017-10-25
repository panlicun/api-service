package com.plc.authority;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plc.util.ErrMsg;
import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;

import com.plc.model.User;

//@Order(Integer.MAX_VALUE)//数越小，越提前执行
//@WebFilter(filterName = "accessFilter", urlPatterns = "/*")
public class AccessFilter implements Filter {
    // Log
    private final Logger log = Logger.getLogger(this.getClass());
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) srequest;
		HttpServletResponse response = (HttpServletResponse) sresponse;
		String path = request.getRequestURI();
        log.info("filter check authority,url : " + path);
        //要验证的页面
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("/test/**","");
        //验证权限
        if(true){//如果没有权限
            response.sendError(403);
            return;
        }
		filterChain.doFilter(srequest, sresponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
