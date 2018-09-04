package com.bo.serviceImpl;

import com.bo.bean.Cart;
import com.bo.mapper.CartMapper;
import com.bo.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CartServiceImpl  implements CartService {
    @Resource
    private CartMapper cartMapper;

    @Override
    public Cart getCartByUid(String uid) {
        return cartMapper.selectByUserId(uid);
    }
}
