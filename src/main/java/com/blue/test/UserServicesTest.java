package com.blue.test;

import com.blue.service.UserService;
import com.blue.service.impl.UserServiceImpl;
import com.blue.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @author shkstart
 * @create 2022-10-27 22:08
 */
public class UserServicesTest {
    private UserService userService =new UserServiceImpl();
    @Test
    public void login(){
        if(userService.login("admin","123456",0)!=null){
            System.out.println("登录成功");
        }else{
            System.out.println("失败");
        }
    }

}
