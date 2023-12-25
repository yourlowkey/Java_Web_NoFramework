package com.virtualpairprogrammers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter(value={"/searchResults.html"})
public class MenuSearchLoggingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String searchTerm = request.getParameter("searchTerm");
		System.out.println("USer searched for : " + searchTerm);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
