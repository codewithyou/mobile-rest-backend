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
public class DemoService {

    @Resource
    private MybatisDao mybatisDao;

    public List<User> getUser(String userName) {
        return mybatisDao.getList("User.getUserList", userName);
    }

    public void saveUser(User user){
        //mybatisDao.save("User.saveUser", user);
    }


}
