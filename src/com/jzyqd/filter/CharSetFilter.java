package com.jzyqd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharSetFilter implements Filter  {
	private String charSet = "gbk";
	public void init(FilterConfig filterConfig) throws ServletException {
		charSet = filterConfig.getInitParameter("charSet");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charSet);
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		
	}
	
	

}
