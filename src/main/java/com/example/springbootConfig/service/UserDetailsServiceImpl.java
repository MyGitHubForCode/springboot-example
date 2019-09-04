package com.example.springbootConfig.service;

import com.example.springbootSecurityUser.dao.UserSecurity;
import com.example.springbootSecurityUser.domain.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * ClassName:
 * Description:
 * date: 2019/9/3 0003 9:52
 *
 * @author SS
 * @since JDK 1.8
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserSecurity userSecurity;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel userModel = userSecurity.queryUserAll(s);
        return new JwtUser(userModel);
    }
}


