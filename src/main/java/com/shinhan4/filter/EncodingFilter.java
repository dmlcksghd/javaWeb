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

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("*.do") // /*
public class EncodingFilter extends HttpFilter implements Filter {
       
    public EncodingFilter() {
        //System.out.println("Encoding Filter 생성"); // 서버 시작시 생성
    }

	public void destroy() {
		//System.out.println("Encoding Filter 소멸"); // 서버 종료시 소멸
	}

	/**
	 * .do 요청할 때 마다 수행된다.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//-------------------서블릿 요청 전 (before)
		//System.out.println("서블릿 요청 전 (before)");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);	// 다른필터를 수행하거나 서블릿을 수행하러간다.
		//-------------------서블릿 수행 후 응답하러가기 전 (after)
		//System.out.println("서블릿 수행 후 (after) 응답하러가기 전");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
