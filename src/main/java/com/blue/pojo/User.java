package com.blue.pojo;

/**
 * @author shkstart

 */
public class User {
    //用户id
    private Integer id;
    //用户昵称
    private String username;
    //用户密码
    private String password;
    //用户邮箱
    private String email;
    //是否是顾客，如果是商家，则为false
    //在数据库中，1表示为用户，为真，0表示为商家，为假
    private  Integer isCus;

    public User() {
    }

    public User(Integer id, String username, String password, String email, Integer isCus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isCus = isCus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsCus() {
        return isCus;
    }

    public void setIsCus(Integer isCus) {
        this.isCus = isCus;
    }
}
