package school.thoughtworks.system.app.demo.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreFilter extends ZuulFilter{
    private static final String PRE_FILTER = "pre";

    private Logger logger =  LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return PRE_FILTER;
    }

    public boolean shouldFilter(){
      return true;
    }

    public int filterOrder() {
        return 0;
    }

    public Object run(){
         RequestContext requestContext = RequestContext.getCurrentContext();
         HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info(String.format("%s request to %s",request.getMethod(),request.getRequestURI()));

        if(request.getParameter("token") == null){
            logger.warn("token is empty");
            requestContext.setSendZuulResponse(false); //告诉zuul不要对他进行router
            requestContext.setResponseStatusCode(401);
            return null;
        }

        logger.info("token is exist!");
        return null;
    }

}
