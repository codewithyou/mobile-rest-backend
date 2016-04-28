package com.tongdianer.zxy.site.xiaoyou.controller;

import com.tongdianer.zxy.site.xiaoyou.bean.ResponseResult;
import com.tongdianer.zxy.site.xiaoyou.bean.User;
import com.tongdianer.zxy.site.xiaoyou.service.UserService;
import com.tongdianer.zxy.site.xiaoyou.util.RestResultGenerator;
import com.tongdianer.zxy.site.xiaoyou.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author kui.liu
 * @since 2014/09/24 下午7:54
 */
@RestController
public class UserRestController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "user/auth/{type}/{userName}/{password}", method = RequestMethod.GET)
    public ResponseResult login(@PathVariable("type") String type, @PathVariable("userName") String userName,@PathVariable("password") String password){
        if("common".equals(type)) {//type=common普通用户名认证;type=tel,手机号密码认证;type=email,邮箱密码认证
            User user = (User) userService.getOne(userName);
            if(user!=null) {
                String requestPwd = User.genPwd(password,user.getSalt());
                if(requestPwd.equals(user.getPassword())) {
                    return RestResultGenerator.genResult(user, "登录成功");
                } else {
                    return RestResultGenerator.genErrorResult("用户名或者密码错误!");
                }
            } else {
                return RestResultGenerator.genErrorResult("用户名或者密码错误!");
            }
        } else if("tel".equals(type)){
            //TODO
        }

        return RestResultGenerator.genErrorResult("登录失败");

    }

    @RequestMapping(value = "user/reg/{type}", method = RequestMethod.POST)
    public ResponseResult reg(@Valid @RequestBody User user,@PathVariable("type") String type) {
        if("common".equals(type)) {
            if(StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getUsername())) {
               return RestResultGenerator.genErrorResult("用户名或者密码为空");
            }
            //查询是否已经存在该用户
            User olduser = (User) userService.getOne(user.getUsername());
            if(olduser !=null) {
                return RestResultGenerator.genErrorResult("该用户已经存在");
            }
            String salt = String.valueOf(StringUtils.randomInt());
            user.setSalt(salt);

            //重新设置密码
            user.setPassword(User.genPwd(user.getPassword(),salt));
            user.setCreateTime(System.currentTimeMillis());
            Object object = userService.addUser(user);
            if(object!=null) {
                return RestResultGenerator.genResult("注册成功");
            } else {
                return  RestResultGenerator.genErrorResult("注册失败");
            }
        }
        return RestResultGenerator.genResult("注册失败了");
    }




}
