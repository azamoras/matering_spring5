package com.mastering.spring.cloud.cap9.zuulapigatewaysever.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class SimpleLogginFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(SimpleLogginFilter.class);
	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
	       RequestContext  context  = RequestContext.getCurrentContext();    
	       HttpServletRequest  httpRequest  = context.getRequest();     
	       log.info(String.format("Request Method  :  %s  n  URL:  %s",httpRequest.getMethod(), httpRequest.getRequestURL().toString()));
	       return  null;
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
