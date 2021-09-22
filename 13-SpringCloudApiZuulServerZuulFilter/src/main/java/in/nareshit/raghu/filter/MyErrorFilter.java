package in.nareshit.raghu.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyErrorFilter extends ZuulFilter {

	private Logger log = LoggerFactory.getLogger(MyErrorFilter.class);

	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		Throwable th = ctx.getThrowable();
		log.info("Request URL =>" + ctx.getRequest().getRequestURL());
		log.error("Unble to Execute Process=>" + th.getMessage());
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
