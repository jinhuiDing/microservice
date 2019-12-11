package com.itmuch.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: PreRequestLogFilter
 * @author: ding
 * @date: 2019/12/11 23:13
 * @version: 1.0
 */

@Component
public class PreRequestLogFilter extends ZuulFilter {


    private static final Logger log = LoggerFactory.getLogger(PreRequestLogFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.error("jsdflkjalf");
        PreRequestLogFilter.log.info(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }
}
