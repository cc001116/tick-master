package cn.flower.tick.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 判断用户是否登录 及Session 是否过期;
 * @filename LoginFilter.java
 * @author ChenCheng
 * @version 1.09
 * @Date 2014-12-01 上午9:52:18
 */
public class LoginFilter extends HttpFilter{
	protected FilterConfig filterConfig;
	private List<String> exceptionRequest = new ArrayList<String>();
	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String uri = request.getRequestURI();
		String requestURL = getRequestURL(uri);
		//9E99322E55B7365CEC42FEAB28DDDA20
		if(exceptionRequest.contains(requestURL) || requestURL.contains("/userregister!")) {
			System.out.println("放行:"+requestURL);
			chain.doFilter(request, response);
		}else {
			HttpSession session = request.getSession(false);
			if("/".equals(requestURL)) {
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return;
			}
			if(session == null || session.getAttribute("user") == null) {
				System.out.println(" 拦截URL ：" +requestURL);
				//String sId = request.getRequestedSessionId();
				/*if(sId !=null && sId.equals(CookieUtil.getCookieValueByKey(request, "sId")))
					System.out.println("登录超时，请重新登录    " + request.getRequestedSessionId());
				else 
					System.out.println("请登录 : "+request.getRequestedSessionId());*/
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}else {
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * 例外（过滤器不过滤的URL）
	 * @param exception
	 * @return
	 */
	public List<String> getExceptionRequest(String exception) {
		if(exception == null)
			return new ArrayList<String>();
		return Arrays.asList( exception.split(";"));
	}
	
	/**
	 * 截取访问的路径名
	 * @param url	requsest 请求URL
	 * @return	返回最后一个"/"(包含)之后的部分
	 */
	public String getRequestURL(String url) {
		return url.substring(url.lastIndexOf("/"));
	}
	/**
	 * 初始化
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		String exceptionURLs = filterConfig.getInitParameter("exception");
		exceptionRequest = getExceptionRequest(exceptionURLs);
	}
}
