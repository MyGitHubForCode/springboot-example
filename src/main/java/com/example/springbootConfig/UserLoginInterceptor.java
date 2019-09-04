package com.example.springbootConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:
 * Description:
 * date: 2019/8/23 0023 14:05
 *
 * @author SS
 * @since JDK 1.8
 */
@Configuration
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        System.out.println("测试preHandle 1");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //前端控制器(DispatcherServlet)调用处理器映射器(doDispatch方法)完成后执行PostHandle
        System.out.println("测试postHandle 2" );

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //返回视图时执行faterCompletion
        //// HandlerExecutionChain ---- DispatcherServlet(doDispatch) ----
        System.out.println("测试afterCompletion 3");
    }
}
