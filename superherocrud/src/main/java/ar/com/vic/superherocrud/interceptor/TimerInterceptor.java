package ar.com.vic.superherocrud.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ar.com.vic.superherocrud.enums.LogType;
import ar.com.vic.superherocrud.util.UtilLog;

public class TimerInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request,  HttpServletResponse response,  Object handler) throws Exception {
		
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime",startTime);
		return true;
	}
		
	@Override
	public void postHandle(HttpServletRequest request,  HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	    
		long endTime = System.currentTimeMillis();
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Method method = handlerMethod.getMethod();
		long startTime = (Long) request.getAttribute("startTime");
		long periodTime = endTime - startTime;
		
		StringBuilder strDif = new StringBuilder();
		strDif.append("Método: ");
		strDif.append(method.getName());
		strDif.append(" Tiempo de ejecución: ");
		strDif.append(periodTime);
		strDif.append(" ms");
		
		UtilLog.registrarInfo(getClass(),LogType.INFO ,"[Tiempo][" + strDif.toString() + "]");
	}

}
