package no.tusla.stockservice.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class UserContextFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		logger.debug("I am entering the different service id with auth token: ",
				httpServletRequest.getHeader("Authorization"));
		UserContextHolder.getContext()
				.setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
		System.out.println(
				UserContext.AUTH_TOKEN + ":" + httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
		filterChain.doFilter(httpServletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}