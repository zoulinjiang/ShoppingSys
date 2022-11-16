package com.blue.service.impl;

import com.blue.dao.CartDao;
import com.blue.dao.UserDao;
import com.blue.dao.impl.CartDaoImpl;
import com.blue.dao.impl.UserDaoImpl;
import com.blue.pojo.Cart;
import com.blue.pojo.User;
import com.blue.service.UserService;

/**
 * @author shkstart
 * @create 2022-10-27 20:45
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    private CartDao cartDao=new CartDaoImpl();
    @Override
    public User login(String username, String password,Integer iscus) {
        return userDao.queryUserByUsernameAndPassword(username,password,iscus);
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserForUsername(username)==null){
            return false;
        }
        return  true;
    }

    @Override
    public void regist(User user) {
        //保存数据，创建用户
        userDao.saveUser(user);
        //得到用户的信息，比如id
        User user2 = userDao.queryUserForUsername(user.getUsername());
        //创建用户购物车
        cartDao.createCart(user2.getId());
    }
}
