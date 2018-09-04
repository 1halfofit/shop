package com.bo.controller;

import com.bo.bean.*;
import com.bo.service.CarItemService;
import com.bo.service.OrdersService;
import com.bo.util.UUIDutil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    //      准备订单页面的数据 跳转到了订单页面
    @Resource
    private CarItemService carItemService;
    @Resource
    private OrdersService ordersService;

    @RequestMapping("addorder")
    public String addorder(HttpSession session, ModelMap mm) {
//        查询内容 用户信息   商品信息
        User user = (User) session.getAttribute("activeuser");
        //当前用户的车
        Cart cart = (Cart) session.getAttribute("activecar");
        List<Cartitem> carItemByCid = carItemService.getCarItemByCid(cart.getCid());
        double total = 0;
        for (Cartitem ci : carItemByCid) {
            total += ci.getSubtotal();
        }
        //将购物车信息传入页面
        mm.addAttribute("cart", carItemByCid);
        //将金额传入页面
        mm.addAttribute("total", total);
        return "order_info";
    }

    //生成订单数据
    @RequestMapping("saveOrder")
    public String saveOrder(Orders orders, HttpSession session, HttpServletRequest request) {
        //车的信息
        Cart cart = (Cart) session.getAttribute("activecar");
        List<Cartitem> carItemByCid = carItemService.getCarItemByCid(cart.getCid());
        double total = 0;
        for (Cartitem c1 : carItemByCid) {
            total += c1.getSubtotal();

        }
        //获取订单数据保存的订单信息
        //用户信息
        User user = (User) session.getAttribute("activeuser");
        orders.setOid(UUIDutil.getuuid());
        orders.setOrdertime(new java.util.Date());
        orders.setUid(user.getUid());
        orders.setTotal(total);

        boolean b = ordersService.saveOrders(orders, carItemByCid, cart);
        if (b) {
            return "jump";
        } else {
            return "WEB-INF/error";
        }
    }

    //点击我的订单  显示详情
    @RequestMapping("ordersshow")
    public String ordersshow(ModelMap mm, HttpSession session) {
        //获取用户的id 查询订单的信息  查询订单的详情
        User user = (User) session.getAttribute("activeuser");
        //根据用户uid 查询订单
        String uid = user.getUid();
        List<Orders> orders = ordersService.selectOrders(uid);
        mm.addAttribute("orders", orders);
        return "order_list";

    }

}
