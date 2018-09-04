package com.bo.service;

import com.bo.bean.User;
import com.bo.bean.UserVo;

public interface UserService {
    boolean saveInfo(User user);

    User loginCheck(UserVo userVo);
}
