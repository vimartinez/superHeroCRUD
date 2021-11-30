package ar.com.vic.superherocrud.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(new TimerInterceptor()).excludePathPatterns("/swagger**", "/webjars/springfox-swagger-ui/**");
        registry.addInterceptor(new LoggerInterceptor()).excludePathPatterns("/swagger**", "/webjars/springfox-swagger-ui/**");
    }
}