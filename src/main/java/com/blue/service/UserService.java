package com.blue.service;

import com.blue.pojo.User;

/**
 * @author shkstart
 */
public interface UserService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return 为空则该用户不存在
     */
    public User login(String username,String password,Integer iscus);

    /**
     * 查找是否存在改用户名
     * @param username
     * @return 为false，则该用户名不存在，可以使用该用户名
     */
    public boolean existUsername(String username);

    /**
     * 注册用户
     * @param user
     */
    public void regist(User user);


}
