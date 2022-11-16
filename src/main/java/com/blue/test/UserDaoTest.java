package com.blue.test;

import com.blue.dao.UserDao;
import com.blue.dao.impl.UserDaoImpl;
import com.blue.pojo.User;
import org.junit.jupiter.api.Test;

/**
 * @author shkstart
 * @create 2022-10-27 20:49
 */
public class UserDaoTest {
    private UserDao userDao= new UserDaoImpl();

    @Test
    public  void queryUserByUsernameAndPassword(){
        User user=userDao.queryUserByUsernameAndPassword("admin","123456",1);
        if(user==null){
            System.out.println("登录失败");
        }else{
            System.out.println("登陆成功");
        }
    }
    @Test
    public  void queryUserForUsername(){
        String username="user1";

        if(userDao.queryUserForUsername(username)!=null){
            System.out.println("用户名重复");
        }else{
            System.out.println("用户名没有重复");
        }
    }
    @Test
    public  void saveUser(){
        User user=new User(null,"user2","123456","user121@qq.com",1);
        System.out.println(userDao.saveUser(user));

    }

}
