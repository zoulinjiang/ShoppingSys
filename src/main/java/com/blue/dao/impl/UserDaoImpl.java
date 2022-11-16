package com.blue.dao.impl;

import com.blue.dao.UserDao;
import com.blue.pojo.User;

/**
 * @author shkstart
 * @create 2022-10-27 20:35
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsernameAndPassword(String username, String password,Integer iscus) {
        String sql="select `id`,`username`,`password`,`email`,`iscus` from s_user where username=? and password=? and iscus=?";
        return (User) queryForOne(User.class,sql,username,password,iscus);
    }

    @Override
    public User queryUserForUsername(String username) {
        String sql="select `id`,`username`,`password`,`email`,`iscus` from s_user where username=?";
        return (User) queryForOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into s_user(`username`,`password`,`email`,`iscus`) values(?,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getIsCus());
    }


}
