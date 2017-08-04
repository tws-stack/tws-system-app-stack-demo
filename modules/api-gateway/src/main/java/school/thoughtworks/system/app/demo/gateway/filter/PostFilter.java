package school.thoughtworks.system.app.demo.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sun.xml.internal.ws.client.ResponseContext;
import javafx.geometry.Pos;
import org.apache.http.protocol.ResponseContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFilter extends ZuulFilter {
    private static final String POST_FILTER = "post";

    private Logger logger =  LoggerFactory.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return POST_FILTER;
    }

    @Override
    public boolean shouldFilter(){
        return true;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public Object run(){
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
        logger.info(String.format("%s request to %s",request.getMethod(),request.getRequestURI()));
        logger.info(String.format("the response status %s,the body is %s",request.getMethod(),response.getStatus()));
        return null;
    }

}
