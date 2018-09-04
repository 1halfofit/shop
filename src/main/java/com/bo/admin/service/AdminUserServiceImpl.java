package com.bo.admin.service;

import com.bo.bean.User;
import com.bo.bean.UserVo;
import com.bo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean adminLogin(UserVo userVo) {
        User user = userMapper.selectUser(userVo);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
}
