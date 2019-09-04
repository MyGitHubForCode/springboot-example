package com.example.springbootConfig;

import com.example.springbootConfig.service.JwtUser;
import com.example.springbootSecurityUser.domain.UserModel;
import com.example.utils.JwtTokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName:
 * Description:
 * date: 2019/9/3 0003 10:13
 *
 * @author SS
 * @since JDK 1.8
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private ThreadLocal<Integer> rememberMe = new ThreadLocal<>();

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/user/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            UserModel userModel = new ObjectMapper().readValue(request.getInputStream(), UserModel.class);
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userModel.getUserName(), userModel.getPassWord(), new ArrayList<>()));
            return authenticate;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
        //System.out.println("jwtUser:" + jwtUser.toString());
       // boolean isRemember = rememberMe.get() == 1;


        String role = "";
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }
        String token = JwtTokenUtils.createToken(jwtUser.getUsername(),role,true);

        response.setHeader("token",JwtTokenUtils.TOKEN_PREFIX+token);
        //super.successfulAuthentication(request, response, chain, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        //super.unsuccessfulAuthentication(request, response, failed);
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
    }
}
