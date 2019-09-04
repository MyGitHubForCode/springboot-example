package com.example.springbootConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:
 * Description: 过滤器
 * date: 2019/8/21 0021 14:49
 *
 * @author SS
 * @since JDK 1.8
 */
@Service
@Configuration
public class SpringbootConfig implements WebMvcConfigurer {

    @Autowired
    UserLoginInterceptor userLoginInterceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /*静态资源拦截*/

        String[] resource = {"classpath:/static/example/","classpath:/static/"};
        String[] handler = {"/static/example/**","/static/**"};
        registry.addResourceHandler(handler).addResourceLocations(resource);

    }

    //容器启动就会校验资源拦截正确与否
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*对自定义类进行拦截过滤 按照自定义类的规则返回数据并执行后续功能--需要进行拦截的需要符合后续的路径匹配规则*/
        registry.addInterceptor(userLoginInterceptor).addPathPatterns("/hello");
    }
}