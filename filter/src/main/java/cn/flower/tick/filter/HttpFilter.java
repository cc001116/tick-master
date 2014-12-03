package cn.flower.tick.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模版方法模式;
 * @FileName HttpFilter.java
 * @author ChenCheng
 * @Date 2014-12-01 上午8:02:28
 */
public abstract class HttpFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 调用子类的方法
		doFilter(request, response, chain);
	}
	
	// 抽象方法，强制子类来实现;
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws IOException, ServletException ;
}
