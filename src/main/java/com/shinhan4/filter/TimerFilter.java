package com.shinhan4.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class TimerFilter
 */
//@WebFilter("/*")
public class TimerFilter extends HttpFilter implements Filter {
       
    public TimerFilter() {
        //System.out.println("TimerFilter 서버 시작시 생성");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//System.out.println("TimerFilter 서버 종료시 소멸");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long start = System.nanoTime();
		chain.doFilter(request, response);
		long end = System.nanoTime();
		
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println(req.getRequestURI() + "요청");
		System.out.println("걸린시간 :" + (end - start) + "ns");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
