package com.tongdianer.zxy.site.xiaoyou.service;

import com.tongdianer.zxy.site.xiaoyou.base.MybatisDao;
import com.tongdianer.zxy.site.xiaoyou.bean.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kui.liu
 * @since 2014/09/25 下午7:01
 */
@Service
public class UserService {

    @Resource
    private MybatisDao mybatisDao;

    public List<User> getUserList(String userName) {
        return mybatisDao.getList("User.getUserList", userName);
    }

    public Object updateUser(User user){
       return mybatisDao.update("User.updateUser", user);
    }

    public Object addUser(User user) {
        try {
            return mybatisDao.insert("User.insertUser",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getOne(String userName) {
        return mybatisDao.getOne("User.getUser",userName);
    }





}
