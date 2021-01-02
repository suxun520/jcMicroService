package cn.ncu.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
//@Component
public class MyZuulFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		ctx.addZuulResponseHeader("Content-type", "text/json;charset=UTF-8");
		ctx.getResponse().setCharacterEncoding("UTF-8");
		System.out.println("请求地址:" + request.getRequestURI());
		String token = request.getParameter("token");
		String msg = "请求成功!";
		if (token == null) {
			ctx.setSendZuulResponse(false);
			msg = "请求失败！";
			ctx.setResponseBody(msg);
			ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
		}

		return msg;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
