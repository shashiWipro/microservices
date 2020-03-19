package com.microservices.zuul.gateway.impl.netflixzuulapigateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class ZuulLoggingFilter extends ZuulFilter{

	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
	HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
	logger.info("request ->{}",
			    request);
	logger.info(" request URI-> {}",
		    request.getRequestURI());
	logger.info(" request Method-> {}",
		     request.getMethod());
	logger.info("query String ->{}",
		    request.getQueryString());
	
		return null;
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
