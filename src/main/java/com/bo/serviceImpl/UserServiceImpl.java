package com.bo.serviceImpl;

import com.bo.bean.Cart;
import com.bo.bean.User;
import com.bo.bean.UserVo;
import com.bo.mapper.CartMapper;
import com.bo.mapper.UserMapper;
import com.bo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private CartMapper cartMapper;

    @Override
    public boolean saveInfo(User user) {
        int b = userMapper.insert(user);
        Cart cart = new Cart();
        cart.setCdis(user.getName() + "的购物车");
        cart.setUid(user.getUid());
        cartMapper.insert(cart);
        return true;
    }

    @Override
    public User loginCheck(UserVo userVo) {
        User users = userMapper.selectUser(userVo);
        return users;
    }


}
