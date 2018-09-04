package com.bo.service;

import com.bo.bean.Cart;
import com.bo.bean.Cartitem;
import com.bo.bean.Orders;

import java.util.List;

public interface OrdersService {
    boolean saveOrders(Orders orders, List<Cartitem> cartitems, Cart cart);

    //根据用户uid查询订单
    List<Orders> selectOrders(String uid);
}
