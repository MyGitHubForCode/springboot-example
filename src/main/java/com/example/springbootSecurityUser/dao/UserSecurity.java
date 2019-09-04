package com.example.springbootSecurityUser.dao;

import com.example.springbootSecurityUser.domain.UserModel;
import com.example.springbootexample.domain.CityModel;

import java.util.ArrayList;

/**
 * ClassName:
 * Description:
 * date: 2019/8/19 0019 10:29
 *
 * @author SS
 * @since JDK 1.8
 */

public interface UserSecurity {

   // UserModel queryUserAllByPN(String userName,String passWold);

    UserModel queryUserAll(String userName);

    int addUser(UserModel userModel);
}
