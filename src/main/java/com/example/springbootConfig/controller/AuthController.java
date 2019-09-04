package com.example.springbootConfig.controller;

import com.example.springbootSecurityUser.dao.UserSecurity;
import com.example.springbootSecurityUser.domain.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:
 * Description:
 * date: 2019/9/3 0003 17:09
 *
 * @author SS
 * @since JDK 1.8
 */
@ResponseBody
@Controller
public class AuthController {

    @Autowired
    private UserSecurity userSecurity;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping( value = "/register",method = RequestMethod.POST)
    public String registerUser(@RequestBody @Param("UserModel") UserModel userModel){

        //System.out.println(userModel);
        String passWord = userModel.getPassWord();
        //String userName = userModel.getUserName();
        userModel.setPassWord(bCryptPasswordEncoder.encode(passWord));
        userModel.setRole("ROLE_USER");
        userSecurity.addUser(userModel);
        return "true";
    }

}
