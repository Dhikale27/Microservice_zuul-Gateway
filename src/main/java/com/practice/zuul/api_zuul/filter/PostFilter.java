package com.practice.zuul.api_zuul.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        javax.servlet.http.HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

        log.info("PostFilter: {}", String.format("response's content type is %s", response.getStatus()));

        return null;
    }
}