package com.blue.dao;

import com.blue.pojo.User;

/**
 * @author shkstart
 * @create 2022-10-24 15:30
 */
public interface UserDao {
    /**
     * 通过用户名和密码进行查询
     * @param username
     * @param password
     * @return 返回null，说明没有该用户信息
     */
    public User queryUserByUsernameAndPassword(String username,String password,Integer iscus);

    /**
     * 查询用户名
     * @param username
     * @return 为空，则是用户名未重复
     */
    public User queryUserForUsername(String username);

    /**
     * 保存用户
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveUser(User user);
}
