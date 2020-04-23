package com.dc.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description
 * @Author DC
 * @Date 2020-04-23
 */
@Component
public class SecurityFilter extends ZuulFilter {
    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     *         pre：路由之前
     *         routing：路由之时
     *         post： 路由之后
     *         error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder：过滤的顺序，越小优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true，永远过滤。
     */
    @Override
    public boolean shouldFilter() {
        //true表示拦截
        return true;
    }

    /**
     * run：过滤器的具体逻辑。
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String securityToken = request.getParameter("token");
        if (securityToken == null) {
            ctx.setSendZuulResponse(false);
            //状态码
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("request failure , you do not have security token ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //return null 表示直接越过此Filter
        return null;
    }
}
