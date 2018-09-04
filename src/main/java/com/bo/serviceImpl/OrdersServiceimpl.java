package com.bo.serviceImpl;

import com.bo.bean.*;
import com.bo.mapper.CartitemMapper;
import com.bo.mapper.OrderitemMapper;
import com.bo.mapper.OrdersMapper;
import com.bo.mapper.ProductMapper;
import com.bo.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceimpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private OrderitemMapper orderitemMapper;
    @Resource
    private CartitemMapper cartitemMapper;
    @Resource
    private ProductMapper productMapper;

    @Override
    public boolean saveOrders(Orders orders, List<Cartitem> cartitems, Cart cart) {
        List<Orderitem> list = new ArrayList<>();
        List<String> pids = new ArrayList<>();
        //inset 执行完后  当前队形就获取了主键值
        ordersMapper.insert(orders);
        for (Cartitem c1 : cartitems) {
            Orderitem orderitem = new Orderitem();
            orderitem.setOid(orders.getOid());
            orderitem.setCount(c1.getCount());
            orderitem.setPid(c1.getProduct().getPid());
            orderitem.setSubtotal(c1.getSubtotal());
            list.add(orderitem);
            pids.add(c1.getProduct().getPid());
            orderitemMapper.batchAddOrderitem(list);
        }
        Integer cid = cart.getCid();
        boolean i1 = cartitemMapper.deleteCartitemAll(cid);
        if (i1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Orders> selectOrders(String uid) {
        List<Orders> ordersList = ordersMapper.selectByUid(uid);
        for (Orders orders : ordersList) {
            List<Orderitem> orderitems = orderitemMapper.selectByoid(orders.getOid());
            for (Orderitem orderitem : orderitems) {
                String pid = orderitem.getPid();
                Product product = productMapper.selectByPrimaryKey(pid);
                orderitem.setProduct(product);
            }
            orders.setOrderitem(orderitems);
        }
        return ordersList;
    }
}
