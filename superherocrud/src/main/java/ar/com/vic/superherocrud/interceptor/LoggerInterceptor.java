package ar.com.vic.superherocrud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ar.com.vic.superherocrud.enums.LogType;
import ar.com.vic.superherocrud.util.SuperHeroLog;

@Component
public class LoggerInterceptor implements HandlerInterceptor {
	
	//private static Logger log =  LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,  HttpServletResponse response,  Object handler) throws Exception {
	    
	   // log.info("[preHandle][" + request + "]" + "[" + request.getMethod() + "]" + request.getRequestURI() + getParameters(request));
	    SuperHeroLog.registrarInfo(getClass(),LogType.INFO ,"[preHandleLogger][" + request + "]" + "[" + request.getMethod() + "]" + request.getRequestURI());
	    return true;
	}
		
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) 
	  throws Exception {
	    if (ex != null){
	        ex.printStackTrace();
	    }
	   // log.info("[afterCompletion][" + request + "][exception: " + ex + "]");
	    SuperHeroLog.registrarInfo(getClass(),LogType.INFO ,"[afterCompletionLogger][" + request + "][exception: " + ex + "]");
	}
	
	@Override
	public void postHandle(HttpServletRequest request,  HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	    
	    //log.info("[postHandle][" + request + "]");
		 SuperHeroLog.registrarInfo(getClass(),LogType.INFO ,"[postHandleLogger][" + request + "]");
	}
}
