package com.tongdianer.zxy.site.xiaoyou.bean;


import com.tongdianer.zxy.site.xiaoyou.util.MD5;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

    @NotEmpty
    private String username;

    //@NotEmpty
    //private Integer age;

    //@NotEmpty
    private String password;

    private long createTime;


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String salt;

    public User(){}

    private User(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public static User newInstance(String userName, String password) {
        return new User(userName, password);
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

    public static String genPwd(String oldPassword,String salt) {
        return MD5.md5(oldPassword+salt);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }


}
