package com.example.springbootConfig.service;

import com.example.springbootSecurityUser.domain.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * ClassName:
 * Description:
 * date: 2019/9/3 0003 9:59
 *
 * @author SS
 * @since JDK 1.8
 */
public class JwtUser implements UserDetails {


    private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private JwtUser() {
    }

    public JwtUser(UserModel user) {
        this.username = user.getUserName();
        this.password = user.getPassWord();
        this.id = user.getId();
        authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    //获取权限
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    //账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //是否锁定账户
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //账号凭证是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //对象是否有效
    @Override
    public boolean isEnabled() {
        return true;
    }
}
