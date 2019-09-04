package com.example.springbootConfig;

import com.example.springbootConfig.service.JWTAuthorizationFilter;
import com.example.springbootConfig.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * ClassName:
 * Description: Spring Security configure
 * date: 2019/8/26 0026 10:54
 *
 * @author SS
 * @since JDK 1.8
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringbootSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    // 加密密码
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //对密码加密
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }


    /* SpringSecurity bases configure */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //disable CSRF
        //http.formLogin().and().httpBasic().and().csrf().disable();
        //antMatchers--配置无需安全校验的路径
        //http.authorizeRequests().antMatchers("/hello")
                //.permitAll().anyRequest().authenticated();

      //  ANT风格路径匹配案例
      //  Path	Description
      //  /app/*.x	匹配(Matches)所有在app路径下的.x文件
      //  /app/p?ttern	匹配(Matches) /app/pattern 和 /app/pXttern,但是不包括/app/pttern
      //  /**/example	匹配(Matches) /app/example, /app/foo/example, 和 /example
      //  /app/**/dir/file.	匹配(Matches) /app/dir/file.jsp, /app/foo/dir/file.html,/app/foo/bar/dir/file.pdf, 和 /app/dir/file.java
      //  /**/*.jsp	匹配(Matches)任何的.jsp 文件

        http.csrf().disable();
        http.cors().disable();
        http.authorizeRequests().antMatchers("/hello")
                .authenticated().anyRequest().permitAll();

        http.addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()));

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //.authorizeRequests();
                //antMatchers("/static/example/hello.html").authenticated().anyRequest().permitAll().and();
                //.addFilter(new JWTAuthenticationFilter(authenticationManager()))
                //.addFilter(new JWTAuthorizationFilter(authenticationManager()));
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //添加JWT过滤
       // http.apply(new JwtTokenFilterConfigurer());
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
