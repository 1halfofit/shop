package com.bo.controller;

import com.bo.bean.*;
import com.bo.service.CarItemService;
import com.bo.service.CartService;
import com.bo.service.ProductService;
import com.bo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CarController {

    @Resource
    private ProductService productService;

    @Resource
    private UserService userService;

    @Resource
    private CartService carService;

    @Resource
    private CarItemService carItemService;

    //添加购物车
    @RequestMapping("addCar")
    public String addCar(String pid, Integer buyNum, HttpSession session) {
        //根据pid获取制定商品信息
        Product proByPid = productService.getProBypid(pid);
        //缺少购物车id(根据当前登录的活动用户信息获取)
        UserVo vo = new UserVo();
        User user = (User) session.getAttribute("activeuser");
        vo.setUsername(user.getUsername());
        vo.setPassword(user.getPassword());
        User nuser = userService.loginCheck(vo);
        //根据登录的用户id查询车
        Cart cartByUid = carService.getCartByUid(nuser.getUid());
        //购物车详情
        Cartitem item = new Cartitem();
        item.setCount(buyNum);
        item.setCid(cartByUid.getCid());
        item.setPid(pid);
        item.setSubtotal((proByPid.getShopprice() * buyNum));
        //添加到数据库
        boolean addInfo = carItemService.addInfo(item);
        if (addInfo) {
            return "jump";
        }
        return "WEB-INF/error";

    }

    //查询当前登录用户的购物车信息
    @RequestMapping("cartinfo")
    public String cartinfo(HttpSession session, ModelMap mm) {
        //获取当前登录的人的信息
        User user = (User) session.getAttribute("activeuser");
        //人的信息---车的信息---车的详情  --mybatis的多表关联
        Cart cartByUid = carService.getCartByUid(user.getUid());
        mm.addAttribute("activecar", cartByUid);
        session.setAttribute("activecar", cartByUid);
        //根据车获取车的详情
        List<Cartitem> carItemByCid = carItemService.getCarItemByCid(cartByUid.getCid());
        double total = 0;
        for (Cartitem c1 : carItemByCid) {
            total += c1.getSubtotal();
        }
        mm.addAttribute("cart", carItemByCid);
        mm.addAttribute("total", total);
        return "cart";
    }

    //删除购物车的商品
    @RequestMapping("DeleteCartitem")
    public String DeleteCartitem(@RequestParam(required = true) Integer[] id) {
        boolean b = carItemService.BatchDeleteInfo(id);
        System.out.println(b);
        if (b) {
            return "redirect:/cartinfo";
        } else {
            return "WEB-INF/error";
        }
    }

    //清空购物车
    @RequestMapping("deleteCartitemAll")
    public String deleteCartitemAll(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("activecar");
        boolean b = carItemService.deleteCartitemAll(cart.getCid());
        if (b) {
            return "redirect:/cartinfo";
        } else {
            return "WEB-INF/error";
        }
    }
}
