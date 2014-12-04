package cn.flower.tick.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 对字符编码进行过滤;
 * 
 * @FileName charsetFilter.java
 * @author ChenCheng
 * @Date 2014-12-01 上午9:52:18
 */
public class charsetFilter extends HttpFilter {
	private String characterEncoding; // 字符编码；
	private boolean enabled; // 是否启用；

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		characterEncoding = filterConfig.getInitParameter("characterEncoding");
		enabled = "true".equalsIgnoreCase(filterConfig
				.getInitParameter("enabled")) ? true : false;
	}

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (enabled) {
			System.out.println("charsetFilter");
			response.setCharacterEncoding(characterEncoding);
			request.setCharacterEncoding(characterEncoding);
			RequestWrapper req = new RequestWrapper(request);
			request = req;
		}
		chain.doFilter(request, response);
	}

	/**
	 * 包装HttpServletRequest对象，实现转码操作;
	 * 
	 * @FileName charsetFilter.java
	 * @author ChenCheng
	 * @version 1.0
	 * @Date 2012-7-31 上午9:53:18
	 */
	class RequestWrapper extends HttpServletRequestWrapper {
		public RequestWrapper(HttpServletRequest request) {
			super(request);
		}

		@Override
		public String getParameter(String name) {

			String value = super.getParameter(name);
			if (value == null)
				return null;

			System.out.println("转前: " + value);
			if (!"get".equalsIgnoreCase(super.getMethod()))
				return value;

			try {
				value = new String(value.getBytes("ISO8859-1"),
						characterEncoding);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
			System.out.println("转后: " + value);
			return value;
		}

	}
}
